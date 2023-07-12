package org.runejs.client.message.inbound.widget.container;

/**
 * Represents an item on a widget.
 */
public class WidgetItem {
    /**
     * The slot on the widget that the item is in.
     */
    public final int index;
    public final int id;
    public final int amount;

    public WidgetItem(int index, int id, int amount) {
        this.index = index;
        this.id = id;
        this.amount = amount;
    }
}
