package org.runejs.harness;

import java.net.InetAddress;

/**
 * Entry point for a headless, externally-driven client.
 *
 * <pre>
 * java -Drunejs.client.config=/path/client-435.conf.yaml -cp client.jar org.runejs.harness.HarnessMain [port]
 * </pre>
 *
 * The process prints {@code HARNESS_PORT=<n>} on standard output once it is listening, then serves a single
 * controller connection over the {@link HarnessServer} protocol until told to quit. Everything the controller asks
 * for runs on one thread, the same thread that steps the game loop, so nothing about the client's state can change
 * between a command being received and its answer being written.
 */
public final class HarnessMain {
    private HarnessMain() {
    }

    public static void main(String[] args) throws Exception {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : 0;

        HeadlessShell shell = new HeadlessShell();
        shell.boot(InetAddress.getByName(org.runejs.Configuration.SERVER_ADDRESS));

        HarnessServer server = new HarnessServer(shell, port);
        System.out.println("HARNESS_PORT=" + server.port());
        System.out.flush();
        server.serve();
        System.exit(0);
    }
}
