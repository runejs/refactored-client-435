package com.jagex.runescape;

import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.CacheIndex_Sub1;
import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.cache.media.Widget;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Item;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.tile.*;
import com.jagex.runescape.scene.util.CollisionMap;

import java.awt.*;
import java.io.*;

public class Class55 {
    public static CacheIndex_Sub1 aClass6_Sub1_1286;
    public static int mouseInvInterfaceIndex = 0;
    public static Class48 aClass48_1289;
    public static RSString aClass1_1291 = RSString.CreateString("slide:");
    public static RSString aClass1_1292 = RSString.CreateString("bevor Sie den Vorgang wiederholen)3");
    public static volatile int eventClickX = 0;
    public static int anInt1296 = -1;
    public static RSString aClass1_1298 = RSString.CreateString("Invalid loginserver requested)3");
    public static int anInt1299 = 2301979;
    public static RSString aClass1_1300 = RSString.CreateString("(U4");
    public static int anInt1304 = 0;

    public static void method958(int arg0) {
        Class61.method995((byte) 85, arg0);
    }

    public static String method959(int arg0, Throwable arg1) throws IOException {
        String string;
        if(arg1 instanceof RSRuntimeException) {
            RSRuntimeException runtimeexception_sub1 = (RSRuntimeException) arg1;
            string = runtimeexception_sub1.aString1653 + " | ";
            arg1 = runtimeexception_sub1.aThrowable1652;
        } else
            string = "";
        StringWriter stringwriter = new StringWriter();
        PrintWriter printwriter = new PrintWriter(stringwriter);
        arg1.printStackTrace(printwriter);
        printwriter.close();
        String string_0_ = stringwriter.toString();
        BufferedReader bufferedreader = new BufferedReader(new StringReader(string_0_));
        if(arg0 != 0)
            return null;
        String string_1_ = bufferedreader.readLine();
        for(; ; ) {
            String string_2_ = bufferedreader.readLine();
            if(string_2_ == null)
                break;
            int i = string_2_.indexOf('(');
            int i_3_ = string_2_.indexOf(')', i + 1);
            if(i >= 0 && i_3_ >= 0) {
                String string_4_ = string_2_.substring(1 + i, i_3_);
                int i_5_ = string_4_.indexOf(".java:");
                if(i_5_ >= 0) {
                    string_4_ = (string_4_.substring(0, i_5_) + string_4_.substring(5 + i_5_));
                    string += string_4_ + ' ';
                    continue;
                }
                string_2_ = string_2_.substring(0, i);
            }
            string_2_ = string_2_.trim();
            string_2_ = string_2_.substring(1 + string_2_.lastIndexOf(' '));
            string_2_ = string_2_.substring(1 + string_2_.lastIndexOf('\t'));
            string += string_2_ + ' ';
        }
        string += "| " + string_1_;
        return string;
    }

    public static Class40_Sub5_Sub15 method960(byte arg0, int arg1) {
        Class40_Sub5_Sub15 class40_sub5_sub15 = ((Class40_Sub5_Sub15) Class42.aClass9_998.get((long) arg1, (byte) 101));
        if(class40_sub5_sub15 != null)
            return class40_sub5_sub15;
        class40_sub5_sub15 = Class35.method421(VarbitDefinition.aCacheIndex_2364, (byte) 79, arg1, Class40_Sub11.aCacheIndex_2162, false);
        if(class40_sub5_sub15 != null)
            Class42.aClass9_998.put(arg0 + -7109, (long) arg1, class40_sub5_sub15);
        if(arg0 != -99)
            method961();
        return class40_sub5_sub15;
    }

    public static void method961() {
        aClass1_1292 = null;
        aClass1_1300 = null;
        aClass1_1291 = null;
        aClass6_Sub1_1286 = null;
        aClass48_1289 = null;
        aClass1_1298 = null;
    }

