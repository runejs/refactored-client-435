package org.runejs.harness;

import java.util.Map;

/**
 * Dispatches protocol operations onto the shell.
 */
public final class HarnessCommands {
    private final HeadlessShell shell;

    public HarnessCommands(HeadlessShell shell) {
        this.shell = shell;
    }

    public Map<String, Object> handle(String op, Map<String, Object> request) {
        if (op == null) {
            return Json.error("Missing op");
        }

        switch (op) {
            case "status":
                return status();
            case "loop":
                shell.loop(Json.intValue(request, "count", 1));
                return status();
            case "draw":
                shell.draw();
                return status();
            default:
                return Json.error("Unknown op: " + op);
        }
    }

    private Map<String, Object> status() {
        Map<String, Object> status = Json.object();
        status.put("gameStatus", shell.gameStatusCode());
        status.put("loops", shell.loops());
        status.put("frames", shell.frames());
        status.put("error", shell.lastError());
        return status;
    }
}
