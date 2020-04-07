package com.jagex.runescape;

import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.VarbitDefinition;
import com.jagex.runescape.cache.media.Widget.Widget;
import com.jagex.runescape.cache.media.Widget.WidgetType;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.media.Rasterizer3D;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.PacketBuffer;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.tile.FloorDecoration;
import com.jagex.runescape.util.Signlink;

public class Class61 {
    public static RSString aClass1_1421 = (RSString.CreateString("To play on this world move to a free area first"));
    public static RSString aClass1_1422 = RSString.CreateString("Username: ");
    public static PacketBuffer packetBuffer = new PacketBuffer(5000);
    public static RSString aClass1_1427 = RSString.CreateString("mapedge");
    public static RSString aClass1_1428 = RSString.CreateString("wishes to duel with you)3");
    public static RSString aClass1_1432 = RSString.CreateString("System update in: ");
    public static int[][] anIntArrayArray1435 = new int[104][104];
    public static RSString aClass1_1437 = RSString.CreateString("null");
    public static RSString aClass1_1440 = RSString.CreateString("backleft1");
    public static Class68 aClass68_1441;
    public static boolean aBoolean1444 = false;
    public static int[] anIntArray1445;
    public static RSString aClass1_1446 = RSString.CreateString("Fps:");

    public Class40_Sub5_Sub1 aClass40_Sub5_Sub1_1419;
    public int[] anIntArray1420;
    public RSString[] aClass1Array1430;
    public int anInt1433 = -1;

    public static void method995(byte arg0, int arg1) {
        if(arg1 != -1 && Class68.aBooleanArray1629[arg1]) {
            VarbitDefinition.aCacheIndex_2349.method171(1, arg1);
            if(arg0 < 31)
                aClass1_1428 = null;
            if(Widget.interfaces[arg1] != null) {
                boolean bool = true;
                for(int i = 0; ((Widget.interfaces[arg1]).length > i); i++) {
                    if(Widget.interfaces[arg1][i] != null) {
                        if((Widget.interfaces[arg1][i].type) != WidgetType.INVENTORY)
                            Widget.interfaces[arg1][i] = null;
                        else
                            bool = false;
                    }
                }
                if(bool)
                    Widget.interfaces[arg1] = null;
                Class68.aBooleanArray1629[arg1] = false;
            }
        }
    }

    public static void method996(int arg0) {
        if(arg0 != 19655)
            aClass1_1432 = null;
        SubNode.aClass68_2091.method1046((byte) 90);
        FloorDecoration.aClass40_Sub5_Sub14_Sub2_593.drawImage(0, 0);
        ActorDefinition.anIntArray2386 = Rasterizer3D.method708(ActorDefinition.anIntArray2386);
    }

    public static void method997(int arg0) {
        if(arg0 != 47)
            initiateVertexHeights(-42, (byte) 12, 92, 18, -72);
        if(Signlink.aString735.toLowerCase().indexOf("microsoft") == -1) {
            HuffmanEncoding.anIntArray1564[44] = 71;
            HuffmanEncoding.anIntArray1564[45] = 26;
            HuffmanEncoding.anIntArray1564[46] = 72;
            HuffmanEncoding.anIntArray1564[47] = 73;
            HuffmanEncoding.anIntArray1564[59] = 57;
            HuffmanEncoding.anIntArray1564[61] = 27;
            HuffmanEncoding.anIntArray1564[91] = 42;
            HuffmanEncoding.anIntArray1564[92] = 74;
            HuffmanEncoding.anIntArray1564[93] = 43;
            if(Signlink.aMethod729 == null) {
                HuffmanEncoding.anIntArray1564[192] = 58;
                HuffmanEncoding.anIntArray1564[222] = 59;
            } else {
                HuffmanEncoding.anIntArray1564[192] = 28;
                HuffmanEncoding.anIntArray1564[222] = 58;
                HuffmanEncoding.anIntArray1564[520] = 59;
            }
        } else {
            HuffmanEncoding.anIntArray1564[186] = 57;
            HuffmanEncoding.anIntArray1564[187] = 27;
            HuffmanEncoding.anIntArray1564[188] = 71;
            HuffmanEncoding.anIntArray1564[189] = 26;
            HuffmanEncoding.anIntArray1564[190] = 72;
            HuffmanEncoding.anIntArray1564[191] = 73;
            HuffmanEncoding.anIntArray1564[192] = 58;
            HuffmanEncoding.anIntArray1564[219] = 42;
            HuffmanEncoding.anIntArray1564[220] = 74;
            HuffmanEncoding.anIntArray1564[221] = 43;
            HuffmanEncoding.anIntArray1564[222] = 59;
            HuffmanEncoding.anIntArray1564[223] = 28;
        }

    }

