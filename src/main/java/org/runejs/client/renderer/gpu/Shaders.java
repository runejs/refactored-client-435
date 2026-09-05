package org.runejs.client.renderer.gpu;

/**
 * The one shader pair the scene is drawn with. Colours arrive pre-lit from the client's own lighting pass, so
 * the fragment stage only has to sample textures, apply the client's texture shading and fog.
 */
final class Shaders {
    private Shaders() {
    }

    static final String VERTEX = ""
            + "#version 330 core\n"
            + "layout(location = 0) in vec3 aPosition;\n"
            + "layout(location = 1) in vec4 aColour;\n"
            + "layout(location = 2) in vec2 aUv;\n"
            + "layout(location = 3) in int aTexture;\n"
            + "uniform mat4 uViewProjection;\n"
            + "out vec4 vColour;\n"
            + "out vec2 vUv;\n"
            + "flat out int vTexture;\n"
            + "out float vDepth;\n"
            + "void main() {\n"
            + "    vec4 clip = uViewProjection * vec4(aPosition, 1.0);\n"
            + "    gl_Position = clip;\n"
            + "    vColour = aColour;\n"
            + "    vUv = aUv;\n"
            + "    vTexture = aTexture;\n"
            + "    vDepth = clip.w;\n"
            + "}\n";

    /**
     * Texture shading mirrors {@code Rasterizer3D.drawTexturedLine}: bits 4-5 of the interpolated shade pick one
     * of the four pre-darkened copies of the texture the client keeps (full, 7/8, 3/4 and 5/8 brightness) and every
     * 64 above that halves the texel again. Texels of pure black are holes, as in the software path.
     */
    static final String FRAGMENT = ""
            + "#version 330 core\n"
            + "in vec4 vColour;\n"
            + "in vec2 vUv;\n"
            + "flat in int vTexture;\n"
            + "in float vDepth;\n"
            + "uniform sampler2DArray uTextures;\n"
            + "uniform float uFogStart;\n"
            + "uniform float uFogEnd;\n"
            + "out vec4 fragColour;\n"
            + "void main() {\n"
            + "    vec4 colour = vColour;\n"
            + "    if (vTexture >= 0) {\n"
            + "        vec3 texel = texture(uTextures, vec3(vUv, float(vTexture))).rgb;\n"
            + "        if (texel.r + texel.g + texel.b <= 0.0) {\n"
            + "            discard;\n"
            + "        }\n"
            + "        float shade = floor(vColour.r * 255.0 + 0.5);\n"
            + "        float octave = floor(shade / 64.0);\n"
            + "        float step = floor(mod(shade, 64.0) / 16.0);\n"
            + "        colour = vec4(texel * exp2(-octave) * (1.0 - step / 8.0), vColour.a);\n"
            + "    }\n"
            + "    if (uFogEnd > uFogStart) {\n"
            + "        float fog = clamp((vDepth - uFogStart) / (uFogEnd - uFogStart), 0.0, 1.0);\n"
            + "        colour.rgb = mix(colour.rgb, vec3(0.0), fog);\n"
            + "    }\n"
            + "    fragColour = colour;\n"
            + "}\n";
}
