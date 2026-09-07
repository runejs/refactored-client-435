package org.runejs.harness;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * A line-oriented JSON protocol over a loopback socket. Each request is one JSON object on one line carrying an
 * {@code op}; each response is one JSON object on one line. Requests are served strictly in order on the calling
 * thread, which is also the thread that drives the game loop.
 */
public final class HarnessServer {
    private final HeadlessShell shell;
    private final ServerSocket serverSocket;
    private final HarnessCommands commands;
    private final CommandExecutor executor;

    public HarnessServer(HeadlessShell shell, int port, HarnessCommands commands, CommandExecutor executor) throws IOException {
        this.shell = shell;
        this.serverSocket = new ServerSocket(port, 1, InetAddress.getLoopbackAddress());
        this.commands = commands;
        this.executor = executor;
    }

    public int port() {
        return serverSocket.getLocalPort();
    }

    public void serve() throws IOException {
        Socket socket = serverSocket.accept();
        socket.setTcpNoDelay(true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), false);

        try {
            String line;
            while ((line = in.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                Map<String, Object> response;
                boolean quit = false;
                try {
                    final Map<String, Object> request = Json.parseObject(line);
                    final String op = Json.stringValue(request, "op");
                    if ("quit".equals(op)) {
                        quit = true;
                        response = Json.object();
                        response.put("ok", true);
                    } else {
                        response = executor.execute(new java.util.concurrent.Callable<Object>() {
                            @Override
                            public Object call() throws Exception {
                                return commands.handle(op, request);
                            }
                        });
                    }
                } catch (Exception e) {
                    response = Json.error(e.getClass().getSimpleName() + ": " + e.getMessage());
                    e.printStackTrace();
                }

                out.print(Json.write(response));
                out.print('\n');
                out.flush();

                if (quit) {
                    break;
                }
            }
        } finally {
            try {
                shell.close();
            } catch (Exception ignored) {
                // The process is exiting either way.
            }
            socket.close();
            serverSocket.close();
        }
    }
}
