package org.runejs.harness;

import java.net.InetAddress;

/**
 * Entry point for a headless, externally-driven client.
 *
 * <pre>
 * java -Drunejs.client.config=/path/client-435.conf.yaml -cp client.jar org.runejs.harness.HarnessMain [port] [--realtime]
 * </pre>
 *
 * The process prints {@code HARNESS_PORT=<n>} on standard output once it is listening, then serves a single
 * controller connection over the {@link HarnessServer} protocol until told to quit.
 *
 * In lockstep mode (the default) the game loop only runs when the controller asks, on the same thread that serves
 * the controller. With {@code --realtime} the loop runs on its own at 20 ms as it would under {@code GameShell},
 * against a server that ticks by itself, and commands are executed between iterations. Either way nothing about
 * the client's state can change between a command being received and its answer being written.
 */
public final class HarnessMain {
    private HarnessMain() {
    }

    public static void main(String[] args) throws Exception {
        int port = 0;
        boolean realtime = false;
        for (String arg : args) {
            if ("--realtime".equals(arg)) {
                realtime = true;
            } else {
                port = Integer.parseInt(arg);
            }
        }

        HeadlessShell shell = new HeadlessShell();
        shell.boot(InetAddress.getByName(org.runejs.Configuration.SERVER_ADDRESS));

        HarnessCommands commands = new HarnessCommands(shell, realtime);
        CommandExecutor executor;
        RealtimeDriver driver = null;
        if (realtime) {
            driver = new RealtimeDriver(shell);
            Thread gameThread = new Thread(driver, "game");
            gameThread.setDaemon(true);
            gameThread.start();
            executor = driver;
        } else {
            executor = new InlineExecutor();
        }

        HarnessServer server = new HarnessServer(shell, port, commands, executor);
        System.out.println("HARNESS_PORT=" + server.port());
        System.out.flush();
        server.serve();
        if (driver != null) {
            driver.stop();
        }
        System.exit(0);
    }
}