    public static void setGerman() {
        Class39.aClass1_917 = Node.aClass1_933;
        SceneTile.aClass1_2057 = Renderable.aClass1_2871;
        Main.aClass1_1781 = Class37.aClass1_880;
        RSString.aClass1_1717 = Class12.aClass1_398;
        Class34.aClass1_817 = Class35.aClass1_1743;
        Actor.aClass1_3159 = Class40_Sub13.aClass1_2176;
        Class5.aClass1_204 = Class40_Sub13.aClass1_2174;
        Class57.aClass1_1333 = Class40_Sub5_Sub15.aClass1_2773;
        Class35.aClass1_1746 = Class37.aClass1_872;
        Class51.aClass1_1196 = SpotAnimDefinition.aClass1_2311;
        Class64.aClass1_1526 = VertexNormal.aClass1_1109;
        Node.aClass1_929 = Class27.aClass1_652;
        Class40_Sub5_Sub11.aClass1_2622 = ActorDefinition.aClass1_2417;
        Item.aClass1_3066 = Class40_Sub5_Sub17_Sub6.aClass1_3247;
        Class59.string_Hidden = ActorDefinition.aClass1_2417;
        Class68.aClass1_1635 = Class65.aClass1_1530;
        Node.aClass1_966 = Class67.aClass1_1613;
        InteractiveObject.aClass1_495 = Class60.aClass1_1401;
        ActorDefinition.aClass1_2396 = Class34.aClass1_850;
        SceneTile.aClass1_2054 = Class37.aClass1_860;
        Node.aClass1_958 = Class64.aClass1_1523;
        RSCanvas.aClass1_51 = AnimationSequence.aClass1_2487;
        aClass1_1291 = Class67.aClass1_1609;
        Class68.aClass1_1638 = Class40_Sub13.aClass1_2185;
        Class37.aClass1_873 = Class33.aClass1_779;
        Node.aClass1_959 = WallDecoration.aClass1_1265;
        SpotAnimDefinition.aClass1_2294 = Class67.aClass1_1612;
        VertexNormal.aClass1_1117 = GameObjectDefinition.aClass1_2560;
        Cache.aClass1_323 = OverlayDefinition.aClass1_2327;
        MouseHandler.aClass1_1465 = Class39.aClass1_898;
        WallDecoration.aClass1_1251 = HashTable.aClass1_563;
        Node.aClass1_960 = Class40_Sub5_Sub17_Sub1.aClass1_2977;
        Node.aClass1_946 = Class64.aClass1_1523;
        GenericTile.aClass1_1223 = Wall.aClass1_352;
        OverlayDefinition.aClass1_2325 = Class40_Sub2.aClass1_1991;
        SceneTile.aClass1_2047 = Class37.aClass1_860;
        Class13.aClass1_417 = IdentityKit.aClass1_2614;
        Wall.aClass1_344 = GenericTile.aClass1_1238;
        Class12.aClass1_399 = Class60.aClass1_1409;
        Class40_Sub5_Sub6.aClass1_2458 = GameObject.aClass1_3046;
        Actor.aClass1_3138 = RSApplet.aClass1_14;
        Class57.aClass1_1343 = ISAAC.aClass1_527;
        Node.aClass1_953 = Class64.aClass1_1523;
        Node.aClass1_942 = Class64.aClass1_1523;
        Class22_Sub2.aClass1_1876 = Npc.aClass1_3309;
        Node.aClass1_952 = Class64.aClass1_1523;
        Class40_Sub5_Sub15.prefix_examine = Class26.aClass1_630;
        Node.aClass1_954 = Class64.aClass1_1523;
        Npc.aClass1_3311 = Class49.aClass1_1146;
        Class68.aClass1_1628 = Class40_Sub5_Sub6.aClass1_2457;
        Class13.str_Loading_Friend_List = VertexNormal.aClass1_1115;
        IdentityKit.aClass1_2587 = Class22_Sub1.aClass1_1838;
        Class40_Sub5_Sub11.aClass1_2620 = Class26.aClass1_631;
        Class27.aClass1_664 = CacheIndex_Sub1.aClass1_1799;
        Class61.aClass1_1422 = KeyFocusListener.aClass1_1271;
        Landscape.aClass1_1181 = HuffmanEncoding.aClass1_1549;
        Class40_Sub7.aClass1_2125 = Class67.aClass1_1591;
        UnderlayDefinition.aClass1_2577 = Class48.aClass1_1137;
        Renderable.aClass1_2864 = CacheIndex_Sub1.aClass1_1816;
        Class68_Sub1.aClass1_2209 = RSString.aClass1_1702;
        ActorDefinition.str_Moderator_mute_option_ON = WallDecoration.aClass1_1269;
        Class22.aClass1_532 = Class57.aClass1_1340;
        Class67.aClass1_1598 = Class37.aClass1_867;
        Npc.aClass1_3305 = Class22_Sub1.aClass1_1871;
        FloorDecoration.aClass1_591 = Class24.aClass1_575;
        Node.aClass1_940 = Class37.aClass1_879;
        SpotAnimDefinition.aClass1_2297 = Item.aClass1_3062;
        Class38_Sub1.aClass1_1917 = Class22.aClass1_538;
        Class30.aClass1_701 = Class35.aClass1_1731;
        Class42.aClass1_997 = SpotAnimDefinition.aClass1_2292;
        Class39.aClass1_904 = Class56.aClass1_1314;
        Class61.aClass1_1421 = ISAAC.aClass1_529;
        Cache.dropStringInstance = SubNode.aClass1_2095;
        Widget.aClass1_2740 = Item.aClass1_3071;
        Class42.aClass1_1001 = Class49.aClass1_1155;
        RSRuntimeException.str_select = Buffer.aClass1_1990;
        Class51.aClass1_1200 = Class35.aClass1_1726;
        HuffmanEncoding.aClass1_1572 = Class38.aClass1_896;
        Cache.aClass1_333 = Class12.aClass1_391;
        Class51.aClass1_1208 = Class64.aClass1_1505;
        Node.aClass1_951 = Class64.aClass1_1523;
        Node.aClass1_931 = PacketBuffer.aClass1_2259;
        Main.aClass1_1763 = Class22_Sub2.aClass1_1889;
        Buffer.aClass1_1983 = OverlayDefinition.aClass1_2315;
        Landscape.aClass1_1173 = Class64.aClass1_1502;
        SceneTile.aClass1_2053 = Renderable.aClass1_2871;
        SpotAnimDefinition.str_prefix_level = Class39.aClass1_914;
        SceneTile.aClass1_2050 = Class37.aClass1_860;
        Node.aClass1_969 = Class64.aClass1_1523;
        Node.aClass1_934 = Class64.aClass1_1523;
        Class40_Sub5_Sub6.aClass1_2460 = Main.aClass1_1757;
        VertexNormal.aClass1_1099 = Actor.aClass1_3154;
        IdentityKit.aClass1_2593 = Class22_Sub1.aClass1_1838;
        Player.aClass1_3286 = IdentityKit.aClass1_2611;
        Node.aClass1_973 = Class64.aClass1_1523;
        FloorDecoration.STRING_CONNECTING_UPDATE_SERVER = FloorDecoration.aClass1_613;
        Player.aClass1_3256 = Npc.aClass1_3308;
        Class40_Sub5_Sub1.aClass1_2274 = Class49.aClass1_1149;
        Class8.aClass1_278 = Class13.aClass1_411;
        GenericTile.aClass1_1218 = IdentityKit.aClass1_2592;
        Node.aClass1_955 = Class64.aClass1_1523;
        Class59.aClass1_1399 = GenericTile.aClass1_1228;
        Class22_Sub1.aClass1_1851 = RSApplet.aClass1_35;
        Node.aClass1_949 = Class27.aClass1_647;
        Class40_Sub5_Sub6.aClass1_2462 = Class22_Sub2.aClass1_1883;
        Class40_Sub13.aClass1_2188 = CacheIndex_Sub1.aClass1_1814;
        Class42.aClass1_1002 = SpotAnimDefinition.aClass1_2292;
        Class38_Sub1.aClass1_1905 = WallDecoration.aClass1_1246;
        Node.aClass1_957 = Class27.aClass1_652;
        Class38.aClass1_885 = SceneCluster.aClass1_766;
        Class22_Sub1.aClass1_1857 = Class12.aClass1_381;
        RSCanvas.aClass1_67 = Class40_Sub5_Sub15.aClass1_2793;
        Node.aClass1_972 = Class37.aClass1_860;
        Class26.aClass1_619 = Class40_Sub7.aClass1_2128;
        Class27.aClass1_668 = Class40_Sub2.aClass1_1995;
        ActorDefinition.aClass1_2432 = VarbitDefinition.aClass1_2354;
        Class40_Sub5_Sub11.aClass1_2629 = ISAAC.aClass1_523;
        SceneTile.aClass1_2042 = WallDecoration.aClass1_1263;
        Node.aClass1_974 = Cache.aClass1_325;
        Class22_Sub2.aClass1_1891 = Class39.aClass1_899;
        HuffmanEncoding.str_Connecting_to_friendserver = SceneTile.aClass1_2046;
        Node.aClass1_976 = Class64.aClass1_1523;
        Node.aClass1_943 = Class60.aClass1_1408;
        Node.aClass1_930 = Class64.aClass1_1523;
        Class40_Sub5_Sub6.aClass1_2438 = Node.aClass1_965;
        Class38.aClass1_882 = Player.aClass1_3285;
        Class40_Sub7.aClass1_2132 = Class12.aClass1_395;
        RSCanvas.aClass1_63 = Npc.aClass1_3302;
        Class57.aClass1_1339 = RSString.aClass1_1713;
        Landscape.aClass1_1174 = Class64.aClass1_1524;
        Class38.aClass1_883 = Class40_Sub5_Sub15.aClass1_2781;
        Class22_Sub1.aClass1_1864 = Landscape.aClass1_1160;
        Node.aClass1_956 = Class27.aClass1_647;
        Widget.aClass1_2671 = HuffmanEncoding.aClass1_1558;
        Class43.aClass1_1019 = CacheIndex_Sub1.aClass1_1798;
        Class40_Sub5_Sub6.aClass1_2446 = Class68_Sub1.aClass1_2198;
        Widget.aClass1_2684 = SpotAnimDefinition.aClass1_2291;
        Class27.takeStringInstance = SpotAnimDefinition.aClass1_2296;
        Class48.aClass1_1124 = MouseHandler.aClass1_1471;
        Class5.aClass1_193 = Landscape.aClass1_1161;
        Class49.aClass1_1148 = Class40_Sub5_Sub1.aClass1_2279;
        Class33.aClass1_799 = Npc.aClass1_3307;
        Class4.aClass1_180 = Class34.aClass1_804;
        Class40_Sub5_Sub15.aClass1_2786 = CacheIndex_Sub1.aClass1_1801;
        GameObject.aClass1_3039 = Class8.aClass1_293;
        Class40_Sub5_Sub17_Sub1.aClass1_3009 = Main.aClass1_1777;
        GameObject.aClass1_3038 = Class39.aClass1_911;
        Class17.aClass1_452 = RSRuntimeException.aClass1_1644;
        Class42.aClass1_988 = Class40_Sub13.aClass1_2186;
        GroundItemTile.aClass1_1354 = Player.aClass1_3269;
        Class22_Sub1.aClass1_1865 = RSRuntimeException.aClass1_1647;
        Class61.aClass1_1428 = SceneTile.aClass1_2051;
        Widget.aClass1_2674 = Class33.aClass1_797;
        Class30.aClass1_682 = PacketBuffer.aClass1_2245;
        ActorDefinition.aClass1_2410 = RSApplet.aClass1_21;
        UnderlayDefinition.aClass1_2566 = FloorDecoration.aClass1_609;
        Node.aClass1_944 = Class64.aClass1_1523;
        PacketBuffer.str_Please_Wait = Class49.aClass1_1153;
        VertexNormal.aClass1_1105 = Class40_Sub13.aClass1_2181;
        Class42.aClass1_1011 = Actor.aClass1_3158;
        Class22_Sub1.aClass1_1870 = Class49.aClass1_1143;
        MouseHandler.aClass1_1474 = Class8.aClass1_300;
        Node.aClass1_937 = Class64.aClass1_1523;
        VertexNormal.aClass1_1090 = Class43.aClass1_1026;
        ActorDefinition.aClass1_2401 = RSApplet.aClass1_21;
        Node.aClass1_967 = Wall.aClass1_343;
        Class65.aClass1_1538 = GameObject.aClass1_3043;
        ActorDefinition.aClass1_2392 = SceneTile.aClass1_2044;
        VertexNormal.aClass1_1097 = Class22_Sub1.aClass1_1849;
        Class40_Sub6.aClass1_2097 = AnimationSequence.aClass1_2481;
        Class67.aClass1_1585 = Class61.aClass1_1426;
        RSString.aClass1_1703 = Class12.aClass1_385;
        VertexNormal.str_Moderator_mute_option_OFF = Class26.aClass1_633;
        LinkedList.aClass1_1076 = GameObjectDefinition.aClass1_2556;
        Class34.aClass1_829 = RSApplet.aClass1_25;
        CollisionMap.str_continue = Class26.aClass1_629;
        Landscape.aClass1_1178 = CacheIndex.aClass1_259;
        Class61.aClass1_1432 = Class44.aClass1_1034;
        Node.aClass1_941 = Class64.aClass1_1523;
        Class26.aClass1_634 = UnderlayDefinition.aClass1_2564;
        WallDecoration.aClass1_1259 = Class12.aClass1_396;
        VarbitDefinition.aClass1_2351 = Class4.aClass1_181;
        Class22_Sub1.aClass1_1858 = Class12.aClass1_382;
        CacheIndex.aClass1_258 = AnimationSequence.aClass1_2475;
        Class35.aClass1_1747 = LinkedList.aClass1_1079;
        Class33.aClass1_783 = Class42.aClass1_1003;
        IdentityKit.aClass1_2615 = HashTable.aClass1_558;
        Main.aClass1_1761 = Class17.aClass1_457;
        Class38_Sub1.aClass1_1922 = Class12.aClass1_386;
        Class44.aClass1_1038 = LinkedList.aClass1_1059;
        Item.aClass1_3050 = Class56.aClass1_1316;
        Class40_Sub6.aClass1_2111 = VertexNormal.aClass1_1116;
        Class39.str_ok = GameObject.aClass1_3037;
        Class12.aClass1_397 = Player.aClass1_3290;
        Landscape.aClass1_1180 = Class40_Sub2.aClass1_2008;
        Class22.aClass1_542 = Class48.aClass1_1137;
        Class17.aClass1_455 = PacketBuffer.aClass1_2260;
        Node.aClass1_924 = aClass1_1292;
        aClass1_1298 = Item.aClass1_3055;
        Actor.aClass1_3124 = LinkedList.aClass1_1084;
        Class60.aClass1_1416 = Widget.aClass1_2716;
        Class42.aClass1_1000 = CollisionMap.aClass1_164;
        ISAAC.aClass1_526 = Class13.aClass1_422;
        Node.aClass1_963 = LinkedList.aClass1_1078;
        Item.aClass1_3069 = ISAAC.aClass1_517;
        Class48.aClass1_1122 = Cache.aClass1_331;
        Class40_Sub5_Sub17_Sub1.aClass1_3014 = GenericTile.aClass1_1241;
        Class44.aClass1_1032 = LinkedList.aClass1_1059;
        VarbitDefinition.aClass1_2357 = Player.aClass1_3275;
        Class8.aClass1_294 = Class40_Sub5_Sub17_Sub6.aClass1_3245;
        Node.aClass1_964 = Class64.aClass1_1523;
    }

