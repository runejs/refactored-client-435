package org.runejs.client.scene.tile;

import org.runejs.client.node.Node;
import org.runejs.client.scene.GroundItemTile;
import org.runejs.client.scene.InteractiveObject;

public class SceneTile extends Node {
    public SceneTile aSceneTile_2058;
    public int wallCullOppositeDirection;
    public GroundItemTile groundItemTile;
    public int anInt2061;
    public boolean drawEntities;
    public int drawLevel;
    public int anInt2064;
    public InteractiveObject[] interactiveObjects = new InteractiveObject[5];
    public int anInt2066;
    public int wallCullDirection;
    public ComplexTile shapedTile;
    public int anInt2069;
    public GenericTile plainTile;
    public boolean draw;
    public Wall wall;
    public int interactiveObjectsSizeOR;
    public int[] sceneSpawnRequestsSize = new int[5];
    public FloorDecoration floorDecoration;
    public int wallUncullDirection;
    public boolean visible;
    public int anInt2078;
    public WallDecoration wallDecoration;
    public int entityCount;

    public SceneTile(int arg0, int arg1, int arg2) {
        interactiveObjectsSizeOR = 0;
        anInt2061 = arg1;
        anInt2069 = anInt2066 = arg0;
        anInt2078 = arg2;

    }
}
