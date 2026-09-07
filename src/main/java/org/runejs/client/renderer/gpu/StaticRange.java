package org.runejs.client.renderer.gpu;

/**
 * Where one scene element's triangles live in the static vertex buffers: a run of opaque vertices and a run of
 * translucent ones, both counted in vertices. An element that carries one of these was uploaded when its region
 * loaded and is drawn by the static pass; anything without one is streamed every frame.
 */
public final class StaticRange {
    public int opaqueFirst;
    public int opaqueCount;
    public int alphaFirst;
    public int alphaCount;
}
