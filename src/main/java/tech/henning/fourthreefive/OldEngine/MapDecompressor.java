package tech.henning.fourthreefive.OldEngine;/*
 * Class: tech.henning.fourthreefive.OldEngine.MapDecompressor.java
 * Loads decompressed maps from a subcache.
 * @ Author: Zee best
 */

import com.jagex.runescape.*;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.scene.util.CollisionMap;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class MapDecompressor {

    public static List<Integer> mapIndices = null;
    public static Map<Integer, byte[]> mapBuffer = new HashMap<Integer, byte[]>();

    public static byte[] grabMap(int id) throws IOException {
        if(mapIndices == null)
            loadIndex2();
        if(mapBuffer.get(id) == null) {
            RandomAccessFile raf_cache = new RandomAccessFile("./data/maps/MAP_CACHE.dat", "rw");
            RandomAccessFile raf_index = new RandomAccessFile("./data/maps/MAP_CACHE.idx", "rw");
            int pos = getIndexPosition(id);
            if(pos == -1)
                return null;
            raf_index.seek(pos * 12);
            raf_cache.seek(raf_index.readInt());
            byte[] b = new byte[raf_index.readInt()];
            raf_cache.readFully(b);
            b = inflate(b, raf_index.readInt());
            mapBuffer.put(id, b);
            return mapBuffer.get(id);
        }
        return mapBuffer.get(id);
    }

    public static void loadIndex2() throws IOException {
        mapIndices = new ArrayList<Integer>();
        DataInputStream dis = new DataInputStream(new FileInputStream("./data/maps/MAP_CACHE.idx2"));
        for(int i = 0; i < (int) new File("./data/maps/MAP_CACHE.idx2").length() / 2; i++)
            mapIndices.add((int) dis.readShort());
    }

    public static int getIndexPosition(int id) throws IOException {
        if(mapIndices.contains(id))
            for(int i = 0; i < mapIndices.size(); i++)
                if(mapIndices.get(i) == id)
                    return i;
        return -1;
    }

    public static byte[] inflate(byte[] b, int l) throws IOException {
        byte[] buf = new byte[l];
        ByteArrayInputStream bais = new ByteArrayInputStream(b);
        DataInputStream dis = new DataInputStream(new GZIPInputStream(bais));
        dis.readFully(buf, 0, buf.length);
        dis.close();
        return buf;
    }

    public static void objectLoader(String file) {
        try {

            RandomAccessFile in = new RandomAccessFile(file, "r");
            //			RandomAccessFile out = new RandomAccessFile(com.jagex.runescape.util.Signlink.findCacheDirectory()+ "maps/test.cmap", "rw");
            int totalObjects = in.readInt();
            //			out.writeInt(totalObjects);
            for(int index = 0; index < totalObjects; index++) {
                //				String data = in.readUTF();
                //				int objectId = Integer.parseInt(data.substring(data.indexOf("i:")+3, data.indexOf("x")-1));
                //				int x = Integer.parseInt(data.substring(data.indexOf("x:")+3, data.indexOf("y")-1));
                //				int y = Integer.parseInt(data.substring(data.indexOf("y:")+3, data.indexOf("z")-1));
                //				int objectPlane = Integer.parseInt(data.substring(data.indexOf("z:")+3, data.indexOf("d")-1));
                //				int direction = Integer.parseInt(data.substring(data.indexOf("d:")+3, data.indexOf("t")-1));
                //				int type = Integer.parseInt(data.substring(data.indexOf("t:")+3));

                int objectId = in.readShort();
                int x = in.readShort();
                int y = in.readShort();
                int objectPlane = in.read();
                int direction = in.read();
                int type = in.read();


                if(objectId != -1) {
                    //					out.writeShort(objectId);
                    //					out.writeShort(x);
                    //					out.writeShort(y);
                    //					out.write(objectPlane);
                    //					out.write(direction);
                    //					out.write(type);
                    spawnObject(objectId, x, y, objectPlane, direction, type);
                    //System.out.println("objectLoader second method called.");
                }
            }
        } catch(Exception e) {
        }

    }

    /**
     * READY FOR TESTING
     * TODO testing
     *
     * @param objectId The object ID
     * @param x        the X spawn coordinate
     * @param y        the Y spawn coordinate
     * @param z        the Z spawn coordinate
     * @param rotation the "face" of the object
     * @param type     what kind, floor, wall, etc. (list coming soon, I have one, just too lazy ;))
     */
    public static void spawnObject(int objectId, int x, int y, int z, int rotation, int type) {
        final CollisionMap[] groundData = Landscape.currentCollisionMap;
        int localX = x - SpotAnimDefinition.baseX;
        int localY = y - Class26.baseY; // ??? is this correct?
        int plane = z;
        if(localX > -1 && localY > -1) {
            if((OverlayDefinition.tile_flags[1][localY][localX] & 2) == 2) {
                plane--;
            }
        }

        CollisionMap class20 = null;
        if(plane >= 0) {
            class20 = groundData[plane];
        }
        if(localY > 0 && localX > 0 && localY < 103 && localX < 103) {
            Class40_Sub5_Sub17_Sub1.addObject(objectId, localX, localY, z, rotation, type, Npc.currentScene, class20);
        }
    }

}
