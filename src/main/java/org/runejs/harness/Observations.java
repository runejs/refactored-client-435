package org.runejs.harness;

import org.runejs.client.Game;
import org.runejs.client.message.InboundMessage;
import org.runejs.client.message.handler.MessageHandlerRegistry;
import org.runejs.client.message.inbound.updating.UpdateNPCsInboundMessage;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Everything the server told the client during a tick, in the server's own vocabulary.
 *
 * Each inbound message is recorded under the name of its decoder's message class, with its public fields. No
 * event vocabulary is invented here: the client's codec already names every message.
 */
public final class Observations implements MessageHandlerRegistry.InboundMessageListener {
    private static final String[] CLASS_SUFFIXES = {"InboundMessage", "Message"};
    /**
     * Enough for several hundred ticks of a busy scene; beyond that the oldest are dropped rather than growing
     * without bound while the client idles.
     */
    private static final int CAPACITY = 20000;

    private final List<Object> recorded = new ArrayList<Object>();
    private long currentTick = 0;
    private boolean countingTicks = false;

    public void attach() {
        Game.handlerRegistry.addListener(this);
    }

    /**
     * Lockstep mode: the controller says which server tick the coming loops belong to.
     */
    public void beginTick(long tick) {
        currentTick = tick;
    }

    /**
     * Live mode: nobody tells the client which tick it is, but every server tick ends with the player and NPC
     * sync messages, so the tick counter advances itself when the NPC sync has been handled.
     */
    public void countTicksFromSync() {
        countingTicks = true;
    }

    public long currentTick() {
        return currentTick;
    }

    public void record(String type, Map<String, Object> details) {
        Map<String, Object> observation = Json.object();
        observation.put("tick", currentTick);
        observation.put("type", type);
        observation.putAll(details);
        recorded.add(observation);
        if (recorded.size() > CAPACITY) {
            recorded.subList(0, recorded.size() - CAPACITY).clear();
        }
    }

    /**
     * Forgets everything recorded before {@code tick}. A live wait uses this to shed an idle backlog while keeping
     * the last few ticks, which is where the consequences of the action just taken are.
     */
    public void forgetBefore(long tick) {
        Iterator<Object> iterator = recorded.iterator();
        while (iterator.hasNext()) {
            Map<?, ?> observation = (Map<?, ?>) iterator.next();
            if (((Number) observation.get("tick")).longValue() < tick) {
                iterator.remove();
            } else {
                break;
            }
        }
    }

    /**
     * Hands over everything recorded since the last drain.
     */
    public List<Object> drain() {
        List<Object> drained = new ArrayList<Object>(recorded);
        recorded.clear();
        return drained;
    }

    @Override
    public void onMessage(InboundMessage message) {
        Map<String, Object> details = Json.object();
        for (Field field : message.getClass().getFields()) {
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }
            Object value;
            try {
                value = field.get(message);
            } catch (IllegalAccessException e) {
                continue;
            }
            if (isSimple(value)) {
                details.put(fieldName(field.getName()), value);
            }
        }
        record("message." + messageName(message.getClass().getSimpleName()), details);

        if (countingTicks && message instanceof UpdateNPCsInboundMessage) {
            currentTick++;
        }
    }

    /**
     * `tick` and `type` belong to the observation itself. A message field with one of those names (CreateObject
     * has a `type`) is reported under a `message` prefix instead of overwriting them.
     */
    private static String fieldName(String name) {
        if (name.equals("tick") || name.equals("type")) {
            return "message" + Character.toUpperCase(name.charAt(0)) + name.substring(1);
        }
        return name;
    }

    private static String messageName(String className) {
        for (String suffix : CLASS_SUFFIXES) {
            if (className.endsWith(suffix) && className.length() > suffix.length()) {
                return className.substring(0, className.length() - suffix.length());
            }
        }
        return className;
    }

    private static boolean isSimple(Object value) {
        return value == null || value instanceof String || value instanceof Number || value instanceof Boolean || value instanceof int[];
    }
}
