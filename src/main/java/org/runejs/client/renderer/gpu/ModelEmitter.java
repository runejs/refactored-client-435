package org.runejs.client.renderer.gpu;

import org.runejs.client.media.Rasterizer3D;
import org.runejs.client.media.renderable.Model;

/**
 * Turns a lit {@link Model} into world-space triangles in the shader's vertex layout. The face types, colours and
 * texture mapping follow {@code Model.method823}: type 0 is Gouraud shaded, 1 flat, 2 textured Gouraud and 3
 * textured flat, with the texture placed by the three vertices of its mapping triangle.
 */
final class ModelEmitter {
    private final boolean[] referencedTextures;

    private int[] worldX = new int[4096];
    private int[] worldY = new int[4096];
    private int[] worldZ = new int[4096];

    ModelEmitter(int textureCount) {
        referencedTextures = new boolean[Math.max(1, textureCount)];
    }

    boolean[] referencedTextures() {
        return referencedTextures;
    }

    void markTexture(int textureId) {
        if (textureId >= 0 && textureId < referencedTextures.length) {
            referencedTextures[textureId] = true;
        }
    }

    /**
     * @param rotation model rotation in the client's 2048-step angle units
     * @param x        world east coordinate of the model origin
     * @param height   world height of the model origin (negative is up, as everywhere in the client)
     * @param north    world north coordinate of the model origin
     */
    void emit(Model model, int rotation, int x, int height, int north, VertexStream opaque, VertexStream alpha) {
        int vertexCount = model.vertexCount;
        if (worldX.length < vertexCount) {
            worldX = new int[vertexCount];
            worldY = new int[vertexCount];
            worldZ = new int[vertexCount];
        }
        int sine = 0;
        int cosine = 0;
        if (rotation != 0) {
            sine = Model.SINE[rotation];
            cosine = Model.COSINE[rotation];
        }
        for (int v = 0; v < vertexCount; v++) {
            int vx = model.verticesX[v];
            int vy = model.verticesY[v];
            int vz = model.verticesZ[v];
            if (rotation != 0) {
                int rotated = vz * sine + vx * cosine >> 16;
                vz = vz * cosine - vx * sine >> 16;
                vx = rotated;
            }
            worldX[v] = vx + x;
            worldY[v] = vy + height;
            worldZ[v] = vz + north;
        }

        int[] types = model.triangleDrawType;
        int[] alphas = model.triangleAlphaValues;
        int[] hsl2rgb = Rasterizer3D.hsl2rgb;
        for (int face = 0; face < model.triangleCount; face++) {
            int type = types == null ? 0 : types[face];
            if (type == -1) {
                continue;
            }
            int a = model.trianglePointsX[face];
            int b = model.trianglePointsY[face];
            int c = model.trianglePointsZ[face];
            int alphaValue = alphas == null ? 0 : alphas[face];
            if ((type & 0x2) != 0) {
                // Rasterizer3D.drawTexturedTriangle has no blending path: a textured face is always opaque.
                alphaValue = 0;
            }
            VertexStream out = alphaValue == 0 ? opaque : alpha;
            int alphaBits = (255 - alphaValue) << 24;
            switch (type & 0x3) {
                case 0:
                    putColoured(out, a, b, c,
                            hsl2rgb[model.triangleHSLA[face] & 0xffff] | alphaBits,
                            hsl2rgb[model.triangleHSLB[face] & 0xffff] | alphaBits,
                            hsl2rgb[model.triangleHSLC[face] & 0xffff] | alphaBits);
                    break;
                case 1: {
                    int colour = hsl2rgb[model.triangleHSLA[face] & 0xffff] | alphaBits;
                    putColoured(out, a, b, c, colour, colour, colour);
                    break;
                }
                case 2:
                    putTextured(model, out, face, type >> 2, a, b, c,
                            model.triangleHSLA[face], model.triangleHSLB[face], model.triangleHSLC[face], alphaBits);
                    break;
                default:
                    putTextured(model, out, face, type >> 2, a, b, c,
                            model.triangleHSLA[face], model.triangleHSLA[face], model.triangleHSLA[face], alphaBits);
                    break;
            }
        }
    }

