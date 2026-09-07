package org.runejs.client.renderer.gpu;

import org.lwjgl.system.Platform;

/**
 * An OpenGL context with no window behind it. The scene is rendered into a framebuffer object and read back into
 * the client's own pixel buffer, so the renderer needs a current context and nothing else from the platform.
 */
public interface GlContext {
    void makeCurrent();

    void destroy();

    /**
     * Creates a context for the current platform, or throws with a message that says why one cannot be had here.
     */
    static GlContext create() {
        Platform platform = Platform.get();
        if (platform == Platform.MACOSX) {
            return new CglContext();
        }
        throw new UnsupportedOperationException("The GPU renderer only knows how to create an offscreen OpenGL context on macOS (CGL); this is " + platform.getName() + ".");
    }
}
