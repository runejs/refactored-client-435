package org.runejs.harness;

import org.yaml.snakeyaml.Yaml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The little JSON the harness protocol needs: parse one line into maps and lists, and write maps and lists back
 * out as one line. Parsing is delegated to SnakeYAML, which the client already ships and which reads JSON as the
 * YAML flow syntax it is.
 */
public final class Json {
    private static final Yaml YAML = new Yaml();

    private Json() {
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> parseObject(String line) {
        Object parsed = YAML.load(line);
        if (!(parsed instanceof Map)) {
            throw new IllegalArgumentException("Expected a JSON object but got: " + line);
        }
        return (Map<String, Object>) parsed;
    }

    public static String write(Object value) {
        StringBuilder out = new StringBuilder();
        append(out, value);
        return out.toString();
    }

    public static Map<String, Object> object() {
        return new LinkedHashMap<String, Object>();
    }

    public static List<Object> array() {
        return new ArrayList<Object>();
    }

    private static void append(StringBuilder out, Object value) {
        if (value == null) {
            out.append("null");
        } else if (value instanceof String) {
            appendString(out, (String) value);
        } else if (value instanceof Boolean || value instanceof Integer || value instanceof Long) {
            out.append(value);
        } else if (value instanceof Number) {
            double number = ((Number) value).doubleValue();
            if (Double.isNaN(number) || Double.isInfinite(number)) {
                out.append("null");
            } else {
                out.append(number);
            }
        } else if (value instanceof Map) {
            appendObject(out, (Map<?, ?>) value);
        } else if (value instanceof Iterable) {
            appendArray(out, (Iterable<?>) value);
        } else if (value instanceof int[]) {
            List<Object> boxed = new ArrayList<Object>();
            for (int element : (int[]) value) {
                boxed.add(element);
            }
            appendArray(out, boxed);
        } else {
            appendString(out, String.valueOf(value));
        }
    }

    private static void appendObject(StringBuilder out, Map<?, ?> map) {
        out.append('{');
        boolean first = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!first) {
                out.append(',');
            }
            first = false;
            appendString(out, String.valueOf(entry.getKey()));
            out.append(':');
            append(out, entry.getValue());
        }
        out.append('}');
    }

    private static void appendArray(StringBuilder out, Iterable<?> values) {
        out.append('[');
        boolean first = true;
        for (Object element : values) {
            if (!first) {
                out.append(',');
            }
            first = false;
            append(out, element);
        }
        out.append(']');
    }

    private static void appendString(StringBuilder out, String text) {
        out.append('"');
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            switch (c) {
                case '"':
                    out.append("\\\"");
                    break;
                case '\\':
                    out.append("\\\\");
                    break;
                case '\n':
                    out.append("\\n");
                    break;
                case '\r':
                    out.append("\\r");
                    break;
                case '\t':
                    out.append("\\t");
                    break;
                default:
                    if (c < 0x20) {
                        out.append(String.format("\\u%04x", (int) c));
                    } else {
                        out.append(c);
                    }
            }
        }
        out.append('"');
    }

    public static int intValue(Map<String, Object> object, String key, int fallback) {
        Object value = object.get(key);
        return value instanceof Number ? ((Number) value).intValue() : fallback;
    }

    public static long longValue(Map<String, Object> object, String key, long fallback) {
        Object value = object.get(key);
        return value instanceof Number ? ((Number) value).longValue() : fallback;
    }

    public static String stringValue(Map<String, Object> object, String key) {
        Object value = object.get(key);
        return value == null ? null : String.valueOf(value);
    }

    public static Map<String, Object> error(String message) {
        Map<String, Object> error = object();
        error.put("error", message);
        return Collections.unmodifiableMap(error);
    }
}
