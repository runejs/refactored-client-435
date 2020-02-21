/* Class40_Sub5_Sub17_Sub5 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Model extends Class40_Sub5_Sub17 {
    public static Model aClass40_Sub5_Sub17_Sub5_3170
            = new Model();
    public static int[] anIntArray3192 = new int[1];
    public static Model aClass40_Sub5_Sub17_Sub5_3195
            = new Model();
    public static int anInt3198;
    public static int[] anIntArray3199;
    public static int[] anIntArray3200 = new int[1600];
    public static boolean[] aBooleanArray3201;
    public static int[] anIntArray3202;
    public static int[] anIntArray3203;
    public static int[] anIntArray3204;
    public static int[] anIntArray3205;
    public static int anInt3206;
    public static boolean aBoolean3207;
    public static int[][] anIntArrayArray3208;
    public static int[] anIntArray3209;
    public static int[][] anIntArrayArray3210;
    public static int[] anIntArray3211;
    public static int[] anIntArray3212;
    public static int anInt3213;
    public static int[] anIntArray3214;
    public static int[] anIntArray3215;
    public static int[] anIntArray3216;
    public static int[] anIntArray3217;
    public static int anInt3218;
    public static int[] anIntArray3219;
    public static int anInt3220;
    public static int[] anIntArray3221;
    public static int[] anIntArray3222;
    public static int[] anIntArray3223;
    public static boolean[] aBooleanArray3224;
    public static int[] anIntArray3225;
    public static int[] anIntArray3226;
    public static int[] anIntArray3227;
    public static int[] anIntArray3228;
    public static int anInt3229;

    static {
        anIntArray3199 = new int[128];
        anInt3198 = 0;
        anIntArray3205 = new int[10];
        anIntArray3203 = new int[4096];
        anIntArray3211 = new int[1000];
        anIntArrayArray3208 = new int[12][2000];
        anIntArray3204 = new int[4096];
        anIntArrayArray3210 = new int[1600][512];
        aBooleanArray3201 = new boolean[4096];
        anIntArray3212 = new int[4096];
        anIntArray3214 = new int[1];
        aBoolean3207 = false;
        anIntArray3216 = new int[2000];
        anIntArray3202 = R3D.anIntArray2932;
        anIntArray3209 = new int[4096];
        anIntArray3222 = new int[10];
        anIntArray3219 = new int[2000];
        anIntArray3223 = new int[4096];
        anIntArray3215 = R3D.sinetable;
        anIntArray3225 = new int[4096];
        anInt3220 = 0;
        anIntArray3227 = new int[10];
        anIntArray3221 = new int[12];
        anIntArray3217 = R3D.cosinetable;
        aBooleanArray3224 = new boolean[4096];
        anIntArray3228 = R3D.anIntArray2929;
        anInt3229 = 0;
        anIntArray3226 = new int[12];
        int i = 0;
        int i_322_ = 248;
        while (i < 9)
            anIntArray3199[i++] = 255;
        while (i < 16) {
            anIntArray3199[i++] = i_322_;
            i_322_ -= 8;
        }
        while (i < 32) {
            anIntArray3199[i++] = i_322_;
            i_322_ -= 4;
        }
        while (i < 64) {
            anIntArray3199[i++] = i_322_;
            i_322_ -= 2;
        }
        while (i < 128)
            anIntArray3199[i++] = i_322_--;
    }

    public int[][] anIntArrayArray3161;
    public int[] anIntArray3162;
    public int anInt3163;
    public boolean aBoolean3164;
    public int[] anIntArray3165;
    public int[] anIntArray3166;
    public int anInt3167;
    public int anInt3168 = 0;
    public int anInt3169;
    public int anInt3171;
    public Class46[] aClass46Array3172;
    public int[] anIntArray3173;
    public Class46[] aClass46Array3174;
    public int anInt3175;
    public int[][] anIntArrayArray3176;
    public int anInt3177;
    public int[] anIntArray3178;
    public int[] anIntArray3179;
    public int anInt3180;
    public int[] anIntArray3181;
    public int[] anIntArray3182;
    public int[] anIntArray3183;
    public int[] anIntArray3184;
    public int[] anIntArray3185;
    public int[] anIntArray3186;
    public int[] anIntArray3187;
    public int[] anIntArray3188;
    public int anInt3189;
    public int[] anIntArray3190;
    public int[] anIntArray3191;
    public int anInt3193;
    public int[] anIntArray3194;
    public int[] anIntArray3196;
    public int anInt3197;

    public Model(byte[] arg0) {
        aBoolean3164 = false;
        anInt3180 = 0;
        anInt3167 = 0;
        anInt3197 = 0;
        Buffer class40_sub1 = new Buffer(arg0);
        Buffer class40_sub1_255_ = new Buffer(arg0);
        Buffer class40_sub1_256_ = new Buffer(arg0);
        Buffer class40_sub1_257_ = new Buffer(arg0);
        Buffer class40_sub1_258_ = new Buffer(arg0);
        class40_sub1.offset = arg0.length - 18;
        int i = class40_sub1.method469(65280);
        int i_259_ = class40_sub1.method469(65280);
        int i_260_ = class40_sub1.method468(false);
        int i_261_ = class40_sub1.method468(false);
        int i_262_ = class40_sub1.method468(false);
        int i_263_ = class40_sub1.method468(false);
        int i_264_ = class40_sub1.method468(false);
        int i_265_ = class40_sub1.method468(false);
        int i_266_ = class40_sub1.method469(65280);
        int i_267_ = class40_sub1.method469(65280);
        int i_268_ = class40_sub1.method469(65280);
        int i_269_ = class40_sub1.method469(65280);
        int i_270_ = 0;
        int i_271_ = i_270_;
        i_270_ += i;
        int i_272_ = i_270_;
        i_270_ += i_259_;
        int i_273_ = i_270_;
        if (i_262_ == 255)
            i_270_ += i_259_;
        else
            i_273_ = -i_262_ - 1;
        int i_274_ = i_270_;
        if (i_264_ == 1)
            i_270_ += i_259_;
        else
            i_274_ = -1;
        int i_275_ = i_270_;
        if (i_261_ == 1)
            i_270_ += i_259_;
        else
            i_275_ = -1;
        int i_276_ = i_270_;
        if (i_265_ == 1)
            i_270_ += i;
        else
            i_276_ = -1;
        int i_277_ = i_270_;
        if (i_263_ == 1)
            i_270_ += i_259_;
        else
            i_277_ = -1;
        int i_278_ = i_270_;
        i_270_ += i_269_;
        int i_279_ = i_270_;
        i_270_ += i_259_ * 2;
        int i_280_ = i_270_;
        i_270_ += i_260_ * 6;
        int i_281_ = i_270_;
        i_270_ += i_266_;
        int i_282_ = i_270_;
        i_270_ += i_267_;
        int i_283_ = i_270_;
        i_270_ += i_268_;
        anInt3167 = i;
        anInt3168 = i_259_;
        anInt3180 = i_260_;
        anIntArray3188 = new int[i];
        anIntArray3187 = new int[i];
        anIntArray3162 = new int[i];
        anIntArray3182 = new int[i_259_];
        anIntArray3196 = new int[i_259_];
        anIntArray3165 = new int[i_259_];
        anIntArray3179 = new int[i_260_];
        anIntArray3190 = new int[i_260_];
        anIntArray3194 = new int[i_260_];
        if (i_276_ >= 0)
            anIntArray3173 = new int[i];
        if (i_275_ >= 0)
            anIntArray3178 = new int[i_259_];
        if (i_273_ >= 0)
            anIntArray3185 = new int[i_259_];
        else
            anInt3197 = -i_273_ - 1;
        if (i_277_ >= 0)
            anIntArray3183 = new int[i_259_];
        if (i_274_ >= 0)
            anIntArray3166 = new int[i_259_];
        anIntArray3191 = new int[i_259_];
        class40_sub1.offset = i_271_;
        class40_sub1_255_.offset = i_281_;
        class40_sub1_256_.offset = i_282_;
        class40_sub1_257_.offset = i_283_;
        class40_sub1_258_.offset = i_276_;
        int i_284_ = 0;
        int i_285_ = 0;
        int i_286_ = 0;
        for (int i_287_ = 0; i_287_ < i; i_287_++) {
            int i_288_ = class40_sub1.method468(false);
            int i_289_ = 0;
            if ((i_288_ & 0x1) != 0)
                i_289_ = class40_sub1_255_.method482((byte) -106);
            int i_290_ = 0;
            if ((i_288_ & 0x2) != 0)
                i_290_ = class40_sub1_256_.method482((byte) 56);
            int i_291_ = 0;
            if ((i_288_ & 0x4) != 0)
                i_291_ = class40_sub1_257_.method482((byte) -102);
            anIntArray3188[i_287_] = i_284_ + i_289_;
            anIntArray3187[i_287_] = i_285_ + i_290_;
            anIntArray3162[i_287_] = i_286_ + i_291_;
            i_284_ = anIntArray3188[i_287_];
            i_285_ = anIntArray3187[i_287_];
            i_286_ = anIntArray3162[i_287_];
            if (anIntArray3173 != null)
                anIntArray3173[i_287_] = class40_sub1_258_.method468(false);
        }
        class40_sub1.offset = i_279_;
        class40_sub1_255_.offset = i_275_;
        class40_sub1_256_.offset = i_273_;
        class40_sub1_257_.offset = i_277_;
        class40_sub1_258_.offset = i_274_;
        for (int i_292_ = 0; i_292_ < i_259_; i_292_++) {
            anIntArray3191[i_292_] = class40_sub1.method469(65280);
            if (anIntArray3178 != null)
                anIntArray3178[i_292_] = class40_sub1_255_.method468(false);
            if (anIntArray3185 != null)
                anIntArray3185[i_292_] = class40_sub1_256_.method468(false);
            if (anIntArray3183 != null)
                anIntArray3183[i_292_] = class40_sub1_257_.method468(false);
            if (anIntArray3166 != null)
                anIntArray3166[i_292_] = class40_sub1_258_.method468(false);
        }
        class40_sub1.offset = i_278_;
        class40_sub1_255_.offset = i_272_;
        int i_293_ = 0;
        int i_294_ = 0;
        int i_295_ = 0;
        int i_296_ = 0;
        for (int i_297_ = 0; i_297_ < i_259_; i_297_++) {
            int i_298_ = class40_sub1_255_.method468(false);
            if (i_298_ == 1) {
                i_293_ = class40_sub1.method482((byte) 76) + i_296_;
                i_296_ = i_293_;
                i_294_ = class40_sub1.method482((byte) -115) + i_296_;
                i_296_ = i_294_;
                i_295_ = class40_sub1.method482((byte) 54) + i_296_;
                i_296_ = i_295_;
                anIntArray3182[i_297_] = i_293_;
                anIntArray3196[i_297_] = i_294_;
                anIntArray3165[i_297_] = i_295_;
            }
            if (i_298_ == 2) {
                i_294_ = i_295_;
                i_295_ = class40_sub1.method482((byte) 102) + i_296_;
                i_296_ = i_295_;
                anIntArray3182[i_297_] = i_293_;
                anIntArray3196[i_297_] = i_294_;
                anIntArray3165[i_297_] = i_295_;
            }
            if (i_298_ == 3) {
                i_293_ = i_295_;
                i_295_ = class40_sub1.method482((byte) 122) + i_296_;
                i_296_ = i_295_;
                anIntArray3182[i_297_] = i_293_;
                anIntArray3196[i_297_] = i_294_;
                anIntArray3165[i_297_] = i_295_;
            }
            if (i_298_ == 4) {
                int i_299_ = i_293_;
                i_293_ = i_294_;
                i_294_ = i_299_;
                i_295_ = class40_sub1.method482((byte) 42) + i_296_;
                i_296_ = i_295_;
                anIntArray3182[i_297_] = i_293_;
                anIntArray3196[i_297_] = i_294_;
                anIntArray3165[i_297_] = i_295_;
            }
        }
        class40_sub1.offset = i_280_;
        for (int i_300_ = 0; i_300_ < i_260_; i_300_++) {
            anIntArray3179[i_300_] = class40_sub1.method469(65280);
            anIntArray3190[i_300_] = class40_sub1.method469(65280);
            anIntArray3194[i_300_] = class40_sub1.method469(65280);
        }
    }

    public Model() {
        aBoolean3164 = false;
        anInt3180 = 0;
        anInt3167 = 0;
        anInt3197 = 0;
    }

    public Model(Model[] arg0, int arg1) {
        aBoolean3164 = false;
        anInt3180 = 0;
        anInt3167 = 0;
        anInt3197 = 0;
        boolean bool = false;
        boolean bool_305_ = false;
        boolean bool_306_ = false;
        boolean bool_307_ = false;
        anInt3167 = 0;
        anInt3168 = 0;
        anInt3180 = 0;
        anInt3197 = -1;
        for (int i = 0; i < arg1; i++) {
            Model class40_sub5_sub17_sub5 = arg0[i];
            if (class40_sub5_sub17_sub5 != null) {
                anInt3167 += class40_sub5_sub17_sub5.anInt3167;
                anInt3168 += class40_sub5_sub17_sub5.anInt3168;
                anInt3180 += class40_sub5_sub17_sub5.anInt3180;
                bool = bool | class40_sub5_sub17_sub5.anIntArray3178 != null;
                if (class40_sub5_sub17_sub5.anIntArray3185 != null)
                    bool_305_ = true;
                else {
                    if (anInt3197 == -1)
                        anInt3197 = class40_sub5_sub17_sub5.anInt3197;
                    if (anInt3197 != class40_sub5_sub17_sub5.anInt3197)
                        bool_305_ = true;
                }
                bool_306_ = (bool_306_
                        | class40_sub5_sub17_sub5.anIntArray3183 != null);
                bool_307_ = (bool_307_
                        | class40_sub5_sub17_sub5.anIntArray3166 != null);
            }
        }
        anIntArray3188 = new int[anInt3167];
        anIntArray3187 = new int[anInt3167];
        anIntArray3162 = new int[anInt3167];
        anIntArray3173 = new int[anInt3167];
        anIntArray3182 = new int[anInt3168];
        anIntArray3196 = new int[anInt3168];
        anIntArray3165 = new int[anInt3168];
        anIntArray3179 = new int[anInt3180];
        anIntArray3190 = new int[anInt3180];
        anIntArray3194 = new int[anInt3180];
        if (bool)
            anIntArray3178 = new int[anInt3168];
        if (bool_305_)
            anIntArray3185 = new int[anInt3168];
        if (bool_306_)
            anIntArray3183 = new int[anInt3168];
        if (bool_307_)
            anIntArray3166 = new int[anInt3168];
        anIntArray3191 = new int[anInt3168];
        anInt3167 = 0;
        anInt3168 = 0;
        anInt3180 = 0;
        int i = 0;
        for (int i_308_ = 0; i_308_ < arg1; i_308_++) {
            Model class40_sub5_sub17_sub5 = arg0[i_308_];
            if (class40_sub5_sub17_sub5 != null) {
                for (int i_309_ = 0;
                     i_309_ < class40_sub5_sub17_sub5.anInt3168; i_309_++) {
                    if (bool) {
                        if (class40_sub5_sub17_sub5.anIntArray3178 == null)
                            anIntArray3178[anInt3168] = 0;
                        else {
                            int i_310_ = (class40_sub5_sub17_sub5
                                    .anIntArray3178[i_309_]);
                            if ((i_310_ & 0x2) == 2)
                                i_310_ += i << 2;
                            anIntArray3178[anInt3168] = i_310_;
                        }
                    }
                    if (bool_305_) {
                        if (class40_sub5_sub17_sub5.anIntArray3185 == null)
                            anIntArray3185[anInt3168]
                                    = class40_sub5_sub17_sub5.anInt3197;
                        else
                            anIntArray3185[anInt3168]
                                    = (class40_sub5_sub17_sub5.anIntArray3185
                                    [i_309_]);
                    }
                    if (bool_306_) {
                        if (class40_sub5_sub17_sub5.anIntArray3183 == null)
                            anIntArray3183[anInt3168] = 0;
                        else
                            anIntArray3183[anInt3168]
                                    = (class40_sub5_sub17_sub5.anIntArray3183
                                    [i_309_]);
                    }
                    if (bool_307_
                            && class40_sub5_sub17_sub5.anIntArray3166 != null)
                        anIntArray3166[anInt3168]
                                = class40_sub5_sub17_sub5.anIntArray3166[i_309_];
                    anIntArray3191[anInt3168]
                            = class40_sub5_sub17_sub5.anIntArray3191[i_309_];
                    anIntArray3182[anInt3168]
                            = method829(class40_sub5_sub17_sub5,
                            (class40_sub5_sub17_sub5.anIntArray3182
                                    [i_309_]));
                    anIntArray3196[anInt3168]
                            = method829(class40_sub5_sub17_sub5,
                            (class40_sub5_sub17_sub5.anIntArray3196
                                    [i_309_]));
                    anIntArray3165[anInt3168]
                            = method829(class40_sub5_sub17_sub5,
                            (class40_sub5_sub17_sub5.anIntArray3165
                                    [i_309_]));
                    anInt3168++;
                }
                for (int i_311_ = 0;
                     i_311_ < class40_sub5_sub17_sub5.anInt3180; i_311_++) {
                    anIntArray3179[anInt3180]
                            = method829(class40_sub5_sub17_sub5,
                            (class40_sub5_sub17_sub5.anIntArray3179
                                    [i_311_]));
                    anIntArray3190[anInt3180]
                            = method829(class40_sub5_sub17_sub5,
                            (class40_sub5_sub17_sub5.anIntArray3190
                                    [i_311_]));
                    anIntArray3194[anInt3180]
                            = method829(class40_sub5_sub17_sub5,
                            (class40_sub5_sub17_sub5.anIntArray3194
                                    [i_311_]));
                    anInt3180++;
                }
                i += class40_sub5_sub17_sub5.anInt3180;
            }
        }
    }

    public Model(Model[] arg0, int arg1,
                 boolean arg2) {
        aBoolean3164 = false;
        anInt3180 = 0;
        anInt3167 = 0;
        anInt3197 = 0;
        boolean bool = false;
        boolean bool_312_ = false;
        boolean bool_313_ = false;
        boolean bool_314_ = false;
        anInt3167 = 0;
        anInt3168 = 0;
        anInt3180 = 0;
        anInt3197 = -1;
        for (int i = 0; i < arg1; i++) {
            Model class40_sub5_sub17_sub5 = arg0[i];
            if (class40_sub5_sub17_sub5 != null) {
                anInt3167 += class40_sub5_sub17_sub5.anInt3167;
                anInt3168 += class40_sub5_sub17_sub5.anInt3168;
                anInt3180 += class40_sub5_sub17_sub5.anInt3180;
                bool = bool | class40_sub5_sub17_sub5.anIntArray3178 != null;
                if (class40_sub5_sub17_sub5.anIntArray3185 != null)
                    bool_312_ = true;
                else {
                    if (anInt3197 == -1)
                        anInt3197 = class40_sub5_sub17_sub5.anInt3197;
                    if (anInt3197 != class40_sub5_sub17_sub5.anInt3197)
                        bool_312_ = true;
                }
                bool_313_ = (bool_313_
                        | class40_sub5_sub17_sub5.anIntArray3183 != null);
                bool_314_ = (bool_314_
                        | class40_sub5_sub17_sub5.anIntArray3191 != null);
            }
        }
        anIntArray3188 = new int[anInt3167];
        anIntArray3187 = new int[anInt3167];
        anIntArray3162 = new int[anInt3167];
        anIntArray3182 = new int[anInt3168];
        anIntArray3196 = new int[anInt3168];
        anIntArray3165 = new int[anInt3168];
        anIntArray3184 = new int[anInt3168];
        anIntArray3181 = new int[anInt3168];
        anIntArray3186 = new int[anInt3168];
        anIntArray3179 = new int[anInt3180];
        anIntArray3190 = new int[anInt3180];
        anIntArray3194 = new int[anInt3180];
        if (bool)
            anIntArray3178 = new int[anInt3168];
        if (bool_312_)
            anIntArray3185 = new int[anInt3168];
        if (bool_313_)
            anIntArray3183 = new int[anInt3168];
        if (bool_314_)
            anIntArray3191 = new int[anInt3168];
        anInt3167 = 0;
        anInt3168 = 0;
        anInt3180 = 0;
        int i = 0;
        for (int i_315_ = 0; i_315_ < arg1; i_315_++) {
            Model class40_sub5_sub17_sub5 = arg0[i_315_];
            if (class40_sub5_sub17_sub5 != null) {
                int i_316_ = anInt3167;
                for (int i_317_ = 0;
                     i_317_ < class40_sub5_sub17_sub5.anInt3167; i_317_++) {
                    anIntArray3188[anInt3167]
                            = class40_sub5_sub17_sub5.anIntArray3188[i_317_];
                    anIntArray3187[anInt3167]
                            = class40_sub5_sub17_sub5.anIntArray3187[i_317_];
                    anIntArray3162[anInt3167]
                            = class40_sub5_sub17_sub5.anIntArray3162[i_317_];
                    anInt3167++;
                }
                for (int i_318_ = 0;
                     i_318_ < class40_sub5_sub17_sub5.anInt3168; i_318_++) {
                    anIntArray3182[anInt3168]
                            = (class40_sub5_sub17_sub5.anIntArray3182[i_318_]
                            + i_316_);
                    anIntArray3196[anInt3168]
                            = (class40_sub5_sub17_sub5.anIntArray3196[i_318_]
                            + i_316_);
                    anIntArray3165[anInt3168]
                            = (class40_sub5_sub17_sub5.anIntArray3165[i_318_]
                            + i_316_);
                    anIntArray3184[anInt3168]
                            = class40_sub5_sub17_sub5.anIntArray3184[i_318_];
                    anIntArray3181[anInt3168]
                            = class40_sub5_sub17_sub5.anIntArray3181[i_318_];
                    anIntArray3186[anInt3168]
                            = class40_sub5_sub17_sub5.anIntArray3186[i_318_];
                    if (bool) {
                        if (class40_sub5_sub17_sub5.anIntArray3178 == null)
                            anIntArray3178[anInt3168] = 0;
                        else {
                            int i_319_ = (class40_sub5_sub17_sub5
                                    .anIntArray3178[i_318_]);
                            if ((i_319_ & 0x2) == 2)
                                i_319_ += i << 2;
                            anIntArray3178[anInt3168] = i_319_;
                        }
                    }
                    if (bool_312_) {
                        if (class40_sub5_sub17_sub5.anIntArray3185 == null)
                            anIntArray3185[anInt3168]
                                    = class40_sub5_sub17_sub5.anInt3197;
                        else
                            anIntArray3185[anInt3168]
                                    = (class40_sub5_sub17_sub5.anIntArray3185
                                    [i_318_]);
                    }
                    if (bool_313_) {
                        if (class40_sub5_sub17_sub5.anIntArray3183 == null)
                            anIntArray3183[anInt3168] = 0;
                        else
                            anIntArray3183[anInt3168]
                                    = (class40_sub5_sub17_sub5.anIntArray3183
                                    [i_318_]);
                    }
                    if (bool_314_
                            && class40_sub5_sub17_sub5.anIntArray3191 != null)
                        anIntArray3191[anInt3168]
                                = class40_sub5_sub17_sub5.anIntArray3191[i_318_];
                    anInt3168++;
                }
                for (int i_320_ = 0;
                     i_320_ < class40_sub5_sub17_sub5.anInt3180; i_320_++) {
                    anIntArray3179[anInt3180]
                            = (class40_sub5_sub17_sub5.anIntArray3179[i_320_]
                            + i_316_);
                    anIntArray3190[anInt3180]
                            = (class40_sub5_sub17_sub5.anIntArray3190[i_320_]
                            + i_316_);
                    anIntArray3194[anInt3180]
                            = (class40_sub5_sub17_sub5.anIntArray3194[i_320_]
                            + i_316_);
                    anInt3180++;
                }
                i += class40_sub5_sub17_sub5.anInt3180;
            }
        }
    }

    public Model(Model arg0, boolean arg1,
                 boolean arg2, boolean arg3) {
        aBoolean3164 = false;
        anInt3180 = 0;
        anInt3167 = 0;
        anInt3197 = 0;
        anInt3167 = arg0.anInt3167;
        anInt3168 = arg0.anInt3168;
        anInt3180 = arg0.anInt3180;
        if (arg1) {
            anIntArray3188 = arg0.anIntArray3188;
            anIntArray3187 = arg0.anIntArray3187;
            anIntArray3162 = arg0.anIntArray3162;
        } else {
            anIntArray3188 = new int[anInt3167];
            anIntArray3187 = new int[anInt3167];
            anIntArray3162 = new int[anInt3167];
            for (int i = 0; i < anInt3167; i++) {
                anIntArray3188[i] = arg0.anIntArray3188[i];
                anIntArray3187[i] = arg0.anIntArray3187[i];
                anIntArray3162[i] = arg0.anIntArray3162[i];
            }
        }
        if (arg2)
            anIntArray3191 = arg0.anIntArray3191;
        else {
            anIntArray3191 = new int[anInt3168];
            for (int i = 0; i < anInt3168; i++)
                anIntArray3191[i] = arg0.anIntArray3191[i];
        }
        if (arg3)
            anIntArray3183 = arg0.anIntArray3183;
        else {
            anIntArray3183 = new int[anInt3168];
            if (arg0.anIntArray3183 == null) {
                for (int i = 0; i < anInt3168; i++)
                    anIntArray3183[i] = 0;
            } else {
                for (int i = 0; i < anInt3168; i++)
                    anIntArray3183[i] = arg0.anIntArray3183[i];
            }
        }
        anIntArray3173 = arg0.anIntArray3173;
        anIntArray3166 = arg0.anIntArray3166;
        anIntArray3178 = arg0.anIntArray3178;
        anIntArray3182 = arg0.anIntArray3182;
        anIntArray3196 = arg0.anIntArray3196;
        anIntArray3165 = arg0.anIntArray3165;
        anIntArray3185 = arg0.anIntArray3185;
        anInt3197 = arg0.anInt3197;
        anIntArray3179 = arg0.anIntArray3179;
        anIntArray3190 = arg0.anIntArray3190;
        anIntArray3194 = arg0.anIntArray3194;
        aBoolean3164 = arg0.aBoolean3164;
    }

    public Model(Model arg0, boolean arg1,
                 boolean arg2) {
        aBoolean3164 = false;
        anInt3180 = 0;
        anInt3167 = 0;
        anInt3197 = 0;
        anInt3167 = arg0.anInt3167;
        anInt3168 = arg0.anInt3168;
        anInt3180 = arg0.anInt3180;
        if (arg1) {
            anIntArray3187 = new int[anInt3167];
            for (int i = 0; i < anInt3167; i++)
                anIntArray3187[i] = arg0.anIntArray3187[i];
        } else
            anIntArray3187 = arg0.anIntArray3187;
        if (arg2) {
            anIntArray3184 = new int[anInt3168];
            anIntArray3181 = new int[anInt3168];
            anIntArray3186 = new int[anInt3168];
            for (int i = 0; i < anInt3168; i++) {
                anIntArray3184[i] = arg0.anIntArray3184[i];
                anIntArray3181[i] = arg0.anIntArray3181[i];
                anIntArray3186[i] = arg0.anIntArray3186[i];
            }
            anIntArray3178 = new int[anInt3168];
            if (arg0.anIntArray3178 == null) {
                for (int i = 0; i < anInt3168; i++)
                    anIntArray3178[i] = 0;
            } else {
                for (int i = 0; i < anInt3168; i++)
                    anIntArray3178[i] = arg0.anIntArray3178[i];
            }
            aClass46Array3174 = new Class46[anInt3167];
            for (int i = 0; i < anInt3167; i++) {
                Class46 class46 = aClass46Array3174[i] = new Class46();
                Class46 class46_321_ = arg0.aClass46Array3174[i];
                class46.anInt1092 = class46_321_.anInt1092;
                class46.anInt1087 = class46_321_.anInt1087;
                class46.anInt1094 = class46_321_.anInt1094;
                class46.anInt1108 = class46_321_.anInt1108;
            }
            aClass46Array3172 = arg0.aClass46Array3172;
        } else {
            anIntArray3184 = arg0.anIntArray3184;
            anIntArray3181 = arg0.anIntArray3181;
            anIntArray3186 = arg0.anIntArray3186;
            anIntArray3178 = arg0.anIntArray3178;
        }
        anIntArray3188 = arg0.anIntArray3188;
        anIntArray3162 = arg0.anIntArray3162;
        anIntArray3191 = arg0.anIntArray3191;
        anIntArray3183 = arg0.anIntArray3183;
        anIntArray3185 = arg0.anIntArray3185;
        anInt3197 = arg0.anInt3197;
        anIntArray3182 = arg0.anIntArray3182;
        anIntArray3196 = arg0.anIntArray3196;
        anIntArray3165 = arg0.anIntArray3165;
        anIntArray3179 = arg0.anIntArray3179;
        anIntArray3190 = arg0.anIntArray3190;
        anIntArray3194 = arg0.anIntArray3194;
        aBoolean3164 = arg0.aBoolean3164;
        anInt3193 = arg0.anInt3193;
    }

    public static void method800() {
        aClass40_Sub5_Sub17_Sub5_3170 = null;
        anIntArray3192 = null;
        aClass40_Sub5_Sub17_Sub5_3195 = null;
        anIntArray3214 = null;
        aBooleanArray3201 = null;
        aBooleanArray3224 = null;
        anIntArray3209 = null;
        anIntArray3204 = null;
        anIntArray3212 = null;
        anIntArray3225 = null;
        anIntArray3203 = null;
        anIntArray3223 = null;
        anIntArray3200 = null;
        anIntArrayArray3210 = null;
        anIntArray3226 = null;
        anIntArrayArray3208 = null;
        anIntArray3219 = null;
        anIntArray3216 = null;
        anIntArray3221 = null;
        anIntArray3227 = null;
        anIntArray3205 = null;
        anIntArray3222 = null;
        anIntArray3211 = null;
        anIntArray3215 = null;
        anIntArray3217 = null;
        anIntArray3202 = null;
        anIntArray3228 = null;
        anIntArray3199 = null;
    }

    public static int method816(int arg0, int arg1, int arg2) {
        if ((arg2 & 0x2) == 2) {
            if (arg1 < 0)
                arg1 = 0;
            else if (arg1 > 127)
                arg1 = 127;
            arg1 = anIntArray3199[arg1];
            return arg1;
        }
        arg1 = arg1 * (arg0 & 0x7f) >> 7;
        if (arg1 < 2)
            arg1 = 2;
        else if (arg1 > 126)
            arg1 = 126;
        return (arg0 & 0xff80) + arg1;
    }

    public static Model method830(Class6 arg0, int arg1,
                                  int arg2) {
        byte[] is = arg0.method172(arg2, 117, arg1);
        if (is == null)
            return null;
        return new Model(is);
    }

    public void method799() {
        if (anInt3169 != 1) {
            anInt3169 = 1;
            anInt2861 = 0;
            anInt3175 = 0;
            anInt3171 = 0;
            for (int i = 0; i < anInt3167; i++) {
                int i_0_ = anIntArray3188[i];
                int i_1_ = anIntArray3187[i];
                int i_2_ = anIntArray3162[i];
                if (-i_1_ > anInt2861)
                    anInt2861 = -i_1_;
                if (i_1_ > anInt3175)
                    anInt3175 = i_1_;
                int i_3_ = i_0_ * i_0_ + i_2_ * i_2_;
                if (i_3_ > anInt3171)
                    anInt3171 = i_3_;
            }
            anInt3171 = (int) (Math.sqrt((double) anInt3171) + 0.99);
            anInt3189 = (int) (Math.sqrt((double) (anInt3171 * anInt3171
                    + anInt2861 * anInt2861))
                    + 0.99);
            anInt3163 = (anInt3189
                    + (int) (Math.sqrt((double) (anInt3171 * anInt3171
                    + anInt3175 * anInt3175))
                    + 0.99));
        }
    }

    public void method755(int arg0, int arg1, int arg2, int arg3, int arg4,
                          int arg5, int arg6, int arg7, int arg8) {
        if (anInt3169 != 1)
            method799();
        int i = arg7 * arg4 - arg5 * arg3 >> 16;
        int i_4_ = arg6 * arg1 + i * arg2 >> 16;
        int i_5_ = anInt3171 * arg2 >> 16;
        int i_6_ = i_4_ + i_5_;
        if (i_6_ > 50 && i_4_ < 3500) {
            int i_7_ = arg7 * arg3 + arg5 * arg4 >> 16;
            int i_8_ = i_7_ - anInt3171 << 9;
            if (i_8_ / i_6_ < R3D.anInt2934) {
                int i_9_ = i_7_ + anInt3171 << 9;
                if (i_9_ / i_6_ > R3D.anInt2942) {
                    int i_10_ = arg6 * arg2 - i * arg1 >> 16;
                    int i_11_ = anInt3171 * arg1 >> 16;
                    int i_12_ = i_10_ + i_11_ << 9;
                    if (i_12_ / i_6_ > R3D.anInt2935) {
                        int i_13_ = i_11_ + (anInt2861 * arg2 >> 16);
                        int i_14_ = i_10_ - i_13_ << 9;
                        if (i_14_ / i_6_ < R3D.anInt2941) {
                            int i_15_ = i_5_ + (anInt2861 * arg1 >> 16);
                            boolean bool = false;
                            boolean bool_16_ = false;
                            if (i_4_ - i_15_ <= 50)
                                bool_16_ = true;
                            boolean bool_17_ = bool_16_ || anInt3180 > 0;
                            boolean bool_18_ = false;
                            if (arg8 > 0 && aBoolean3207) {
                                int i_19_ = i_4_ - i_5_;
                                if (i_19_ <= 50)
                                    i_19_ = 50;
                                if (i_7_ > 0) {
                                    i_8_ /= i_6_;
                                    i_9_ /= i_19_;
                                } else {
                                    i_9_ /= i_6_;
                                    i_8_ /= i_19_;
                                }
                                if (i_10_ > 0) {
                                    i_14_ /= i_6_;
                                    i_12_ /= i_19_;
                                } else {
                                    i_12_ /= i_6_;
                                    i_14_ /= i_19_;
                                }
                                int i_20_
                                        = (anInt3229
                                        - R3D.anInt2937);
                                int i_21_
                                        = (anInt3198
                                        - R3D.anInt2931);
                                if (i_20_ > i_8_ && i_20_ < i_9_
                                        && i_21_ > i_14_ && i_21_ < i_12_) {
                                    if (aBoolean3164)
                                        anIntArray3211[anInt3220++] = arg8;
                                    else
                                        bool_18_ = true;
                                }
                            }
                            int i_22_ = R3D.anInt2937;
                            int i_23_ = R3D.anInt2931;
                            int i_24_ = 0;
                            int i_25_ = 0;
                            if (arg0 != 0) {
                                i_24_ = anIntArray3215[arg0];
                                i_25_ = anIntArray3217[arg0];
                            }
                            for (int i_26_ = 0; i_26_ < anInt3167; i_26_++) {
                                int i_27_ = anIntArray3188[i_26_];
                                int i_28_ = anIntArray3187[i_26_];
                                int i_29_ = anIntArray3162[i_26_];
                                if (arg0 != 0) {
                                    int i_30_
                                            = i_29_ * i_24_ + i_27_ * i_25_ >> 16;
                                    i_29_
                                            = i_29_ * i_25_ - i_27_ * i_24_ >> 16;
                                    i_27_ = i_30_;
                                }
                                i_27_ += arg5;
                                i_28_ += arg6;
                                i_29_ += arg7;
                                int i_31_ = i_29_ * arg3 + i_27_ * arg4 >> 16;
                                i_29_ = i_29_ * arg4 - i_27_ * arg3 >> 16;
                                i_27_ = i_31_;
                                i_31_ = i_28_ * arg2 - i_29_ * arg1 >> 16;
                                i_29_ = i_28_ * arg1 + i_29_ * arg2 >> 16;
                                i_28_ = i_31_;
                                anIntArray3212[i_26_] = i_29_ - i_4_;
                                if (i_29_ >= 50) {
                                    anIntArray3209[i_26_]
                                            = i_22_ + (i_27_ << 9) / i_29_;
                                    anIntArray3204[i_26_]
                                            = i_23_ + (i_28_ << 9) / i_29_;
                                } else {
                                    anIntArray3209[i_26_] = -5000;
                                    bool = true;
                                }
                                if (bool_17_) {
                                    anIntArray3225[i_26_] = i_27_;
                                    anIntArray3203[i_26_] = i_28_;
                                    anIntArray3223[i_26_] = i_29_;
                                }
                            }
                            try {
                                method815(bool, bool_18_, arg8);
                            } catch (Exception exception) {
                                /* empty */
                            }
                        }
                    }
                }
            }
        }
    }

    public void method801(int arg0, int arg1, int arg2, int arg3, int arg4,
                          int arg5, int arg6, int arg7) {
        if (anInt3169 != 2 && anInt3169 != 1)
            method827();
        int i = R3D.anInt2937;
        int i_32_ = R3D.anInt2931;
        int i_33_ = anIntArray3215[arg0];
        int i_34_ = anIntArray3217[arg0];
        int i_35_ = anIntArray3215[arg1];
        int i_36_ = anIntArray3217[arg1];
        int i_37_ = anIntArray3215[arg2];
        int i_38_ = anIntArray3217[arg2];
        int i_39_ = anIntArray3215[arg3];
        int i_40_ = anIntArray3217[arg3];
        int i_41_ = arg5 * i_39_ + arg6 * i_40_ >> 16;
        for (int i_42_ = 0; i_42_ < anInt3167; i_42_++) {
            int i_43_ = anIntArray3188[i_42_];
            int i_44_ = anIntArray3187[i_42_];
            int i_45_ = anIntArray3162[i_42_];
            if (arg2 != 0) {
                int i_46_ = i_44_ * i_37_ + i_43_ * i_38_ >> 16;
                i_44_ = i_44_ * i_38_ - i_43_ * i_37_ >> 16;
                i_43_ = i_46_;
            }
            if (arg0 != 0) {
                int i_47_ = i_44_ * i_34_ - i_45_ * i_33_ >> 16;
                i_45_ = i_44_ * i_33_ + i_45_ * i_34_ >> 16;
                i_44_ = i_47_;
            }
            if (arg1 != 0) {
                int i_48_ = i_45_ * i_35_ + i_43_ * i_36_ >> 16;
                i_45_ = i_45_ * i_36_ - i_43_ * i_35_ >> 16;
                i_43_ = i_48_;
            }
            i_43_ += arg4;
            i_44_ += arg5;
            i_45_ += arg6;
            int i_49_ = i_44_ * i_40_ - i_45_ * i_39_ >> 16;
            i_45_ = i_44_ * i_39_ + i_45_ * i_40_ >> 16;
            i_44_ = i_49_;
            anIntArray3212[i_42_] = i_45_ - i_41_;
            anIntArray3209[i_42_] = i + (i_43_ << 9) / arg7;
            anIntArray3204[i_42_] = i_32_ + (i_44_ << 9) / arg7;
            if (anInt3180 > 0) {
                anIntArray3225[i_42_] = i_43_;
                anIntArray3203[i_42_] = i_44_;
                anIntArray3223[i_42_] = i_45_;
            }
        }
        try {
            method815(false, false, 0);
        } catch (Exception exception) {
            /* empty */
        }
    }

    public void method802(int arg0, int arg1, int arg2, int arg3, int arg4,
                          boolean arg5) {
        int i = (int) Math.sqrt((double) (arg2 * arg2 + arg3 * arg3
                + arg4 * arg4));
        int i_50_ = arg1 * i >> 8;
        if (anIntArray3184 == null) {
            anIntArray3184 = new int[anInt3168];
            anIntArray3181 = new int[anInt3168];
            anIntArray3186 = new int[anInt3168];
        }
        if (aClass46Array3174 == null) {
            aClass46Array3174 = new Class46[anInt3167];
            for (int i_51_ = 0; i_51_ < anInt3167; i_51_++)
                aClass46Array3174[i_51_] = new Class46();
        }
        for (int i_52_ = 0; i_52_ < anInt3168; i_52_++) {
            int i_53_ = anIntArray3182[i_52_];
            int i_54_ = anIntArray3196[i_52_];
            int i_55_ = anIntArray3165[i_52_];
            int i_56_ = anIntArray3188[i_54_] - anIntArray3188[i_53_];
            int i_57_ = anIntArray3187[i_54_] - anIntArray3187[i_53_];
            int i_58_ = anIntArray3162[i_54_] - anIntArray3162[i_53_];
            int i_59_ = anIntArray3188[i_55_] - anIntArray3188[i_53_];
            int i_60_ = anIntArray3187[i_55_] - anIntArray3187[i_53_];
            int i_61_ = anIntArray3162[i_55_] - anIntArray3162[i_53_];
            int i_62_ = i_57_ * i_61_ - i_60_ * i_58_;
            int i_63_ = i_58_ * i_59_ - i_61_ * i_56_;
            int i_64_;
            for (i_64_ = i_56_ * i_60_ - i_59_ * i_57_;
                 (i_62_ > 8192 || i_63_ > 8192 || i_64_ > 8192 || i_62_ < -8192
                         || i_63_ < -8192 || i_64_ < -8192);
                 i_64_ >>= 1) {
                i_62_ >>= 1;
                i_63_ >>= 1;
            }
            int i_65_ = (int) Math.sqrt((double) (i_62_ * i_62_ + i_63_ * i_63_
                    + i_64_ * i_64_));
            if (i_65_ <= 0)
                i_65_ = 1;
            i_62_ = i_62_ * 256 / i_65_;
            i_63_ = i_63_ * 256 / i_65_;
            i_64_ = i_64_ * 256 / i_65_;
            if (anIntArray3178 == null || (anIntArray3178[i_52_] & 0x1) == 0) {
                Class46 class46 = aClass46Array3174[i_53_];
                class46.anInt1092 += i_62_;
                class46.anInt1087 += i_63_;
                class46.anInt1094 += i_64_;
                class46.anInt1108++;
                class46 = aClass46Array3174[i_54_];
                class46.anInt1092 += i_62_;
                class46.anInt1087 += i_63_;
                class46.anInt1094 += i_64_;
                class46.anInt1108++;
                class46 = aClass46Array3174[i_55_];
                class46.anInt1092 += i_62_;
                class46.anInt1087 += i_63_;
                class46.anInt1094 += i_64_;
                class46.anInt1108++;
            } else {
                int i_66_ = arg0 + (arg2 * i_62_ + arg3 * i_63_
                        + arg4 * i_64_) / (i_50_ + i_50_ / 2);
                anIntArray3184[i_52_] = method816(anIntArray3191[i_52_], i_66_,
                        anIntArray3178[i_52_]);
            }
        }
        if (arg5)
            method808(arg0, i_50_, arg2, arg3, arg4);
        else {
            aClass46Array3172 = new Class46[anInt3167];
            for (int i_67_ = 0; i_67_ < anInt3167; i_67_++) {
                Class46 class46 = aClass46Array3174[i_67_];
                Class46 class46_68_ = aClass46Array3172[i_67_] = new Class46();
                class46_68_.anInt1092 = class46.anInt1092;
                class46_68_.anInt1087 = class46.anInt1087;
                class46_68_.anInt1094 = class46.anInt1094;
                class46_68_.anInt1108 = class46.anInt1108;
            }
            anInt3193 = (arg0 << 16) + (i_50_ & 0xffff);
        }
    }

    public void method803(int arg0, int arg1) {
        for (int i = 0; i < anInt3168; i++) {
            if (anIntArray3191[i] == arg0)
                anIntArray3191[i] = arg1;
        }
    }

    public void method804(int arg0) {
        aClass46Array3174 = null;
        anInt3169 = 0;
        int i = anIntArray3215[arg0];
        int i_69_ = anIntArray3217[arg0];
        for (int i_70_ = 0; i_70_ < anInt3167; i_70_++) {
            int i_71_
                    = (anIntArray3187[i_70_] * i_69_ - anIntArray3162[i_70_] * i
                    >> 16);
            anIntArray3162[i_70_]
                    = (anIntArray3187[i_70_] * i + anIntArray3162[i_70_] * i_69_
                    >> 16);
            anIntArray3187[i_70_] = i_71_;
        }
    }

    public int method805() {
        method799();
        return anInt3171;
    }

    public Model method806(boolean arg0) {
        if (!arg0 && anIntArray3214.length < anInt3168)
            anIntArray3214 = new int[anInt3168 + 100];
        return method820(arg0, aClass40_Sub5_Sub17_Sub5_3195, anIntArray3214);
    }

    public boolean method807(int arg0, int arg1, int arg2, int arg3, int arg4,
                             int arg5, int arg6, int arg7) {
        if (arg1 < arg2 && arg1 < arg3 && arg1 < arg4)
            return false;
        if (arg1 > arg2 && arg1 > arg3 && arg1 > arg4)
            return false;
        if (arg0 < arg5 && arg0 < arg6 && arg0 < arg7)
            return false;
        return arg0 <= arg5 || arg0 <= arg6 || arg0 <= arg7;
    }

    public void method808(int arg0, int arg1, int arg2, int arg3, int arg4) {
        for (int i = 0; i < anInt3168; i++) {
            int i_72_ = anIntArray3182[i];
            int i_73_ = anIntArray3196[i];
            int i_74_ = anIntArray3165[i];
            if (anIntArray3178 == null) {
                int i_75_ = anIntArray3191[i];
                Class46 class46 = aClass46Array3174[i_72_];
                int i_76_ = arg0 + ((arg2 * class46.anInt1092
                        + arg3 * class46.anInt1087
                        + arg4 * class46.anInt1094)
                        / (arg1 * class46.anInt1108));
                anIntArray3184[i] = method816(i_75_, i_76_, 0);
                class46 = aClass46Array3174[i_73_];
                i_76_ = arg0 + ((arg2 * class46.anInt1092
                        + arg3 * class46.anInt1087
                        + arg4 * class46.anInt1094)
                        / (arg1 * class46.anInt1108));
                anIntArray3181[i] = method816(i_75_, i_76_, 0);
                class46 = aClass46Array3174[i_74_];
                i_76_ = arg0 + ((arg2 * class46.anInt1092
                        + arg3 * class46.anInt1087
                        + arg4 * class46.anInt1094)
                        / (arg1 * class46.anInt1108));
                anIntArray3186[i] = method816(i_75_, i_76_, 0);
            } else if ((anIntArray3178[i] & 0x1) == 0) {
                int i_77_ = anIntArray3191[i];
                int i_78_ = anIntArray3178[i];
                Class46 class46 = aClass46Array3174[i_72_];
                int i_79_ = arg0 + ((arg2 * class46.anInt1092
                        + arg3 * class46.anInt1087
                        + arg4 * class46.anInt1094)
                        / (arg1 * class46.anInt1108));
                anIntArray3184[i] = method816(i_77_, i_79_, i_78_);
                class46 = aClass46Array3174[i_73_];
                i_79_ = arg0 + ((arg2 * class46.anInt1092
                        + arg3 * class46.anInt1087
                        + arg4 * class46.anInt1094)
                        / (arg1 * class46.anInt1108));
                anIntArray3181[i] = method816(i_77_, i_79_, i_78_);
                class46 = aClass46Array3174[i_74_];
                i_79_ = arg0 + ((arg2 * class46.anInt1092
                        + arg3 * class46.anInt1087
                        + arg4 * class46.anInt1094)
                        / (arg1 * class46.anInt1108));
                anIntArray3186[i] = method816(i_77_, i_79_, i_78_);
            }
        }
        aClass46Array3174 = null;
        aClass46Array3172 = null;
        anIntArray3173 = null;
        anIntArray3166 = null;
        if (anIntArray3178 != null) {
            for (int i = 0; i < anInt3168; i++) {
                if ((anIntArray3178[i] & 0x2) == 2)
                    return;
            }
        }
        anIntArray3191 = null;
    }

    public void method809(Class40_Sub5_Sub15 arg0, int arg1,
                          Class40_Sub5_Sub15 arg2, int arg3, int[] arg4) {
        if (arg1 != -1) {
            if (arg4 == null || arg3 == -1)
                method825(arg0, arg1);
            else {
                aClass46Array3174 = null;
                anInt3169 = 0;
                Class41 class41 = arg0.aClass41Array2794[arg1];
                Class41 class41_80_ = arg2.aClass41Array2794[arg3];
                Class40_Sub13 class40_sub13 = class41.aClass40_Sub13_983;
                anInt3218 = 0;
                anInt3213 = 0;
                anInt3206 = 0;
                int i = 0;
                int i_81_ = arg4[i++];
                for (int i_82_ = 0; i_82_ < class41.anInt981; i_82_++) {
                    int i_83_;
                    for (i_83_ = class41.anIntArray984[i_82_]; i_83_ > i_81_;
                         i_81_ = arg4[i++]) {
                        /* empty */
                    }
                    if (i_83_ != i_81_
                            || class40_sub13.anIntArray2178[i_83_] == 0)
                        method811(class40_sub13.anIntArray2178[i_83_],
                                class40_sub13.anIntArrayArray2168[i_83_],
                                class41.anIntArray982[i_82_],
                                class41.anIntArray987[i_82_],
                                class41.anIntArray986[i_82_]);
                }
                anInt3218 = 0;
                anInt3213 = 0;
                anInt3206 = 0;
                i = 0;
                i_81_ = arg4[i++];
                for (int i_84_ = 0; i_84_ < class41_80_.anInt981; i_84_++) {
                    int i_85_;
                    for (i_85_ = class41_80_.anIntArray984[i_84_];
                         i_85_ > i_81_; i_81_ = arg4[i++]) {
                        /* empty */
                    }
                    if (i_85_ == i_81_
                            || class40_sub13.anIntArray2178[i_85_] == 0)
                        method811(class40_sub13.anIntArray2178[i_85_],
                                class40_sub13.anIntArrayArray2168[i_85_],
                                class41_80_.anIntArray982[i_84_],
                                class41_80_.anIntArray987[i_84_],
                                class41_80_.anIntArray986[i_84_]);
                }
            }
        }
    }

    public void method810() {
        if (anIntArray3173 != null) {
            int[] is = new int[256];
            int i = 0;
            for (int i_86_ = 0; i_86_ < anInt3167; i_86_++) {
                int i_87_ = anIntArray3173[i_86_];
                is[i_87_]++;
                if (i_87_ > i)
                    i = i_87_;
            }
            anIntArrayArray3161 = new int[i + 1][];
            for (int i_88_ = 0; i_88_ <= i; i_88_++) {
                anIntArrayArray3161[i_88_] = new int[is[i_88_]];
                is[i_88_] = 0;
            }
            for (int i_89_ = 0; i_89_ < anInt3167; i_89_++) {
                int i_90_ = anIntArray3173[i_89_];
                anIntArrayArray3161[i_90_][is[i_90_]++] = i_89_;
            }
            anIntArray3173 = null;
        }
        if (anIntArray3166 != null) {
            int[] is = new int[256];
            int i = 0;
            for (int i_91_ = 0; i_91_ < anInt3168; i_91_++) {
                int i_92_ = anIntArray3166[i_91_];
                is[i_92_]++;
                if (i_92_ > i)
                    i = i_92_;
            }
            anIntArrayArray3176 = new int[i + 1][];
            for (int i_93_ = 0; i_93_ <= i; i_93_++) {
                anIntArrayArray3176[i_93_] = new int[is[i_93_]];
                is[i_93_] = 0;
            }
            for (int i_94_ = 0; i_94_ < anInt3168; i_94_++) {
                int i_95_ = anIntArray3166[i_94_];
                anIntArrayArray3176[i_95_][is[i_95_]++] = i_94_;
            }
            anIntArray3166 = null;
        }
    }

    public void method811(int arg0, int[] arg1, int arg2, int arg3, int arg4) {
        int i = arg1.length;
        if (arg0 == 0) {
            int i_96_ = 0;
            anInt3218 = 0;
            anInt3213 = 0;
            anInt3206 = 0;
            for (int i_97_ = 0; i_97_ < i; i_97_++) {
                int i_98_ = arg1[i_97_];
                if (i_98_ < anIntArrayArray3161.length) {
                    int[] is = anIntArrayArray3161[i_98_];
                    for (int i_99_ = 0; i_99_ < is.length; i_99_++) {
                        int i_100_ = is[i_99_];
                        anInt3218 += anIntArray3188[i_100_];
                        anInt3213 += anIntArray3187[i_100_];
                        anInt3206 += anIntArray3162[i_100_];
                        i_96_++;
                    }
                }
            }
            if (i_96_ > 0) {
                anInt3218 = anInt3218 / i_96_ + arg2;
                anInt3213 = anInt3213 / i_96_ + arg3;
                anInt3206 = anInt3206 / i_96_ + arg4;
            } else {
                anInt3218 = arg2;
                anInt3213 = arg3;
                anInt3206 = arg4;
            }
        } else if (arg0 == 1) {
            for (int i_101_ = 0; i_101_ < i; i_101_++) {
                int i_102_ = arg1[i_101_];
                if (i_102_ < anIntArrayArray3161.length) {
                    int[] is = anIntArrayArray3161[i_102_];
                    for (int i_103_ = 0; i_103_ < is.length; i_103_++) {
                        int i_104_ = is[i_103_];
                        anIntArray3188[i_104_] += arg2;
                        anIntArray3187[i_104_] += arg3;
                        anIntArray3162[i_104_] += arg4;
                    }
                }
            }
        } else if (arg0 == 2) {
            for (int i_105_ = 0; i_105_ < i; i_105_++) {
                int i_106_ = arg1[i_105_];
                if (i_106_ < anIntArrayArray3161.length) {
                    int[] is = anIntArrayArray3161[i_106_];
                    for (int i_107_ = 0; i_107_ < is.length; i_107_++) {
                        int i_108_ = is[i_107_];
                        anIntArray3188[i_108_] -= anInt3218;
                        anIntArray3187[i_108_] -= anInt3213;
                        anIntArray3162[i_108_] -= anInt3206;
                        int i_109_ = (arg2 & 0xff) * 8;
                        int i_110_ = (arg3 & 0xff) * 8;
                        int i_111_ = (arg4 & 0xff) * 8;
                        if (i_111_ != 0) {
                            int i_112_ = anIntArray3215[i_111_];
                            int i_113_ = anIntArray3217[i_111_];
                            int i_114_ = ((anIntArray3187[i_108_] * i_112_
                                    + anIntArray3188[i_108_] * i_113_)
                                    >> 16);
                            anIntArray3187[i_108_]
                                    = (anIntArray3187[i_108_] * i_113_
                                    - anIntArray3188[i_108_] * i_112_) >> 16;
                            anIntArray3188[i_108_] = i_114_;
                        }
                        if (i_109_ != 0) {
                            int i_115_ = anIntArray3215[i_109_];
                            int i_116_ = anIntArray3217[i_109_];
                            int i_117_ = ((anIntArray3187[i_108_] * i_116_
                                    - anIntArray3162[i_108_] * i_115_)
                                    >> 16);
                            anIntArray3162[i_108_]
                                    = (anIntArray3187[i_108_] * i_115_
                                    + anIntArray3162[i_108_] * i_116_) >> 16;
                            anIntArray3187[i_108_] = i_117_;
                        }
                        if (i_110_ != 0) {
                            int i_118_ = anIntArray3215[i_110_];
                            int i_119_ = anIntArray3217[i_110_];
                            int i_120_ = ((anIntArray3162[i_108_] * i_118_
                                    + anIntArray3188[i_108_] * i_119_)
                                    >> 16);
                            anIntArray3162[i_108_]
                                    = (anIntArray3162[i_108_] * i_119_
                                    - anIntArray3188[i_108_] * i_118_) >> 16;
                            anIntArray3188[i_108_] = i_120_;
                        }
                        anIntArray3188[i_108_] += anInt3218;
                        anIntArray3187[i_108_] += anInt3213;
                        anIntArray3162[i_108_] += anInt3206;
                    }
                }
            }
        } else if (arg0 == 3) {
            for (int i_121_ = 0; i_121_ < i; i_121_++) {
                int i_122_ = arg1[i_121_];
                if (i_122_ < anIntArrayArray3161.length) {
                    int[] is = anIntArrayArray3161[i_122_];
                    for (int i_123_ = 0; i_123_ < is.length; i_123_++) {
                        int i_124_ = is[i_123_];
                        anIntArray3188[i_124_] -= anInt3218;
                        anIntArray3187[i_124_] -= anInt3213;
                        anIntArray3162[i_124_] -= anInt3206;
                        anIntArray3188[i_124_]
                                = anIntArray3188[i_124_] * arg2 / 128;
                        anIntArray3187[i_124_]
                                = anIntArray3187[i_124_] * arg3 / 128;
                        anIntArray3162[i_124_]
                                = anIntArray3162[i_124_] * arg4 / 128;
                        anIntArray3188[i_124_] += anInt3218;
                        anIntArray3187[i_124_] += anInt3213;
                        anIntArray3162[i_124_] += anInt3206;
                    }
                }
            }
        } else if (arg0 == 5 && anIntArrayArray3176 != null
                && anIntArray3183 != null) {
            for (int i_125_ = 0; i_125_ < i; i_125_++) {
                int i_126_ = arg1[i_125_];
                if (i_126_ < anIntArrayArray3176.length) {
                    int[] is = anIntArrayArray3176[i_126_];
                    for (int i_127_ = 0; i_127_ < is.length; i_127_++) {
                        int i_128_ = is[i_127_];
                        anIntArray3183[i_128_] += arg2 * 8;
                        if (anIntArray3183[i_128_] < 0)
                            anIntArray3183[i_128_] = 0;
                        if (anIntArray3183[i_128_] > 255)
                            anIntArray3183[i_128_] = 255;
                    }
                }
            }
        }
    }

    public void method812(int arg0, int arg1, int arg2, int arg3, int arg4,
                          int arg5, int arg6) {
        if (anInt3169 != 2 && anInt3169 != 1)
            method827();
        int i = R3D.anInt2937;
        int i_129_ = R3D.anInt2931;
        int i_130_ = anIntArray3215[arg0];
        int i_131_ = anIntArray3217[arg0];
        int i_132_ = anIntArray3215[arg1];
        int i_133_ = anIntArray3217[arg1];
        int i_134_ = anIntArray3215[arg2];
        int i_135_ = anIntArray3217[arg2];
        int i_136_ = anIntArray3215[arg3];
        int i_137_ = anIntArray3217[arg3];
        int i_138_ = arg5 * i_136_ + arg6 * i_137_ >> 16;
        for (int i_139_ = 0; i_139_ < anInt3167; i_139_++) {
            int i_140_ = anIntArray3188[i_139_];
            int i_141_ = anIntArray3187[i_139_];
            int i_142_ = anIntArray3162[i_139_];
            if (arg2 != 0) {
                int i_143_ = i_141_ * i_134_ + i_140_ * i_135_ >> 16;
                i_141_ = i_141_ * i_135_ - i_140_ * i_134_ >> 16;
                i_140_ = i_143_;
            }
            if (arg0 != 0) {
                int i_144_ = i_141_ * i_131_ - i_142_ * i_130_ >> 16;
                i_142_ = i_141_ * i_130_ + i_142_ * i_131_ >> 16;
                i_141_ = i_144_;
            }
            if (arg1 != 0) {
                int i_145_ = i_142_ * i_132_ + i_140_ * i_133_ >> 16;
                i_142_ = i_142_ * i_133_ - i_140_ * i_132_ >> 16;
                i_140_ = i_145_;
            }
            i_140_ += arg4;
            i_141_ += arg5;
            i_142_ += arg6;
            int i_146_ = i_141_ * i_137_ - i_142_ * i_136_ >> 16;
            i_142_ = i_141_ * i_136_ + i_142_ * i_137_ >> 16;
            i_141_ = i_146_;
            anIntArray3212[i_139_] = i_142_ - i_138_;
            anIntArray3209[i_139_] = i + (i_140_ << 9) / i_142_;
            anIntArray3204[i_139_] = i_129_ + (i_141_ << 9) / i_142_;
            if (anInt3180 > 0) {
                anIntArray3225[i_139_] = i_140_;
                anIntArray3203[i_139_] = i_141_;
                anIntArray3223[i_139_] = i_142_;
            }
        }
        try {
            method815(false, false, 0);
        } catch (Exception exception) {
            /* empty */
        }
    }

    public void method813() {
        aClass46Array3174 = null;
        anInt3169 = 0;
        for (int i = 0; i < anInt3167; i++) {
            int i_147_ = anIntArray3188[i];
            anIntArray3188[i] = anIntArray3162[i];
            anIntArray3162[i] = -i_147_;
        }
    }

    public void method814(int arg0) {
        int i = R3D.anInt2937;
        int i_148_ = R3D.anInt2931;
        int i_149_ = 0;
        int i_150_ = anIntArray3182[arg0];
        int i_151_ = anIntArray3196[arg0];
        int i_152_ = anIntArray3165[arg0];
        int i_153_ = anIntArray3223[i_150_];
        int i_154_ = anIntArray3223[i_151_];
        int i_155_ = anIntArray3223[i_152_];
        if (anIntArray3183 == null)
            R3D.anInt2933 = 0;
        else
            R3D.anInt2933 = anIntArray3183[arg0];
        if (i_153_ >= 50) {
            anIntArray3227[i_149_] = anIntArray3209[i_150_];
            anIntArray3205[i_149_] = anIntArray3204[i_150_];
            anIntArray3222[i_149_++] = anIntArray3184[arg0];
        } else {
            int i_156_ = anIntArray3225[i_150_];
            int i_157_ = anIntArray3203[i_150_];
            int i_158_ = anIntArray3184[arg0];
            if (i_155_ >= 50) {
                int i_159_ = (50 - i_153_) * anIntArray3228[i_155_ - i_153_];
                anIntArray3227[i_149_]
                        = i + (i_156_ + ((anIntArray3225[i_152_] - i_156_) * i_159_
                        >> 16)
                        << 9) / 50;
                anIntArray3205[i_149_]
                        = (i_148_
                        + (i_157_ + ((anIntArray3203[i_152_] - i_157_) * i_159_
                        >> 16)
                        << 9) / 50);
                anIntArray3222[i_149_++]
                        = i_158_ + ((anIntArray3186[arg0] - i_158_) * i_159_
                        >> 16);
            }
            if (i_154_ >= 50) {
                int i_160_ = (50 - i_153_) * anIntArray3228[i_154_ - i_153_];
                anIntArray3227[i_149_]
                        = i + (i_156_ + ((anIntArray3225[i_151_] - i_156_) * i_160_
                        >> 16)
                        << 9) / 50;
                anIntArray3205[i_149_]
                        = (i_148_
                        + (i_157_ + ((anIntArray3203[i_151_] - i_157_) * i_160_
                        >> 16)
                        << 9) / 50);
                anIntArray3222[i_149_++]
                        = i_158_ + ((anIntArray3181[arg0] - i_158_) * i_160_
                        >> 16);
            }
        }
        if (i_154_ >= 50) {
            anIntArray3227[i_149_] = anIntArray3209[i_151_];
            anIntArray3205[i_149_] = anIntArray3204[i_151_];
            anIntArray3222[i_149_++] = anIntArray3181[arg0];
        } else {
            int i_161_ = anIntArray3225[i_151_];
            int i_162_ = anIntArray3203[i_151_];
            int i_163_ = anIntArray3181[arg0];
            if (i_153_ >= 50) {
                int i_164_ = (50 - i_154_) * anIntArray3228[i_153_ - i_154_];
                anIntArray3227[i_149_]
                        = i + (i_161_ + ((anIntArray3225[i_150_] - i_161_) * i_164_
                        >> 16)
                        << 9) / 50;
                anIntArray3205[i_149_]
                        = (i_148_
                        + (i_162_ + ((anIntArray3203[i_150_] - i_162_) * i_164_
                        >> 16)
                        << 9) / 50);
                anIntArray3222[i_149_++]
                        = i_163_ + ((anIntArray3184[arg0] - i_163_) * i_164_
                        >> 16);
            }
            if (i_155_ >= 50) {
                int i_165_ = (50 - i_154_) * anIntArray3228[i_155_ - i_154_];
                anIntArray3227[i_149_]
                        = i + (i_161_ + ((anIntArray3225[i_152_] - i_161_) * i_165_
                        >> 16)
                        << 9) / 50;
                anIntArray3205[i_149_]
                        = (i_148_
                        + (i_162_ + ((anIntArray3203[i_152_] - i_162_) * i_165_
                        >> 16)
                        << 9) / 50);
                anIntArray3222[i_149_++]
                        = i_163_ + ((anIntArray3186[arg0] - i_163_) * i_165_
                        >> 16);
            }
        }
        if (i_155_ >= 50) {
            anIntArray3227[i_149_] = anIntArray3209[i_152_];
            anIntArray3205[i_149_] = anIntArray3204[i_152_];
            anIntArray3222[i_149_++] = anIntArray3186[arg0];
        } else {
            int i_166_ = anIntArray3225[i_152_];
            int i_167_ = anIntArray3203[i_152_];
            int i_168_ = anIntArray3186[arg0];
            if (i_154_ >= 50) {
                int i_169_ = (50 - i_155_) * anIntArray3228[i_154_ - i_155_];
                anIntArray3227[i_149_]
                        = i + (i_166_ + ((anIntArray3225[i_151_] - i_166_) * i_169_
                        >> 16)
                        << 9) / 50;
                anIntArray3205[i_149_]
                        = (i_148_
                        + (i_167_ + ((anIntArray3203[i_151_] - i_167_) * i_169_
                        >> 16)
                        << 9) / 50);
                anIntArray3222[i_149_++]
                        = i_168_ + ((anIntArray3181[arg0] - i_168_) * i_169_
                        >> 16);
            }
            if (i_153_ >= 50) {
                int i_170_ = (50 - i_155_) * anIntArray3228[i_153_ - i_155_];
                anIntArray3227[i_149_]
                        = i + (i_166_ + ((anIntArray3225[i_150_] - i_166_) * i_170_
                        >> 16)
                        << 9) / 50;
                anIntArray3205[i_149_]
                        = (i_148_
                        + (i_167_ + ((anIntArray3203[i_150_] - i_167_) * i_170_
                        >> 16)
                        << 9) / 50);
                anIntArray3222[i_149_++]
                        = i_168_ + ((anIntArray3184[arg0] - i_168_) * i_170_
                        >> 16);
            }
        }
        int i_171_ = anIntArray3227[0];
        int i_172_ = anIntArray3227[1];
        int i_173_ = anIntArray3227[2];
        int i_174_ = anIntArray3205[0];
        int i_175_ = anIntArray3205[1];
        int i_176_ = anIntArray3205[2];
        R3D.aBoolean2947 = false;
        if (i_149_ == 3) {
            if (i_171_ < 0 || i_172_ < 0 || i_173_ < 0
                    || i_171_ > R3D.anInt2945
                    || i_172_ > R3D.anInt2945
                    || i_173_ > R3D.anInt2945)
                R3D.aBoolean2947 = true;
            int i_177_;
            if (anIntArray3178 == null)
                i_177_ = 0;
            else
                i_177_ = anIntArray3178[arg0] & 0x3;
            if (i_177_ == 0)
                R3D.method706(i_174_, i_175_, i_176_,
                        i_171_, i_172_, i_173_,
                        anIntArray3222[0],
                        anIntArray3222[1],
                        anIntArray3222[2]);
            else if (i_177_ == 1)
                R3D.method712(i_174_, i_175_, i_176_,
                        i_171_, i_172_, i_173_,
                        (anIntArray3202
                                [anIntArray3184[arg0]]));
            else if (i_177_ == 2) {
                int i_178_ = anIntArray3178[arg0] >> 2;
                int i_179_ = anIntArray3179[i_178_];
                int i_180_ = anIntArray3190[i_178_];
                int i_181_ = anIntArray3194[i_178_];
                R3D.method699
                        (i_174_, i_175_, i_176_, i_171_, i_172_, i_173_,
                                anIntArray3222[0], anIntArray3222[1], anIntArray3222[2],
                                anIntArray3225[i_179_], anIntArray3225[i_180_],
                                anIntArray3225[i_181_], anIntArray3203[i_179_],
                                anIntArray3203[i_180_], anIntArray3203[i_181_],
                                anIntArray3223[i_179_], anIntArray3223[i_180_],
                                anIntArray3223[i_181_], anIntArray3191[arg0]);
            } else if (i_177_ == 3) {
                int i_182_ = anIntArray3178[arg0] >> 2;
                int i_183_ = anIntArray3179[i_182_];
                int i_184_ = anIntArray3190[i_182_];
                int i_185_ = anIntArray3194[i_182_];
                R3D.method699
                        (i_174_, i_175_, i_176_, i_171_, i_172_, i_173_,
                                anIntArray3184[arg0], anIntArray3184[arg0],
                                anIntArray3184[arg0], anIntArray3225[i_183_],
                                anIntArray3225[i_184_], anIntArray3225[i_185_],
                                anIntArray3203[i_183_], anIntArray3203[i_184_],
                                anIntArray3203[i_185_], anIntArray3223[i_183_],
                                anIntArray3223[i_184_], anIntArray3223[i_185_],
                                anIntArray3191[arg0]);
            }
        }
        if (i_149_ == 4) {
            if (i_171_ < 0 || i_172_ < 0 || i_173_ < 0
                    || i_171_ > R3D.anInt2945
                    || i_172_ > R3D.anInt2945
                    || i_173_ > R3D.anInt2945
                    || anIntArray3227[3] < 0
                    || anIntArray3227[3] > R3D.anInt2945)
                R3D.aBoolean2947 = true;
            int i_186_;
            if (anIntArray3178 == null)
                i_186_ = 0;
            else
                i_186_ = anIntArray3178[arg0] & 0x3;
            if (i_186_ == 0) {
                R3D.method706(i_174_, i_175_, i_176_,
                        i_171_, i_172_, i_173_,
                        anIntArray3222[0],
                        anIntArray3222[1],
                        anIntArray3222[2]);
                R3D.method706(i_174_, i_176_,
                        anIntArray3205[3], i_171_,
                        i_173_, anIntArray3227[3],
                        anIntArray3222[0],
                        anIntArray3222[2],
                        anIntArray3222[3]);
            } else if (i_186_ == 1) {
                int i_187_ = anIntArray3202[anIntArray3184[arg0]];
                R3D.method712(i_174_, i_175_, i_176_,
                        i_171_, i_172_, i_173_,
                        i_187_);
                R3D.method712(i_174_, i_176_,
                        anIntArray3205[3], i_171_,
                        i_173_, anIntArray3227[3],
                        i_187_);
            } else if (i_186_ == 2) {
                int i_188_ = anIntArray3178[arg0] >> 2;
                int i_189_ = anIntArray3179[i_188_];
                int i_190_ = anIntArray3190[i_188_];
                int i_191_ = anIntArray3194[i_188_];
                R3D.method699
                        (i_174_, i_175_, i_176_, i_171_, i_172_, i_173_,
                                anIntArray3222[0], anIntArray3222[1], anIntArray3222[2],
                                anIntArray3225[i_189_], anIntArray3225[i_190_],
                                anIntArray3225[i_191_], anIntArray3203[i_189_],
                                anIntArray3203[i_190_], anIntArray3203[i_191_],
                                anIntArray3223[i_189_], anIntArray3223[i_190_],
                                anIntArray3223[i_191_], anIntArray3191[arg0]);
                R3D.method699
                        (i_174_, i_176_, anIntArray3205[3], i_171_, i_173_,
                                anIntArray3227[3], anIntArray3222[0], anIntArray3222[2],
                                anIntArray3222[3], anIntArray3225[i_189_],
                                anIntArray3225[i_190_], anIntArray3225[i_191_],
                                anIntArray3203[i_189_], anIntArray3203[i_190_],
                                anIntArray3203[i_191_], anIntArray3223[i_189_],
                                anIntArray3223[i_190_], anIntArray3223[i_191_],
                                anIntArray3191[arg0]);
            } else if (i_186_ == 3) {
                int i_192_ = anIntArray3178[arg0] >> 2;
                int i_193_ = anIntArray3179[i_192_];
                int i_194_ = anIntArray3190[i_192_];
                int i_195_ = anIntArray3194[i_192_];
                R3D.method699
                        (i_174_, i_175_, i_176_, i_171_, i_172_, i_173_,
                                anIntArray3184[arg0], anIntArray3184[arg0],
                                anIntArray3184[arg0], anIntArray3225[i_193_],
                                anIntArray3225[i_194_], anIntArray3225[i_195_],
                                anIntArray3203[i_193_], anIntArray3203[i_194_],
                                anIntArray3203[i_195_], anIntArray3223[i_193_],
                                anIntArray3223[i_194_], anIntArray3223[i_195_],
                                anIntArray3191[arg0]);
                R3D.method699
                        (i_174_, i_176_, anIntArray3205[3], i_171_, i_173_,
                                anIntArray3227[3], anIntArray3184[arg0],
                                anIntArray3184[arg0], anIntArray3184[arg0],
                                anIntArray3225[i_193_], anIntArray3225[i_194_],
                                anIntArray3225[i_195_], anIntArray3203[i_193_],
                                anIntArray3203[i_194_], anIntArray3203[i_195_],
                                anIntArray3223[i_193_], anIntArray3223[i_194_],
                                anIntArray3223[i_195_], anIntArray3191[arg0]);
            }
        }
    }

    public void method815(boolean arg0, boolean arg1, int arg2) {
        if (anInt3163 < 1600) {
            for (int i = 0; i < anInt3163; i++)
                anIntArray3200[i] = 0;
            for (int i = 0; i < anInt3168; i++) {
                if (anIntArray3178 == null || anIntArray3178[i] != -1) {
                    int i_196_ = anIntArray3182[i];
                    int i_197_ = anIntArray3196[i];
                    int i_198_ = anIntArray3165[i];
                    int i_199_ = anIntArray3209[i_196_];
                    int i_200_ = anIntArray3209[i_197_];
                    int i_201_ = anIntArray3209[i_198_];
                    if (arg0 && (i_199_ == -5000 || i_200_ == -5000
                            || i_201_ == -5000)) {
                        int i_202_ = anIntArray3225[i_196_];
                        int i_203_ = anIntArray3225[i_197_];
                        int i_204_ = anIntArray3225[i_198_];
                        int i_205_ = anIntArray3203[i_196_];
                        int i_206_ = anIntArray3203[i_197_];
                        int i_207_ = anIntArray3203[i_198_];
                        int i_208_ = anIntArray3223[i_196_];
                        int i_209_ = anIntArray3223[i_197_];
                        int i_210_ = anIntArray3223[i_198_];
                        i_202_ -= i_203_;
                        i_204_ -= i_203_;
                        i_205_ -= i_206_;
                        i_207_ -= i_206_;
                        i_208_ -= i_209_;
                        i_210_ -= i_209_;
                        int i_211_ = i_205_ * i_210_ - i_208_ * i_207_;
                        int i_212_ = i_208_ * i_204_ - i_202_ * i_210_;
                        int i_213_ = i_202_ * i_207_ - i_205_ * i_204_;
                        if (i_203_ * i_211_ + i_206_ * i_212_ + i_209_ * i_213_
                                > 0) {
                            aBooleanArray3224[i] = true;
                            int i_214_ = ((anIntArray3212[i_196_]
                                    + anIntArray3212[i_197_]
                                    + anIntArray3212[i_198_]) / 3
                                    + anInt3189);
                            anIntArrayArray3210[i_214_]
                                    [anIntArray3200[i_214_]++]
                                    = i;
                        }
                    } else {
                        if (arg1 && method807(anInt3229, anInt3198,
                                anIntArray3204[i_196_],
                                anIntArray3204[i_197_],
                                anIntArray3204[i_198_], i_199_,
                                i_200_, i_201_)) {
                            anIntArray3211[anInt3220++] = arg2;
                            arg1 = false;
                        }
                        if (((i_199_ - i_200_) * (anIntArray3204[i_198_]
                                - anIntArray3204[i_197_])
                                - (anIntArray3204[i_196_]
                                - anIntArray3204[i_197_]) * (i_201_ - i_200_))
                                > 0) {
                            aBooleanArray3224[i] = false;
                            aBooleanArray3201[i] = i_199_ < 0 || i_200_ < 0 || i_201_ < 0
                                    || i_199_ > R3D.anInt2945
                                    || i_200_ > R3D.anInt2945
                                    || i_201_ > R3D.anInt2945;
                            int i_215_ = ((anIntArray3212[i_196_]
                                    + anIntArray3212[i_197_]
                                    + anIntArray3212[i_198_]) / 3
                                    + anInt3189);
                            anIntArrayArray3210[i_215_]
                                    [anIntArray3200[i_215_]++]
                                    = i;
                        }
                    }
                }
            }
            if (anIntArray3185 == null) {
                for (int i = anInt3163 - 1; i >= 0; i--) {
                    int i_216_ = anIntArray3200[i];
                    if (i_216_ > 0) {
                        int[] is = anIntArrayArray3210[i];
                        for (int i_217_ = 0; i_217_ < i_216_; i_217_++)
                            method823(is[i_217_]);
                    }
                }
            } else {
                for (int i = 0; i < 12; i++) {
                    anIntArray3226[i] = 0;
                    anIntArray3221[i] = 0;
                }
                for (int i = anInt3163 - 1; i >= 0; i--) {
                    int i_218_ = anIntArray3200[i];
                    if (i_218_ > 0) {
                        int[] is = anIntArrayArray3210[i];
                        for (int i_219_ = 0; i_219_ < i_218_; i_219_++) {
                            int i_220_ = is[i_219_];
                            int i_221_ = anIntArray3185[i_220_];
                            int i_222_ = anIntArray3226[i_221_]++;
                            anIntArrayArray3208[i_221_][i_222_] = i_220_;
                            if (i_221_ < 10)
                                anIntArray3221[i_221_] += i;
                            else if (i_221_ == 10)
                                anIntArray3219[i_222_] = i;
                            else
                                anIntArray3216[i_222_] = i;
                        }
                    }
                }
                int i = 0;
                if (anIntArray3226[1] > 0 || anIntArray3226[2] > 0)
                    i = ((anIntArray3221[1] + anIntArray3221[2])
                            / (anIntArray3226[1] + anIntArray3226[2]));
                int i_223_ = 0;
                if (anIntArray3226[3] > 0 || anIntArray3226[4] > 0)
                    i_223_ = ((anIntArray3221[3] + anIntArray3221[4])
                            / (anIntArray3226[3] + anIntArray3226[4]));
                int i_224_ = 0;
                if (anIntArray3226[6] > 0 || anIntArray3226[8] > 0)
                    i_224_ = ((anIntArray3221[6] + anIntArray3221[8])
                            / (anIntArray3226[6] + anIntArray3226[8]));
                int i_225_ = 0;
                int i_226_ = anIntArray3226[10];
                int[] is = anIntArrayArray3208[10];
                int[] is_227_ = anIntArray3219;
                if (i_225_ == i_226_) {
                    i_225_ = 0;
                    i_226_ = anIntArray3226[11];
                    is = anIntArrayArray3208[11];
                    is_227_ = anIntArray3216;
                }
                int i_228_;
                if (i_225_ < i_226_)
                    i_228_ = is_227_[i_225_];
                else
                    i_228_ = -1000;
                for (int i_229_ = 0; i_229_ < 10; i_229_++) {
                    while (i_229_ == 0) {
                        if (i_228_ <= i)
                            break;
                        method823(is[i_225_++]);
                        if (i_225_ == i_226_
                                && is != anIntArrayArray3208[11]) {
                            i_225_ = 0;
                            i_226_ = anIntArray3226[11];
                            is = anIntArrayArray3208[11];
                            is_227_ = anIntArray3216;
                        }
                        if (i_225_ < i_226_)
                            i_228_ = is_227_[i_225_];
                        else
                            i_228_ = -1000;
                    }
                    while (i_229_ == 3) {
                        if (i_228_ <= i_223_)
                            break;
                        method823(is[i_225_++]);
                        if (i_225_ == i_226_
                                && is != anIntArrayArray3208[11]) {
                            i_225_ = 0;
                            i_226_ = anIntArray3226[11];
                            is = anIntArrayArray3208[11];
                            is_227_ = anIntArray3216;
                        }
                        if (i_225_ < i_226_)
                            i_228_ = is_227_[i_225_];
                        else
                            i_228_ = -1000;
                    }
                    while (i_229_ == 5 && i_228_ > i_224_) {
                        method823(is[i_225_++]);
                        if (i_225_ == i_226_
                                && is != anIntArrayArray3208[11]) {
                            i_225_ = 0;
                            i_226_ = anIntArray3226[11];
                            is = anIntArrayArray3208[11];
                            is_227_ = anIntArray3216;
                        }
                        if (i_225_ < i_226_)
                            i_228_ = is_227_[i_225_];
                        else
                            i_228_ = -1000;
                    }
                    int i_230_ = anIntArray3226[i_229_];
                    int[] is_231_ = anIntArrayArray3208[i_229_];
                    for (int i_232_ = 0; i_232_ < i_230_; i_232_++)
                        method823(is_231_[i_232_]);
                }
                while (i_228_ != -1000) {
                    method823(is[i_225_++]);
                    if (i_225_ == i_226_ && is != anIntArrayArray3208[11]) {
                        i_225_ = 0;
                        is = anIntArrayArray3208[11];
                        i_226_ = anIntArray3226[11];
                        is_227_ = anIntArray3216;
                    }
                    if (i_225_ < i_226_)
                        i_228_ = is_227_[i_225_];
                    else
                        i_228_ = -1000;
                }
            }
        }
    }

    public Model method817(boolean arg0) {
        if (!arg0 && anIntArray3192.length < anInt3168)
            anIntArray3192 = new int[anInt3168 + 100];
        return method820(arg0, aClass40_Sub5_Sub17_Sub5_3170, anIntArray3192);
    }

    public void method818() {
        aClass46Array3174 = null;
        anInt3169 = 0;
        for (int i = 0; i < anInt3167; i++)
            anIntArray3162[i] = -anIntArray3162[i];
        for (int i = 0; i < anInt3168; i++) {
            int i_233_ = anIntArray3182[i];
            anIntArray3182[i] = anIntArray3165[i];
            anIntArray3165[i] = i_233_;
        }
    }

    public void method819() {
        aClass46Array3174 = null;
        anInt3169 = 0;
        for (int i = 0; i < anInt3167; i++) {
            anIntArray3188[i] = -anIntArray3188[i];
            anIntArray3162[i] = -anIntArray3162[i];
        }
    }

    public Model method820
            (boolean arg0, Model arg1, int[] arg2) {
        arg1.anInt3167 = anInt3167;
        arg1.anInt3168 = anInt3168;
        arg1.anInt3180 = anInt3180;
        if (arg1.anIntArray3188 == null
                || arg1.anIntArray3188.length < anInt3167) {
            arg1.anIntArray3188 = new int[anInt3167 + 100];
            arg1.anIntArray3187 = new int[anInt3167 + 100];
            arg1.anIntArray3162 = new int[anInt3167 + 100];
        }
        for (int i = 0; i < anInt3167; i++) {
            arg1.anIntArray3188[i] = anIntArray3188[i];
            arg1.anIntArray3187[i] = anIntArray3187[i];
            arg1.anIntArray3162[i] = anIntArray3162[i];
        }
        if (arg0)
            arg1.anIntArray3183 = anIntArray3183;
        else {
            arg1.anIntArray3183 = arg2;
            if (anIntArray3183 == null) {
                for (int i = 0; i < anInt3168; i++)
                    arg1.anIntArray3183[i] = 0;
            } else {
                for (int i = 0; i < anInt3168; i++)
                    arg1.anIntArray3183[i] = anIntArray3183[i];
            }
        }
        arg1.anIntArray3178 = anIntArray3178;
        arg1.anIntArray3191 = anIntArray3191;
        arg1.anIntArray3185 = anIntArray3185;
        arg1.anInt3197 = anInt3197;
        arg1.anIntArrayArray3176 = anIntArrayArray3176;
        arg1.anIntArrayArray3161 = anIntArrayArray3161;
        arg1.anIntArray3182 = anIntArray3182;
        arg1.anIntArray3196 = anIntArray3196;
        arg1.anIntArray3165 = anIntArray3165;
        arg1.anIntArray3184 = anIntArray3184;
        arg1.anIntArray3181 = anIntArray3181;
        arg1.anIntArray3186 = anIntArray3186;
        arg1.anIntArray3179 = anIntArray3179;
        arg1.anIntArray3190 = anIntArray3190;
        arg1.anIntArray3194 = anIntArray3194;
        arg1.aBoolean3164 = aBoolean3164;
        arg1.anInt3169 = 0;
        return arg1;
    }

    public void method821(int arg0, int arg1, int arg2) {
        aClass46Array3174 = null;
        anInt3169 = 0;
        for (int i = 0; i < anInt3167; i++) {
            anIntArray3188[i] = anIntArray3188[i] * arg0 / 128;
            anIntArray3187[i] = anIntArray3187[i] * arg1 / 128;
            anIntArray3162[i] = anIntArray3162[i] * arg2 / 128;
        }
    }

    public void method822() {
        if (anInt3169 != 3) {
            anInt3169 = 3;
            anInt2861 = 0;
            anInt3175 = 0;
            anInt3171 = 999999;
            anInt3163 = -999999;
            anInt3189 = -99999;
            anInt3177 = 99999;
            for (int i = 0; i < anInt3167; i++) {
                int i_234_ = anIntArray3188[i];
                int i_235_ = anIntArray3187[i];
                int i_236_ = anIntArray3162[i];
                if (i_234_ < anInt3171)
                    anInt3171 = i_234_;
                if (i_234_ > anInt3163)
                    anInt3163 = i_234_;
                if (i_236_ < anInt3177)
                    anInt3177 = i_236_;
                if (i_236_ > anInt3189)
                    anInt3189 = i_236_;
                if (-i_235_ > anInt2861)
                    anInt2861 = -i_235_;
                if (i_235_ > anInt3175)
                    anInt3175 = i_235_;
            }
        }
    }

    public void method823(int arg0) {
        if (aBooleanArray3224[arg0])
            method814(arg0);
        else {
            int i = anIntArray3182[arg0];
            int i_237_ = anIntArray3196[arg0];
            int i_238_ = anIntArray3165[arg0];
            R3D.aBoolean2947 = aBooleanArray3201[arg0];
            if (anIntArray3183 == null)
                R3D.anInt2933 = 0;
            else
                R3D.anInt2933 = anIntArray3183[arg0];
            int i_239_;
            if (anIntArray3178 == null)
                i_239_ = 0;
            else
                i_239_ = anIntArray3178[arg0] & 0x3;
            if (i_239_ == 0)
                R3D.method706(anIntArray3204[i],
                        anIntArray3204[i_237_],
                        anIntArray3204[i_238_],
                        anIntArray3209[i],
                        anIntArray3209[i_237_],
                        anIntArray3209[i_238_],
                        anIntArray3184[arg0],
                        anIntArray3181[arg0],
                        anIntArray3186[arg0]);
            else if (i_239_ == 1)
                R3D.method712(anIntArray3204[i],
                        anIntArray3204[i_237_],
                        anIntArray3204[i_238_],
                        anIntArray3209[i],
                        anIntArray3209[i_237_],
                        anIntArray3209[i_238_],
                        (anIntArray3202
                                [anIntArray3184[arg0]]));
            else if (i_239_ == 2) {
                int i_240_ = anIntArray3178[arg0] >> 2;
                int i_241_ = anIntArray3179[i_240_];
                int i_242_ = anIntArray3190[i_240_];
                int i_243_ = anIntArray3194[i_240_];
                R3D.method699
                        (anIntArray3204[i], anIntArray3204[i_237_],
                                anIntArray3204[i_238_], anIntArray3209[i],
                                anIntArray3209[i_237_], anIntArray3209[i_238_],
                                anIntArray3184[arg0], anIntArray3181[arg0],
                                anIntArray3186[arg0], anIntArray3225[i_241_],
                                anIntArray3225[i_242_], anIntArray3225[i_243_],
                                anIntArray3203[i_241_], anIntArray3203[i_242_],
                                anIntArray3203[i_243_], anIntArray3223[i_241_],
                                anIntArray3223[i_242_], anIntArray3223[i_243_],
                                anIntArray3191[arg0]);
            } else if (i_239_ == 3) {
                int i_244_ = anIntArray3178[arg0] >> 2;
                int i_245_ = anIntArray3179[i_244_];
                int i_246_ = anIntArray3190[i_244_];
                int i_247_ = anIntArray3194[i_244_];
                R3D.method699
                        (anIntArray3204[i], anIntArray3204[i_237_],
                                anIntArray3204[i_238_], anIntArray3209[i],
                                anIntArray3209[i_237_], anIntArray3209[i_238_],
                                anIntArray3184[arg0], anIntArray3184[arg0],
                                anIntArray3184[arg0], anIntArray3225[i_245_],
                                anIntArray3225[i_246_], anIntArray3225[i_247_],
                                anIntArray3203[i_245_], anIntArray3203[i_246_],
                                anIntArray3203[i_247_], anIntArray3223[i_245_],
                                anIntArray3223[i_246_], anIntArray3223[i_247_],
                                anIntArray3191[arg0]);
            }
        }
    }

    public void method824() {
        aClass46Array3174 = null;
        anInt3169 = 0;
        for (int i = 0; i < anInt3167; i++) {
            int i_248_ = anIntArray3162[i];
            anIntArray3162[i] = anIntArray3188[i];
            anIntArray3188[i] = -i_248_;
        }
    }

    public void method825(Class40_Sub5_Sub15 arg0, int arg1) {
        if (anIntArrayArray3161 != null && arg1 != -1) {
            aClass46Array3174 = null;
            anInt3169 = 0;
            Class41 class41 = arg0.aClass41Array2794[arg1];
            Class40_Sub13 class40_sub13 = class41.aClass40_Sub13_983;
            anInt3218 = 0;
            anInt3213 = 0;
            anInt3206 = 0;
            for (int i = 0; i < class41.anInt981; i++) {
                int i_249_ = class41.anIntArray984[i];
                method811(class40_sub13.anIntArray2178[i_249_],
                        class40_sub13.anIntArrayArray2168[i_249_],
                        class41.anIntArray982[i], class41.anIntArray987[i],
                        class41.anIntArray986[i]);
            }
        }
    }

    public void method826(int arg0, int arg1, int arg2) {
        int i = anInt3193 >> 16;
        int i_250_ = anInt3193 << 16 >> 16;
        method808(i, i_250_, arg0, arg1, arg2);
    }

    public void method827() {
        if (anInt3169 != 2) {
            anInt3169 = 2;
            anInt3171 = 0;
            for (int i = 0; i < anInt3167; i++) {
                int i_251_ = anIntArray3188[i];
                int i_252_ = anIntArray3187[i];
                int i_253_ = anIntArray3162[i];
                int i_254_
                        = i_251_ * i_251_ + i_253_ * i_253_ + i_252_ * i_252_;
                if (i_254_ > anInt3171)
                    anInt3171 = i_254_;
            }
            anInt3171 = (int) (Math.sqrt((double) anInt3171) + 0.99);
            anInt3189 = anInt3171;
            anInt3163 = anInt3171 + anInt3171;
        }
    }

    public void method828(int arg0, int arg1, int arg2) {
        anInt3169 = 0;
        for (int i = 0; i < anInt3167; i++) {
            anIntArray3188[i] += arg0;
            anIntArray3187[i] += arg1;
            anIntArray3162[i] += arg2;
        }
    }

    public int method829(Model arg0, int arg1) {
        int i = -1;
        int i_301_ = arg0.anIntArray3188[arg1];
        int i_302_ = arg0.anIntArray3187[arg1];
        int i_303_ = arg0.anIntArray3162[arg1];
        for (int i_304_ = 0; i_304_ < anInt3167; i_304_++) {
            if (i_301_ == anIntArray3188[i_304_]
                    && i_302_ == anIntArray3187[i_304_]
                    && i_303_ == anIntArray3162[i_304_]) {
                i = i_304_;
                break;
            }
        }
        if (i == -1) {
            anIntArray3188[anInt3167] = i_301_;
            anIntArray3187[anInt3167] = i_302_;
            anIntArray3162[anInt3167] = i_303_;
            if (arg0.anIntArray3173 != null)
                anIntArray3173[anInt3167] = arg0.anIntArray3173[arg1];
            i = anInt3167++;
        }
        return i;
    }
}