    private void putColoured(VertexStream out, int a, int b, int c, int colourA, int colourB, int colourC) {
        out.put(worldX[a], worldY[a], worldZ[a], colourA, 0f, 0f, -1);
        out.put(worldX[b], worldY[b], worldZ[b], colourB, 0f, 0f, -1);
        out.put(worldX[c], worldY[c], worldZ[c], colourC, 0f, 0f, -1);
    }

    /**
     * The texture's origin sits on vertex P, its u axis runs along P to M and its v axis along P to N; every
     * vertex of the face gets the coordinates that express it in that basis.
     */
    private void putTextured(Model model, VertexStream out, int face, int mapping, int a, int b, int c, int shadeA, int shadeB, int shadeC, int alphaBits) {
        int texture = model.triangleColorValues[face];
        markTexture(texture);
        if (model.texturedTrianglePointsX == null || mapping >= model.texturedTrianglePointsX.length) {
            int colour = alphaBits | 0x808080;
            putColoured(out, a, b, c, colour, colour, colour);
            return;
        }
        int p = model.texturedTrianglePointsX[mapping];
        int m = model.texturedTrianglePointsY[mapping];
        int n = model.texturedTrianglePointsZ[mapping];
        double px = model.verticesX[p];
        double py = model.verticesY[p];
        double pz = model.verticesZ[p];
        double e1x = model.verticesX[m] - px;
        double e1y = model.verticesY[m] - py;
        double e1z = model.verticesZ[m] - pz;
        double e2x = model.verticesX[n] - px;
        double e2y = model.verticesY[n] - py;
        double e2z = model.verticesZ[n] - pz;
        double nx = e1y * e2z - e1z * e2y;
        double ny = e1z * e2x - e1x * e2z;
        double nz = e1x * e2y - e1y * e2x;
        double lengthSquared = nx * nx + ny * ny + nz * nz;
        if (lengthSquared == 0.0) {
            lengthSquared = 1.0;
        }
        putTexturedVertex(model, out, a, px, py, pz, e1x, e1y, e1z, e2x, e2y, e2z, nx, ny, nz, lengthSquared, shadeA, alphaBits, texture);
        putTexturedVertex(model, out, b, px, py, pz, e1x, e1y, e1z, e2x, e2y, e2z, nx, ny, nz, lengthSquared, shadeB, alphaBits, texture);
        putTexturedVertex(model, out, c, px, py, pz, e1x, e1y, e1z, e2x, e2y, e2z, nx, ny, nz, lengthSquared, shadeC, alphaBits, texture);
    }

    private void putTexturedVertex(Model model, VertexStream out, int vertex, double px, double py, double pz,
                                   double e1x, double e1y, double e1z, double e2x, double e2y, double e2z,
                                   double nx, double ny, double nz, double lengthSquared, int shade, int alphaBits, int texture) {
        double dx = model.verticesX[vertex] - px;
        double dy = model.verticesY[vertex] - py;
        double dz = model.verticesZ[vertex] - pz;
        // d x e2, projected on the normal, is u times |n|^2; e1 x d likewise gives v.
        double ux = dy * e2z - dz * e2y;
        double uy = dz * e2x - dx * e2z;
        double uz = dx * e2y - dy * e2x;
        double vx = e1y * dz - e1z * dy;
        double vy = e1z * dx - e1x * dz;
        double vz = e1x * dy - e1y * dx;
        float u = (float) ((ux * nx + uy * ny + uz * nz) / lengthSquared);
        float v = (float) ((vx * nx + vy * ny + vz * nz) / lengthSquared);
        out.put(worldX[vertex], worldY[vertex], worldZ[vertex], alphaBits | ((shade & 0xff) << 16), u, v, texture);
    }
}
