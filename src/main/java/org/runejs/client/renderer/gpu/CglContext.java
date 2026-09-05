package org.runejs.client.renderer.gpu;

import org.lwjgl.PointerBuffer;
import org.lwjgl.opengl.CGL;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryStack;

import java.nio.IntBuffer;

import static org.lwjgl.system.MemoryUtil.NULL;

/**
 * A core-profile OpenGL context created straight through CGL. CGL contexts do not need the AppKit main thread,
 * which is what lets the game thread own one while AWT owns the window.
 */
final class CglContext implements GlContext {
    private long pixelFormat;
    private long context;

    CglContext() {
        try (MemoryStack stack = MemoryStack.stackPush()) {
            IntBuffer attributes = stack.ints(
                    CGL.kCGLPFAOpenGLProfile, CGL.kCGLOGLPVersion_3_2_Core,
                    CGL.kCGLPFAColorSize, 24,
                    CGL.kCGLPFADepthSize, 24,
                    CGL.kCGLPFAAccelerated,
                    CGL.kCGLPFAAllowOfflineRenderers,
                    0);
            PointerBuffer formats = stack.mallocPointer(1);
            IntBuffer formatCount = stack.mallocInt(1);
            check(CGL.CGLChoosePixelFormat(attributes, formats, formatCount), "CGLChoosePixelFormat");
            if (formatCount.get(0) == 0 || formats.get(0) == NULL) {
                throw new IllegalStateException("CGL offered no accelerated core-profile pixel format.");
            }
            pixelFormat = formats.get(0);
            PointerBuffer contexts = stack.mallocPointer(1);
            check(CGL.CGLCreateContext(pixelFormat, NULL, contexts), "CGLCreateContext");
            context = contexts.get(0);
        }
        makeCurrent();
        GL.createCapabilities();
    }

    @Override
    public void makeCurrent() {
        check(CGL.CGLSetCurrentContext(context), "CGLSetCurrentContext");
    }

    @Override
    public void destroy() {
        CGL.CGLSetCurrentContext(NULL);
        if (context != NULL) {
            CGL.CGLDestroyContext(context);
            context = NULL;
        }
        if (pixelFormat != NULL) {
            CGL.CGLDestroyPixelFormat(pixelFormat);
            pixelFormat = NULL;
        }
    }

    private static void check(int error, String call) {
        if (error != CGL.kCGLNoError) {
            throw new IllegalStateException(call + " failed: " + CGL.CGLErrorString(error));
        }
    }
}
