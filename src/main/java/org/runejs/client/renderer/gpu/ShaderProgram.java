package org.runejs.client.renderer.gpu;

import static org.lwjgl.opengl.GL20.*;

final class ShaderProgram {
    final int id;

    ShaderProgram(String vertexSource, String fragmentSource) {
        int vertex = compile(GL_VERTEX_SHADER, vertexSource, "vertex");
        int fragment = compile(GL_FRAGMENT_SHADER, fragmentSource, "fragment");
        id = glCreateProgram();
        glAttachShader(id, vertex);
        glAttachShader(id, fragment);
        glLinkProgram(id);
        if (glGetProgrami(id, GL_LINK_STATUS) == GL_FALSE) {
            String log = glGetProgramInfoLog(id);
            glDeleteProgram(id);
            throw new IllegalStateException("Shader program failed to link: " + log);
        }
        glDetachShader(id, vertex);
        glDetachShader(id, fragment);
        glDeleteShader(vertex);
        glDeleteShader(fragment);
    }

    int uniform(String name) {
        int location = glGetUniformLocation(id, name);
        if (location < 0) {
            throw new IllegalStateException("Shader has no uniform named " + name);
        }
        return location;
    }

    void use() {
        glUseProgram(id);
    }

    void delete() {
        glDeleteProgram(id);
    }

    private static int compile(int type, String source, String kind) {
        int shader = glCreateShader(type);
        glShaderSource(shader, source);
        glCompileShader(shader);
        if (glGetShaderi(shader, GL_COMPILE_STATUS) == GL_FALSE) {
            String log = glGetShaderInfoLog(shader);
            glDeleteShader(shader);
            throw new IllegalStateException("The " + kind + " shader failed to compile: " + log);
        }
        return shader;
    }
}