    public static void method998() {
        anIntArrayArray1435 = null;
        aClass1_1446 = null;
        anIntArray1445 = null;
        aClass68_1441 = null;
        packetBuffer = null;
        aClass1_1422 = null;
        aClass1_1437 = null;
        aClass1_1421 = null;
        aClass1_1432 = null;
        aClass1_1428 = null;
        aClass1_1440 = null;
        aClass1_1427 = null;
    }

    public static void initiateVertexHeights(int arg0, byte arg1, int arg2, int arg3, int arg4) {
        int i = -112 / ((50 - arg1) / 53);
        for(int i_0_ = arg0; (i_0_ <= arg0 + arg2); i_0_++) {
            for(int i_1_ = arg4; (arg3 + arg4 >= i_1_); i_1_++) {
                if(i_1_ >= 0 && i_1_ < 104 && i_0_ >= 0 && i_0_ < 104) {
                    InteractiveObject.aByteArrayArrayArray492[0][i_1_][i_0_] = (byte) 127;
                    if(arg4 == i_1_ && i_1_ > 0)
                        Class40_Sub6.tile_height[0][i_1_][i_0_] = (Class40_Sub6.tile_height[0][-1 + i_1_][i_0_]);
                    if(arg4 + arg3 == i_1_ && i_1_ < 103)
                        Class40_Sub6.tile_height[0][i_1_][i_0_] = (Class40_Sub6.tile_height[0][i_1_ + 1][i_0_]);
                    if(i_0_ == arg0 && i_0_ > 0)
                        Class40_Sub6.tile_height[0][i_1_][i_0_] = (Class40_Sub6.tile_height[0][i_1_][i_0_ + -1]);
                    if(i_0_ == arg0 + arg2 && i_0_ < 103)
                        Class40_Sub6.tile_height[0][i_1_][i_0_] = (Class40_Sub6.tile_height[0][i_1_][1 + i_0_]);
                }
            }
        }
    }

    public static void method1000(boolean arg0) {
        if(arg0) {
            for(Class40_Sub5_Sub17_Sub6 class40_sub5_sub17_sub6 = ((Class40_Sub5_Sub17_Sub6) Class57.aLinkedList_1332.method902((byte) -90)); class40_sub5_sub17_sub6 != null; class40_sub5_sub17_sub6 = ((Class40_Sub5_Sub17_Sub6) Class57.aLinkedList_1332.method909(-4))) {
                if((Player.worldLevel == class40_sub5_sub17_sub6.anInt3239) && !class40_sub5_sub17_sub6.aBoolean3237) {
                    if(Node.pulseCycle >= class40_sub5_sub17_sub6.anInt3230) {
                        class40_sub5_sub17_sub6.method834(8076, Class5.anInt199);
                        if(class40_sub5_sub17_sub6.aBoolean3237)
                            class40_sub5_sub17_sub6.method457(-1);
                        else
                            Npc.currentScene.method134(class40_sub5_sub17_sub6.anInt3239, class40_sub5_sub17_sub6.anInt3244, class40_sub5_sub17_sub6.anInt3235, class40_sub5_sub17_sub6.anInt3231, 60, class40_sub5_sub17_sub6, 0, -1, false);
                    }
                } else
                    class40_sub5_sub17_sub6.method457(-1);
            }
        }
    }
}
