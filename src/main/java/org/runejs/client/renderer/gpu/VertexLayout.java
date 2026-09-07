package org.runejs.client.renderer.gpu;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

/**
 * Binds a vertex buffer in the {@link VertexStream} layout to a vertex array object.
 */
final class VertexLayout {
    private VertexLayout() {
    }

    static int createVertexArray(int vbo) {
        int vao = glGenVertexArrays();
        glBindVertexArray(vao);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glEnableVertexAttribArray(0);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, VertexStream.STRIDE, 0);
        glEnableVertexAttribArray(1);
        glVertexAttribPointer(1, 4, GL_UNSIGNED_BYTE, true, VertexStream.STRIDE, 12);
        glEnableVertexAttribArray(2);
        glVertexAttribPointer(2, 2, GL_FLOAT, false, VertexStream.STRIDE, 16);
        glEnableVertexAttribArray(3);
        glVertexAttribIPointer(3, 1, GL_INT, VertexStream.STRIDE, 24);
        glBindVertexArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
        return vao;
    }
}
