package org.runejs.client;

import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.cache.def.SpotAnimDefinition;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.media.renderable.Renderable;

public class SpotAnim extends Renderable {

    public int startCycle;
    public int z;
    public int anInt3233;
    public int y;
    public boolean animationFinished;
    public int plane;
    public int frame = 0;
    public AnimationSequence animation;
    public int x;
    public int id;

    public SpotAnim(int id, int plane, int x, int y, int z, int delay, int cycle) {
        animationFinished = false;
        anInt3233 = 0;
        this.y = y;
        this.x = x;
        startCycle = delay + cycle;
        this.z = z;
        this.id = id;
        this.plane = plane;
        int animationId = SpotAnimDefinition.forId(this.id).animationId;
        if(animationId != -1) {
            animationFinished = false;
            animation = AnimationSequence.getAnimationSequence(animationId);
        } else
            animationFinished = true;

    }


    public Model getRotatedModel() {
        SpotAnimDefinition spotAnimDefinition = SpotAnimDefinition.forId(id);
        Model model;
        if(animationFinished)
            model = spotAnimDefinition.getModel(-1);
        else
            model = spotAnimDefinition.getModel(frame);
        if(model == null)
            return null;
        return model;
    }

    public void method834(int delta) {
        if(!animationFinished) {
            anInt3233 += delta;
            while(anInt3233 > animation.frameLengths[frame]) {
                anInt3233 -= animation.frameLengths[frame];
                frame++;
                if(animation.frameIds.length <= frame) {
                    animationFinished = true;
                    break;
                }
            }
        }
    }
}
