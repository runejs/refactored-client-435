package org.runejs.client.renderer.gpu;

import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;

/**
 * A growable, native vertex buffer in the layout the scene shader reads: position (3 floats), colour (4 unsigned
 * bytes), texture coordinates (2 floats) and texture layer (1 int), 28 bytes per vertex. Untextured vertices
 * carry an RGB colour and a layer of -1; textured ones carry the shade in the red channel instead.
 */
public final class VertexStream {
    public static final int STRIDE = 28;

    private ByteBuffer buffer;
    private int vertexCount;

    public VertexStream(int initialVertices) {
        buffer = MemoryUtil.memAlloc(initialVertices * STRIDE);
    }

    public void clear() {
        buffer.clear();
        vertexCount = 0;
    }

    public int vertexCount() {
        return vertexCount;
    }

    public boolean isEmpty() {
        return vertexCount == 0;
    }

    /**
     * @param rgba 0xAARRGGBB; alpha 255 is opaque
     */
    public void put(float x, float y, float z, int rgba, float u, float v, int texture) {
        if (buffer.remaining() < STRIDE) {
            grow();
        }
        buffer.putFloat(x).putFloat(y).putFloat(z);
        buffer.put((byte) (rgba >> 16)).put((byte) (rgba >> 8)).put((byte) rgba).put((byte) (rgba >>> 24));
        buffer.putFloat(u).putFloat(v);
        buffer.putInt(texture);
        vertexCount++;
    }

    private void grow() {
        int position = buffer.position();
        buffer = MemoryUtil.memRealloc(buffer, buffer.capacity() * 2);
        buffer.position(position);
    }

    /**
     * The written vertices, ready for upload. The stream must not be written to again until the returned view has
     * been consumed.
     */
    public ByteBuffer upload() {
        ByteBuffer view = buffer.duplicate();
        view.flip();
        return view;
    }

    public void free() {
        MemoryUtil.memFree(buffer);
        buffer = null;
    }
}
