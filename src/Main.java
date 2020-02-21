/* client - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.net.InetAddress;
import java.net.Socket;

public class Main extends RSApplet
{
    public static int anInt1754;
    public static int anInt1755;
    public static int anInt1756;
    public static RSString aClass1_1757
	= Class58.method978(-11538, "RS Rebirth wurde aktualisiert(Q");
    public static int anInt1758;
    public static int anInt1759;
    public static int anInt1760;
    public static RSString aClass1_1761;
    public static RSString aClass1_1762 = Class58.method978(-11538, "logo");
    public static RSString aClass1_1763;
    public static int anInt1764;
    public static int anInt1765;
    public static int anInt1766;
    public static RSString aClass1_1767 = Class58.method978(-11538, "Use");
    public static int anInt1768;
    public static int anInt1769;
    public static int anInt1770;
    public static int anInt1771;
    public static int anInt1772;
    public static int anInt1773;
    public static int anInt1774;
    public static RSString aClass1_1775;
    public static int anInt1776;
    public static RSString aClass1_1777;
    public static RSString[] aClass1Array1778;
    public static int anInt1779;
    public static int anInt1780;
    public static RSString aClass1_1781;
    public static int anInt1782;
    public static RSString aClass1_1783;
    public static int anInt1784;
    public static int anInt1785;
    public static int anInt1786;
    public static int anInt1787;
    public static RSString aClass1_1788;
    public static int anInt1789;
    public static boolean aBoolean1790;
    public static boolean aBoolean1791;
    
    public void method35(int arg0, int arg1) {
	anInt1789++;
	if (Class10.anInt350 != Floor.anInt2340)
	    Class10.anInt350 = Floor.anInt2340;
	else
	    Class10.anInt350 = Class3.anInt172;
	Class29.aClass64_676 = null;
	Class68.aClass15_1632 = null;
	Class8.anInt292++;
	if (arg0 != 30)
	    main(null);
	Class8.anInt290 = 0;
	if ((Class8.anInt292 ^ 0xffffffff) > -3
	    || arg1 != 7 && (arg1 ^ 0xffffffff) != -10) {
	    if (Class8.anInt292 < 2 || (arg1 ^ 0xffffffff) != -7) {
		if (Class8.anInt292 >= 4) {
		    if ((Class51.anInt1197 ^ 0xffffffff) >= -6) {
			this.openErrorPage((byte) 104, "js5connect");
			Class51.anInt1197 = 1000;
		    } else
			ISAAC.anInt509 = 3000;
		}
	    } else {
		this.openErrorPage((byte) 86, "js5connect_outofdate");
		Class51.anInt1197 = 1000;
	    }
	} else if (Class51.anInt1197 > 5)
	    ISAAC.anInt509 = 3000;
	else {
	    this.openErrorPage((byte) 122, "js5connect_full");
	    Class51.anInt1197 = 1000;
	}
    }
    
    public static boolean method36(int arg0, int arg1, int arg2, int arg3,
				   int arg4, int arg5, int arg6, int arg7,
				   Class40_Sub5_Sub12[] arg8, boolean arg9) {
	try {
	    Rasterizer.method655(arg2, arg1, arg6, arg5);
	    boolean bool = arg9;
	    for (int i = 0; (i ^ 0xffffffff) > (arg8.length ^ 0xffffffff);
		 i++) {
		Class40_Sub5_Sub12 class40_sub5_sub12 = arg8[i];
		if (class40_sub5_sub12 != null
		    && class40_sub5_sub12.anInt2648 == arg4) {
		    if (class40_sub5_sub12.anInt2639 > 0)
			Class58.method976((byte) 70, class40_sub5_sub12);
		    int i_0_ = arg2 + class40_sub5_sub12.anInt2656;
		    if (!class40_sub5_sub12.aBoolean2694)
			i_0_ -= arg3;
		    int i_1_ = arg1 + class40_sub5_sub12.anInt2696;
		    if (!class40_sub5_sub12.aBoolean2694)
			i_1_ -= arg7;
		    int i_2_ = class40_sub5_sub12.anInt2745;
		    if (class40_sub5_sub12
			== Class10.aClass40_Sub5_Sub12_353) {
			i_2_ = 128;
			Class40_Sub5_Sub12 class40_sub5_sub12_3_
			    = Class40_Sub13.method878(-1598852880,
						      class40_sub5_sub12);
			int[] is = Class13.method247(class40_sub5_sub12_3_,
						     (byte) 117);
			int[] is_4_
			    = Class13.method247(class40_sub5_sub12, (byte) 97);
			int i_5_ = (Landscape.anInt1166
				    + (-Class40_Sub5_Sub11.anInt2621
				       + (is_4_[1] - is[1])));
			if (i_5_ < 0)
			    i_5_ = 0;
			if (i_5_ - -class40_sub5_sub12.anInt2643
			    > class40_sub5_sub12_3_.anInt2643)
			    i_5_ = (class40_sub5_sub12_3_.anInt2643
				    + -class40_sub5_sub12.anInt2643);
			i_1_ = i_5_ + is[1];
			int i_6_ = (Class13.anInt420
				    + (-Class40_Sub2.anInt1996 + -is[0])
				    + is_4_[0]);
			if (i_6_ < 0)
			    i_6_ = 0;
			if ((i_6_ - -class40_sub5_sub12.anInt2692 ^ 0xffffffff)
			    < (class40_sub5_sub12_3_.anInt2692 ^ 0xffffffff))
			    i_6_ = (-class40_sub5_sub12.anInt2692
				    + class40_sub5_sub12_3_.anInt2692);
			i_0_ = is[0] - -i_6_;
		    }
		    if (!class40_sub5_sub12.aBoolean2636
			|| (Rasterizer.anInt2772 >= i_0_
			    && ((Rasterizer.anInt2770 ^ 0xffffffff)
				<= (i_1_ ^ 0xffffffff))
			    && ((Rasterizer.anInt2771 ^ 0xffffffff)
				>= (i_0_ + class40_sub5_sub12.anInt2692
				    ^ 0xffffffff))
			    && ((i_1_ - -class40_sub5_sub12.anInt2643
				 ^ 0xffffffff)
				<= (Rasterizer.anInt2767
				    ^ 0xffffffff)))) {
			if (class40_sub5_sub12.anInt2683 == 0) {
			    if (class40_sub5_sub12.aBoolean2750
				&& !Class29.method371(8247, arg0, i))
				continue;
			    if (!class40_sub5_sub12.aBoolean2636) {
				if ((-class40_sub5_sub12.anInt2643
				     + class40_sub5_sub12.anInt2720)
				    < class40_sub5_sub12.anInt2731)
				    class40_sub5_sub12.anInt2731
					= (-class40_sub5_sub12.anInt2643
					   + class40_sub5_sub12.anInt2720);
				if (class40_sub5_sub12.anInt2731 < 0)
				    class40_sub5_sub12.anInt2731 = 0;
			    }
			    bool &= method36(arg0, i_1_, i_0_,
					     class40_sub5_sub12.anInt2746, i,
					     (class40_sub5_sub12.anInt2643
					      + i_1_),
					     (class40_sub5_sub12.anInt2692
					      + i_0_),
					     class40_sub5_sub12.anInt2731,
					     arg8, arg9);
			    if (class40_sub5_sub12.aClass40_Sub5_Sub12Array2713
				!= null)
				bool &= (method36
					 (arg0, i_1_, i_0_,
					  class40_sub5_sub12.anInt2746,
					  class40_sub5_sub12.anInt2689,
					  i_1_ - -class40_sub5_sub12.anInt2643,
					  class40_sub5_sub12.anInt2692 + i_0_,
					  class40_sub5_sub12.anInt2731,
					  (class40_sub5_sub12
					   .aClass40_Sub5_Sub12Array2713),
					  true));
			    Rasterizer.method655(arg2, arg1, arg6,
							 arg5);
			    if ((class40_sub5_sub12.anInt2643 ^ 0xffffffff)
				> (class40_sub5_sub12.anInt2720 ^ 0xffffffff))
				Class27.method355(0,
						  class40_sub5_sub12.anInt2731,
						  class40_sub5_sub12.anInt2720,
						  i_0_ + (class40_sub5_sub12
							  .anInt2692),
						  class40_sub5_sub12.anInt2643,
						  i_1_);
			}
			if (class40_sub5_sub12.anInt2683 != 1) {
			    if (class40_sub5_sub12.anInt2683 == 2) {
				int i_7_ = 0;
				for (int i_8_ = 0;
				     ((i_8_ ^ 0xffffffff)
				      > (class40_sub5_sub12.anInt2643
					 ^ 0xffffffff));
				     i_8_++) {
				    for (int i_9_ = 0;
					 class40_sub5_sub12.anInt2692 > i_9_;
					 i_9_++) {
					int i_10_
					    = ((class40_sub5_sub12.anInt2749
						+ 32) * i_9_
					       + i_0_);
					int i_11_
					    = ((32 - -(class40_sub5_sub12
						       .anInt2667)) * i_8_
					       + i_1_);
					if ((i_7_ ^ 0xffffffff) > -21) {
					    i_10_ += (class40_sub5_sub12
						      .anIntArray2699[i_7_]);
					    i_11_ += (class40_sub5_sub12
						      .anIntArray2708[i_7_]);
					}
					if (((class40_sub5_sub12.anIntArray2685
					      [i_7_])
					     ^ 0xffffffff)
					    >= -1) {
					    if ((class40_sub5_sub12
						 .anIntArray2704) != null
						&& (i_7_ ^ 0xffffffff) > -21) {
						DirectColorSprite class40_sub5_sub14_sub4
						    = (class40_sub5_sub12
							   .method638
						       ((byte) 78, i_7_));
						if (class40_sub5_sub14_sub4
						    == null) {
						    if (Class40_Sub13
							.aBoolean2177)
							bool = false;
						} else
						    class40_sub5_sub14_sub4
							.method721
							(i_10_, i_11_);
					    }
					} else {
					    int i_12_ = 0;
					    int i_13_
						= -1 + (class40_sub5_sub12
							.anIntArray2685[i_7_]);
					    int i_14_ = 0;
					    if ((-32 + (Rasterizer
							.anInt2771) < i_10_
						 && ((i_10_ ^ 0xffffffff)
						     > ((Rasterizer
							 .anInt2772)
							^ 0xffffffff))
						 && (((Rasterizer
						       .anInt2767) + -32
						      ^ 0xffffffff)
						     > (i_11_ ^ 0xffffffff))
						 && (Rasterizer
						     .anInt2770) > i_11_)
						|| (Class40_Sub4.anInt2049 != 0
						    && (Class58.anInt1352
							== i_7_))) {
						int i_15_ = 0;
						if (Class8.anInt301 == 1
						    && ((Class45.anInt1061
							 ^ 0xffffffff)
							== (i_7_ ^ 0xffffffff))
						    && ((class40_sub5_sub12
							 .anInt2689)
							== ISAAC.anInt525))
						    i_15_ = 16777215;
						DirectColorSprite class40_sub5_sub14_sub4
						    = (Class40_Sub13.method876
						       (117,
							(class40_sub5_sub12
							 .anIntArray2710
							 [i_7_]),
							i_13_, i_15_));
						if (class40_sub5_sub14_sub4
						    == null)
						    bool = false;
						else {
						    if ((Class40_Sub4.anInt2049
							 ^ 0xffffffff) != -1
							&& ((i_7_ ^ 0xffffffff)
							    == ((Class58
								 .anInt1352)
								^ 0xffffffff))
							&& ((class40_sub5_sub12
							     .anInt2689)
							    == (Class48
								.anInt1127))) {
							i_14_
							    = ((Landscape
								.anInt1166)
							       + -(ItemDefinition
								   .anInt2798));
							i_12_
							    = (Class13.anInt420
							       + -(Class40_Sub5_Sub17
								   .anInt2869));
							if (i_12_ < 5
							    && i_12_ > -5)
							    i_12_ = 0;
							if (i_14_ < 5
							    && ((i_14_
								 ^ 0xffffffff)
								< 4))
							    i_14_ = 0;
							if (((Buffer
							      .anInt1978)
							     ^ 0xffffffff)
							    > -6) {
							    i_14_ = 0;
							    i_12_ = 0;
							}
							class40_sub5_sub14_sub4
							    .method728
							    (i_12_ + i_10_,
							     i_11_ + i_14_,
							     128);
							if ((arg4 ^ 0xffffffff)
							    != 0) {
							    Class40_Sub5_Sub12 class40_sub5_sub12_16_
								= arg8[arg4];
							    if (((i_14_ + i_11_
								  ^ 0xffffffff)
								 > ((Rasterizer
								     .anInt2767)
								    ^ 0xffffffff))
								&& ((class40_sub5_sub12_16_
								     .anInt2731)
								    > 0)) {
								int i_17_
								    = ((Class5
									.anInt199)
								       * ((Rasterizer
									   .anInt2767)
									  + -i_11_
									  - i_14_)
								       / 3);
								if ((10
								     * (Class5
									.anInt199))
								    < i_17_)
								    i_17_
									= (10
									   * Class5.anInt199);
								if ((i_17_
								     ^ 0xffffffff)
								    < ((class40_sub5_sub12_16_
									.anInt2731)
								       ^ 0xffffffff))
								    i_17_
									= (class40_sub5_sub12_16_
									   .anInt2731);
								class40_sub5_sub12_16_
								    .anInt2731
								    -= i_17_;
								ItemDefinition
								    .anInt2798
								    += i_17_;
							    }
							    if ((((Rasterizer
								   .anInt2770)
								  ^ 0xffffffff)
								 > ((32 + i_11_
								     + i_14_)
								    ^ 0xffffffff))
								&& (((class40_sub5_sub12_16_
								      .anInt2731)
								     ^ 0xffffffff)
								    > ((-(class40_sub5_sub12_16_
									  .anInt2643)
									+ (class40_sub5_sub12_16_
									   .anInt2720))
								       ^ 0xffffffff))) {
								int i_18_
								    = ((Class5
									.anInt199)
								       * (-(Rasterizer
									    .anInt2770)
									  + 32
									  + (i_11_
									     + i_14_))
								       / 3);
								if (((Class5
								      .anInt199)
								     * 10)
								    < i_18_)
								    i_18_
									= (10
									   * Class5.anInt199);
								if ((-(class40_sub5_sub12_16_
								       .anInt2731)
								     + (class40_sub5_sub12_16_
									.anInt2720)
								     + -(class40_sub5_sub12_16_
									 .anInt2643))
								    < i_18_)
								    i_18_
									= (-class40_sub5_sub12_16_.anInt2643
									   + class40_sub5_sub12_16_.anInt2720
									   + -class40_sub5_sub12_16_.anInt2731);
								ItemDefinition
								    .anInt2798
								    -= i_18_;
								class40_sub5_sub12_16_
								    .anInt2731
								    += i_18_;
							    }
							}
						    } else if ((Class40_Sub5_Sub17_Sub1
								.anInt2999) == 0
							       || ((Class52
								    .anInt1233)
								   != i_7_)
							       || (((Class30
								     .anInt704)
								    ^ 0xffffffff)
								   != ((class40_sub5_sub12
									.anInt2689)
								       ^ 0xffffffff)))
							class40_sub5_sub14_sub4
							    .method721
							    (i_10_, i_11_);
						    else
							class40_sub5_sub14_sub4
							    .method728
							    (i_10_, i_11_,
							     128);
						    if (((class40_sub5_sub14_sub4
							  .anInt2954)
							 ^ 0xffffffff) == -34
							|| (class40_sub5_sub12
							    .anIntArray2710
							    [i_7_]) != 1) {
							int i_19_
							    = (class40_sub5_sub12
							       .anIntArray2710
							       [i_7_]);
							Class40_Sub5_Sub17_Sub6
							    .aClass40_Sub5_Sub14_Sub1_3236
							    .method690
							    ((Class40_Sub5_Sub12
								  .method648
							      (i_19_,
							       (byte) -100)),
							     i_12_ + (1
								      + i_10_),
							     (i_11_ + 10
							      - -i_14_),
							     0);
							Class40_Sub5_Sub17_Sub6
							    .aClass40_Sub5_Sub14_Sub1_3236
							    .method690
							    ((Class40_Sub5_Sub12
								  .method648
							      (i_19_,
							       (byte) -100)),
							     i_10_ - -i_12_,
							     i_14_ + (i_11_
								      - -9),
							     16776960);
						    }
						}
					    }
					}
					i_7_++;
				    }
				}
			    } else if (class40_sub5_sub12.anInt2683 == 3) {
				int i_20_;
				if (ItemDefinition.method746
				    (false, class40_sub5_sub12)) {
				    i_20_ = class40_sub5_sub12.anInt2726;
				    if (Class29.method371(8247, arg0, i)
					&& (class40_sub5_sub12.anInt2663
					    ^ 0xffffffff) != -1)
					i_20_ = class40_sub5_sub12.anInt2663;
				} else {
				    i_20_ = class40_sub5_sub12.anInt2647;
				    if (Class29.method371(8247, arg0, i)
					&& class40_sub5_sub12.anInt2719 != 0)
					i_20_ = class40_sub5_sub12.anInt2719;
				}
				if (i_2_ == 0) {
				    if (!class40_sub5_sub12.aBoolean2645)
					Rasterizer.method665
					    (i_0_, i_1_,
					     class40_sub5_sub12.anInt2692,
					     class40_sub5_sub12.anInt2643,
					     i_20_);
				    else
					Rasterizer.method656
					    (i_0_, i_1_,
					     class40_sub5_sub12.anInt2692,
					     class40_sub5_sub12.anInt2643,
					     i_20_);
				} else if (!class40_sub5_sub12.aBoolean2645)
				    Rasterizer.method654
					(i_0_, i_1_,
					 class40_sub5_sub12.anInt2692,
					 class40_sub5_sub12.anInt2643, i_20_,
					 -(0xff & i_2_) + 256);
				else
				    Rasterizer.method664
					(i_0_, i_1_,
					 class40_sub5_sub12.anInt2692,
					 class40_sub5_sub12.anInt2643, i_20_,
					 -(0xff & i_2_) + 256);
			    } else if (class40_sub5_sub12.anInt2683 == 4) {
				RSFont class40_sub5_sub14_sub1
				    = class40_sub5_sub12.method647((byte) 34);
				if (class40_sub5_sub14_sub1 == null) {
				    if (Class40_Sub13.aBoolean2177)
					bool = false;
				} else {
				    RSString class1
					= class40_sub5_sub12.aClass1_2668;
				    int i_21_;
				    if (ItemDefinition.method746
					(false, class40_sub5_sub12)) {
					i_21_ = class40_sub5_sub12.anInt2726;
					if (Class29.method371(8247, arg0, i)
					    && (class40_sub5_sub12.anInt2663
						^ 0xffffffff) != -1)
					    i_21_
						= class40_sub5_sub12.anInt2663;
					if (class40_sub5_sub12.aClass1_2640
						.method59(-3136)
					    > 0)
					    class1 = (class40_sub5_sub12
						      .aClass1_2640);
				    } else {
					i_21_ = class40_sub5_sub12.anInt2647;
					if (Class29.method371(8247, arg0, i)
					    && (class40_sub5_sub12.anInt2719
						!= 0))
					    i_21_
						= class40_sub5_sub12.anInt2719;
				    }
				    if (class40_sub5_sub12.aBoolean2636
					&& (class40_sub5_sub12.anInt2718
					    != -1)) {
					ItemDefinition class40_sub5_sub16
					    = (Class44.method897
					       (class40_sub5_sub12.anInt2718,
						10));
					class1
					    = class40_sub5_sub16.aClass1_2796;
					if (class1 == null)
					    class1 = RSApplet.aClass1_34;
					if (class40_sub5_sub16.anInt2795 == 1
					    || (class40_sub5_sub12.anInt2734
						^ 0xffffffff) != -2)
					    class1 = (Class40_Sub5_Sub17_Sub6
							  .method832
						      (-40,
						       (new RSString[]
							{ class1,
							  Class29.aClass1_674,
							  (Class45.method903
							   ((class40_sub5_sub12
							     .anInt2734),
							    (byte) -109)) })));
				    }
				    if (class40_sub5_sub12.anInt2714 == 6
					&& ((class40_sub5_sub12.anInt2689
					     ^ 0xffffffff)
					    == (Class6_Sub1.anInt1819
						^ 0xffffffff))) {
					i_21_ = class40_sub5_sub12.anInt2647;
					class1
					    = PacketBuffer.aClass1_2240;
				    }
				    if ((Rasterizer.anInt2768
					 ^ 0xffffffff)
					== -480) {
					if (i_21_ == 16776960)
					    i_21_ = 255;
					if (i_21_ == 49152)
					    i_21_ = 16777215;
				    }
				    class1 = (Class40_Sub4.method532
					      ((byte) 20, class40_sub5_sub12,
					       class1));
				    class40_sub5_sub14_sub1.method672
					(class1, i_0_, i_1_,
					 class40_sub5_sub12.anInt2692,
					 class40_sub5_sub12.anInt2643, i_21_,
					 class40_sub5_sub12.aBoolean2665,
					 class40_sub5_sub12.anInt2733,
					 class40_sub5_sub12.anInt2715,
					 class40_sub5_sub12.anInt2732);
				}
			    } else if (class40_sub5_sub12.anInt2683 == 5) {
				if (!class40_sub5_sub12.aBoolean2636) {
				    DirectColorSprite class40_sub5_sub14_sub4
					= (class40_sub5_sub12.method643
					   (127,
					    (ItemDefinition.method746
					     (false, class40_sub5_sub12))));
				    if (class40_sub5_sub14_sub4 != null)
					class40_sub5_sub14_sub4
					    .method721(i_0_, i_1_);
				    else if (Class40_Sub13.aBoolean2177)
					bool = false;
				} else {
				    int i_22_ = 0;
				    int i_23_ = 0;
				    DirectColorSprite class40_sub5_sub14_sub4;
				    if (class40_sub5_sub12.anInt2718 == -1)
					class40_sub5_sub14_sub4
					    = class40_sub5_sub12
						  .method643(127, false);
				    else {
					class40_sub5_sub14_sub4
					    = (Class40_Sub13.method876
					       (99,
						class40_sub5_sub12.anInt2734,
						class40_sub5_sub12.anInt2718,
						0));
					i_22_ = (class40_sub5_sub14_sub4
						 .anInt2954);
					i_23_ = (class40_sub5_sub14_sub4
						 .anInt2952);
					class40_sub5_sub14_sub4.anInt2952 = 32;
					class40_sub5_sub14_sub4.anInt2954 = 32;
				    }
				    if (class40_sub5_sub14_sub4 != null) {
					int i_24_ = (class40_sub5_sub14_sub4
						     .anInt2950);
					int i_25_ = (class40_sub5_sub14_sub4
						     .anInt2951);
					if (!class40_sub5_sub12.aBoolean2641) {
					    int i_26_
						= 4096 * (class40_sub5_sub12
							  .anInt2692) / i_25_;
					    if ((class40_sub5_sub12.anInt2751
						 ^ 0xffffffff)
						== -1) {
						if (i_2_ == 0) {
						    if (((i_25_ ^ 0xffffffff)
							 == ((class40_sub5_sub12
							      .anInt2692)
							     ^ 0xffffffff))
							&& ((class40_sub5_sub12
							     .anInt2643)
							    == i_24_))
							class40_sub5_sub14_sub4
							    .method721
							    (i_0_, i_1_);
						    else
							class40_sub5_sub14_sub4
							    .method732
							    (i_0_, i_1_,
							     (class40_sub5_sub12
							      .anInt2692),
							     (class40_sub5_sub12
							      .anInt2643));
						} else
						    class40_sub5_sub14_sub4
							.method716
							(i_0_, i_1_,
							 (class40_sub5_sub12
							  .anInt2692),
							 (class40_sub5_sub12
							  .anInt2643),
							 256 + -(0xff & i_2_));
					    } else
						class40_sub5_sub14_sub4
						    .method720
						    ((class40_sub5_sub12
						      .anInt2692) / 2 + i_0_,
						     (class40_sub5_sub12
						      .anInt2643) / 2 + i_1_,
						     (class40_sub5_sub12
						      .anInt2751),
						     i_26_);
					} else {
					    int[] is = new int[4];
					    Rasterizer.method661(is);
					    int i_27_ = i_0_;
					    if ((is[0] ^ 0xffffffff)
						< (i_27_ ^ 0xffffffff))
						i_27_ = is[0];
					    int i_28_ = i_1_;
					    if ((is[1] ^ 0xffffffff)
						< (i_28_ ^ 0xffffffff))
						i_28_ = is[1];
					    int i_29_
						= (class40_sub5_sub12.anInt2692
						   + i_0_);
					    if ((is[2] ^ 0xffffffff)
						> (i_29_ ^ 0xffffffff))
						i_29_ = is[2];
					    int i_30_
						= (class40_sub5_sub12.anInt2643
						   + i_1_);
					    if (i_30_ > is[3])
						i_30_ = is[3];
					    Rasterizer.method655
						(i_27_, i_28_, i_29_, i_30_);
					    int i_31_
						= (class40_sub5_sub12.anInt2692
						   - (1 + -i_25_)) / i_25_;
					    int i_32_
						= (class40_sub5_sub12.anInt2643
						   - (1 + -i_24_)) / i_24_;
					    for (int i_33_ = 0; i_31_ > i_33_;
						 i_33_++) {
						for (int i_34_ = 0;
						     ((i_32_ ^ 0xffffffff)
						      < (i_34_ ^ 0xffffffff));
						     i_34_++) {
						    if (((class40_sub5_sub12
							  .anInt2751)
							 ^ 0xffffffff)
							== -1) {
							if ((i_2_ ^ 0xffffffff)
							    == -1)
							    class40_sub5_sub14_sub4
								.method721
								((i_33_ * i_25_
								  + i_0_),
								 (i_34_ * i_24_
								  + i_1_));
							else
							    class40_sub5_sub14_sub4
								.method728
								((i_0_
								  - -(i_33_
								      * i_25_)),
								 (i_1_
								  - -(i_24_
								      * i_34_)),
								 (-(i_2_
								    & 0xff)
								  + 256));
						    } else
							class40_sub5_sub14_sub4
							    .method720
							    ((i_25_ / 2
							      + (i_33_ * i_25_
								 + i_0_)),
							     (i_24_ / 2
							      + (i_1_
								 - -(i_24_
								     * i_34_))),
							     (class40_sub5_sub12
							      .anInt2751),
							     4096);
						}
					    }
					    Rasterizer.method657(is);
					}
				    } else if (Class40_Sub13.aBoolean2177)
					bool = false;
				    if ((class40_sub5_sub12.anInt2718
					 ^ 0xffffffff)
					!= 0) {
					if ((class40_sub5_sub12.anInt2734
					     ^ 0xffffffff) != -2
					    || (i_22_ ^ 0xffffffff) == -34) {
					    Class40_Sub5_Sub17_Sub6
						.aClass40_Sub5_Sub14_Sub1_3236
						.method690
						((HashTable.method334
						  ((class40_sub5_sub12
						    .anInt2734),
						   -1)),
						 i_0_ - -1, i_1_ + 10, 0);
					    Class40_Sub5_Sub17_Sub6
						.aClass40_Sub5_Sub14_Sub1_3236
						.method690
						((HashTable.method334
						  ((class40_sub5_sub12
						    .anInt2734),
						   -1)),
						 i_0_, 9 + i_1_, 16776960);
					}
					class40_sub5_sub14_sub4.anInt2954
					    = i_22_;
					class40_sub5_sub14_sub4.anInt2952
					    = i_23_;
				    }
				}
			    } else if ((class40_sub5_sub12.anInt2683
					^ 0xffffffff)
				       == -7) {
				boolean bool_35_
				    = (ItemDefinition.method746
				       (false, class40_sub5_sub12));
				Object object = null;
				int i_36_;
				if (!bool_35_)
				    i_36_ = class40_sub5_sub12.anInt2659;
				else
				    i_36_ = class40_sub5_sub12.anInt2653;
				Model class40_sub5_sub17_sub5;
				if ((class40_sub5_sub12.anInt2687 ^ 0xffffffff)
				    != -6) {
				    if (i_36_ == -1) {
					class40_sub5_sub17_sub5
					    = (class40_sub5_sub12.method646
					       ((byte) 46, null, -1, bool_35_,
						(Class40_Sub5_Sub13
						 .aClass40_Sub5_Sub17_Sub4_Sub1_2760
						 .aClass30_3282)));
					if (class40_sub5_sub17_sub5 == null
					    && Class40_Sub13.aBoolean2177)
					    bool = false;
				    } else {
					Class40_Sub5_Sub7 class40_sub5_sub7
					    = Class68_Sub1.method1050(i_36_,
								      2);
					class40_sub5_sub17_sub5
					    = (class40_sub5_sub12.method646
					       ((byte) 76, class40_sub5_sub7,
						class40_sub5_sub12.anInt2654,
						bool_35_,
						(Class40_Sub5_Sub13
						 .aClass40_Sub5_Sub17_Sub4_Sub1_2760
						 .aClass30_3282)));
					if (class40_sub5_sub17_sub5 == null
					    && Class40_Sub13.aBoolean2177)
					    bool = false;
				    }
				} else if ((class40_sub5_sub12.anInt2673
					    ^ 0xffffffff)
					   != -1)
				    class40_sub5_sub17_sub5
					= Class40_Sub5_Sub13
					      .aClass40_Sub5_Sub17_Sub4_Sub1_2760
					      .method756(92);
				else
				    class40_sub5_sub17_sub5
					= (Class45.aClass30_1082.method377
					   (null, null, -1, -1, (byte) -88));
				int i_37_ = class40_sub5_sub12.anInt2690;
				int i_38_ = class40_sub5_sub12.anInt2725;
				int i_39_ = class40_sub5_sub12.anInt2679;
				int i_40_ = class40_sub5_sub12.anInt2657;
				int i_41_ = class40_sub5_sub12.anInt2737;
				int i_42_ = class40_sub5_sub12.anInt2728;
				if ((class40_sub5_sub12.anInt2718 ^ 0xffffffff)
				    != 0) {
				    ItemDefinition class40_sub5_sub16
					= Class44.method897((class40_sub5_sub12
							     .anInt2718),
							    10);
				    if (class40_sub5_sub16 != null) {
					class40_sub5_sub16
					    = (class40_sub5_sub16.method743
					       ((byte) -37,
						class40_sub5_sub12.anInt2734));
					class40_sub5_sub17_sub5
					    = class40_sub5_sub16
						  .method753(true, 1, 26910);
					i_38_ = class40_sub5_sub16.anInt2827;
					i_39_ = class40_sub5_sub16.anInt2810;
					i_41_ = class40_sub5_sub16.anInt2806;
					i_37_ = class40_sub5_sub16.anInt2844;
					i_42_ = class40_sub5_sub16.anInt2817;
					i_40_ = class40_sub5_sub16.anInt2830;
					if (class40_sub5_sub12.anInt2692 > 0)
					    i_42_ = (32 * i_42_
						     / (class40_sub5_sub12
							.anInt2692));
				    }
				}
				R3D.method710
				    (i_0_ + class40_sub5_sub12.anInt2692 / 2,
				     class40_sub5_sub12.anInt2643 / 2 + i_1_);
				int i_43_ = (i_42_ * (R3D
						      .sinetable[i_37_])
					     >> -844145968);
				int i_44_ = (i_42_ * (R3D
						      .cosinetable[i_37_])
					     >> -1486826672);
				if (class40_sub5_sub17_sub5 != null) {
				    if (class40_sub5_sub12.aBoolean2636) {
					class40_sub5_sub17_sub5.method799();
					if (class40_sub5_sub12.aBoolean2701)
					    class40_sub5_sub17_sub5.method801
						(0, i_40_, i_38_, i_37_, i_41_,
						 (i_39_ + i_43_
						  + (class40_sub5_sub17_sub5
						     .anInt2861) / 2),
						 i_44_ - -i_39_, i_42_);
					else
					    class40_sub5_sub17_sub5.method812
						(0, i_40_, i_38_, i_37_, i_41_,
						 (i_39_
						  + ((class40_sub5_sub17_sub5
						      .anInt2861) / 2
						     + i_43_)),
						 i_44_ + i_39_);
				    } else
					class40_sub5_sub17_sub5.method812
					    (0, i_40_, 0, i_37_, 0, i_43_,
					     i_44_);
				}
				R3D.method702();
			    } else {
				if (class40_sub5_sub12.anInt2683 == 7) {
				    RSFont class40_sub5_sub14_sub1
					= class40_sub5_sub12
					      .method647((byte) 34);
				    if (class40_sub5_sub14_sub1 == null) {
					if (Class40_Sub13.aBoolean2177)
					    bool = false;
					continue;
				    }
				    int i_45_ = 0;
				    for (int i_46_ = 0;
					 ((i_46_ ^ 0xffffffff)
					  > (class40_sub5_sub12.anInt2643
					     ^ 0xffffffff));
					 i_46_++) {
					for (int i_47_ = 0;
					     (i_47_
					      < class40_sub5_sub12.anInt2692);
					     i_47_++) {
					    if (((class40_sub5_sub12
						  .anIntArray2685[i_45_])
						 ^ 0xffffffff)
						< -1) {
						ItemDefinition class40_sub5_sub16
						    = (Class44.method897
						       ((-1
							 + (class40_sub5_sub12
							    .anIntArray2685
							    [i_45_])),
							10));
						RSString class1
						    = (class40_sub5_sub16
						       .aClass1_2796);
						if (class1 == null)
						    class1 = (RSApplet
							      .aClass1_34);
						if ((class40_sub5_sub16
						     .anInt2795) == 1
						    || ((class40_sub5_sub12
							 .anIntArray2710
							 [i_45_])
							^ 0xffffffff) != -2)
						    class1
							= (Class40_Sub5_Sub17_Sub6
							       .method832
							   (101,
							    (new RSString[]
							     { class1,
							       (Class29
								.aClass1_674),
							       (Class45
								    .method903
								((class40_sub5_sub12
								  .anIntArray2710
								  [i_45_]),
								 (byte) -105)) })));
						int i_48_
						    = ((i_47_
							* ((class40_sub5_sub12
							    .anInt2749)
							   + 115))
						       + i_0_);
						int i_49_
						    = ((i_46_
							* ((class40_sub5_sub12
							    .anInt2667)
							   + 12))
						       + i_1_);
						if (((class40_sub5_sub12
						      .anInt2733)
						     ^ 0xffffffff)
						    == -1)
						    class40_sub5_sub14_sub1
							.method683
							(class1, i_48_, i_49_,
							 (class40_sub5_sub12
							  .anInt2647),
							 (class40_sub5_sub12
							  .aBoolean2665));
						else if ((class40_sub5_sub12
							  .anInt2733)
							 == 1)
						    class40_sub5_sub14_sub1
							.method688
							(class1,
							 (i_48_
							  + (class40_sub5_sub12
							     .anInt2692) / 2),
							 i_49_,
							 (class40_sub5_sub12
							  .anInt2647),
							 (class40_sub5_sub12
							  .aBoolean2665));
						else
						    class40_sub5_sub14_sub1
							.method677
							(class1,
							 (-1
							  + (class40_sub5_sub12
							     .anInt2692)
							  + i_48_),
							 i_49_,
							 (class40_sub5_sub12
							  .anInt2647),
							 (class40_sub5_sub12
							  .aBoolean2665));
					    }
					    i_45_++;
					}
				    }
				}
				if (class40_sub5_sub12.anInt2683 == 8
				    && Class37.method438(arg0, i, (byte) 52)
				    && ((Class53.anInt1257 ^ 0xffffffff)
					== (RSString.anInt1711 ^ 0xffffffff))) {
				    int i_50_ = 0;
				    int i_51_ = 0;
				    RSFont class40_sub5_sub14_sub1
					= (Class53
					   .aClass40_Sub5_Sub14_Sub1_1268);
				    RSString class1
					= class40_sub5_sub12.aClass1_2668;
				    class1 = (Class40_Sub4.method532
					      ((byte) 20, class40_sub5_sub12,
					       class1));
				    while (class1.method59(-3136) > 0) {
					int i_52_
					    = class1.method60((Class30
							       .aClass1_686),
							      32);
					RSString class1_53_;
					if (i_52_ != -1) {
					    class1_53_
						= class1.method68(0, 0, i_52_);
					    class1
						= class1.method50((byte) 95,
								  2 + i_52_);
					} else {
					    class1_53_ = class1;
					    class1 = Class66.aClass1_1567;
					}
					int i_54_ = class40_sub5_sub14_sub1
							.method681(class1_53_);
					i_51_ += (class40_sub5_sub14_sub1
						  .anInt2910) + 1;
					if ((i_50_ ^ 0xffffffff)
					    > (i_54_ ^ 0xffffffff))
					    i_50_ = i_54_;
				    }
				    i_51_ += 7;
				    int i_55_
					= 5 + (class40_sub5_sub12.anInt2643
					       + i_1_);
				    if (i_55_ + i_51_ > arg5)
					i_55_ = arg5 + -i_51_;
				    i_50_ += 6;
				    int i_56_
					= -5 + (class40_sub5_sub12.anInt2692
						+ i_0_ - i_50_);
				    if ((i_56_ ^ 0xffffffff)
					> (5 + i_0_ ^ 0xffffffff))
					i_56_ = 5 + i_0_;
				    if (i_50_ + i_56_ > arg6)
					i_56_ = -i_50_ + arg6;
				    Rasterizer.method656(i_56_, i_55_,
								 i_50_, i_51_,
								 16777120);
				    Rasterizer.method665(i_56_, i_55_,
								 i_50_, i_51_,
								 0);
				    class1 = class40_sub5_sub12.aClass1_2668;
				    int i_57_
					= (2
					   + (i_55_ - -(class40_sub5_sub14_sub1
							.anInt2910)));
				    class1 = (Class40_Sub4.method532
					      ((byte) 20, class40_sub5_sub12,
					       class1));
				    while ((class1.method59(-3136)
					    ^ 0xffffffff)
					   < -1) {
					int i_58_
					    = class1.method60((Class30
							       .aClass1_686),
							      32);
					RSString class1_59_;
					if (i_58_ == -1) {
					    class1_59_ = class1;
					    class1 = Class66.aClass1_1567;
					} else {
					    class1_59_
						= class1.method68(0, 0, i_58_);
					    class1
						= class1.method50((byte) 95,
								  i_58_ + 2);
					}
					class40_sub5_sub14_sub1.method683
					    (class1_59_, i_56_ - -3, i_57_, 0,
					     false);
					i_57_ += 1 + (class40_sub5_sub14_sub1
						      .anInt2910);
				    }
				}
				if ((class40_sub5_sub12.anInt2683 ^ 0xffffffff)
				    == -10)
				    Rasterizer.method666
					(i_0_, i_1_,
					 class40_sub5_sub12.anInt2692 + i_0_,
					 class40_sub5_sub12.anInt2643 + i_1_,
					 class40_sub5_sub12.anInt2647);
			    }
			}
		    }
		}
	    }
	    anInt1776++;
	    return bool;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("client.U(" + arg0 + ',' + arg1 + ','
				    + arg2 + ',' + arg3 + ',' + arg4 + ','
				    + arg5 + ',' + arg6 + ',' + arg7 + ','
				    + (arg8 != null ? "{...}" : "null") + ','
				    + arg9 + ')'));
	}
    }
    
    public void method23(int arg0) {
	anInt1786++;
	Node.anInt926++;
	method39(arg0 + 23636);
	Class13.method242((byte) -91);
	if (arg0 != -22636)
	    method43(null, false);
	Class33.method413((byte) -116);
	RSRuntimeException.method1054((byte) 125);
	Class40_Sub5_Sub12.method639(122);
	Class64.method1015(-656);
	if ((Class51.anInt1197 ^ 0xffffffff) != -1) {
	    if (Class51.anInt1197 != 5) {
		if ((Class51.anInt1197 ^ 0xffffffff) != -11) {
		    if ((Class51.anInt1197 ^ 0xffffffff) != -21) {
			if ((Class51.anInt1197 ^ 0xffffffff) == -26)
			    Landscape.method933(-95);
		    } else {
			Class60.method993(-103);
			Class40_Sub5_Sub2.method552(true);
		    }
		} else
		    Class60.method993(-104);
	    } else {
		Class40_Sub3.method530(100);
		Class60.method992(75);
	    }
	} else {
	    Class40_Sub3.method530(arg0 + 22736);
	    Class60.method992(75);
	}
	if (Class51.anInt1197 == 30)
	    NPC.method796((byte) 77);
	else if ((Class51.anInt1197 ^ 0xffffffff) == -36)
	    NPC.method796((byte) 98);
	else if ((Class51.anInt1197 ^ 0xffffffff) == -41)
	    Class40_Sub5_Sub2.method552(true);
    }
    
    public static void method37(Class6_Sub1 arg0, byte arg1, int arg2) {
	try {
	    anInt1754++;
	    if (arg1 != 98)
		aClass1_1777 = null;
	    if (Class48.aClass40_Sub1_1132 != null) {
		Class48.aClass40_Sub1_1132.offset = 5 + arg2 * 4;
		int i = Class48.aClass40_Sub1_1132.method491(-4750);
		arg0.method200(i, 99);
	    } else {
		HashTable.method327(true, null, 255, 255, (byte) 0, 0,
				  (byte) 90);
		Class24.aClass6_Sub1Array580[arg2] = arg0;
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("client.AA("
				    + (arg0 != null ? "{...}" : "null") + ','
				    + arg1 + ',' + arg2 + ')'));
	}
    }
    
    public static void method38(int arg0) {
	try {
	    anInt1785++;
	    if ((Class40_Sub5_Sub6.anInt2452 ^ 0xffffffff) >= -1) {
		if (Class40_Sub5_Sub10.anInt2613 > 0) {
		    for (int i = 0; i < 256; i++) {
			if (Class40_Sub5_Sub10.anInt2613 > 768)
			    Class42.anIntArray1013[i]
				= (Class40_Sub5_Sub9.method614
				   ((byte) -112, Class51.anIntArray1198[i],
				    Class40_Sub5_Sub17_Sub6.anIntArray3248[i],
				    -Class40_Sub5_Sub10.anInt2613 + 1024));
			else if (Class40_Sub5_Sub10.anInt2613 > 256)
			    Class42.anIntArray1013[i]
				= Class40_Sub5_Sub17_Sub6.anIntArray3248[i];
			else
			    Class42.anIntArray1013[i]
				= (Class40_Sub5_Sub9.method614
				   ((byte) -124,
				    Class40_Sub5_Sub17_Sub6.anIntArray3248[i],
				    Class51.anIntArray1198[i],
				    -Class40_Sub5_Sub10.anInt2613 + 256));
		    }
		} else {
		    for (int i = 0; (i ^ 0xffffffff) > -257; i++)
			Class42.anIntArray1013[i] = Class51.anIntArray1198[i];
		}
	    } else {
		for (int i = 0; (i ^ 0xffffffff) > -257; i++) {
		    if ((Class40_Sub5_Sub6.anInt2452 ^ 0xffffffff) >= -769) {
			if ((Class40_Sub5_Sub6.anInt2452 ^ 0xffffffff) < -257)
			    Class42.anIntArray1013[i]
				= Class40_Sub5_Sub17.anIntArray2865[i];
			else
			    Class42.anIntArray1013[i]
				= (Class40_Sub5_Sub9.method614
				   ((byte) 93,
				    Class40_Sub5_Sub17.anIntArray2865[i],
				    Class51.anIntArray1198[i],
				    -Class40_Sub5_Sub6.anInt2452 + 256));
		    } else
			Class42.anIntArray1013[i]
			    = (Class40_Sub5_Sub9.method614
			       ((byte) 81, Class51.anIntArray1198[i],
				Class40_Sub5_Sub17.anIntArray2865[i],
				-Class40_Sub5_Sub6.anInt2452 + 1024));
		}
	    }
	    int i = 256;
	    for (int i_60_ = 0; (i_60_ ^ 0xffffffff) > -33921; i_60_++)
		Class8.aClass68_298.anIntArray1621[i_60_]
		    = (Class39.aClass40_Sub5_Sub14_Sub4_918.anIntArray2955
		       [i_60_]);
	    int i_61_ = 0;
	    int i_62_ = 1152;
	    for (int i_63_ = 1; i - 1 > i_63_; i_63_++) {
		int i_64_ = (-i_63_ + i) * Class17.anIntArray466[i_63_] / i;
		int i_65_ = i_64_ + 22;
		if ((i_65_ ^ 0xffffffff) > -1)
		    i_65_ = 0;
		i_61_ += i_65_;
		for (int i_66_ = i_65_; (i_66_ ^ 0xffffffff) > -129; i_66_++) {
		    int i_67_ = Class4.anIntArray178[i_61_++];
		    if ((i_67_ ^ 0xffffffff) != -1) {
			int i_68_ = -i_67_ + 256;
			int i_69_ = i_67_;
			i_67_ = Class42.anIntArray1013[i_67_];
			int i_70_ = Class8.aClass68_298.anIntArray1621[i_62_];
			Class8.aClass68_298.anIntArray1621[i_62_++]
			    = ((Class66.method1021
				(-16711936,
				 (Class66.method1021(i_67_, 16711935) * i_69_
				  - -(i_68_
				      * Class66.method1021(i_70_, 16711935)))))
			       - -(Class66.method1021
				   ((Class66.method1021(65280, i_70_) * i_68_
				     + i_69_ * Class66.method1021(65280,
								  i_67_)),
				    16711680))) >> 1730944744;
		    } else
			i_62_++;
		}
		i_62_ += i_65_;
	    }
	    i_62_ = 1176;
	    i_61_ = arg0;
	    for (int i_71_ = 0; i_71_ < 33920; i_71_++)
		Class40_Sub5_Sub17_Sub2.aClass68_3042.anIntArray1621[i_71_]
		    = (Class40_Sub4.aClass40_Sub5_Sub14_Sub4_2043
		       .anIntArray2955[i_71_]);
	    for (int i_72_ = 1; (i_72_ ^ 0xffffffff) > (-1 + i ^ 0xffffffff);
		 i_72_++) {
		int i_73_ = (-i_72_ + i) * Class17.anIntArray466[i_72_] / i;
		int i_74_ = 103 + -i_73_;
		i_62_ += i_73_;
		for (int i_75_ = 0; i_75_ < i_74_; i_75_++) {
		    int i_76_ = Class4.anIntArray178[i_61_++];
		    if (i_76_ != 0) {
			int i_77_ = i_76_;
			int i_78_ = (Class40_Sub5_Sub17_Sub2.aClass68_3042
				     .anIntArray1621[i_62_]);
			int i_79_ = 256 + -i_76_;
			i_76_ = Class42.anIntArray1013[i_76_];
			Class40_Sub5_Sub17_Sub2.aClass68_3042
			    .anIntArray1621[i_62_++]
			    = ((Class66.method1021
				((i_77_ * Class66.method1021(65280, i_76_)
				  + i_79_ * Class66.method1021(65280, i_78_)),
				 16711680))
			       + (Class66.method1021
				  ((i_79_ * Class66.method1021(16711935, i_78_)
				    + (Class66.method1021(16711935, i_76_)
				       * i_77_)),
				   -16711936))) >> 1103065832;
		    } else
			i_62_++;
		}
		i_62_ += 128 - (i_74_ - -i_73_);
		i_61_ += -i_74_ + 128;
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "client.FA(" + arg0 + ')');
	}
    }
    
    public void method39(int arg0) {
	anInt1780++;
	if (arg0 != Class51.anInt1197) {
	    boolean bool = Class25.method346((byte) 48);
	    if (!bool)
		method40(arg0 ^ 0x3ed);
	}
    }
    
    public void method34(int arg0) {
	try {
	    anInt1787++;
	    if (Class67.aBoolean1575) {
		Class22_Sub1.method311((byte) -80, Class62.aCanvas1469);
		Class55.method965(32, Class62.aCanvas1469);
		this.setCanvas((byte) 86);
		Class40_Sub5_Sub12.method642(Class62.aCanvas1469, -10);
		RSRuntimeException.method1056(Class62.aCanvas1469,
						 (byte) 33);
	    }
	    if (Class51.anInt1197 == 0)
		Class40_Sub5_Sub17_Sub2.method772(Class67.anInt1607, null,
						  Class22_Sub2.aClass1_1898,
						  -86);
	    else if ((Class51.anInt1197 ^ 0xffffffff) != -6) {
		if (Class51.anInt1197 != 10) {
		    if ((Class51.anInt1197 ^ 0xffffffff) != -21) {
			if ((Class51.anInt1197 ^ 0xffffffff) == -26) {
			    if ((Class68.anInt1634 ^ 0xffffffff) == -2) {
				if (Class37.anInt874
				    > PacketBuffer.anInt2231)
				    PacketBuffer.anInt2231
					= Class37.anInt874;
				int i = ((-Class37.anInt874
					  + PacketBuffer.anInt2231)
					 * 50 / PacketBuffer.anInt2231);
				Class51.method940
				    (0, Class67.aClass1_1585, true,
				     (Class40_Sub5_Sub17_Sub6.method832
				      (110,
				       new RSString[] { Class3.aClass1_170,
						      HashTable.method334(i, -1),
						      Class30.aClass1_698 })));
			    } else if ((Class68.anInt1634 ^ 0xffffffff)
				       == -3) {
				if (Class40_Sub5_Sub10.anInt2591
				    > Class40_Sub5_Sub17_Sub2.anInt3048)
				    Class40_Sub5_Sub17_Sub2.anInt3048
					= Class40_Sub5_Sub10.anInt2591;
				int i
				    = ((50
					* (-Class40_Sub5_Sub10.anInt2591
					   + Class40_Sub5_Sub17_Sub2.anInt3048)
					/ Class40_Sub5_Sub17_Sub2.anInt3048)
				       + 50);
				Class51.method940
				    (0, Class67.aClass1_1585, true,
				     (Class40_Sub5_Sub17_Sub6.method832
				      (-98,
				       new RSString[] { Class3.aClass1_170,
						      HashTable.method334(i, -1),
						      Class30.aClass1_698 })));
			    } else
				Class51.method940(0, Class67.aClass1_1585,
						  false, null);
			} else if (Class51.anInt1197 != 30) {
			    if (Class51.anInt1197 != 35) {
				if (Class51.anInt1197 == 40)
				    Class51.method940
					(0,
					 (NPC
					  .aClass1_3305),
					 false,
					 Class40_Sub5_Sub17_Sub4.aClass1_3159);
			    } else
				Class5.method164(0);
			} else
			    Class27.method365(-20197);
		    } else
			Class53.method951(-19010,
					  (Class40_Sub5_Sub17_Sub6
					   .aClass40_Sub5_Sub14_Sub1_3246),
					  (Class40_Sub5_Sub17_Sub6
					   .aClass40_Sub5_Sub14_Sub1_3236));
		} else
		    Class53.method951(-19010,
				      (Class40_Sub5_Sub17_Sub6
				       .aClass40_Sub5_Sub14_Sub1_3246),
				      (Class40_Sub5_Sub17_Sub6
				       .aClass40_Sub5_Sub14_Sub1_3236));
	    } else
		Class53.method951(-19010,
				  (Class40_Sub5_Sub17_Sub6
				   .aClass40_Sub5_Sub14_Sub1_3246),
				  (Class40_Sub5_Sub17_Sub6
				   .aClass40_Sub5_Sub14_Sub1_3236));
	    NPC.anInt3294 = 0;
	    int i = -22 / ((arg0 - 6) / 50);
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "client.S(" + arg0 + ')');
	}
    }
    
    public static void main(String[] arg0) {
	try {
	    anInt1768++;
	    try {
			if ((arg0.length ^ 0xffffffff) != -7)
			    Class37.method432((byte) 37);
			Class13.worldid = Integer.parseInt(arg0[0]);
			if (!arg0[1].equals("live")) {
			    if (arg0[1].equals("office"))
				Class44.modewhere = 1;
			    else if (arg0[1].equals("local"))
				Class44.modewhere = 2;
			    else
				Class37.method432((byte) 118);
			} else
			    Class44.modewhere = 0;
			if (arg0[2].equals("live"))
			    Class44.modewhat = 0;
			else if (!arg0[2].equals("rc")) {
			    if (arg0[2].equals("wip"))
				Class44.modewhat = 2;
			    else
				Class37.method432((byte) 34);
			} else
			    Class44.modewhat = 1;
			if (arg0[3].equals("lowmem"))
			    Class59.method983(120);
			else if (arg0[3].equals("highmem"))
			    Class8.method210(0);
			else
			    Class37.method432((byte) 121);
			if (!arg0[4].equals("free")) {
			    if (arg0[4].equals("members"))
				Class22.aBoolean541 = true;
			    else
				Class37.method432((byte) 93);
			} else
			    Class22.aBoolean541 = false;
			if (!arg0[5].equals("english")) {
			    if (!arg0[5].equals("german"))
				Class37.method432((byte) 106);
			    else {
				Class55.method962(18782);
				Class34.anInt848 = 1;
			    }
			} else
			    Class34.anInt848 = 0;
			Main main = new Main();
			main.openClientApplet("runescape", 13, 503, 32 - -Class44.modewhat, InetAddress.getLocalHost(), 435, 765);
	    } catch (Exception exception) {
	    	Class6.method169(null, (byte) -128, exception);
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "client.main(" + (arg0 != null ? "{...}"
						     : "null") + ')');
	}
    }
    
    public void method40(int arg0) {
	if (arg0 != 5)
	    aClass1_1781 = null;
	anInt1774++;
	if ((Class34.anInt813 ^ 0xffffffff) <= -5) {
	    this.openErrorPage((byte) 120, "js5crc");
	    Class51.anInt1197 = 1000;
	} else {
	    if ((Class40_Sub5_Sub1.anInt2278 ^ 0xffffffff) <= -5) {
		if (Class51.anInt1197 > 5) {
		    Class40_Sub5_Sub1.anInt2278 = 3;
		    ISAAC.anInt509 = 3000;
		} else {
		    this.openErrorPage((byte) 58, "js5io");
		    Class51.anInt1197 = 1000;
		    return;
		}
	    }
	    if (ISAAC.anInt509-- <= 0) {
		do {
		    try {
			if (Class8.anInt290 == 0) {
			    Class68.aClass15_1632
				= ISAAC.aClass31_521
				      .method395(arg0 ^ 0x6, Class10.anInt350);
			    Class8.anInt290++;
			}
			if ((Class8.anInt290 ^ 0xffffffff) == -2) {
			    if (Class68.aClass15_1632.anInt434 == 2) {
				method35(30, -1);
				break;
			    }
			    if (Class68.aClass15_1632.anInt434 == 1)
				Class8.anInt290++;
			}
			if ((Class8.anInt290 ^ 0xffffffff) == -3) {
			    Class29.aClass64_676
				= new Class64((Socket) (Class68.aClass15_1632
							.anObject437),
					      ISAAC.aClass31_521);
			    Buffer class40_sub1 = new Buffer(5);
			    class40_sub1.put(15, (byte) -128);
			    class40_sub1.putInt(56, 435);
			    Class29.aClass64_676.method1010(5, (byte) -19, 0,
							    (class40_sub1
							     .payload));
			    Class8.anInt290++;
			    Class22_Sub1.aLong1841 = Class51.method937(1);
			}
			if ((Class8.anInt290 ^ 0xffffffff) == -4) {
			    if (Class51.anInt1197 > 5
				&& (Class29.aClass64_676
					.method1014(arg0 + -131)
				    ^ 0xffffffff) >= -1) {
				if ((Class51.method937(1)
				     + -Class22_Sub1.aLong1841)
				    > 30000L) {
				    method35(30, -2);
				    break;
				}
			    } else {
				int i = Class29.aClass64_676.method1016(112);
				if (i != 0) {
				    method35(30, i);
				    break;
				}
				Class8.anInt290++;
			    }
			}
			if (Class8.anInt290 != 4)
			    break;
			Class17.method273(Class29.aClass64_676, 105,
					  Class51.anInt1197 > 20);
			Class68.aClass15_1632 = null;
			Class8.anInt290 = 0;
			Class29.aClass64_676 = null;
			Class8.anInt292 = 0;
		    } catch (java.io.IOException ioexception) {
			method35(30, -3);
			break;
		    }
		    break;
		} while (false);
	    }
	}
    }
    
    public static void method41(boolean arg0) {
	try {
	    aClass1_1762 = null;
	    aClass1_1781 = null;
	    aClass1Array1778 = null;
	    aClass1_1763 = null;
	    aClass1_1775 = null;
	    aClass1_1783 = null;
	    aClass1_1777 = null;
	    aClass1_1788 = null;
	    aClass1_1767 = null;
	    if (arg0 != false)
		method36(-124, 5, -72, 123, 30, -52, 55, 27, null, false);
	    aClass1_1761 = null;
	    aClass1_1757 = null;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   "client.BA(" + arg0 + ')');
	}
    }
    
    public void method24(int arg0) {
	if (Class12.aClass39_387 != null)
	    Class12.aClass39_387.aBoolean913 = false;
	anInt1771++;
	Class12.aClass39_387 = null;
	if (Class40_Sub6.aClass64_2098 != null) {
	    Class40_Sub6.aClass64_2098.method1009(-100);
	    Class40_Sub6.aClass64_2098 = null;
	}
	ItemDefinition.method744((byte) -80);
	Class13.method249(true);
	Class33.method407(false);
	Class60.method989(true);
	NpcDefinition.method567(arg0 ^ 0x1);
	Class52.method947(-1);
	do {
	    try {
		if (Class40_Sub5_Sub2.aClass67_2298 != null)
		    Class40_Sub5_Sub2.aClass67_2298.method1036(841617512);
		if (arg0 != 0)
		    method31(false);
		if (Class40_Sub5_Sub6.aClass67Array2436 != null) {
		    for (int i = 0;
			 i < Class40_Sub5_Sub6.aClass67Array2436.length; i++) {
			if (Class40_Sub5_Sub6.aClass67Array2436[i] != null)
			    Class40_Sub5_Sub6.aClass67Array2436[i]
				.method1036(arg0 ^ 0x322a1068);
		    }
		}
		if (Class30.aClass67_693 == null)
		    break;
		Class30.aClass67_693.method1036(841617512);
	    } catch (java.io.IOException ioexception) {
		break;
	    }
	    break;
	} while (false);
    }
    
    public void init() {
	try {
	    anInt1765++;
	    if (this.verifyHost(31)) {
		Class13.worldid
		    = Integer.parseInt(this.getParameter("worldid"));
		Class44.modewhat
		    = Integer.parseInt(this.getParameter("modewhat"));
		Class44.modewhere
		    = Integer.parseInt(this.getParameter("modewhere"));
		String string = this.getParameter("lowmem");
		if (string != null && string.equals("1"))
		    Class59.method983(-111);
		else
		    Class8.method210(0);
		String string_80_ = this.getParameter("members");
		if (string_80_ != null && string_80_.equals("1"))
		    Class22.aBoolean541 = true;
		else
		    Class22.aBoolean541 = false;
		String string_81_ = this.getParameter("lang");
		if (string_81_ != null && string_81_.equals("1")) {
		    Class55.method962(18782);
		    Class34.anInt848 = 1;
		}
		this.displayClientFrame((byte) 120, 435, 503, 765, Class44.modewhat + 32);
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "client.init(" + ')');
	}
    }
    
    public static int method42(int arg0, int arg1, int arg2, int arg3,
			       int arg4, int arg5, int arg6) {
	try {
	    arg5 &= 0x3;
	    anInt1779++;
	    if ((arg0 & arg1 ^ 0xffffffff) == -2) {
		int i = arg2;
		arg2 = arg4;
		arg4 = i;
	    }
	    if ((arg5 ^ 0xffffffff) == -1)
		return arg3;
	    if ((arg5 ^ 0xffffffff) == -2)
		return arg6;
	    if ((arg5 ^ 0xffffffff) == -3)
		return 7 - (arg3 - -arg2) + 1;
	    return 7 + (-arg6 + 1) + -arg4;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("client.DA(" + arg0 + ',' + arg1 + ','
				    + arg2 + ',' + arg3 + ',' + arg4 + ','
				    + arg5 + ',' + arg6 + ')'));
	}
    }
    
    public void method16(int arg0) {
	try {
	    anInt1770++;
	    method41(false);
	    RSString.method83((byte) 121);
	    RSApplet.method18(false);
	    Class38.method439((byte) 123);
	    Class68.method1042(arg0 + -28063);
	    Class39.method453((byte) -74);
	    Buffer.method499(true);
	    Class64.method1011(true);
	    Class6_Sub1.method203(arg0 ^ 0x6dc2);
	    Class67.method1037(false);
	    Class56.method967(78);
	    NPC.method797(arg0 + -27855);
	    PacketBuffer.method514(1);
	    RSFont.method676();
	    Class2.method114();
	    Class3.method152(-19156);
	    Player.method794(false);
	    Class45.method900(29690);
	    Class40_Sub5_Sub12.method641(-92);
	    Class48.method924((byte) 111);
	    Class30.method376(arg0 + -14636);
	    Class40_Sub5_Sub17_Sub4.method788(87);
	    Class40_Sub3.method529(-10);
	    NpcDefinition.method581(-96);
	    HashTable.method328(false);
	    Node.method458((byte) 127);
	    ISAAC.method282(true);
	    Class49.method930(94);
	    Cache.method234(arg0 ^ 0x6def);
	    Class40_Sub5_Sub7.method589(arg0 ^ 0x6de9);
	    Model.method800();
	    Class37.method433(-29013);
	    RSRuntimeException.method1053(-124);
	    Class26.method350(0);
	    Class40_Sub4.method534(-95);
	    Class19.method280(true);
	    Class32.method401(94);
	    Class40_Sub5_Sub17.method757((byte) -117);
	    Class10.method237(arg0 ^ 0x6df9);
	    Class53.method952(0);
	    Class25.method348(arg0 + -34645);
	    Class52.method946(false);
	    Class11.method239();
	    Class54.method953((byte) -38);
	    Class62.method1001(true);
	    Class51.method939(-108);
	    SubNode.method541(117);
	    Class6.method180(arg0 ^ arg0);
	    Class44.method896(arg0 ^ ~0x6da1);
	    Class33.method408(arg0 + -6046);
	    Class8.method214(arg0 ^ ~0x6dea);
	    Class55.method961(1);
	    Class60.method994(false);
	    Class65.method1017((byte) -25);
	    Class27.method356(arg0 ^ ~0x6ced);
	    Class40_Sub5_Sub13.method653(-1);
	    Landscape.method935(10582);
	    R3D.method704();
	    Rasterizer.method667();
	    Class42.method887((byte) -108);
	    Class24.method339((byte) -41);
	    Class17.method277((byte) 83);
	    Floor.method554((byte) 122);
	    Class40_Sub5_Sub9.method621(arg0 ^ 0x6da1);
	    Class40_Sub5_Sub10.method625(0);
	    Class40_Sub5_Sub8.method604(true);
	    ItemDefinition.method745(64);
	    Class40_Sub5_Sub15.method734(76);
	    Class40_Sub5_Sub2.method548(-3254);
	    Class40_Sub5_Sub4.method565(-124);
	    Class40_Sub5_Sub11.method632(-1);
	    Class35.method423((byte) -81);
	    EntryTable.method871();
	    Class66.method1022(-125);
	    Class59.method985((byte) -127);
	    Class5.method163((byte) -94);
	    Class40_Sub2.method524(-9019);
	    Class40_Sub5_Sub1.method542(-27934);
	    Class4.method159((byte) 76);
	    Class63.method1005();
	    Class46.method914(arg0 + -28113);
	    Class40_Sub5_Sub17_Sub1.method761((byte) 113);
	    Class40_Sub5_Sub17_Sub6.method835((byte) 98);
	    Class12.method240((byte) -76);
	    Class43.method893((byte) 127);
	    Class61.method998(-128);
	    Class40_Sub5_Sub17_Sub2.method770((byte) -95);
	    Class40_Sub5_Sub17_Sub3.method780(24399);
	    Class40_Sub7.method839(arg0 ^ 0x6d9e);
	    Class13.method248(arg0 ^ 0x925e);
	    RSCanvas.method47((byte) -46);
	    Class38_Sub1.method449(arg0 + -50848);
	    Class68_Sub1.method1047(0);
	    Class58.method981((byte) -120);
	    Class16.method268();
	    Class57.method974(arg0 + -28128);
	    Class41.method881();
	    Class40_Sub13.method877(0);
	    Class21.method289();
	    Class34.method418(7679);
	    Class40_Sub6.method837((byte) 59);
	    Class22.method298(120);
	    Class40_Sub5_Sub6.method582(true);
	    Class8_Sub1.method220();
	    Class8_Sub1_Sub1.method228();
	    Class29.method370(8);
	    Class40_Sub11.method874((byte) 101);
	    Class22_Sub2.method320(39);
	    Class14.method266();
	    Class22_Sub1.method310(77);
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "client.I(" + arg0 + ')');
	}
    }
    
    public static void method43(Class6 arg0, boolean arg1) {
	try {
	    if (arg1 == true) {
		anInt1755++;
		Class64.aClass6_1521 = arg0;
		Class59.anInt1383
		    = Class64.aClass6_1521.method190(16, (byte) 24);
	    }
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception,
				   ("client.EA("
				    + (arg0 != null ? "{...}" : "null") + ','
				    + arg1 + ')'));
	}
    }
    
    public void method31(boolean arg0) {
	try {
	    Class3.anInt172
		= Class44.modewhere == 0 ? 443 : 50000 + Class13.worldid;
	    Floor.anInt2340
		= ((Class44.modewhere ^ 0xffffffff) != -1
		   ? Class13.worldid + 40000 : 43594);
	    anInt1782++;
	    if (arg0 != true)
		aBoolean1790 = true;
	    Class10.anInt350 = Floor.anInt2340;
	    Class61.method997(47);
	    Class40_Sub5_Sub12.method642(Class62.aCanvas1469, -10);
	    RSRuntimeException.method1056(Class62.aCanvas1469, (byte) 70);
	    RSCanvas.anInt57 = Signlink.anInt737;
	    try {
		if (ISAAC.aClass31_521.aClass47_736 != null) {
		    Class40_Sub5_Sub2.aClass67_2298
			= new Class67(ISAAC.aClass31_521.aClass47_736, 5200,
				      0);
		    for (int i = 0; i < 13; i++)
			Class40_Sub5_Sub6.aClass67Array2436[i]
			    = new Class67((ISAAC.aClass31_521
					   .aClass47Array723[i]),
					  6000, 0);
		    Class30.aClass67_693
			= new Class67(ISAAC.aClass31_521.aClass47_728, 6000,
				      0);
		    Class40_Sub5_Sub4.aClass56_2356
			= new Class56(255, Class40_Sub5_Sub2.aClass67_2298,
				      Class30.aClass67_693, 500000);
		    ISAAC.aClass31_521.aClass47Array723 = null;
		    ISAAC.aClass31_521.aClass47_728 = null;
		    ISAAC.aClass31_521.aClass47_736 = null;
		}
	    } catch (java.io.IOException ioexception) {
		Class40_Sub5_Sub4.aClass56_2356 = null;
		Class40_Sub5_Sub2.aClass67_2298 = null;
		Class30.aClass67_693 = null;
	    }
	    if ((Class44.modewhere ^ 0xffffffff) != -1)
		Class19.aBoolean496 = true;
	    Class12.aClass40_Sub5_Sub12_383 = new Class40_Sub5_Sub12();
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "client.M(" + arg0 + ')');
	}
    }
    
    public static void method44(int arg0) {
	try {
	    Class51.aLong1203 = 0L;
	    Class12.aClass39_387.anInt921 = 0;
	    Class22_Sub2.anInt1888 = 0;
	    anInt1760++;
	    RSString.anInt1694 = 0;
	    Class46.anInt1091 = 0;
	    Class40_Sub5_Sub2.anInt2282 = 0;
	    Class10.anInt335 = 0;
	    Class3.anInt142 = 0;
	    Class42.anInt994 = 0;
	    SubNode.anInt2088 = 0;
	    Class52.anInt1211 = 0;
	    Class40_Sub5_Sub7.anInt2486 = 0;
	    Class40_Sub5_Sub1.anInt2264 = 0;
	    Class27.anInt659 = 0;
	    Class40_Sub5_Sub4.anInt2363 = 0;
	    Class40_Sub13.anInt2184 = 0;
	    Class27.anInt646 = 0;
	    Class60.anInt1418 = 0;
	    Class40_Sub5_Sub12.anInt2700 = 0;
	    RSApplet.anInt18 = 0;
	    Buffer.anInt1935 = 0;
	    Class6.anInt244 = 0;
	    ItemDefinition.anInt2809 = 0;
	    NPC.anInt3313 = 0;
	    Buffer.anInt1958 = 0;
	    Floor.anInt2348 = 0;
	    Class4.anInt184 = 0;
	    Class61.anInt1424 = 0;
	    Class42.anInt992 = 0;
	    Class3.anInt139 = 0;
	    Class13.anInt413 = 0;
	    RSString.anInt1663 = 0;
	    Class5.anInt209 = 0;
	    Class6.anInt253 = 0;
	    Class30.anInt706 = 0;
	    RSCanvas.anInt58 = 0;
	    Class62.anInt1449 = 0;
	    Class60.anInt1412 = 0;
	    Class64.anInt1525 = 0;
	    Class38_Sub1.anInt1901 = 0;
	    Class5.anInt201 = 0;
	    Class6.anInt218 = 0;
	    Class59.anInt1381 = 0;
	    Class17.anInt453 = 0;
	    Class40_Sub5_Sub17.anInt2868 = 0;
	    Class17.anInt454 = 0;
	    PacketBuffer.anInt2253 = 0;
	    HashTable.anInt555 = 0;
	    Cache.anInt308 = 0;
	    Class43.anInt1018 = 0;
	    Buffer.anInt1986 = 0;
	    RSApplet.anInt33 = 0;
	    Class45.anInt1067 = 0;
	    Class13.anInt400 = 0;
	    Class45.anInt1070 = 0;
	    Class51.anInt1188 = 0;
	    Class6.anInt213 = 0;
	    Class68.anInt1616 = 0;
	    Class8.anInt285 = 0;
	    HashTable.anInt551 = 0;
	    Class40_Sub5_Sub9.anInt2580 = 0;
	    anInt1776 = 0;
	    Class40_Sub5_Sub17_Sub2.anInt3023 = 0;
	    Class8.anInt282 = 0;
	    Class37.anInt866 = 0;
	    Class40_Sub5_Sub7.anInt2492 = 0;
	    NPC.anInt3306 = 0;
	    Class40_Sub3.anInt2034 = 0;
	    Class66.anInt1561 = 0;
	    Class40_Sub5_Sub8.anInt2554 = 0;
	    Class56.anInt1319 = 0;
	    NpcDefinition.anInt2378 = 0;
	    Floor.anInt2341 = 0;
	    Floor.anInt2331 = 0;
	    Class40_Sub5_Sub4.anInt2365 = 0;
	    Class35.anInt1723 = 0;
	    Class3.anInt144 = 0;
	    Class40_Sub5_Sub10.anInt2608 = 0;
	    Class40_Sub5_Sub12.anInt2662 = 0;
	    Class40_Sub13.anInt2169 = 0;
	    Class40_Sub5_Sub17_Sub2.anInt3028 = 0;
	    Class68_Sub1.anInt2195 = 0;
	    RSApplet.anInt41 = 0;
	    Class6.anInt228 = 0;
	    SubNode.anInt2085 = 0;
	    Class40_Sub5_Sub6.anInt2450 = 0;
	    Class38.anInt891 = 0;
	    RSRuntimeException.anInt1645 = 0;
	    Class10.anInt339 = 0;
	    Class48.anInt1134 = 0;
	    Class32.anInt765 = 0;
	    Buffer.anInt1956 = 0;
	    Class62.anInt1448 = 0;
	    RSString.anInt1661 = 0;
	    Class40_Sub4.anInt2041 = 0;
	    Class52.anInt1227 = 0;
	    RSRuntimeException.anInt1643 = 0;
	    RSString.anInt1683 = 0;
	    Buffer.anInt1926 = 0;
	    RSRuntimeException.anInt1650 = 0;
	    Class67.anInt1584 = 0;
	    Class67.anInt1606 = 0;
	    Class6_Sub1.anInt1793 = 0;
	    Class40_Sub5_Sub17_Sub3.anInt3061 = 0;
	    Class57.anInt1330 = 0;
	    Class25.anInt599 = 0;
	    anInt1782 = 0;
	    Class40_Sub5_Sub1.anInt2281 = 0;
	    anInt1760 = 0;
	    Buffer.anInt1927 = 0;
	    RSString.anInt1671 = 0;
	    Class29.anInt677 = 0;
	    Class62.anInt1454 = 0;
	    Class40_Sub5_Sub12.anInt2635 = 0;
	    Class40_Sub6.anInt2115 = 0;
	    RSApplet.anInt36 = 0;
	    Class27.anInt650 = 0;
	    Buffer.anInt1929 = 0;
	    Class5.anInt205 = 0;
	    Class25.anInt596 = 0;
	    RSString.anInt1693 = 0;
	    Class33.anInt788 = 0;
	    Buffer.anInt1943 = 0;
	    Class40_Sub11.anInt2152 = 0;
	    Class37.anInt859 = 0;
	    Class40_Sub5_Sub17_Sub4.anInt3128 = 0;
	    Class64.anInt1522 = 0;
	    PacketBuffer.anInt2249 = 0;
	    Class34.anInt815 = 0;
	    Class40_Sub5_Sub12.anInt2705 = 0;
	    Class40_Sub5_Sub17_Sub3.anInt3053 = 0;
	    Class40_Sub5_Sub9.anInt2575 = 0;
	    PacketBuffer.anInt2233 = 0;
	    Class33.anInt790 = 0;
	    Class40_Sub7.anInt2126 = 0;
	    NpcDefinition.anInt2422 = 0;
	    Class40_Sub5_Sub10.anInt2601 = 0;
	    RSApplet.anInt15 = 0;
	    Class45.anInt1074 = 0;
	    RSApplet.anInt40 = 0;
	    Class40_Sub5_Sub6.anInt2444 = 0;
	    Class64.anInt1514 = 0;
	    NpcDefinition.anInt2373 = 0;
	    RSString.anInt1701 = 0;
	    Class40_Sub5_Sub1.anInt2265 = 0;
	    Class40_Sub5_Sub17_Sub2.anInt3031 = 0;
	    RSString.anInt1704 = 0;
	    Class45.anInt1053 = 0;
	    Class59.anInt1384 = 0;
	    Class6.anInt246 = 0;
	    Class27.anInt645 = 0;
	    Class40_Sub5_Sub17_Sub1.anInt2986 = 0;
	    Buffer.anInt1932 = 0;
	    Class53.anInt1248 = 0;
	    Class3.anInt159 = 0;
	    Class67.anInt1599 = 0;
	    Class40_Sub5_Sub11.anInt2632 = 0;
	    Class40_Sub11.anInt2151 = 0;
	    RSApplet.anInt7 = 0;
	    Class53.anInt1250 = 0;
	    Class46.anInt1107 = 0;
	    Class40_Sub6.anInt2100 = 0;
	    Class40_Sub5_Sub6.anInt2453 = 0;
	    Class40_Sub5_Sub17.anInt2863 = 0;
	    Floor.anInt2339 = 0;
	    Class6.anInt231 = 0;
	    RSApplet.anInt22 = 0;
	    Class22_Sub1.anInt1839 = 0;
	    Class6.anInt251 = 0;
	    Class30.anInt691 = 0;
	    Class65.anInt1532 = 0;
	    Class6_Sub1.anInt1808 = 0;
	    Buffer.anInt1960 = 0;
	    PacketBuffer.anInt2251 = 0;
	    anInt1774 = 0;
	    Class40_Sub11.anInt2150 = 0;
	    Class40_Sub5_Sub17_Sub1.anInt2979 = 0;
	    Class35.anInt1722 = 0;
	    Class25.anInt598 = 0;
	    Floor.anInt2326 = 0;
	    Class48.anInt1136 = 0;
	    Class66.anInt1547 = 0;
	    RSApplet.anInt17 = 0;
	    Class22_Sub2.anInt1894 = 0;
	    ItemDefinition.anInt2835 = 0;
	    anInt1779 = 0;
	    Class60.anInt1405 = 0;
	    Class22_Sub1.anInt1840 = 0;
	    RSString.anInt1707 = 0;
	    Class40_Sub5_Sub9.anInt2578 = 0;
	    Class40_Sub5_Sub11.anInt2619 = 0;
	    Class27.anInt663 = 0;
	    RSString.anInt1673 = 0;
	    Class30.anInt711 = 0;
	    RSString.anInt1709 = 0;
	    Class37.anInt864 = 0;
	    Class26.anInt628 = 0;
	    Class48.anInt1139 = 0;
	    Class40_Sub5_Sub4.anInt2362 = 0;
	    Class40_Sub11.anInt2148 = 0;
	    Class68_Sub1.anInt2206 = 0;
	    Class40_Sub5_Sub8.anInt2551 = 0;
	    RSString.anInt1697 = 0;
	    Class22_Sub1.anInt1862 = 0;
	    Class30.anInt707 = 0;
	    Class43.anInt1017 = 0;
	    Class40_Sub5_Sub17_Sub6.anInt3232 = 0;
	    Class62.anInt1460 = 0;
	    RSString.anInt1657 = 0;
	    Class22_Sub1.anInt1859 = 0;
	    Class8.anInt283 = 0;
	    RSApplet.anInt44 = 0;
	    Class40_Sub3.anInt2029 = 0;
	    Class40_Sub13.anInt2170 = 0;
	    RSString.anInt1681 = 0;
	    Class22_Sub1.anInt1843 = 0;
	    Class52.anInt1236 = 0;
	    HashTable.anInt552 = 0;
	    Class13.anInt410 = 0;
	    Class62.anInt1462 = 0;
	    Class55.anInt1287 = 0;
	    Class40_Sub5_Sub17_Sub4.anInt3106 = 0;
	    PacketBuffer.anInt2243 = 0;
	    RSString.anInt1656 = 0;
	    Class30.anInt694 = 0;
	    Buffer.anInt1941 = 0;
	    Class3.anInt147 = 0;
	    Node.anInt927 = 0;
	    Class27.anInt656 = 0;
	    Class24.anInt579 = 0;
	    ItemDefinition.anInt2838 = 0;
	    Class27.anInt642 = 0;
	    Class67.anInt1594 = 0;
	    Class30.anInt690 = 0;
	    Buffer.anInt1955 = 0;
	    Class40_Sub5_Sub17_Sub4.anInt3108 = 0;
	    Class3.anInt138 = 0;
	    Floor.anInt2316 = 0;
	    Class62.anInt1461 = 0;
	    Class17.anInt447 = 0;
	    Player.anInt3261 = 0;
	    Class6_Sub1.anInt1815 = 0;
	    Class55.anInt1302 = 0;
	    Class40_Sub5_Sub17_Sub3.anInt3064 = 0;
	    HashTable.anInt556 = 0;
	    Class38_Sub1.anInt1904 = 0;
	    Class30.anInt703 = 0;
	    Class44.anInt1045 = 0;
	    anInt1786 = 0;
	    Class40_Sub2.anInt2006 = 0;
	    Class33.anInt782 = 0;
	    Class55.anInt1293 = 0;
	    Class30.anInt705 = 0;
	    Class32.anInt744 = 0;
	    Class59.anInt1382 = 0;
	    Class58.anInt1367 = 0;
	    Class8.anInt275 = 0;
	    Class62.anInt1453 = 0;
	    Class67.anInt1587 = 0;
	    Class40_Sub5_Sub12.anInt2739 = 0;
	    Class68.anInt1622 = 0;
	    Class40_Sub5_Sub17_Sub1.anInt3003 = 0;
	    Class62.anInt1459 = 0;
	    Class40_Sub5_Sub8.anInt2529 = 0;
	    RSApplet.anInt32 = 0;
	    Class40_Sub5_Sub17_Sub2.anInt3020 = 0;
	    anInt1755 = 0;
	    Buffer.anInt1962 = 0;
	    Class65.anInt1534 = 0;
	    Class10.anInt345 = 0;
	    Class27.anInt640 = 0;
	    Class22_Sub2.anInt1880 = 0;
	    Buffer.anInt1951 = 0;
	    Buffer.anInt1930 = 0;
	    Class58.anInt1368 = 0;
	    Class38_Sub1.anInt1902 = 0;
	    Class25.anInt592 = 0;
	    Class6.anInt241 = 0;
	    RSApplet.anInt29 = 0;
	    Class6.anInt238 = 0;
	    RSApplet.anInt3 = 0;
	    Class40_Sub5_Sub17_Sub2.anInt3033 = 0;
	    ISAAC.anInt514 = 0;
	    Class54.anInt1274 = 0;
	    Class40_Sub5_Sub12.anInt2675 = 0;
	    anInt1780 = 0;
	    Class24.anInt586 = 0;
	    RSString.anInt1660 = 0;
	    Class40_Sub5_Sub2.anInt2288 = 0;
	    Class40_Sub3.anInt2022 = 0;
	    Class42.anInt999 = 0;
	    RSString.anInt1655 = 0;
	    Class6.anInt250 = 0;
	    Class54.anInt1279 = 0;
	    NpcDefinition.anInt2414 = 0;
	    Class33.anInt780 = 0;
	    Class40_Sub5_Sub10.anInt2603 = 0;
	    Cache.anInt315 = 0;
	    Class40_Sub5_Sub10.anInt2585 = 0;
	    Class40_Sub5_Sub12.anInt2652 = 0;
	    Class40_Sub5_Sub10.anInt2607 = 0;
	    Class68.anInt1627 = 0;
	    Node.anInt971 = 0;
	    Class52.anInt1237 = 0;
	    Class45.anInt1052 = 0;
	    Class58.anInt1360 = 0;
	    Class67.anInt1576 = 0;
	    Class44.anInt1050 = 0;
	    NpcDefinition.anInt2419 = 0;
	    Class42.anInt1007 = 0;
	    NpcDefinition.anInt2379 = 0;
	    NpcDefinition.anInt2420 = 0;
	    Class6.anInt226 = 0;
	    Buffer.anInt1974 = 0;
	    Class68_Sub1.anInt2203 = 0;
	    ItemDefinition.anInt2843 = 0;
	    Buffer.anInt1975 = 0;
	    Class40_Sub5_Sub17_Sub2.anInt3017 = 0;
	    Buffer.anInt1948 = 0;
	    Class40_Sub5_Sub7.anInt2478 = 0;
	    Class38_Sub1.anInt1908 = 0;
	    Class6.anInt247 = 0;
	    Class40_Sub5_Sub17_Sub4.anInt3146 = 0;
	    NPC.anInt3296 = 0;
	    Class43.anInt1023 = 0;
	    Class56.anInt1310 = 0;
	    Class13.anInt415 = 0;
	    Class67.anInt1581 = 0;
	    RSApplet.anInt5 = 0;
	    Class24.anInt585 = 0;
	    Class3.anInt143 = 0;
	    Class40_Sub6.anInt2108 = 0;
	    Class5.anInt207 = 0;
	    Class6_Sub1.anInt1817 = 0;
	    Landscape.anInt1177 = 0;
	    Class6.anInt223 = 0;
	    Class22.anInt536 = 0;
	    RSString.anInt1666 = 0;
	    RSString.anInt1685 = 0;
	    Class3.anInt146 = 0;
	    Class58.anInt1356 = 0;
	    Class40_Sub13.anInt2180 = 0;
	    Buffer.anInt1969 = 0;
	    Class40_Sub5_Sub12.anInt2634 = 0;
	    Class32.anInt754 = 0;
	    Buffer.anInt1989 = 0;
	    Class40_Sub5_Sub17_Sub4.anInt3147 = 0;
	    Class40_Sub5_Sub17_Sub4.anInt3076 = 0;
	    Class55.anInt1307 = 0;
	    Class22_Sub1.anInt1854 = 0;
	    Class52.anInt1239 = 0;
	    NPC.anInt3303 = 0;
	    RSCanvas.anInt56 = 0;
	    Buffer.anInt1952 = 0;
	    Class49.anInt1142 = 0;
	    Class61.anInt1442 = 0;
	    Class37.anInt862 = 0;
	    Class54.anInt1277 = 0;
	    Class6.anInt248 = 0;
	    Class40_Sub5_Sub7.anInt2467 = 0;
	    Class59.anInt1380 = 0;
	    Class51.anInt1192 = 0;
	    RSString.anInt1678 = 0;
	    Class40_Sub5_Sub2.anInt2284 = 0;
	    RSCanvas.anInt52 = 0;
	    Class40_Sub5_Sub8.anInt2531 = 0;
	    Class40_Sub13.anInt2182 = 0;
	    Class40_Sub5_Sub2.anInt2289 = 0;
	    Class55.anInt1303 = 0;
	    Class40_Sub5_Sub17.anInt2867 = 0;
	    Class22_Sub2.anInt1897 = 0;
	    Buffer.anInt1957 = 0;
	    ISAAC.anInt520 = 0;
	    Class40_Sub5_Sub8.anInt2539 = 0;
	    Class40_Sub5_Sub17_Sub1.anInt2994 = 0;
	    Class40_Sub2.anInt1999 = 0;
	    Class40_Sub5_Sub17_Sub1.anInt3007 = 0;
	    Class58.anInt1351 = 0;
	    Class40_Sub5_Sub6.anInt2454 = 0;
	    Class45.anInt1063 = 0;
	    PacketBuffer.anInt2234 = 0;
	    Class40_Sub5_Sub17_Sub4.anInt3133 = 0;
	    Class46.anInt1103 = 0;
	    Class33.anInt793 = 0;
	    PacketBuffer.anInt2242 = 0;
	    Class40_Sub5_Sub9.anInt2573 = 0;
	    Class3.anInt156 = 0;
	    HashTable.anInt561 = 0;
	    Class40_Sub5_Sub10.anInt2612 = 0;
	    Buffer.anInt1931 = 0;
	    Class62.anInt1447 = 0;
	    Buffer.anInt1980 = 0;
	    Class66.anInt1573 = 0;
	    Class40_Sub5_Sub12.anInt2735 = 0;
	    Class62.anInt1452 = 0;
	    Class30.anInt702 = 0;
	    Class6.anInt232 = 0;
	    ItemDefinition.anInt2826 = 0;
	    Class40_Sub5_Sub4.anInt2369 = 0;
	    Class40_Sub5_Sub7.anInt2493 = 0;
	    Class6.anInt214 = 0;
	    ISAAC.anInt503 = 0;
	    Class34.anInt806 = 0;
	    Class26.anInt616 = 0;
	    Class58.anInt1369 = 0;
	    Class67.anInt1597 = 0;
	    Player.anInt3292 = 0;
	    Class61.anInt1443 = 0;
	    Class39.anInt916 = 0;
	    Class3.anInt157 = 0;
	    Class40_Sub11.anInt2149 = 0;
	    Class34.anInt838 = 0;
	    Class40_Sub5_Sub12.anInt2717 = 0;
	    Class66.anInt1566 = 0;
	    Class40_Sub5_Sub13.anInt2756 = 0;
	    Class48.anInt1135 = 0;
	    Class22_Sub1.anInt1853 = 0;
	    Class45.anInt1054 = 0;
	    Player.anInt3277 = 0;
	    Node.anInt935 = 0;
	    anInt1765 = 0;
	    HashTable.anInt570 = 0;
	    ItemDefinition.anInt2821 = 0;
	    RSString.anInt1698 = 0;
	    Class37.anInt868 = 0;
	    Class33.anInt781 = 0;
	    Class35.anInt1724 = 0;
	    Class44.anInt1046 = 0;
	    Class60.anInt1414 = 0;
	    Class56.anInt1326 = 0;
	    anInt1770 = 0;
	    Class40_Sub5_Sub4.anInt2371 = 0;
	    ItemDefinition.anInt2839 = 0;
	    Class62.anInt1451 = 0;
	    Class40_Sub5_Sub9.anInt2584 = 0;
	    Class44.anInt1036 = 0;
	    Class54.anInt1275 = 0;
	    Buffer.anInt1937 = 0;
	    Class27.anInt639 = 0;
	    Buffer.anInt1977 = 0;
	    Class44.anInt1044 = 0;
	    Buffer.anInt1940 = 0;
	    Class43.anInt1016 = 0;
	    Class40_Sub5_Sub17_Sub1.anInt2959 = 0;
	    Class40_Sub5_Sub6.anInt2455 = 0;
	    HashTable.anInt557 = 0;
	    Buffer.anInt1936 = 0;
	    RSApplet.anInt19 = 0;
	    NpcDefinition.anInt2429 = 0;
	    Class40_Sub5_Sub17_Sub1.anInt2956 = 0;
	    Class22_Sub2.anInt1892 = 0;
	    HashTable.anInt560 = 0;
	    Class5.anInt192 = 0;
	    Class39.anInt902 = 0;
	    Class40_Sub5_Sub17.anInt2859 = 0;
	    Class56.anInt1322 = 0;
	    RSString.anInt1667 = 0;
	    Class4.anInt187 = 0;
	    Class22.anInt531 = 0;
	    Buffer.anInt1934 = 0;
	    Class6.anInt211 = 0;
	    Class45.anInt1066 = 0;
	    RSString.anInt1662 = 0;
	    Class6.anInt263 = 0;
	    PacketBuffer.anInt2237 = 0;
	    PacketBuffer.anInt2235 = 0;
	    Class37.anInt870 = 0;
	    Class40_Sub5_Sub12.anInt2724 = 0;
	    Class60.anInt1400 = 0;
	    Class45.anInt1072 = 0;
	    Class40_Sub5_Sub17_Sub2.anInt3032 = 0;
	    RSApplet.anInt23 = 0;
	    Class68_Sub1.anInt2202 = 0;
	    Class8.anInt287 = 0;
	    Class45.anInt1058 = 0;
	    Buffer.anInt1981 = 0;
	    HashTable.anInt559 = 0;
	    Class40_Sub2.anInt1992 = 0;
	    Class37.anInt863 = 0;
	    Class67.anInt1574 = 0;
	    PacketBuffer.anInt2232 = 0;
	    Class25.anInt597 = 0;
	    Class40_Sub5_Sub17.anInt2855 = 0;
	    Class68_Sub1.anInt2190 = 0;
	    Class40_Sub7.anInt2122 = 0;
	    anInt1768 = 0;
	    Class8.anInt277 = 0;
	    Class40_Sub5_Sub17_Sub4.anInt3103 = 0;
	    Class5.anInt190 = 0;
	    Class60.anInt1410 = 0;
	    Class40_Sub5_Sub8.anInt2532 = 0;
	    Class40_Sub13.anInt2173 = 0;
	    Class40_Sub5_Sub8.anInt2535 = 0;
	    Class68.anInt1626 = 0;
	    RSApplet.anInt16 = 0;
	    Class55.anInt1308 = 0;
	    Class27.anInt636 = 0;
	    Buffer.anInt1968 = 0;
	    Class30.anInt689 = 0;
	    RSApplet.anInt30 = 0;
	    Class68_Sub1.anInt2200 = 0;
	    RSString.anInt1664 = 0;
	    Class49.anInt1144 = 0;
	    Class40_Sub5_Sub12.anInt2697 = 0;
	    RSString.anInt1659 = 0;
	    Class40_Sub5_Sub7.anInt2464 = 0;
	    Class51.anInt1191 = 0;
	    RSString.anInt1714 = 0;
	    Class40_Sub5_Sub17_Sub3.anInt3052 = 0;
	    ItemDefinition.anInt2842 = 0;
	    Class42.anInt991 = 0;
	    RSString.anInt1670 = 0;
	    Class64.anInt1527 = 0;
	    anInt1754 = 0;
	    anInt1759 = 0;
	    Class45.anInt1062 = 0;
	    Landscape.anInt1182 = 0;
	    Cache.anInt311 = 0;
	    Class40_Sub5_Sub15.anInt2783 = 0;
	    Class54.anInt1273 = 0;
	    Class13.anInt409 = 0;
	    RSApplet.anInt11 = 0;
	    Class40_Sub5_Sub6.anInt2448 = 0;
	    Class29.anInt669 = 0;
	    Class54.anInt1281 = 0;
	    Class22.anInt543 = 0;
	    RSString.anInt1676 = 0;
	    Class13.anInt401 = 0;
	    Class39.anInt903 = 0;
	    RSString.anInt1695 = 0;
	    anInt1784 = 0;
	    Class22.anInt539 = 0;
	    Class33.anInt775 = 0;
	    Class68_Sub1.anInt2208 = 0;
	    Class34.anInt821 = 0;
	    Buffer.anInt1928 = 0;
	    NpcDefinition.anInt2403 = 0;
	    Cache.anInt307 = 0;
	    Class45.anInt1069 = 0;
	    Class40_Sub5_Sub9.anInt2569 = 0;
	    RSApplet.anInt26 = 0;
	    Buffer.anInt1946 = 0;
	    Class40_Sub5_Sub13.anInt2759 = 0;
	    Class22.anInt540 = 0;
	    Class6.anInt234 = 0;
	    Class30.anInt700 = 0;
	    Class6_Sub1.anInt1804 = 0;
	    Class40_Sub5_Sub12.anInt2646 = 0;
	    Class6_Sub1.anInt1792 = 0;
	    Class35.anInt1741 = 0;
	    Class3.anInt154 = 0;
	    Node.anInt961 = 0;
	    Class66.anInt1571 = 0;
	    Class26.anInt625 = 0;
	    Class67.anInt1608 = 0;
	    Class33.anInt776 = 0;
	    RSApplet.anInt13 = 0;
	    Class27.anInt641 = 0;
	    Buffer.anInt1944 = 0;
	    Class13.anInt408 = 0;
	    Class17.anInt446 = 0;
	    Class40_Sub5_Sub17_Sub4.anInt3084 = 0;
	    Class22_Sub1.anInt1842 = 0;
	    anInt1787 = 0;
	    RSApplet.anInt9 = 0;
	    Node.anInt962 = 0;
	    Class52.anInt1224 = 0;
	    RSString.anInt1708 = 0;
	    NPC.anInt3299 = 0;
	    Class68_Sub1.anInt2191 = 0;
	    Class40_Sub5_Sub7.anInt2468 = 0;
	    Class40_Sub5_Sub6.anInt2445 = 0;
	    Class27.anInt644 = 0;
	    Class52.anInt1240 = 0;
	    Class66.anInt1562 = 0;
	    RSString.anInt1710 = 0;
	    Class54.anInt1276 = 0;
	    Landscape.anInt1179 = 0;
	    NpcDefinition.anInt2412 = 0;
	    Class40_Sub5_Sub17_Sub1.anInt2970 = 0;
	    Class17.anInt458 = 0;
	    SubNode.anInt2089 = 0;
	    Buffer.anInt1967 = 0;
	    Class29.anInt675 = 0;
	    Class3.anInt155 = 0;
	    PacketBuffer.anInt2252 = 0;
	    RSString.anInt1700 = 0;
	    Class60.anInt1404 = 0;
	    Class40_Sub5_Sub17_Sub4.anInt3142 = 0;
	    Class56.anInt1327 = 0;
	    RSString.anInt1669 = 0;
	    Landscape.anInt1159 = 0;
	    Class40_Sub5_Sub17_Sub4.anInt3121 = 0;
	    Class33.anInt785 = 0;
	    Class38_Sub1.anInt1913 = 0;
	    RSString.anInt1658 = 0;
	    Class24.anInt584 = 0;
	    ISAAC.anInt500 = 0;
	    Class40_Sub5_Sub17_Sub1.anInt3008 = 0;
	    Class40_Sub5_Sub4.anInt2355 = 0;
	    Class35.anInt1751 = 0;
	    Class62.anInt1458 = 0;
	    Class22_Sub2.anInt1884 = 0;
	    NPC.anInt3310 = 0;
	    Class44.anInt1037 = 0;
	    SubNode.anInt2094 = 0;
	    Class33.anInt789 = 0;
	    Buffer.anInt1954 = 0;
	    Class40_Sub5_Sub8.anInt2514 = 0;
	    Class8.anInt280 = 0;
	    Class55.anInt1290 = 0;
	    Class52.anInt1212 = 0;
	    Class27.anInt657 = 0;
	    Buffer.anInt1970 = 0;
	    Class40_Sub5_Sub17_Sub1.anInt3005 = 0;
	    RSApplet.anInt42 = 0;
	    Class40_Sub4.anInt2040 = 0;
	    RSString.anInt1688 = 0;
	    Class6_Sub1.anInt1818 = 0;
	    Class27.anInt651 = 0;
	    Class40_Sub5_Sub7.anInt2471 = 0;
	    Class22_Sub1.anInt1850 = 0;
	    Cache.anInt306 = 0;
	    Class58.anInt1350 = 0;
	    Class6.anInt245 = 0;
	    Class27.anInt667 = 0;
	    Class6.anInt240 = 0;
	    RSString.anInt1674 = 0;
	    Class44.anInt1029 = 0;
	    Class40_Sub5_Sub2.anInt2304 = 0;
	    RSApplet.anInt39 = 0;
	    Class40_Sub5_Sub13.anInt2761 = 0;
	    Buffer.anInt1973 = 0;
	    Class60.anInt1406 = 0;
	    Class22_Sub1.anInt1837 = 0;
	    Class6.anInt222 = 0;
	    Class3.anInt148 = 0;
	    Buffer.anInt1949 = 0;
	    Class64.anInt1518 = 0;
	    Class24.anInt582 = 0;
	    Class64.anInt1519 = 0;
	    Landscape.anInt1165 = 0;
	    Class40_Sub4.anInt2052 = 0;
	    Buffer.anInt1953 = 0;
	    Class68_Sub1.anInt2196 = 0;
	    Class33.anInt792 = 0;
	    Class40_Sub5_Sub7.anInt2469 = 0;
	    RSApplet.anInt20 = 0;
	    Buffer.anInt1939 = 0;
	    PacketBuffer.anInt2230 = 0;
	    Class40_Sub5_Sub17_Sub6.anInt3234 = 0;
	    Class40_Sub5_Sub17_Sub3.anInt3070 = 0;
	    Class34.anInt836 = 0;
	    Class61.anInt1431 = 0;
	    Class40_Sub5_Sub10.anInt2596 = 0;
	    Class3.anInt160 = 0;
	    Class40_Sub2.anInt2004 = 0;
	    Class68_Sub1.anInt2205 = 0;
	    Class65.anInt1539 = 0;
	    Class35.anInt1739 = 0;
	    Player.anInt3263 = 0;
	    Buffer.anInt1966 = 0;
	    Class53.anInt1245 = 0;
	    Class68_Sub1.anInt2201 = 0;
	    Class6.anInt237 = 0;
	    Class40_Sub5_Sub6.anInt2449 = 0;
	    Class3.anInt161 = 0;
	    Class64.anInt1507 = 0;
	    Class3.anInt158 = 0;
	    Class40_Sub5_Sub11.anInt2624 = 0;
	    Class48.anInt1140 = 0;
	    Class68_Sub1.anInt2192 = 0;
	    Class46.anInt1101 = 0;
	    Class64.anInt1501 = 0;
	    Class40_Sub5_Sub1.anInt2269 = 0;
	    Class33.anInt794 = 0;
	    Class64.anInt1516 = 0;
	    ItemDefinition.anInt2801 = 0;
	    RSApplet.anInt24 = 0;
	    RSApplet.anInt37 = 0;
	    Buffer.anInt1979 = 0;
	    Class61.anInt1434 = 0;
	    Buffer.anInt1965 = 0;
	    Class25.anInt604 = 0;
	    Class40_Sub5_Sub17_Sub1.anInt2978 = 0;
	    Landscape.anInt1164 = 0;
	    RSString.anInt1672 = 0;
	    Class55.anInt1305 = 0;
	    Class34.anInt800 = 0;
	    Class38.anInt897 = 0;
	    Class43.anInt1015 = 0;
	    Class6_Sub1.anInt1805 = 0;
	    Buffer.anInt1945 = 0;
	    Class3.anInt137 = 0;
	    RSString.anInt1687 = 0;
	    Class66.anInt1570 = 0;
	    Floor.anInt2347 = 0;
	    Class56.anInt1325 = 0;
	    Class40_Sub5_Sub4.anInt2353 = 0;
	    Class48.anInt1141 = 0;
	    ItemDefinition.anInt2832 = 0;
	    Buffer.anInt1942 = 0;
	    Class40_Sub5_Sub17_Sub4.anInt3085 = 0;
	    Class40_Sub5_Sub12.anInt2666 = 0;
	    Class40_Sub5_Sub13.anInt2755 = 0;
	    Class40_Sub2.anInt1998 = 0;
	    Class40_Sub5_Sub6.anInt2456 = 0;
	    Class38_Sub1.anInt1899 = 0;
	    Class40_Sub5_Sub17_Sub6.anInt3241 = 0;
	    HashTable.anInt568 = 0;
	    ItemDefinition.anInt2802 = 0;
	    Class45.anInt1060 = 0;
	    Class45.anInt1055 = 0;
	    Class40_Sub5_Sub7.anInt2465 = 0;
	    NpcDefinition.anInt2431 = 0;
	    Class6_Sub1.anInt1795 = 0;
	    RSString.anInt1712 = 0;
	    Class22_Sub1.anInt1869 = 0;
	    Class35.anInt1721 = 0;
	    Class6.anInt235 = 0;
	    RSCanvas.anInt50 = 0;
	    Class51.anInt1189 = 0;
	    Class27.anInt655 = 0;
	    Class40_Sub5_Sub15.anInt2789 = 0;
	    Class40_Sub4.anInt2056 = 0;
	    ItemDefinition.anInt2837 = 0;
	    Class40_Sub5_Sub17_Sub6.anInt3252 = 0;
	    Class26.anInt626 = 0;
	    Class34.anInt807 = 0;
	    Buffer.anInt1963 = 0;
	    Class37.anInt861 = 0;
	    Class40_Sub5_Sub17_Sub2.anInt3022 = 0;
	    Class34.anInt803 = 0;
	    Class66.anInt1568 = 0;
	    Class58.anInt1357 = 0;
	    Class66.anInt1553 = 0;
	    Class55.anInt1297 = 0;
	    Class64.anInt1506 = 0;
	    SubNode.anInt2096 = 0;
	    Class40_Sub5_Sub12.anInt2638 = 0;
	    NpcDefinition.anInt2398 = 0;
	    RSString.anInt1682 = 0;
	    Class54.anInt1280 = 0;
	    Class56.anInt1317 = 0;
	    ItemDefinition.anInt2808 = 0;
	    Class40_Sub5_Sub15.anInt2785 = 0;
	    Class45.anInt1065 = 0;
	    Class40_Sub5_Sub8.anInt2555 = 0;
	    Class37.anInt865 = 0;
	    Buffer.anInt1950 = 0;
	    Player.anInt3280 = 0;
	    Buffer.anInt1971 = 0;
	    anInt1772 = 0;
	    Class42.anInt1009 = 0;
	    Class40_Sub5_Sub17_Sub3.anInt3057 = 0;
	    anInt1771 = 0;
	    RSString.anInt1689 = 0;
	    Class40_Sub5_Sub8.anInt2509 = 0;
	    RSString.anInt1686 = 0;
	    Class40_Sub5_Sub8.anInt2550 = 0;
	    Class32.anInt753 = 0;
	    Class40_Sub5_Sub1.anInt2261 = 0;
	    Class19.anInt467 = 0;
	    Class56.anInt1328 = 0;
	    Class4.anInt186 = 0;
	    SubNode.anInt2092 = 0;
	    Class8.anInt276 = 0;
	    RSApplet.anInt12 = 0;
	    Class6_Sub1.anInt1794 = 0;
	    Class22_Sub2.anInt1882 = 0;
	    Node.anInt928 = 0;
	    Class40_Sub5_Sub6.anInt2435 = 0;
	    Class13.anInt416 = 0;
	    RSApplet.anInt10 = 0;
	    Class6.anInt242 = 0;
	    Class38_Sub1.anInt1911 = 0;
	    Class46.anInt1106 = 0;
	    RSApplet.anInt6 = 0;
	    Class56.anInt1312 = 0;
	    ISAAC.anInt499 = 0;
	    Class40_Sub5_Sub17_Sub6.anInt3251 = 0;
	    Class40_Sub5_Sub11.anInt2618 = 0;
	    Class68_Sub1.anInt2193 = 0;
	    Floor.anInt2329 = 0;
	    Node.anInt970 = 0;
	    Class48.anInt1130 = 0;
	    Class55.anInt1306 = 0;
	    Class38_Sub1.anInt1907 = 0;
	    Class6_Sub1.anInt1809 = 0;
	    Class24.anInt576 = 0;
	    Floor.anInt2343 = 0;
	    Class46.anInt1096 = 0;
	    Class17.anInt459 = 0;
	    Class40_Sub5_Sub10.anInt2589 = 0;
	    RSApplet.anInt27 = 0;
	    Class53.anInt1256 = 0;
	    ItemDefinition.anInt2847 = 0;
	    Class54.anInt1272 = 0;
	    Class40_Sub5_Sub8.anInt2552 = 0;
	    Class6.anInt230 = 0;
	    Class68.anInt1620 = 0;
	    Class40_Sub5_Sub4.anInt2360 = 0;
	    PacketBuffer.anInt2246 = 0;
	    Class40_Sub5_Sub8.anInt2498 = 0;
	    Class42.anInt1004 = 0;
	    RSString.anInt1679 = 0;
	    Class35.anInt1742 = 0;
	    Class27.anInt648 = 0;
	    Class35.anInt1729 = 0;
	    Class61.anInt1436 = 0;
	    RSRuntimeException.anInt1646 = 0;
	    Class40_Sub5_Sub9.anInt2572 = 0;
	    Class40_Sub5_Sub17_Sub2.anInt3025 = 0;
	    Player.anInt3279 = 0;
	    Buffer.anInt1961 = 0;
	    Class6_Sub1.anInt1803 = 0;
	    Class51.anInt1190 = 0;
	    Class5.anInt197 = 0;
	    Class29.anInt679 = 0;
	    Class3.anInt149 = 0;
	    Class56.anInt1311 = 0;
	    ISAAC.anInt501 = 0;
	    Buffer.anInt1938 = 0;
	    Class40_Sub5_Sub7.anInt2491 = 0;
	    ItemDefinition.anInt2811 = 0;
	    Class40_Sub4.anInt2045 = 0;
	    Cache.anInt310 = 0;
	    Class29.anInt672 = 0;
	    Class60.anInt1403 = 0;
	    Class35.anInt1719 = 0;
	    Floor.anInt2317 = 0;
	    NpcDefinition.anInt2424 = 0;
	    Class51.anInt1193 = 0;
	    ISAAC.anInt507 = 0;
	    Class53.anInt1258 = 0;
	    Class3.anInt152 = 0;
	    RSApplet.anInt38 = 0;
	    Class40_Sub2.anInt2009 = 0;
	    Class13.anInt407 = 0;
	    Class40_Sub5_Sub17_Sub3.anInt3063 = 0;
	    Class44.anInt1031 = arg0;
	    NpcDefinition.anInt2390 = 0;
	    NpcDefinition.anInt2400 = 0;
	    Class33.anInt787 = 0;
	    anInt1785 = 0;
	    anInt1789 = 0;
	    Class68.anInt1624 = 0;
	    ISAAC.anInt504 = 0;
	    Class35.aBoolean1735 = true;
	    HashTable.aBoolean571 = true;
	    SubNode.method540(arg0 + 23721);
	    Cache.anInt324 = -1;
	    Class4.aBoolean173 = false;
	    RSString.anInt1690 = -1;
	    Class57.packetid = -1;
	    Class40_Sub5_Sub15.anInt2782 = 0;
	    Class35.anInt1728 = 0;
	    Player.anInt3288 = 0;
	    Class32.packetBuffer.offset = 0;
	    Class32.anInt771 = 0;
	    Class49.anInt1151 = -1;
	    Cache.outgoingbuffer.offset = 0;
	    NpcDefinition.anInt2394 = 0;
	    Class40_Sub5_Sub13.method650(true, 0);
	    for (int i = 0; (i ^ 0xffffffff) > -101; i++)
		Class40_Sub5_Sub17_Sub4.aClass1Array3160[i] = null;
	    Class8.anInt301 = 0;
	    Class57.anInt1342 = -40 + (int) (80.0 * Math.random());
	    Class48.anInt1126 = -55 + (int) (Math.random() * 110.0);
	    Class40_Sub5_Sub4.anInt2366 = 0;
	    Class43.anInt1020 = (int) (Math.random() * 120.0) + -60;
	    Buffer.anInt1985 = -1;
	    Class40_Sub5_Sub8.anInt2558 = 0;
	    PacketBuffer.anInt2248 = 0;
	    anInt1773 = 0;
	    Class58.anInt1373 = 0x7ff & -10 + (int) (20.0 * Math.random());
	    Class51.anInt1187 = -20 + (int) (Math.random() * 30.0);
	    Class27.anInt658 = 0;
	    Buffer.anInt1976 = -50 + (int) (Math.random() * 100.0);
	    Class60.anInt1407 = 0;
	    Class55.anInt1304 = 0;
	    for (int i = 0; (i ^ 0xffffffff) > -2049; i++) {
		Class40_Sub5_Sub17_Sub4
		    .aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i]
		    = null;
		Class22.aClass40_Sub1Array534[i] = null;
	    }
	    for (int i = 0; (i ^ 0xffffffff) > -32769; i++)
		Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i] = null;
	    Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub4_Sub1_2760
		= Class40_Sub5_Sub17_Sub4
		      .aClass40_Sub5_Sub17_Sub4_Sub1Array3156[2047]
		= new Player();
	    Class43.aClass45_1022.method906(0);
	    Class57.aClass45_1332.method906(0);
	    for (int i = 0; (i ^ 0xffffffff) > -5; i++) {
		for (int i_82_ = 0; i_82_ < 104; i_82_++) {
		    for (int i_83_ = 0; (i_83_ ^ 0xffffffff) > -105; i_83_++)
			Class10.aClass45ArrayArrayArray357[i][i_82_][i_83_]
			    = null;
		}
	    }
	    Class45.aClass45_1064 = new Class45();
	    Class40_Sub5_Sub17_Sub3.anInt3060 = 0;
	    Class12.anInt380 = 0;
	    Class55.method958(Class48.anInt1138, arg0 ^ ~0x378d);
	    Class48.anInt1138 = -1;
	    Class55.method958(Class43.anInt1028, -14222);
	    Class43.anInt1028 = -1;
	    Class55.method958(Class66.anInt1560, -14222);
	    Class66.anInt1560 = -1;
	    Class55.method958(NpcDefinition.anInt2433, arg0 + -14222);
	    NpcDefinition.anInt2433 = -1;
	    Class55.method958(Class40_Sub5_Sub9.anInt2562, -14222);
	    Class40_Sub5_Sub9.anInt2562 = -1;
	    Class55.method958(Class29.anInt673, arg0 ^ ~0x378d);
	    Class29.anInt673 = -1;
	    Class55.method958(Class58.anInt1376, -14222);
	    Class40_Sub5_Sub15.anInt2780 = 0;
	    Class19.aBoolean490 = false;
	    Class4.aBoolean173 = false;
	    Class58.anInt1376 = -1;
	    RSApplet.aClass1_8 = null;
	    Class6_Sub1.anInt1819 = -1;
	    Class51.anInt1205 = -1;
	    Class40_Sub6.anInt2118 = 0;
	    Class5.anInt208 = 3;
	    Class45.aClass30_1082.method380(null, false, 7, new int[5], -1);
	    for (int i = 0; i < 5; i++) {
		aClass1Array1778[i] = null;
		Class13.aBooleanArray414[i] = false;
	    }
	    ISAAC.aBoolean519 = true;
	} catch (RuntimeException runtimeexception) {
	    throw Class8.method216(runtimeexception, "client.V(" + arg0 + ')');
	}
    }
    
    static {
	anInt1764 = 0;
	aClass1_1775
	    = (Class58.method978
	       (-11538, "Account locked as we suspect it has been stolen)3"));
	anInt1756 = 0;
	aClass1_1777 = Class58.method978(-11538, "Verbinde mit Server)3)3)3");
	aClass1_1781 = aClass1_1775;
	anInt1769 = -1;
	anInt1766 = 1;
	anInt1773 = 0;
	aClass1_1783 = Class58.method978(-11538, "Welcome to RS Rebirth");
	aClass1_1761 = aClass1_1783;
	aClass1Array1778 = new RSString[5];
	aClass1_1763 = aClass1_1767;
	aClass1_1788 = Class58.method978(-11538, "backtop1");
    }
}
