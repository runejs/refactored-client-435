/* Class40 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Node
{
    public static RSString aClass1_923;
    public static RSString aClass1_924;
    public static RSString aClass1_925;
    public static int anInt926;
    public static int anInt927;
    public static int anInt928;
    public static RSString aClass1_929;
    public static RSString aClass1_930;
    public static RSString aClass1_931;
    public static RSString aClass1_932;
    public static RSString aClass1_933
	= Class58.method978(-11538, " zuerst von Ihrer Ignorieren)2Liste(Q");
    public static RSString aClass1_934;
    public static int anInt935;
    public long key;
    public static RSString aClass1_937;
    public static int anInt938;
    public static RSString aClass1_939 = Class58.method978(-11538, "white:");
    public static RSString aClass1_940 = aClass1_939;
    public static RSString aClass1_941;
    public static RSString aClass1_942;
    public static RSString aClass1_943;
    public static RSString aClass1_944;
    public static RSString aClass1_945;
    public static RSString aClass1_946;
    public static int anInt947;
    public static RSString aClass1_948 = Class58.method978(-11538, ":chalreq:");
    public static RSString aClass1_949;
    public Node aClass40_950;
    public static RSString aClass1_951;
    public static RSString aClass1_952;
    public static RSString aClass1_953;
    public static RSString aClass1_954;
    public static RSString aClass1_955;
    public static RSString aClass1_956;
    public static RSString aClass1_957;
    public static RSString aClass1_958;
    public static RSString aClass1_959;
    public static RSString aClass1_960;
    public static int anInt961;
    public static int anInt962;
    public static RSString aClass1_963;
    public static RSString aClass1_964;
    public static RSString aClass1_965;
    public static RSString aClass1_966;
    public static RSString aClass1_967;
    public Node aClass40_968;
    public static RSString aClass1_969;
    public static int anInt970;
    public static int anInt971;
    public static RSString aClass1_972;
    public static RSString aClass1_973;
    public static RSString aClass1_974;
    public static RSString aClass1_975;
    public static RSString aClass1_976;
    
    public boolean method454(boolean arg0) {
	try {
	    anInt962++;
	    if (aClass40_968 == null)
		return false;
	    if (arg0 != false)
		method458((byte) -21);
	    return true;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "nd.QA(" + arg0 + ')');
	}
    }
    
    public static void method455(int arg0, int arg1, int arg2, int arg3) {
	if (arg2 != 1)
	    aClass1_972 = null;
	for (int i = 0; (i ^ 0xffffffff) > -9; i++) {
	    for (int i_0_ = 0; (i_0_ ^ 0xffffffff) > -9; i_0_++)
		Class40_Sub6.anIntArrayArrayArray2099[arg1][arg3 - -i]
		    [arg0 - -i_0_]
		    = 0;
	}
	anInt935++;
	if ((arg3 ^ 0xffffffff) < -1) {
	    for (int i = 1; (i ^ 0xffffffff) > -9; i++)
		Class40_Sub6.anIntArrayArrayArray2099[arg1][arg3][arg0 - -i]
		    = (Class40_Sub6.anIntArrayArrayArray2099[arg1][-1 + arg3]
		       [i + arg0]);
	}
	if ((arg0 ^ 0xffffffff) < -1) {
	    for (int i = 1; i < 8; i++)
		Class40_Sub6.anIntArrayArrayArray2099[arg1][i + arg3][arg0]
		    = (Class40_Sub6.anIntArrayArrayArray2099[arg1][i + arg3]
		       [-1 + arg0]);
	}
	if ((arg3 ^ 0xffffffff) < -1
	    && (Class40_Sub6.anIntArrayArrayArray2099[arg1][-1 + arg3][arg0]
		!= 0))
	    Class40_Sub6.anIntArrayArrayArray2099[arg1][arg3][arg0]
		= Class40_Sub6.anIntArrayArrayArray2099[arg1][arg3 - 1][arg0];
	else if (arg0 > 0 && ((Class40_Sub6.anIntArrayArrayArray2099[arg1]
			       [arg3][arg0 - 1])
			      ^ 0xffffffff) != -1)
	    Class40_Sub6.anIntArrayArrayArray2099[arg1][arg3][arg0]
		= Class40_Sub6.anIntArrayArrayArray2099[arg1][arg3][-1 + arg0];
	else if ((arg3 ^ 0xffffffff) < -1 && (arg0 ^ 0xffffffff) < -1
		 && ((Class40_Sub6.anIntArrayArrayArray2099[arg1][arg3 + -1]
		      [-1 + arg0])
		     ^ 0xffffffff) != -1)
	    Class40_Sub6.anIntArrayArrayArray2099[arg1][arg3][arg0]
		= (Class40_Sub6.anIntArrayArrayArray2099[arg1][-1 + arg3]
		   [arg0 - 1]);
    }
    
    public static void method456(int arg0, byte arg1) {
	try {
	    anInt961++;
	    if (arg1 < 79)
		aClass1_965 = null;
	    if (Class24.method340(61)) {
		if (Class26.aBoolean618)
		    Floor.anInt2342 = arg0;
		else
		    Class40_Sub5_Sub13.method651(22741, arg0);
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "nd.PA(" + arg0 + ',' + arg1 + ')');
	}
    }
    
    public void method457(int arg0) {
	try {
	    anInt970++;
	    if (aClass40_968 != null) {
		aClass40_968.aClass40_950 = aClass40_950;
		if (arg0 == -1) {
		    aClass40_950.aClass40_968 = aClass40_968;
		    aClass40_968 = null;
		    aClass40_950 = null;
		}
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "nd.OA(" + arg0 + ')');
	}
    }
    
    public static void method458(byte arg0) {
	try {
	    aClass1_952 = null;
	    aClass1_939 = null;
	    aClass1_964 = null;
	    aClass1_965 = null;
	    aClass1_940 = null;
	    aClass1_973 = null;
	    aClass1_924 = null;
	    aClass1_934 = null;
	    aClass1_967 = null;
	    aClass1_954 = null;
	    aClass1_972 = null;
	    aClass1_976 = null;
	    aClass1_944 = null;
	    aClass1_959 = null;
	    aClass1_943 = null;
	    aClass1_933 = null;
	    aClass1_975 = null;
	    aClass1_949 = null;
	    aClass1_951 = null;
	    aClass1_974 = null;
	    aClass1_963 = null;
	    aClass1_942 = null;
	    aClass1_946 = null;
	    if (arg0 <= 60)
		method459(69, 126, (byte) 94);
	    aClass1_929 = null;
	    aClass1_955 = null;
	    aClass1_931 = null;
	    aClass1_941 = null;
	    aClass1_945 = null;
	    aClass1_930 = null;
	    aClass1_956 = null;
	    aClass1_948 = null;
	    aClass1_966 = null;
	    aClass1_960 = null;
	    aClass1_969 = null;
	    aClass1_932 = null;
	    aClass1_923 = null;
	    aClass1_953 = null;
	    aClass1_957 = null;
	    aClass1_937 = null;
	    aClass1_925 = null;
	    aClass1_958 = null;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "nd.TA(" + arg0 + ')');
	}
    }
    
    public static boolean method459(int arg0, int arg1, byte arg2) {
	try {
	    if ((arg0 ^ 0xffffffff) == -12)
		arg0 = 10;
	    if (arg2 < 83)
		method459(125, 22, (byte) 101);
	    anInt971++;
	    Class40_Sub5_Sub8 class40_sub5_sub8
		= Class40_Sub4.method535(arg1, (byte) 127);
	    if ((arg0 ^ 0xffffffff) <= -6 && (arg0 ^ 0xffffffff) >= -9)
		arg0 = 4;
	    return class40_sub5_sub8.method610(arg0, 7533);
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("nd.SA(" + arg0 + ',' + arg1 + ',' + arg2
				    + ')'));
	}
    }
    
    static {
	anInt938 = 500;
	anInt926 = 0;
	aClass1_932 = Class58.method978(-11538, "@gr2@");
	aClass1_923 = Class58.method978(-11538, "");
	aClass1_955 = aClass1_923;
	aClass1_958 = aClass1_923;
	aClass1_967 = aClass1_923;
	aClass1_951 = aClass1_923;
	aClass1_937 = aClass1_923;
	aClass1_966 = aClass1_923;
	aClass1_949 = aClass1_923;
	aClass1_944 = aClass1_923;
	aClass1_943 = aClass1_923;
	aClass1_974 = aClass1_923;
	aClass1_959 = aClass1_923;
	aClass1_964 = aClass1_923;
	aClass1_930 = aClass1_923;
	aClass1_969 = aClass1_923;
	aClass1_925 = aClass1_923;
	aClass1_965 = Class58.method978(-11538, "scrollen:");
	aClass1_941 = aClass1_923;
	aClass1_931 = aClass1_923;
	aClass1_975 = Class58.method978(-11538, ")3");
	aClass1_946 = aClass1_923;
	aClass1_952 = aClass1_923;
	aClass1_945 = aClass1_923;
	aClass1_957 = aClass1_923;
	aClass1_954 = aClass1_923;
	aClass1_929 = aClass1_923;
	aClass1_924 = aClass1_923;
	aClass1_942 = aClass1_923;
	aClass1_953 = aClass1_923;
	aClass1_934 = aClass1_923;
	aClass1_960 = aClass1_923;
	aClass1_973 = aClass1_923;
	aClass1_956 = aClass1_923;
	aClass1_976 = aClass1_923;
	aClass1_963 = aClass1_923;
	anInt947 = 0;
	aClass1_972 = aClass1_923;
    }
}