    public static int method963(int arg0, byte arg1, int arg2) {
        if(arg0 > arg2) {
            int i = arg2;
            arg2 = arg0;
            arg0 = i;
        }
        if(arg1 != -62)
            aClass48_1289 = null;
        int i;
        for(/**/; arg0 != 0; arg0 = i) {
            i = arg2 % arg0;
            arg2 = arg0;
        }
        return arg2;
    }

    public static void method964(int arg0) {
        try {
            Graphics graphics = MouseHandler.aCanvas1469.getGraphics();
            SubNode.aClass68_2091.method1044(0, 553, graphics, 205);
        } catch(Exception exception) {
            MouseHandler.aCanvas1469.repaint();
        }
        if(arg0 != 40)
            anInt1296 = 7;
    }

    public static void method965(int arg0, Component arg1) {
        if(arg0 == 32) {
            arg1.removeMouseListener(GameObject.frame);
            arg1.removeMouseMotionListener(GameObject.frame);
            arg1.removeFocusListener(GameObject.frame);
        }
    }

    public static void method966(int arg0, CacheIndex arg1, CacheIndex arg2) {
        UnderlayDefinition.aCacheIndex_2582 = arg1;
        int i = -87 / ((-20 - arg0) / 56);
        InteractiveObject.aCacheIndex_488 = arg2;
    }
}
