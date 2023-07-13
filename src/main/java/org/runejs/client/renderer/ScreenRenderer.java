package org.runejs.client.renderer;

import java.awt.*;

public abstract class ScreenRenderer {

    public abstract void drawLoadingText(int percent, Color color, String desc);

    public abstract void disposeLoadingText();

}
