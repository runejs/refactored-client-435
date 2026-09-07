package org.runejs.client.renderer.gpu;

import org.lwjgl.system.MemoryUtil;
import org.runejs.client.Interface3;

import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL12.*;
import static org.lwjgl.opengl.GL30.*;

/**
 * Every game texture as one layer of a 2D array texture, in the client's own pixel format. Layers are uploaded the
 * first time something references them and re-uploaded every frame while the client animates them (water, lava).
 */
final class TextureArray {
    final int id;
    final int size;
    final int layers;

    private final Interface3 provider;
    /**
     * Whether a layer holds the texture's real pixels. A texture the client has not decoded yet is uploaded as its
     * average colour and retried on the next frame, which is what the software rasterizer draws in that case too.
     */
    private final boolean[] complete;
    private final IntBuffer scratch;

    TextureArray(Interface3 provider) {
        this.provider = provider;
        size = provider.method15() ? 64 : 128;
        layers = Math.max(1, provider.textureCount());
        complete = new boolean[layers];
        scratch = MemoryUtil.memAllocInt(size * size);
        id = glGenTextures();
        glBindTexture(GL_TEXTURE_2D_ARRAY, id);
        glTexImage3D(GL_TEXTURE_2D_ARRAY, 0, GL_RGBA8, size, size, layers, 0, GL_BGRA, GL_UNSIGNED_INT_8_8_8_8_REV, (IntBuffer) null);
        glTexParameteri(GL_TEXTURE_2D_ARRAY, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D_ARRAY, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D_ARRAY, GL_TEXTURE_WRAP_S, GL_REPEAT);
        glTexParameteri(GL_TEXTURE_2D_ARRAY, GL_TEXTURE_WRAP_T, GL_REPEAT);
    }

    void bind() {
        glBindTexture(GL_TEXTURE_2D_ARRAY, id);
    }

    /**
     * Brings every referenced layer up to date: incomplete ones are retried, animated ones follow the client's
     * animation.
     */
    void refresh(boolean[] referenced) {
        bind();
        int count = Math.min(layers, referenced.length);
        for (int textureId = 0; textureId < count; textureId++) {
            if (referenced[textureId] && (!complete[textureId] || provider.isTextureAnimated(textureId))) {
                upload(textureId);
            }
        }
    }

    private void upload(int textureId) {
        int[] pixels = provider.getTexturePixels(textureId);
        scratch.clear();
        if (pixels == null || pixels.length < size * size) {
            int average = provider.getAverageTextureColour(textureId) & 0xffffff;
            if (average == 0) {
                average = 0x010101;
            }
            for (int i = 0; i < size * size; i++) {
                scratch.put(average);
            }
            complete[textureId] = false;
        } else {
            scratch.put(pixels, 0, size * size);
            complete[textureId] = true;
        }
        scratch.flip();
        glTexSubImage3D(GL_TEXTURE_2D_ARRAY, 0, 0, 0, textureId, size, size, 1, GL_BGRA, GL_UNSIGNED_INT_8_8_8_8_REV, scratch);
    }

    void delete() {
        glDeleteTextures(id);
        MemoryUtil.memFree(scratch);
    }
}
