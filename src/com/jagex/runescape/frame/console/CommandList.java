package com.jagex.runescape.frame.console;

import java.util.ArrayList;

public class CommandList extends ArrayList<Command> {
    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the lowest index {@code i} such that
     * {@code Objects.equals(o, get(i))},
     * or -1 if there is no such index.
     */
    @Override
    public int indexOf(Object o) {
        return indexOfRange(o, 0, size());
    }

    int indexOfRange(Object o, int start, int end) {
        Object[] es = toArray();
        if(o == null) {
            for(int i = start; i < end; i++) {
                if(es[i] == null) {
                    return i;
                }
            }
        } else {
            for(int i = start; i < end; i++) {
                if(es[i].equals(o)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
