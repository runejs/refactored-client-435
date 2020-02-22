package com.jagex.runescape.media.renderable;

import com.jagex.runescape.*;
import com.jagex.runescape.io.Buffer;
import tech.henning.fourthreefive.OldEngine.ModelLoader;

public class Model extends Renderable {
    public static Model aClass40_Sub5_Sub17_Sub5_3170 = new Model();
    public static int[] anIntArray3192 = new int[1];
    public static Model aClass40_Sub5_Sub17_Sub5_3195 = new Model();
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
        while(i < 9)
            anIntArray3199[i++] = 255;
        while(i < 16) {
            anIntArray3199[i++] = i_322_;
            i_322_ -= 8;
        }
        while(i < 32) {
            anIntArray3199[i++] = i_322_;
            i_322_ -= 4;
        }
        while(i < 64) {
            anIntArray3199[i++] = i_322_;
            i_322_ -= 2;
        }
        while(i < 128)
            anIntArray3199[i++] = i_322_--;
    }

    public int[][] anIntArrayArray3161;
    public int[] verticesZ;
    public int anInt3163;
    public boolean aBoolean3164;
    public int[] trianglePointsZ;
    public int[] triangleSkinValues;
    public int vertexCount;
    public int triangleCount = 0;
    public int anInt3169;
    public int anInt3171;
    public VertexNormal[] vertexNormalOffset;
    public int[] vertexSkins;
    public VertexNormal[] verticesNormal;
    public int anInt3175;
    public int[][] anIntArrayArray3176;
    public int anInt3177;
    public int[] triangleDrawType;
    public int[] texturedTrianglePointsX;
    public int anInt3180;
    public int[] triangleHSLB;
    public int[] trianglePointsX;
    public int[] triangleAlphaValues;
    public int[] triangleHSLA;
    public int[] trianglePriorities;
    public int[] triangleHSLC;
    public int[] verticesY;
    public int[] verticesX;
    public int anInt3189;
    public int[] texturedTrianglePointsY;
    public int[] triangleColorValues;
    public int anInt3193;
    public int[] texturedTrianglePointsZ;
    public int[] trianglePointsY;
    public int anInt3197;

    public Model(byte[] arg0) { // MODEL LOADING
        aBoolean3164 = false;
        anInt3180 = 0;
        vertexCount = 0;
        anInt3197 = 0;
        Buffer vertexDirectionOffsetBuffer = new Buffer(arg0);
        Buffer xDataOffsetBuffer = new Buffer(arg0);
        Buffer yDataOffsetBuffer = new Buffer(arg0);
        Buffer zDataOffsetBuffer = new Buffer(arg0);
        Buffer vertexSkinOffsetBuffer = new Buffer(arg0);
        vertexDirectionOffsetBuffer.currentPosition = arg0.length - 18;
        int i = vertexDirectionOffsetBuffer.getUnsignedShortBE();
        int triangleCount = vertexDirectionOffsetBuffer.getUnsignedShortBE();
        int i_260_ = vertexDirectionOffsetBuffer.getUnsignedByte();
        int i_261_ = vertexDirectionOffsetBuffer.getUnsignedByte();
        int i_262_ = vertexDirectionOffsetBuffer.getUnsignedByte();
        int i_263_ = vertexDirectionOffsetBuffer.getUnsignedByte();
        int i_264_ = vertexDirectionOffsetBuffer.getUnsignedByte();
        int i_265_ = vertexDirectionOffsetBuffer.getUnsignedByte();
        int i_266_ = vertexDirectionOffsetBuffer.getUnsignedShortBE();
        int i_267_ = vertexDirectionOffsetBuffer.getUnsignedShortBE();
        int i_268_ = vertexDirectionOffsetBuffer.getUnsignedShortBE();
        int i_269_ = vertexDirectionOffsetBuffer.getUnsignedShortBE();
        int i_270_ = 0;
        int i_271_ = i_270_;
        i_270_ += i;
        int triangleTypeOffset = i_270_;
        i_270_ += triangleCount;
        int trianglePriorityOffset = i_270_;
        if(i_262_ == 255)
            i_270_ += triangleCount;
        else
            trianglePriorityOffset = -i_262_ - 1;
        int triangleSkinOffset = i_270_;
        if(i_264_ == 1)
            i_270_ += triangleCount;
        else
            triangleSkinOffset = -1;
        int texturePointerOffset = i_270_;
        if(i_261_ == 1)
            i_270_ += triangleCount;
        else
            texturePointerOffset = -1;
        int i_276_ = i_270_;
        if(i_265_ == 1)
            i_270_ += i;
        else
            i_276_ = -1;
        int triangleAlphaOffset = i_270_;
        if(i_263_ == 1)
            i_270_ += triangleCount;
        else
            triangleAlphaOffset = -1;
        int triangleDataOffset = i_270_;
        i_270_ += i_269_;
        int colorDataOffset = i_270_;
        i_270_ += triangleCount * 2;
        int i_280_ = i_270_;
        i_270_ += i_260_ * 6;
        int i_281_ = i_270_;
        i_270_ += i_266_;
        int i_282_ = i_270_;
        i_270_ += i_267_;
        int i_283_ = i_270_;
        i_270_ += i_268_;
        vertexCount = i;
        this.triangleCount = triangleCount;
        anInt3180 = i_260_;
        verticesX = new int[i];
        verticesY = new int[i];
        verticesZ = new int[i];
        trianglePointsX = new int[triangleCount];
        trianglePointsY = new int[triangleCount];
        trianglePointsZ = new int[triangleCount];
        texturedTrianglePointsX = new int[i_260_];
        texturedTrianglePointsY = new int[i_260_];
        texturedTrianglePointsZ = new int[i_260_];
        if(i_276_ >= 0)
            vertexSkins = new int[i];
        if(texturePointerOffset >= 0)
            triangleDrawType = new int[triangleCount];
        if(trianglePriorityOffset >= 0)
            trianglePriorities = new int[triangleCount];
        else
            anInt3197 = -trianglePriorityOffset - 1;
        if(triangleAlphaOffset >= 0)
            triangleAlphaValues = new int[triangleCount];
        if(triangleSkinOffset >= 0)
            triangleSkinValues = new int[triangleCount];
        triangleColorValues = new int[triangleCount];
        vertexDirectionOffsetBuffer.currentPosition = i_271_;
        xDataOffsetBuffer.currentPosition = i_281_;
        yDataOffsetBuffer.currentPosition = i_282_;
        zDataOffsetBuffer.currentPosition = i_283_;
        vertexSkinOffsetBuffer.currentPosition = i_276_;
        int baseOffsetX = 0;
        int baseOffsetY = 0;
        int baseOffsetZ = 0;
        for(int i_287_ = 0; i_287_ < i; i_287_++) {
            int flag = vertexDirectionOffsetBuffer.getUnsignedByte();
            int i_289_ = 0;
            if((flag & 0x1) != 0)
                i_289_ = xDataOffsetBuffer.getSignedSmart();
            int i_290_ = 0;
            if((flag & 0x2) != 0)
                i_290_ = yDataOffsetBuffer.getSignedSmart();
            int currentOffsetZ = 0;
            if((flag & 0x4) != 0)
                currentOffsetZ = zDataOffsetBuffer.getSignedSmart();
            verticesX[i_287_] = baseOffsetX + i_289_;
            verticesY[i_287_] = baseOffsetY + i_290_;
            verticesZ[i_287_] = baseOffsetZ + currentOffsetZ;
            baseOffsetX = verticesX[i_287_];
            baseOffsetY = verticesY[i_287_];
            baseOffsetZ = verticesZ[i_287_];
            if(vertexSkins != null)
                vertexSkins[i_287_] = vertexSkinOffsetBuffer.getUnsignedByte();
        }
        vertexDirectionOffsetBuffer.currentPosition = colorDataOffset;
        xDataOffsetBuffer.currentPosition = texturePointerOffset;
        yDataOffsetBuffer.currentPosition = trianglePriorityOffset;
        zDataOffsetBuffer.currentPosition = triangleAlphaOffset;
        vertexSkinOffsetBuffer.currentPosition = triangleSkinOffset;
        for(int i_292_ = 0; i_292_ < triangleCount; i_292_++) {
            triangleColorValues[i_292_] = vertexDirectionOffsetBuffer.getUnsignedShortBE();
            if(triangleDrawType != null)
                triangleDrawType[i_292_] = xDataOffsetBuffer.getUnsignedByte();
            if(trianglePriorities != null)
                trianglePriorities[i_292_] = yDataOffsetBuffer.getUnsignedByte();
            if(triangleAlphaValues != null)
                triangleAlphaValues[i_292_] = zDataOffsetBuffer.getUnsignedByte();
            if(triangleSkinValues != null)
                triangleSkinValues[i_292_] = vertexSkinOffsetBuffer.getUnsignedByte();
        }
        vertexDirectionOffsetBuffer.currentPosition = triangleDataOffset;
        xDataOffsetBuffer.currentPosition = triangleTypeOffset;
        int trianglePointOffsetX = 0;
        int trianglePointOffsetY = 0;
        int trianglePointOffsetZ = 0;
        int offset = 0;
        for(int triangle = 0; triangle < triangleCount; triangle++) {
            int type = xDataOffsetBuffer.getUnsignedByte();
            if(type == 1) {
                trianglePointOffsetX = vertexDirectionOffsetBuffer.getSignedSmart() + offset;
                offset = trianglePointOffsetX;
                trianglePointOffsetY = vertexDirectionOffsetBuffer.getSignedSmart() + offset;
                offset = trianglePointOffsetY;
                trianglePointOffsetZ = vertexDirectionOffsetBuffer.getSignedSmart() + offset;
                offset = trianglePointOffsetZ;
                trianglePointsX[triangle] = trianglePointOffsetX;
                trianglePointsY[triangle] = trianglePointOffsetY;
                trianglePointsZ[triangle] = trianglePointOffsetZ;
            }
            if(type == 2) {
                trianglePointOffsetY = trianglePointOffsetZ;
                trianglePointOffsetZ = vertexDirectionOffsetBuffer.getSignedSmart() + offset;
                offset = trianglePointOffsetZ;
                trianglePointsX[triangle] = trianglePointOffsetX;
                trianglePointsY[triangle] = trianglePointOffsetY;
                trianglePointsZ[triangle] = trianglePointOffsetZ;
            }
            if(type == 3) {
                trianglePointOffsetX = trianglePointOffsetZ;
                trianglePointOffsetZ = vertexDirectionOffsetBuffer.getSignedSmart() + offset;
                offset = trianglePointOffsetZ;
                trianglePointsX[triangle] = trianglePointOffsetX;
                trianglePointsY[triangle] = trianglePointOffsetY;
                trianglePointsZ[triangle] = trianglePointOffsetZ;
            }
            if(type == 4) {
                int oldTrianglePointOffsetX = trianglePointOffsetX;
                trianglePointOffsetX = trianglePointOffsetY;
                trianglePointOffsetY = oldTrianglePointOffsetX;
                trianglePointOffsetZ = vertexDirectionOffsetBuffer.getSignedSmart() + offset;
                offset = trianglePointOffsetZ;
                trianglePointsX[triangle] = trianglePointOffsetX;
                trianglePointsY[triangle] = trianglePointOffsetY;
                trianglePointsZ[triangle] = trianglePointOffsetZ;
            }
        }
        vertexDirectionOffsetBuffer.currentPosition = i_280_;
        for(int triangle = 0; triangle < i_260_; triangle++) {
            texturedTrianglePointsX[triangle] = vertexDirectionOffsetBuffer.getUnsignedShortBE();
            texturedTrianglePointsY[triangle] = vertexDirectionOffsetBuffer.getUnsignedShortBE();
            texturedTrianglePointsZ[triangle] = vertexDirectionOffsetBuffer.getUnsignedShortBE();
        }
    }

    public Model() {
        aBoolean3164 = false;
        anInt3180 = 0;
        vertexCount = 0;
        anInt3197 = 0;
    }

    public Model(Model[] arg0, int arg1) {
        aBoolean3164 = false;
        anInt3180 = 0;
        vertexCount = 0;
        anInt3197 = 0;
        boolean bool = false;
        boolean bool_305_ = false;
        boolean bool_306_ = false;
        boolean bool_307_ = false;
        vertexCount = 0;
        triangleCount = 0;
        anInt3180 = 0;
        anInt3197 = -1;
        for(int i = 0; i < arg1; i++) {
            Model class40_sub5_sub17_sub5 = arg0[i];
            if(class40_sub5_sub17_sub5 != null) {
                vertexCount += class40_sub5_sub17_sub5.vertexCount;
                triangleCount += class40_sub5_sub17_sub5.triangleCount;
                anInt3180 += class40_sub5_sub17_sub5.anInt3180;
                bool = bool | class40_sub5_sub17_sub5.triangleDrawType != null;
                if(class40_sub5_sub17_sub5.trianglePriorities != null)
                    bool_305_ = true;
                else {
                    if(anInt3197 == -1)
                        anInt3197 = class40_sub5_sub17_sub5.anInt3197;
                    if(anInt3197 != class40_sub5_sub17_sub5.anInt3197)
                        bool_305_ = true;
                }
                bool_306_ = (bool_306_ | class40_sub5_sub17_sub5.triangleAlphaValues != null);
                bool_307_ = (bool_307_ | class40_sub5_sub17_sub5.triangleSkinValues != null);
            }
        }
        verticesX = new int[vertexCount];
        verticesY = new int[vertexCount];
        verticesZ = new int[vertexCount];
        vertexSkins = new int[vertexCount];
        trianglePointsX = new int[triangleCount];
        trianglePointsY = new int[triangleCount];
        trianglePointsZ = new int[triangleCount];
        texturedTrianglePointsX = new int[anInt3180];
        texturedTrianglePointsY = new int[anInt3180];
        texturedTrianglePointsZ = new int[anInt3180];
        if(bool)
            triangleDrawType = new int[triangleCount];
        if(bool_305_)
            trianglePriorities = new int[triangleCount];
        if(bool_306_)
            triangleAlphaValues = new int[triangleCount];
        if(bool_307_)
            triangleSkinValues = new int[triangleCount];
        triangleColorValues = new int[triangleCount];
        vertexCount = 0;
        triangleCount = 0;
        anInt3180 = 0;
        int i = 0;
        for(int i_308_ = 0; i_308_ < arg1; i_308_++) {
            Model class40_sub5_sub17_sub5 = arg0[i_308_];
            if(class40_sub5_sub17_sub5 != null) {
                for(int i_309_ = 0; i_309_ < class40_sub5_sub17_sub5.triangleCount; i_309_++) {
                    if(bool) {
                        if(class40_sub5_sub17_sub5.triangleDrawType == null)
                            triangleDrawType[triangleCount] = 0;
                        else {
                            int i_310_ = (class40_sub5_sub17_sub5.triangleDrawType[i_309_]);
                            if((i_310_ & 0x2) == 2)
                                i_310_ += i << 2;
                            triangleDrawType[triangleCount] = i_310_;
                        }
                    }
                    if(bool_305_) {
                        if(class40_sub5_sub17_sub5.trianglePriorities == null)
                            trianglePriorities[triangleCount] = class40_sub5_sub17_sub5.anInt3197;
                        else
                            trianglePriorities[triangleCount] = (class40_sub5_sub17_sub5.trianglePriorities[i_309_]);
                    }
                    if(bool_306_) {
                        if(class40_sub5_sub17_sub5.triangleAlphaValues == null)
                            triangleAlphaValues[triangleCount] = 0;
                        else
                            triangleAlphaValues[triangleCount] = (class40_sub5_sub17_sub5.triangleAlphaValues[i_309_]);
                    }
                    if(bool_307_ && class40_sub5_sub17_sub5.triangleSkinValues != null)
                        triangleSkinValues[triangleCount] = class40_sub5_sub17_sub5.triangleSkinValues[i_309_];
                    triangleColorValues[triangleCount] = class40_sub5_sub17_sub5.triangleColorValues[i_309_];
                    trianglePointsX[triangleCount] = method829(class40_sub5_sub17_sub5, (class40_sub5_sub17_sub5.trianglePointsX[i_309_]));
                    trianglePointsY[triangleCount] = method829(class40_sub5_sub17_sub5, (class40_sub5_sub17_sub5.trianglePointsY[i_309_]));
                    trianglePointsZ[triangleCount] = method829(class40_sub5_sub17_sub5, (class40_sub5_sub17_sub5.trianglePointsZ[i_309_]));
                    triangleCount++;
                }
                for(int i_311_ = 0; i_311_ < class40_sub5_sub17_sub5.anInt3180; i_311_++) {
                    texturedTrianglePointsX[anInt3180] = method829(class40_sub5_sub17_sub5, (class40_sub5_sub17_sub5.texturedTrianglePointsX[i_311_]));
                    texturedTrianglePointsY[anInt3180] = method829(class40_sub5_sub17_sub5, (class40_sub5_sub17_sub5.texturedTrianglePointsY[i_311_]));
                    texturedTrianglePointsZ[anInt3180] = method829(class40_sub5_sub17_sub5, (class40_sub5_sub17_sub5.texturedTrianglePointsZ[i_311_]));
                    anInt3180++;
                }
                i += class40_sub5_sub17_sub5.anInt3180;
            }
        }
    }

    public Model(Model[] arg0, int arg1, boolean arg2) {
        aBoolean3164 = false;
        anInt3180 = 0;
        vertexCount = 0;
        anInt3197 = 0;
        boolean bool = false;
        boolean bool_312_ = false;
        boolean bool_313_ = false;
        boolean bool_314_ = false;
        vertexCount = 0;
        triangleCount = 0;
        anInt3180 = 0;
        anInt3197 = -1;
        for(int i = 0; i < arg1; i++) {
            Model class40_sub5_sub17_sub5 = arg0[i];
            if(class40_sub5_sub17_sub5 != null) {
                vertexCount += class40_sub5_sub17_sub5.vertexCount;
                triangleCount += class40_sub5_sub17_sub5.triangleCount;
                anInt3180 += class40_sub5_sub17_sub5.anInt3180;
                bool = bool | class40_sub5_sub17_sub5.triangleDrawType != null;
                if(class40_sub5_sub17_sub5.trianglePriorities != null)
                    bool_312_ = true;
                else {
                    if(anInt3197 == -1)
                        anInt3197 = class40_sub5_sub17_sub5.anInt3197;
                    if(anInt3197 != class40_sub5_sub17_sub5.anInt3197)
                        bool_312_ = true;
                }
                bool_313_ = (bool_313_ | class40_sub5_sub17_sub5.triangleAlphaValues != null);
                bool_314_ = (bool_314_ | class40_sub5_sub17_sub5.triangleColorValues != null);
            }
        }
        verticesX = new int[vertexCount];
        verticesY = new int[vertexCount];
        verticesZ = new int[vertexCount];
        trianglePointsX = new int[triangleCount];
        trianglePointsY = new int[triangleCount];
        trianglePointsZ = new int[triangleCount];
        triangleHSLA = new int[triangleCount];
        triangleHSLB = new int[triangleCount];
        triangleHSLC = new int[triangleCount];
        texturedTrianglePointsX = new int[anInt3180];
        texturedTrianglePointsY = new int[anInt3180];
        texturedTrianglePointsZ = new int[anInt3180];
        if(bool)
            triangleDrawType = new int[triangleCount];
        if(bool_312_)
            trianglePriorities = new int[triangleCount];
        if(bool_313_)
            triangleAlphaValues = new int[triangleCount];
        if(bool_314_)
            triangleColorValues = new int[triangleCount];
        vertexCount = 0;
        triangleCount = 0;
        anInt3180 = 0;
        int i = 0;
        for(int i_315_ = 0; i_315_ < arg1; i_315_++) {
            Model class40_sub5_sub17_sub5 = arg0[i_315_];
            if(class40_sub5_sub17_sub5 != null) {
                int i_316_ = vertexCount;
                for(int i_317_ = 0; i_317_ < class40_sub5_sub17_sub5.vertexCount; i_317_++) {
                    verticesX[vertexCount] = class40_sub5_sub17_sub5.verticesX[i_317_];
                    verticesY[vertexCount] = class40_sub5_sub17_sub5.verticesY[i_317_];
                    verticesZ[vertexCount] = class40_sub5_sub17_sub5.verticesZ[i_317_];
                    vertexCount++;
                }
                for(int i_318_ = 0; i_318_ < class40_sub5_sub17_sub5.triangleCount; i_318_++) {
                    trianglePointsX[triangleCount] = (class40_sub5_sub17_sub5.trianglePointsX[i_318_] + i_316_);
                    trianglePointsY[triangleCount] = (class40_sub5_sub17_sub5.trianglePointsY[i_318_] + i_316_);
                    trianglePointsZ[triangleCount] = (class40_sub5_sub17_sub5.trianglePointsZ[i_318_] + i_316_);
                    triangleHSLA[triangleCount] = class40_sub5_sub17_sub5.triangleHSLA[i_318_];
                    triangleHSLB[triangleCount] = class40_sub5_sub17_sub5.triangleHSLB[i_318_];
                    triangleHSLC[triangleCount] = class40_sub5_sub17_sub5.triangleHSLC[i_318_];
                    if(bool) {
                        if(class40_sub5_sub17_sub5.triangleDrawType == null)
                            triangleDrawType[triangleCount] = 0;
                        else {
                            int i_319_ = (class40_sub5_sub17_sub5.triangleDrawType[i_318_]);
                            if((i_319_ & 0x2) == 2)
                                i_319_ += i << 2;
                            triangleDrawType[triangleCount] = i_319_;
                        }
                    }
                    if(bool_312_) {
                        if(class40_sub5_sub17_sub5.trianglePriorities == null)
                            trianglePriorities[triangleCount] = class40_sub5_sub17_sub5.anInt3197;
                        else
                            trianglePriorities[triangleCount] = (class40_sub5_sub17_sub5.trianglePriorities[i_318_]);
                    }
                    if(bool_313_) {
                        if(class40_sub5_sub17_sub5.triangleAlphaValues == null)
                            triangleAlphaValues[triangleCount] = 0;
                        else
                            triangleAlphaValues[triangleCount] = (class40_sub5_sub17_sub5.triangleAlphaValues[i_318_]);
                    }
                    if(bool_314_ && class40_sub5_sub17_sub5.triangleColorValues != null)
                        triangleColorValues[triangleCount] = class40_sub5_sub17_sub5.triangleColorValues[i_318_];
                    triangleCount++;
                }
                for(int i_320_ = 0; i_320_ < class40_sub5_sub17_sub5.anInt3180; i_320_++) {
                    texturedTrianglePointsX[anInt3180] = (class40_sub5_sub17_sub5.texturedTrianglePointsX[i_320_] + i_316_);
                    texturedTrianglePointsY[anInt3180] = (class40_sub5_sub17_sub5.texturedTrianglePointsY[i_320_] + i_316_);
                    texturedTrianglePointsZ[anInt3180] = (class40_sub5_sub17_sub5.texturedTrianglePointsZ[i_320_] + i_316_);
                    anInt3180++;
                }
                i += class40_sub5_sub17_sub5.anInt3180;
            }
        }
    }

    public Model(Model arg0, boolean arg1, boolean arg2, boolean arg3) {
        aBoolean3164 = false;
        anInt3180 = 0;
        vertexCount = 0;
        anInt3197 = 0;
        vertexCount = arg0.vertexCount;
        triangleCount = arg0.triangleCount;
        anInt3180 = arg0.anInt3180;
        if(arg1) {
            verticesX = arg0.verticesX;
            verticesY = arg0.verticesY;
            verticesZ = arg0.verticesZ;
        } else {
            verticesX = new int[vertexCount];
            verticesY = new int[vertexCount];
            verticesZ = new int[vertexCount];
            for(int i = 0; i < vertexCount; i++) {
                verticesX[i] = arg0.verticesX[i];
                verticesY[i] = arg0.verticesY[i];
                verticesZ[i] = arg0.verticesZ[i];
            }
        }
        if(arg2)
            triangleColorValues = arg0.triangleColorValues;
        else {
            triangleColorValues = new int[triangleCount];
            for(int i = 0; i < triangleCount; i++)
                triangleColorValues[i] = arg0.triangleColorValues[i];
        }
        if(arg3)
            triangleAlphaValues = arg0.triangleAlphaValues;
        else {
            triangleAlphaValues = new int[triangleCount];
            if(arg0.triangleAlphaValues == null) {
                for(int i = 0; i < triangleCount; i++)
                    triangleAlphaValues[i] = 0;
            } else {
                for(int i = 0; i < triangleCount; i++)
                    triangleAlphaValues[i] = arg0.triangleAlphaValues[i];
            }
        }
        vertexSkins = arg0.vertexSkins;
        triangleSkinValues = arg0.triangleSkinValues;
        triangleDrawType = arg0.triangleDrawType;
        trianglePointsX = arg0.trianglePointsX;
        trianglePointsY = arg0.trianglePointsY;
        trianglePointsZ = arg0.trianglePointsZ;
        trianglePriorities = arg0.trianglePriorities;
        anInt3197 = arg0.anInt3197;
        texturedTrianglePointsX = arg0.texturedTrianglePointsX;
        texturedTrianglePointsY = arg0.texturedTrianglePointsY;
        texturedTrianglePointsZ = arg0.texturedTrianglePointsZ;
        aBoolean3164 = arg0.aBoolean3164;
    }

    public Model(boolean adjustToTerrain, boolean nonFlatShading, Model model) {
        aBoolean3164 = false;
        anInt3180 = 0;
        vertexCount = 0;
        anInt3197 = 0;
        vertexCount = model.vertexCount;
        triangleCount = model.triangleCount;
        anInt3180 = model.anInt3180;
        if(adjustToTerrain) {
            verticesY = new int[vertexCount];
            System.arraycopy(model.verticesY, 0, verticesY, 0, vertexCount);
        } else {
            verticesY = model.verticesY;
        }
        if(nonFlatShading) {
            triangleHSLA = new int[triangleCount];
            triangleHSLB = new int[triangleCount];
            triangleHSLC = new int[triangleCount];
            for(int triangle = 0; triangle < triangleCount; triangle++) {
                triangleHSLA[triangle] = model.triangleHSLA[triangle];
                triangleHSLB[triangle] = model.triangleHSLB[triangle];
                triangleHSLC[triangle] = model.triangleHSLC[triangle];
            }
            triangleDrawType = new int[triangleCount];
            if(model.triangleDrawType == null) {
                for(int i = 0; i < triangleCount; i++)
                    triangleDrawType[i] = 0;
            } else {
                System.arraycopy(model.triangleDrawType, 0, triangleDrawType, 0, triangleCount);
            }
            verticesNormal = new VertexNormal[vertexCount];
            for(int vertex = 0; vertex < vertexCount; vertex++) {
                VertexNormal vertexNormalNew = verticesNormal[vertex] = new VertexNormal();
                VertexNormal vertexNormalOld = model.verticesNormal[vertex];
                vertexNormalNew.x = vertexNormalOld.x;
                vertexNormalNew.y = vertexNormalOld.y;
                vertexNormalNew.z = vertexNormalOld.z;
                vertexNormalNew.magnitude = vertexNormalOld.magnitude;
            }
            vertexNormalOffset = model.vertexNormalOffset;
        } else {
            triangleHSLA = model.triangleHSLA;
            triangleHSLB = model.triangleHSLB;
            triangleHSLC = model.triangleHSLC;
            triangleDrawType = model.triangleDrawType;
        }
        verticesX = model.verticesX;
        verticesZ = model.verticesZ;
        triangleColorValues = model.triangleColorValues;
        triangleAlphaValues = model.triangleAlphaValues;
        trianglePriorities = model.trianglePriorities;
        anInt3197 = model.anInt3197;
        trianglePointsX = model.trianglePointsX;
        trianglePointsY = model.trianglePointsY;
        trianglePointsZ = model.trianglePointsZ;
        texturedTrianglePointsX = model.texturedTrianglePointsX;
        texturedTrianglePointsY = model.texturedTrianglePointsY;
        texturedTrianglePointsZ = model.texturedTrianglePointsZ;
        aBoolean3164 = model.aBoolean3164;
        anInt3193 = model.anInt3193;
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
        if((arg2 & 0x2) == 2) {
            if(arg1 < 0)
                arg1 = 0;
            else if(arg1 > 127)
                arg1 = 127;
            arg1 = anIntArray3199[arg1];
            return arg1;
        }
        arg1 = arg1 * (arg0 & 0x7f) >> 7;
        if(arg1 < 2)
            arg1 = 2;
        else if(arg1 > 126)
            arg1 = 126;
        return (arg0 & 0xff80) + arg1;
    }

    public static Model getModel(Class6 arg0, int arg1, int arg2) {
        try {
            if(ModelLoader.models == null) {
                new ModelLoader();
            }
            for(int modelStored : ModelLoader.models) {
                if(modelStored == arg1) {
                    return new Model(ModelLoader.loadNewModel(modelStored));
                }
            }
            byte[] is = arg0.method172(arg2, 117, arg1);
            if(is == null)
                return null;
            return new Model(is);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;

        // 435 model loading:
        //        byte[] is = arg0.method172(arg2, 117, arg1);
        //        if(is == null)
        //            return null;
        //        return new com.jagex.runescape.media.renderable.Model(is);
    }

    public void method799() {
        if(anInt3169 != 1) {
            anInt3169 = 1;
            anInt2861 = 0;
            anInt3175 = 0;
            anInt3171 = 0;
            for(int i = 0; i < vertexCount; i++) {
                int i_0_ = verticesX[i];
                int i_1_ = verticesY[i];
                int i_2_ = verticesZ[i];
                if(-i_1_ > anInt2861)
                    anInt2861 = -i_1_;
                if(i_1_ > anInt3175)
                    anInt3175 = i_1_;
                int i_3_ = i_0_ * i_0_ + i_2_ * i_2_;
                if(i_3_ > anInt3171)
                    anInt3171 = i_3_;
            }
            anInt3171 = (int) (Math.sqrt((double) anInt3171) + 0.99);
            anInt3189 = (int) (Math.sqrt((double) (anInt3171 * anInt3171 + anInt2861 * anInt2861)) + 0.99);
            anInt3163 = (anInt3189 + (int) (Math.sqrt((double) (anInt3171 * anInt3171 + anInt3175 * anInt3175)) + 0.99));
        }
    }

    public void method755(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
        if(anInt3169 != 1)
            method799();
        int i = arg7 * arg4 - arg5 * arg3 >> 16;
        int i_4_ = arg6 * arg1 + i * arg2 >> 16;
        int i_5_ = anInt3171 * arg2 >> 16;
        int i_6_ = i_4_ + i_5_;
        if(i_6_ > 50 && i_4_ < 3500) {
            int i_7_ = arg7 * arg3 + arg5 * arg4 >> 16;
            int i_8_ = i_7_ - anInt3171 << 9;
            if(i_8_ / i_6_ < R3D.anInt2934) {
                int i_9_ = i_7_ + anInt3171 << 9;
                if(i_9_ / i_6_ > R3D.anInt2942) {
                    int i_10_ = arg6 * arg2 - i * arg1 >> 16;
                    int i_11_ = anInt3171 * arg1 >> 16;
                    int i_12_ = i_10_ + i_11_ << 9;
                    if(i_12_ / i_6_ > R3D.anInt2935) {
                        int i_13_ = i_11_ + (anInt2861 * arg2 >> 16);
                        int i_14_ = i_10_ - i_13_ << 9;
                        if(i_14_ / i_6_ < R3D.anInt2941) {
                            int i_15_ = i_5_ + (anInt2861 * arg1 >> 16);
                            boolean bool = false;
                            boolean bool_16_ = false;
                            if(i_4_ - i_15_ <= 50)
                                bool_16_ = true;
                            boolean bool_17_ = bool_16_ || anInt3180 > 0;
                            boolean bool_18_ = false;
                            if(arg8 > 0 && aBoolean3207) {
                                int i_19_ = i_4_ - i_5_;
                                if(i_19_ <= 50)
                                    i_19_ = 50;
                                if(i_7_ > 0) {
                                    i_8_ /= i_6_;
                                    i_9_ /= i_19_;
                                } else {
                                    i_9_ /= i_6_;
                                    i_8_ /= i_19_;
                                }
                                if(i_10_ > 0) {
                                    i_14_ /= i_6_;
                                    i_12_ /= i_19_;
                                } else {
                                    i_12_ /= i_6_;
                                    i_14_ /= i_19_;
                                }
                                int i_20_ = (anInt3229 - R3D.anInt2937);
                                int i_21_ = (anInt3198 - R3D.anInt2931);
                                if(i_20_ > i_8_ && i_20_ < i_9_ && i_21_ > i_14_ && i_21_ < i_12_) {
                                    if(aBoolean3164)
                                        anIntArray3211[anInt3220++] = arg8;
                                    else
                                        bool_18_ = true;
                                }
                            }
                            int i_22_ = R3D.anInt2937;
                            int i_23_ = R3D.anInt2931;
                            int i_24_ = 0;
                            int i_25_ = 0;
                            if(arg0 != 0) {
                                i_24_ = anIntArray3215[arg0];
                                i_25_ = anIntArray3217[arg0];
                            }
                            for(int i_26_ = 0; i_26_ < vertexCount; i_26_++) {
                                int i_27_ = verticesX[i_26_];
                                int i_28_ = verticesY[i_26_];
                                int i_29_ = verticesZ[i_26_];
                                if(arg0 != 0) {
                                    int i_30_ = i_29_ * i_24_ + i_27_ * i_25_ >> 16;
                                    i_29_ = i_29_ * i_25_ - i_27_ * i_24_ >> 16;
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
                                if(i_29_ >= 50) {
                                    anIntArray3209[i_26_] = i_22_ + (i_27_ << 9) / i_29_;
                                    anIntArray3204[i_26_] = i_23_ + (i_28_ << 9) / i_29_;
                                } else {
                                    anIntArray3209[i_26_] = -5000;
                                    bool = true;
                                }
                                if(bool_17_) {
                                    anIntArray3225[i_26_] = i_27_;
                                    anIntArray3203[i_26_] = i_28_;
                                    anIntArray3223[i_26_] = i_29_;
                                }
                            }
                            try {
                                method815(bool, bool_18_, arg8);
                            } catch(Exception exception) {
                                /* empty */
                            }
                        }
                    }
                }
            }
        }
    }

    public void method801(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
        if(anInt3169 != 2 && anInt3169 != 1)
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
        for(int i_42_ = 0; i_42_ < vertexCount; i_42_++) {
            int i_43_ = verticesX[i_42_];
            int i_44_ = verticesY[i_42_];
            int i_45_ = verticesZ[i_42_];
            if(arg2 != 0) {
                int i_46_ = i_44_ * i_37_ + i_43_ * i_38_ >> 16;
                i_44_ = i_44_ * i_38_ - i_43_ * i_37_ >> 16;
                i_43_ = i_46_;
            }
            if(arg0 != 0) {
                int i_47_ = i_44_ * i_34_ - i_45_ * i_33_ >> 16;
                i_45_ = i_44_ * i_33_ + i_45_ * i_34_ >> 16;
                i_44_ = i_47_;
            }
            if(arg1 != 0) {
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
            if(anInt3180 > 0) {
                anIntArray3225[i_42_] = i_43_;
                anIntArray3203[i_42_] = i_44_;
                anIntArray3223[i_42_] = i_45_;
            }
        }
        try {
            method815(false, false, 0);
        } catch(Exception exception) {
            /* empty */
        }
    }

    public void method802(int arg0, int arg1, int arg2, int arg3, int arg4, boolean arg5) {
        int i = (int) Math.sqrt((double) (arg2 * arg2 + arg3 * arg3 + arg4 * arg4));
        int i_50_ = arg1 * i >> 8;
        if(triangleHSLA == null) {
            triangleHSLA = new int[triangleCount];
            triangleHSLB = new int[triangleCount];
            triangleHSLC = new int[triangleCount];
        }
        if(verticesNormal == null) {
            verticesNormal = new VertexNormal[vertexCount];
            for(int i_51_ = 0; i_51_ < vertexCount; i_51_++)
                verticesNormal[i_51_] = new VertexNormal();
        }
        for(int i_52_ = 0; i_52_ < triangleCount; i_52_++) {
            int i_53_ = trianglePointsX[i_52_];
            int i_54_ = trianglePointsY[i_52_];
            int i_55_ = trianglePointsZ[i_52_];
            int i_56_ = verticesX[i_54_] - verticesX[i_53_];
            int i_57_ = verticesY[i_54_] - verticesY[i_53_];
            int i_58_ = verticesZ[i_54_] - verticesZ[i_53_];
            int i_59_ = verticesX[i_55_] - verticesX[i_53_];
            int i_60_ = verticesY[i_55_] - verticesY[i_53_];
            int i_61_ = verticesZ[i_55_] - verticesZ[i_53_];
            int i_62_ = i_57_ * i_61_ - i_60_ * i_58_;
            int i_63_ = i_58_ * i_59_ - i_61_ * i_56_;
            int i_64_;
            for(i_64_ = i_56_ * i_60_ - i_59_ * i_57_; (i_62_ > 8192 || i_63_ > 8192 || i_64_ > 8192 || i_62_ < -8192 || i_63_ < -8192 || i_64_ < -8192); i_64_ >>= 1) {
                i_62_ >>= 1;
                i_63_ >>= 1;
            }
            int i_65_ = (int) Math.sqrt((double) (i_62_ * i_62_ + i_63_ * i_63_ + i_64_ * i_64_));
            if(i_65_ <= 0)
                i_65_ = 1;
            i_62_ = i_62_ * 256 / i_65_;
            i_63_ = i_63_ * 256 / i_65_;
            i_64_ = i_64_ * 256 / i_65_;
            if(triangleDrawType == null || (triangleDrawType[i_52_] & 0x1) == 0) {
                VertexNormal class46 = verticesNormal[i_53_];
                class46.x += i_62_;
                class46.y += i_63_;
                class46.z += i_64_;
                class46.magnitude++;
                class46 = verticesNormal[i_54_];
                class46.x += i_62_;
                class46.y += i_63_;
                class46.z += i_64_;
                class46.magnitude++;
                class46 = verticesNormal[i_55_];
                class46.x += i_62_;
                class46.y += i_63_;
                class46.z += i_64_;
                class46.magnitude++;
            } else {
                int i_66_ = arg0 + (arg2 * i_62_ + arg3 * i_63_ + arg4 * i_64_) / (i_50_ + i_50_ / 2);
                triangleHSLA[i_52_] = method816(triangleColorValues[i_52_], i_66_, triangleDrawType[i_52_]);
            }
        }
        if(arg5)
            method808(arg0, i_50_, arg2, arg3, arg4);
        else {
            vertexNormalOffset = new VertexNormal[vertexCount];
            for(int i_67_ = 0; i_67_ < vertexCount; i_67_++) {
                VertexNormal class46 = verticesNormal[i_67_];
                VertexNormal class46_68_ = vertexNormalOffset[i_67_] = new VertexNormal();
                class46_68_.x = class46.x;
                class46_68_.y = class46.y;
                class46_68_.z = class46.z;
                class46_68_.magnitude = class46.magnitude;
            }
            anInt3193 = (arg0 << 16) + (i_50_ & 0xffff);
        }
    }

    public void method803(int arg0, int arg1) {
        for(int i = 0; i < triangleCount; i++) {
            if(triangleColorValues[i] == arg0)
                triangleColorValues[i] = arg1;
        }
    }

    public void method804(int arg0) {
        verticesNormal = null;
        anInt3169 = 0;
        int i = anIntArray3215[arg0];
        int i_69_ = anIntArray3217[arg0];
        for(int i_70_ = 0; i_70_ < vertexCount; i_70_++) {
            int i_71_ = (verticesY[i_70_] * i_69_ - verticesZ[i_70_] * i >> 16);
            verticesZ[i_70_] = (verticesY[i_70_] * i + verticesZ[i_70_] * i_69_ >> 16);
            verticesY[i_70_] = i_71_;
        }
    }

    public int method805() {
        method799();
        return anInt3171;
    }

    public Model method806(boolean arg0) {
        if(!arg0 && anIntArray3214.length < triangleCount)
            anIntArray3214 = new int[triangleCount + 100];
        return method820(arg0, aClass40_Sub5_Sub17_Sub5_3195, anIntArray3214);
    }

    public boolean method807(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
        if(arg1 < arg2 && arg1 < arg3 && arg1 < arg4)
            return false;
        if(arg1 > arg2 && arg1 > arg3 && arg1 > arg4)
            return false;
        if(arg0 < arg5 && arg0 < arg6 && arg0 < arg7)
            return false;
        return arg0 <= arg5 || arg0 <= arg6 || arg0 <= arg7;
    }

    public void method808(int arg0, int arg1, int arg2, int arg3, int arg4) {
        for(int i = 0; i < triangleCount; i++) {
            int i_72_ = trianglePointsX[i];
            int i_73_ = trianglePointsY[i];
            int i_74_ = trianglePointsZ[i];
            if(triangleDrawType == null) {
                int i_75_ = triangleColorValues[i];
                VertexNormal class46 = verticesNormal[i_72_];
                int i_76_ = arg0 + ((arg2 * class46.x + arg3 * class46.y + arg4 * class46.z) / (arg1 * class46.magnitude));
                triangleHSLA[i] = method816(i_75_, i_76_, 0);
                class46 = verticesNormal[i_73_];
                i_76_ = arg0 + ((arg2 * class46.x + arg3 * class46.y + arg4 * class46.z) / (arg1 * class46.magnitude));
                triangleHSLB[i] = method816(i_75_, i_76_, 0);
                class46 = verticesNormal[i_74_];
                i_76_ = arg0 + ((arg2 * class46.x + arg3 * class46.y + arg4 * class46.z) / (arg1 * class46.magnitude));
                triangleHSLC[i] = method816(i_75_, i_76_, 0);
            } else if((triangleDrawType[i] & 0x1) == 0) {
                int i_77_ = triangleColorValues[i];
                int i_78_ = triangleDrawType[i];
                VertexNormal class46 = verticesNormal[i_72_];
                int i_79_ = arg0 + ((arg2 * class46.x + arg3 * class46.y + arg4 * class46.z) / (arg1 * class46.magnitude));
                triangleHSLA[i] = method816(i_77_, i_79_, i_78_);
                class46 = verticesNormal[i_73_];
                i_79_ = arg0 + ((arg2 * class46.x + arg3 * class46.y + arg4 * class46.z) / (arg1 * class46.magnitude));
                triangleHSLB[i] = method816(i_77_, i_79_, i_78_);
                class46 = verticesNormal[i_74_];
                i_79_ = arg0 + ((arg2 * class46.x + arg3 * class46.y + arg4 * class46.z) / (arg1 * class46.magnitude));
                triangleHSLC[i] = method816(i_77_, i_79_, i_78_);
            }
        }
        verticesNormal = null;
        vertexNormalOffset = null;
        vertexSkins = null;
        triangleSkinValues = null;
        if(triangleDrawType != null) {
            for(int i = 0; i < triangleCount; i++) {
                if((triangleDrawType[i] & 0x2) == 2)
                    return;
            }
        }
        triangleColorValues = null;
    }

    public void method809(Class40_Sub5_Sub15 arg0, int arg1, Class40_Sub5_Sub15 arg2, int arg3, int[] arg4) {
        if(arg1 != -1) {
            if(arg4 == null || arg3 == -1)
                method825(arg0, arg1);
            else {
                verticesNormal = null;
                anInt3169 = 0;
                Class41 class41 = arg0.aClass41Array2794[arg1];
                Class41 class41_80_ = arg2.aClass41Array2794[arg3];
                Class40_Sub13 class40_sub13 = class41.aClass40_Sub13_983;
                anInt3218 = 0;
                anInt3213 = 0;
                anInt3206 = 0;
                int i = 0;
                int i_81_ = arg4[i++];
                for(int i_82_ = 0; i_82_ < class41.anInt981; i_82_++) {
                    int i_83_;
                    for(i_83_ = class41.anIntArray984[i_82_]; i_83_ > i_81_; i_81_ = arg4[i++]) {
                        /* empty */
                    }
                    if(i_83_ != i_81_ || class40_sub13.anIntArray2178[i_83_] == 0)
                        method811(class40_sub13.anIntArray2178[i_83_], class40_sub13.anIntArrayArray2168[i_83_], class41.anIntArray982[i_82_], class41.anIntArray987[i_82_], class41.anIntArray986[i_82_]);
                }
                anInt3218 = 0;
                anInt3213 = 0;
                anInt3206 = 0;
                i = 0;
                i_81_ = arg4[i++];
                for(int i_84_ = 0; i_84_ < class41_80_.anInt981; i_84_++) {
                    int i_85_;
                    for(i_85_ = class41_80_.anIntArray984[i_84_]; i_85_ > i_81_; i_81_ = arg4[i++]) {
                        /* empty */
                    }
                    if(i_85_ == i_81_ || class40_sub13.anIntArray2178[i_85_] == 0)
                        method811(class40_sub13.anIntArray2178[i_85_], class40_sub13.anIntArrayArray2168[i_85_], class41_80_.anIntArray982[i_84_], class41_80_.anIntArray987[i_84_], class41_80_.anIntArray986[i_84_]);
                }
            }
        }
    }

    public void method810() {
        if(vertexSkins != null) {
            int[] is = new int[256];
            int i = 0;
            for(int i_86_ = 0; i_86_ < vertexCount; i_86_++) {
                int i_87_ = vertexSkins[i_86_];
                is[i_87_]++;
                if(i_87_ > i)
                    i = i_87_;
            }
            anIntArrayArray3161 = new int[i + 1][];
            for(int i_88_ = 0; i_88_ <= i; i_88_++) {
                anIntArrayArray3161[i_88_] = new int[is[i_88_]];
                is[i_88_] = 0;
            }
            for(int i_89_ = 0; i_89_ < vertexCount; i_89_++) {
                int i_90_ = vertexSkins[i_89_];
                anIntArrayArray3161[i_90_][is[i_90_]++] = i_89_;
            }
            vertexSkins = null;
        }
        if(triangleSkinValues != null) {
            int[] is = new int[256];
            int i = 0;
            for(int i_91_ = 0; i_91_ < triangleCount; i_91_++) {
                int i_92_ = triangleSkinValues[i_91_];
                is[i_92_]++;
                if(i_92_ > i)
                    i = i_92_;
            }
            anIntArrayArray3176 = new int[i + 1][];
            for(int i_93_ = 0; i_93_ <= i; i_93_++) {
                anIntArrayArray3176[i_93_] = new int[is[i_93_]];
                is[i_93_] = 0;
            }
            for(int i_94_ = 0; i_94_ < triangleCount; i_94_++) {
                int i_95_ = triangleSkinValues[i_94_];
                anIntArrayArray3176[i_95_][is[i_95_]++] = i_94_;
            }
            triangleSkinValues = null;
        }
    }

    public void method811(int arg0, int[] arg1, int arg2, int arg3, int arg4) {
        int i = arg1.length;
        if(arg0 == 0) {
            int i_96_ = 0;
            anInt3218 = 0;
            anInt3213 = 0;
            anInt3206 = 0;
            for(int i_97_ = 0; i_97_ < i; i_97_++) {
                int i_98_ = arg1[i_97_];
                if(i_98_ < anIntArrayArray3161.length) {
                    int[] is = anIntArrayArray3161[i_98_];
                    for(int i_99_ = 0; i_99_ < is.length; i_99_++) {
                        int i_100_ = is[i_99_];
                        anInt3218 += verticesX[i_100_];
                        anInt3213 += verticesY[i_100_];
                        anInt3206 += verticesZ[i_100_];
                        i_96_++;
                    }
                }
            }
            if(i_96_ > 0) {
                anInt3218 = anInt3218 / i_96_ + arg2;
                anInt3213 = anInt3213 / i_96_ + arg3;
                anInt3206 = anInt3206 / i_96_ + arg4;
            } else {
                anInt3218 = arg2;
                anInt3213 = arg3;
                anInt3206 = arg4;
            }
        } else if(arg0 == 1) {
            for(int i_101_ = 0; i_101_ < i; i_101_++) {
                int i_102_ = arg1[i_101_];
                if(i_102_ < anIntArrayArray3161.length) {
                    int[] is = anIntArrayArray3161[i_102_];
                    for(int i_103_ = 0; i_103_ < is.length; i_103_++) {
                        int i_104_ = is[i_103_];
                        verticesX[i_104_] += arg2;
                        verticesY[i_104_] += arg3;
                        verticesZ[i_104_] += arg4;
                    }
                }
            }
        } else if(arg0 == 2) {
            for(int i_105_ = 0; i_105_ < i; i_105_++) {
                int i_106_ = arg1[i_105_];
                if(i_106_ < anIntArrayArray3161.length) {
                    int[] is = anIntArrayArray3161[i_106_];
                    for(int i_107_ = 0; i_107_ < is.length; i_107_++) {
                        int i_108_ = is[i_107_];
                        verticesX[i_108_] -= anInt3218;
                        verticesY[i_108_] -= anInt3213;
                        verticesZ[i_108_] -= anInt3206;
                        int i_109_ = (arg2 & 0xff) * 8;
                        int i_110_ = (arg3 & 0xff) * 8;
                        int i_111_ = (arg4 & 0xff) * 8;
                        if(i_111_ != 0) {
                            int i_112_ = anIntArray3215[i_111_];
                            int i_113_ = anIntArray3217[i_111_];
                            int i_114_ = ((verticesY[i_108_] * i_112_ + verticesX[i_108_] * i_113_) >> 16);
                            verticesY[i_108_] = (verticesY[i_108_] * i_113_ - verticesX[i_108_] * i_112_) >> 16;
                            verticesX[i_108_] = i_114_;
                        }
                        if(i_109_ != 0) {
                            int i_115_ = anIntArray3215[i_109_];
                            int i_116_ = anIntArray3217[i_109_];
                            int i_117_ = ((verticesY[i_108_] * i_116_ - verticesZ[i_108_] * i_115_) >> 16);
                            verticesZ[i_108_] = (verticesY[i_108_] * i_115_ + verticesZ[i_108_] * i_116_) >> 16;
                            verticesY[i_108_] = i_117_;
                        }
                        if(i_110_ != 0) {
                            int i_118_ = anIntArray3215[i_110_];
                            int i_119_ = anIntArray3217[i_110_];
                            int i_120_ = ((verticesZ[i_108_] * i_118_ + verticesX[i_108_] * i_119_) >> 16);
                            verticesZ[i_108_] = (verticesZ[i_108_] * i_119_ - verticesX[i_108_] * i_118_) >> 16;
                            verticesX[i_108_] = i_120_;
                        }
                        verticesX[i_108_] += anInt3218;
                        verticesY[i_108_] += anInt3213;
                        verticesZ[i_108_] += anInt3206;
                    }
                }
            }
        } else if(arg0 == 3) {
            for(int i_121_ = 0; i_121_ < i; i_121_++) {
                int i_122_ = arg1[i_121_];
                if(i_122_ < anIntArrayArray3161.length) {
                    int[] is = anIntArrayArray3161[i_122_];
                    for(int i_123_ = 0; i_123_ < is.length; i_123_++) {
                        int i_124_ = is[i_123_];
                        verticesX[i_124_] -= anInt3218;
                        verticesY[i_124_] -= anInt3213;
                        verticesZ[i_124_] -= anInt3206;
                        verticesX[i_124_] = verticesX[i_124_] * arg2 / 128;
                        verticesY[i_124_] = verticesY[i_124_] * arg3 / 128;
                        verticesZ[i_124_] = verticesZ[i_124_] * arg4 / 128;
                        verticesX[i_124_] += anInt3218;
                        verticesY[i_124_] += anInt3213;
                        verticesZ[i_124_] += anInt3206;
                    }
                }
            }
        } else if(arg0 == 5 && anIntArrayArray3176 != null && triangleAlphaValues != null) {
            for(int i_125_ = 0; i_125_ < i; i_125_++) {
                int i_126_ = arg1[i_125_];
                if(i_126_ < anIntArrayArray3176.length) {
                    int[] is = anIntArrayArray3176[i_126_];
                    for(int i_127_ = 0; i_127_ < is.length; i_127_++) {
                        int i_128_ = is[i_127_];
                        triangleAlphaValues[i_128_] += arg2 * 8;
                        if(triangleAlphaValues[i_128_] < 0)
                            triangleAlphaValues[i_128_] = 0;
                        if(triangleAlphaValues[i_128_] > 255)
                            triangleAlphaValues[i_128_] = 255;
                    }
                }
            }
        }
    }

    public void method812(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
        if(anInt3169 != 2 && anInt3169 != 1)
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
        for(int i_139_ = 0; i_139_ < vertexCount; i_139_++) {
            int i_140_ = verticesX[i_139_];
            int i_141_ = verticesY[i_139_];
            int i_142_ = verticesZ[i_139_];
            if(arg2 != 0) {
                int i_143_ = i_141_ * i_134_ + i_140_ * i_135_ >> 16;
                i_141_ = i_141_ * i_135_ - i_140_ * i_134_ >> 16;
                i_140_ = i_143_;
            }
            if(arg0 != 0) {
                int i_144_ = i_141_ * i_131_ - i_142_ * i_130_ >> 16;
                i_142_ = i_141_ * i_130_ + i_142_ * i_131_ >> 16;
                i_141_ = i_144_;
            }
            if(arg1 != 0) {
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
            if(anInt3180 > 0) {
                anIntArray3225[i_139_] = i_140_;
                anIntArray3203[i_139_] = i_141_;
                anIntArray3223[i_139_] = i_142_;
            }
        }
        try {
            method815(false, false, 0);
        } catch(Exception exception) {
            /* empty */
        }
    }

    public void method813() {
        verticesNormal = null;
        anInt3169 = 0;
        for(int i = 0; i < vertexCount; i++) {
            int i_147_ = verticesX[i];
            verticesX[i] = verticesZ[i];
            verticesZ[i] = -i_147_;
        }
    }

    public void method814(int arg0) {
        int i = R3D.anInt2937;
        int i_148_ = R3D.anInt2931;
        int i_149_ = 0;
        int i_150_ = trianglePointsX[arg0];
        int i_151_ = trianglePointsY[arg0];
        int i_152_ = trianglePointsZ[arg0];
        int i_153_ = anIntArray3223[i_150_];
        int i_154_ = anIntArray3223[i_151_];
        int i_155_ = anIntArray3223[i_152_];
        if(triangleAlphaValues == null)
            R3D.anInt2933 = 0;
        else
            R3D.anInt2933 = triangleAlphaValues[arg0];
        if(i_153_ >= 50) {
            anIntArray3227[i_149_] = anIntArray3209[i_150_];
            anIntArray3205[i_149_] = anIntArray3204[i_150_];
            anIntArray3222[i_149_++] = triangleHSLA[arg0];
        } else {
            int i_156_ = anIntArray3225[i_150_];
            int i_157_ = anIntArray3203[i_150_];
            int i_158_ = triangleHSLA[arg0];
            if(i_155_ >= 50) {
                int i_159_ = (50 - i_153_) * anIntArray3228[i_155_ - i_153_];
                anIntArray3227[i_149_] = i + (i_156_ + ((anIntArray3225[i_152_] - i_156_) * i_159_ >> 16) << 9) / 50;
                anIntArray3205[i_149_] = (i_148_ + (i_157_ + ((anIntArray3203[i_152_] - i_157_) * i_159_ >> 16) << 9) / 50);
                anIntArray3222[i_149_++] = i_158_ + ((triangleHSLC[arg0] - i_158_) * i_159_ >> 16);
            }
            if(i_154_ >= 50) {
                int i_160_ = (50 - i_153_) * anIntArray3228[i_154_ - i_153_];
                anIntArray3227[i_149_] = i + (i_156_ + ((anIntArray3225[i_151_] - i_156_) * i_160_ >> 16) << 9) / 50;
                anIntArray3205[i_149_] = (i_148_ + (i_157_ + ((anIntArray3203[i_151_] - i_157_) * i_160_ >> 16) << 9) / 50);
                anIntArray3222[i_149_++] = i_158_ + ((triangleHSLB[arg0] - i_158_) * i_160_ >> 16);
            }
        }
        if(i_154_ >= 50) {
            anIntArray3227[i_149_] = anIntArray3209[i_151_];
            anIntArray3205[i_149_] = anIntArray3204[i_151_];
            anIntArray3222[i_149_++] = triangleHSLB[arg0];
        } else {
            int i_161_ = anIntArray3225[i_151_];
            int i_162_ = anIntArray3203[i_151_];
            int i_163_ = triangleHSLB[arg0];
            if(i_153_ >= 50) {
                int i_164_ = (50 - i_154_) * anIntArray3228[i_153_ - i_154_];
                anIntArray3227[i_149_] = i + (i_161_ + ((anIntArray3225[i_150_] - i_161_) * i_164_ >> 16) << 9) / 50;
                anIntArray3205[i_149_] = (i_148_ + (i_162_ + ((anIntArray3203[i_150_] - i_162_) * i_164_ >> 16) << 9) / 50);
                anIntArray3222[i_149_++] = i_163_ + ((triangleHSLA[arg0] - i_163_) * i_164_ >> 16);
            }
            if(i_155_ >= 50) {
                int i_165_ = (50 - i_154_) * anIntArray3228[i_155_ - i_154_];
                anIntArray3227[i_149_] = i + (i_161_ + ((anIntArray3225[i_152_] - i_161_) * i_165_ >> 16) << 9) / 50;
                anIntArray3205[i_149_] = (i_148_ + (i_162_ + ((anIntArray3203[i_152_] - i_162_) * i_165_ >> 16) << 9) / 50);
                anIntArray3222[i_149_++] = i_163_ + ((triangleHSLC[arg0] - i_163_) * i_165_ >> 16);
            }
        }
        if(i_155_ >= 50) {
            anIntArray3227[i_149_] = anIntArray3209[i_152_];
            anIntArray3205[i_149_] = anIntArray3204[i_152_];
            anIntArray3222[i_149_++] = triangleHSLC[arg0];
        } else {
            int i_166_ = anIntArray3225[i_152_];
            int i_167_ = anIntArray3203[i_152_];
            int i_168_ = triangleHSLC[arg0];
            if(i_154_ >= 50) {
                int i_169_ = (50 - i_155_) * anIntArray3228[i_154_ - i_155_];
                anIntArray3227[i_149_] = i + (i_166_ + ((anIntArray3225[i_151_] - i_166_) * i_169_ >> 16) << 9) / 50;
                anIntArray3205[i_149_] = (i_148_ + (i_167_ + ((anIntArray3203[i_151_] - i_167_) * i_169_ >> 16) << 9) / 50);
                anIntArray3222[i_149_++] = i_168_ + ((triangleHSLB[arg0] - i_168_) * i_169_ >> 16);
            }
            if(i_153_ >= 50) {
                int i_170_ = (50 - i_155_) * anIntArray3228[i_153_ - i_155_];
                anIntArray3227[i_149_] = i + (i_166_ + ((anIntArray3225[i_150_] - i_166_) * i_170_ >> 16) << 9) / 50;
                anIntArray3205[i_149_] = (i_148_ + (i_167_ + ((anIntArray3203[i_150_] - i_167_) * i_170_ >> 16) << 9) / 50);
                anIntArray3222[i_149_++] = i_168_ + ((triangleHSLA[arg0] - i_168_) * i_170_ >> 16);
            }
        }
        int i_171_ = anIntArray3227[0];
        int i_172_ = anIntArray3227[1];
        int i_173_ = anIntArray3227[2];
        int i_174_ = anIntArray3205[0];
        int i_175_ = anIntArray3205[1];
        int i_176_ = anIntArray3205[2];
        R3D.aBoolean2947 = false;
        if(i_149_ == 3) {
            if(i_171_ < 0 || i_172_ < 0 || i_173_ < 0 || i_171_ > R3D.anInt2945 || i_172_ > R3D.anInt2945 || i_173_ > R3D.anInt2945)
                R3D.aBoolean2947 = true;
            int i_177_;
            if(triangleDrawType == null)
                i_177_ = 0;
            else
                i_177_ = triangleDrawType[arg0] & 0x3;
            if(i_177_ == 0)
                R3D.method706(i_174_, i_175_, i_176_, i_171_, i_172_, i_173_, anIntArray3222[0], anIntArray3222[1], anIntArray3222[2]);
            else if(i_177_ == 1)
                R3D.method712(i_174_, i_175_, i_176_, i_171_, i_172_, i_173_, (anIntArray3202[triangleHSLA[arg0]]));
            else if(i_177_ == 2) {
                int i_178_ = triangleDrawType[arg0] >> 2;
                int i_179_ = texturedTrianglePointsX[i_178_];
                int i_180_ = texturedTrianglePointsY[i_178_];
                int i_181_ = texturedTrianglePointsZ[i_178_];
                R3D.method699(i_174_, i_175_, i_176_, i_171_, i_172_, i_173_, anIntArray3222[0], anIntArray3222[1], anIntArray3222[2], anIntArray3225[i_179_], anIntArray3225[i_180_], anIntArray3225[i_181_], anIntArray3203[i_179_], anIntArray3203[i_180_], anIntArray3203[i_181_], anIntArray3223[i_179_], anIntArray3223[i_180_], anIntArray3223[i_181_], triangleColorValues[arg0]);
            } else if(i_177_ == 3) {
                int i_182_ = triangleDrawType[arg0] >> 2;
                int i_183_ = texturedTrianglePointsX[i_182_];
                int i_184_ = texturedTrianglePointsY[i_182_];
                int i_185_ = texturedTrianglePointsZ[i_182_];
                R3D.method699(i_174_, i_175_, i_176_, i_171_, i_172_, i_173_, triangleHSLA[arg0], triangleHSLA[arg0], triangleHSLA[arg0], anIntArray3225[i_183_], anIntArray3225[i_184_], anIntArray3225[i_185_], anIntArray3203[i_183_], anIntArray3203[i_184_], anIntArray3203[i_185_], anIntArray3223[i_183_], anIntArray3223[i_184_], anIntArray3223[i_185_], triangleColorValues[arg0]);
            }
        }
        if(i_149_ == 4) {
            if(i_171_ < 0 || i_172_ < 0 || i_173_ < 0 || i_171_ > R3D.anInt2945 || i_172_ > R3D.anInt2945 || i_173_ > R3D.anInt2945 || anIntArray3227[3] < 0 || anIntArray3227[3] > R3D.anInt2945)
                R3D.aBoolean2947 = true;
            int i_186_;
            if(triangleDrawType == null)
                i_186_ = 0;
            else
                i_186_ = triangleDrawType[arg0] & 0x3;
            if(i_186_ == 0) {
                R3D.method706(i_174_, i_175_, i_176_, i_171_, i_172_, i_173_, anIntArray3222[0], anIntArray3222[1], anIntArray3222[2]);
                R3D.method706(i_174_, i_176_, anIntArray3205[3], i_171_, i_173_, anIntArray3227[3], anIntArray3222[0], anIntArray3222[2], anIntArray3222[3]);
            } else if(i_186_ == 1) {
                int i_187_ = anIntArray3202[triangleHSLA[arg0]];
                R3D.method712(i_174_, i_175_, i_176_, i_171_, i_172_, i_173_, i_187_);
                R3D.method712(i_174_, i_176_, anIntArray3205[3], i_171_, i_173_, anIntArray3227[3], i_187_);
            } else if(i_186_ == 2) {
                int i_188_ = triangleDrawType[arg0] >> 2;
                int i_189_ = texturedTrianglePointsX[i_188_];
                int i_190_ = texturedTrianglePointsY[i_188_];
                int i_191_ = texturedTrianglePointsZ[i_188_];
                R3D.method699(i_174_, i_175_, i_176_, i_171_, i_172_, i_173_, anIntArray3222[0], anIntArray3222[1], anIntArray3222[2], anIntArray3225[i_189_], anIntArray3225[i_190_], anIntArray3225[i_191_], anIntArray3203[i_189_], anIntArray3203[i_190_], anIntArray3203[i_191_], anIntArray3223[i_189_], anIntArray3223[i_190_], anIntArray3223[i_191_], triangleColorValues[arg0]);
                R3D.method699(i_174_, i_176_, anIntArray3205[3], i_171_, i_173_, anIntArray3227[3], anIntArray3222[0], anIntArray3222[2], anIntArray3222[3], anIntArray3225[i_189_], anIntArray3225[i_190_], anIntArray3225[i_191_], anIntArray3203[i_189_], anIntArray3203[i_190_], anIntArray3203[i_191_], anIntArray3223[i_189_], anIntArray3223[i_190_], anIntArray3223[i_191_], triangleColorValues[arg0]);
            } else if(i_186_ == 3) {
                int i_192_ = triangleDrawType[arg0] >> 2;
                int i_193_ = texturedTrianglePointsX[i_192_];
                int i_194_ = texturedTrianglePointsY[i_192_];
                int i_195_ = texturedTrianglePointsZ[i_192_];
                R3D.method699(i_174_, i_175_, i_176_, i_171_, i_172_, i_173_, triangleHSLA[arg0], triangleHSLA[arg0], triangleHSLA[arg0], anIntArray3225[i_193_], anIntArray3225[i_194_], anIntArray3225[i_195_], anIntArray3203[i_193_], anIntArray3203[i_194_], anIntArray3203[i_195_], anIntArray3223[i_193_], anIntArray3223[i_194_], anIntArray3223[i_195_], triangleColorValues[arg0]);
                R3D.method699(i_174_, i_176_, anIntArray3205[3], i_171_, i_173_, anIntArray3227[3], triangleHSLA[arg0], triangleHSLA[arg0], triangleHSLA[arg0], anIntArray3225[i_193_], anIntArray3225[i_194_], anIntArray3225[i_195_], anIntArray3203[i_193_], anIntArray3203[i_194_], anIntArray3203[i_195_], anIntArray3223[i_193_], anIntArray3223[i_194_], anIntArray3223[i_195_], triangleColorValues[arg0]);
            }
        }
    }

    public void method815(boolean arg0, boolean arg1, int arg2) {
        if(anInt3163 < 1600) {
            for(int i = 0; i < anInt3163; i++)
                anIntArray3200[i] = 0;
            for(int i = 0; i < triangleCount; i++) {
                if(triangleDrawType == null || triangleDrawType[i] != -1) {
                    int i_196_ = trianglePointsX[i];
                    int i_197_ = trianglePointsY[i];
                    int i_198_ = trianglePointsZ[i];
                    int i_199_ = anIntArray3209[i_196_];
                    int i_200_ = anIntArray3209[i_197_];
                    int i_201_ = anIntArray3209[i_198_];
                    if(arg0 && (i_199_ == -5000 || i_200_ == -5000 || i_201_ == -5000)) {
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
                        if(i_203_ * i_211_ + i_206_ * i_212_ + i_209_ * i_213_ > 0) {
                            aBooleanArray3224[i] = true;
                            int i_214_ = ((anIntArray3212[i_196_] + anIntArray3212[i_197_] + anIntArray3212[i_198_]) / 3 + anInt3189);
                            anIntArrayArray3210[i_214_][anIntArray3200[i_214_]++] = i;
                        }
                    } else {
                        if(arg1 && method807(anInt3229, anInt3198, anIntArray3204[i_196_], anIntArray3204[i_197_], anIntArray3204[i_198_], i_199_, i_200_, i_201_)) {
                            anIntArray3211[anInt3220++] = arg2;
                            arg1 = false;
                        }
                        if(((i_199_ - i_200_) * (anIntArray3204[i_198_] - anIntArray3204[i_197_]) - (anIntArray3204[i_196_] - anIntArray3204[i_197_]) * (i_201_ - i_200_)) > 0) {
                            aBooleanArray3224[i] = false;
                            aBooleanArray3201[i] = i_199_ < 0 || i_200_ < 0 || i_201_ < 0 || i_199_ > R3D.anInt2945 || i_200_ > R3D.anInt2945 || i_201_ > R3D.anInt2945;
                            int i_215_ = ((anIntArray3212[i_196_] + anIntArray3212[i_197_] + anIntArray3212[i_198_]) / 3 + anInt3189);
                            anIntArrayArray3210[i_215_][anIntArray3200[i_215_]++] = i;
                        }
                    }
                }
            }
            if(trianglePriorities == null) {
                for(int i = anInt3163 - 1; i >= 0; i--) {
                    int i_216_ = anIntArray3200[i];
                    if(i_216_ > 0) {
                        int[] is = anIntArrayArray3210[i];
                        for(int i_217_ = 0; i_217_ < i_216_; i_217_++)
                            method823(is[i_217_]);
                    }
                }
            } else {
                for(int i = 0; i < 12; i++) {
                    anIntArray3226[i] = 0;
                    anIntArray3221[i] = 0;
                }
                for(int i = anInt3163 - 1; i >= 0; i--) {
                    int i_218_ = anIntArray3200[i];
                    if(i_218_ > 0) {
                        int[] is = anIntArrayArray3210[i];
                        for(int i_219_ = 0; i_219_ < i_218_; i_219_++) {
                            int i_220_ = is[i_219_];
                            int i_221_ = trianglePriorities[i_220_];
                            int i_222_ = anIntArray3226[i_221_]++;
                            anIntArrayArray3208[i_221_][i_222_] = i_220_;
                            if(i_221_ < 10)
                                anIntArray3221[i_221_] += i;
                            else if(i_221_ == 10)
                                anIntArray3219[i_222_] = i;
                            else
                                anIntArray3216[i_222_] = i;
                        }
                    }
                }
                int i = 0;
                if(anIntArray3226[1] > 0 || anIntArray3226[2] > 0)
                    i = ((anIntArray3221[1] + anIntArray3221[2]) / (anIntArray3226[1] + anIntArray3226[2]));
                int i_223_ = 0;
                if(anIntArray3226[3] > 0 || anIntArray3226[4] > 0)
                    i_223_ = ((anIntArray3221[3] + anIntArray3221[4]) / (anIntArray3226[3] + anIntArray3226[4]));
                int i_224_ = 0;
                if(anIntArray3226[6] > 0 || anIntArray3226[8] > 0)
                    i_224_ = ((anIntArray3221[6] + anIntArray3221[8]) / (anIntArray3226[6] + anIntArray3226[8]));
                int i_225_ = 0;
                int i_226_ = anIntArray3226[10];
                int[] is = anIntArrayArray3208[10];
                int[] is_227_ = anIntArray3219;
                if(i_225_ == i_226_) {
                    i_225_ = 0;
                    i_226_ = anIntArray3226[11];
                    is = anIntArrayArray3208[11];
                    is_227_ = anIntArray3216;
                }
                int i_228_;
                if(i_225_ < i_226_)
                    i_228_ = is_227_[i_225_];
                else
                    i_228_ = -1000;
                for(int i_229_ = 0; i_229_ < 10; i_229_++) {
                    while(i_229_ == 0) {
                        if(i_228_ <= i)
                            break;
                        method823(is[i_225_++]);
                        if(i_225_ == i_226_ && is != anIntArrayArray3208[11]) {
                            i_225_ = 0;
                            i_226_ = anIntArray3226[11];
                            is = anIntArrayArray3208[11];
                            is_227_ = anIntArray3216;
                        }
                        if(i_225_ < i_226_)
                            i_228_ = is_227_[i_225_];
                        else
                            i_228_ = -1000;
                    }
                    while(i_229_ == 3) {
                        if(i_228_ <= i_223_)
                            break;
                        method823(is[i_225_++]);
                        if(i_225_ == i_226_ && is != anIntArrayArray3208[11]) {
                            i_225_ = 0;
                            i_226_ = anIntArray3226[11];
                            is = anIntArrayArray3208[11];
                            is_227_ = anIntArray3216;
                        }
                        if(i_225_ < i_226_)
                            i_228_ = is_227_[i_225_];
                        else
                            i_228_ = -1000;
                    }
                    while(i_229_ == 5 && i_228_ > i_224_) {
                        method823(is[i_225_++]);
                        if(i_225_ == i_226_ && is != anIntArrayArray3208[11]) {
                            i_225_ = 0;
                            i_226_ = anIntArray3226[11];
                            is = anIntArrayArray3208[11];
                            is_227_ = anIntArray3216;
                        }
                        if(i_225_ < i_226_)
                            i_228_ = is_227_[i_225_];
                        else
                            i_228_ = -1000;
                    }
                    int i_230_ = anIntArray3226[i_229_];
                    int[] is_231_ = anIntArrayArray3208[i_229_];
                    for(int i_232_ = 0; i_232_ < i_230_; i_232_++)
                        method823(is_231_[i_232_]);
                }
                while(i_228_ != -1000) {
                    method823(is[i_225_++]);
                    if(i_225_ == i_226_ && is != anIntArrayArray3208[11]) {
                        i_225_ = 0;
                        is = anIntArrayArray3208[11];
                        i_226_ = anIntArray3226[11];
                        is_227_ = anIntArray3216;
                    }
                    if(i_225_ < i_226_)
                        i_228_ = is_227_[i_225_];
                    else
                        i_228_ = -1000;
                }
            }
        }
    }

    public Model method817(boolean arg0) {
        if(!arg0 && anIntArray3192.length < triangleCount)
            anIntArray3192 = new int[triangleCount + 100];
        return method820(arg0, aClass40_Sub5_Sub17_Sub5_3170, anIntArray3192);
    }

    public void method818() {
        verticesNormal = null;
        anInt3169 = 0;
        for(int i = 0; i < vertexCount; i++)
            verticesZ[i] = -verticesZ[i];
        for(int i = 0; i < triangleCount; i++) {
            int i_233_ = trianglePointsX[i];
            trianglePointsX[i] = trianglePointsZ[i];
            trianglePointsZ[i] = i_233_;
        }
    }

    public void method819() {
        verticesNormal = null;
        anInt3169 = 0;
        for(int i = 0; i < vertexCount; i++) {
            verticesX[i] = -verticesX[i];
            verticesZ[i] = -verticesZ[i];
        }
    }

    public Model method820(boolean arg0, Model arg1, int[] arg2) {
        arg1.vertexCount = vertexCount;
        arg1.triangleCount = triangleCount;
        arg1.anInt3180 = anInt3180;
        if(arg1.verticesX == null || arg1.verticesX.length < vertexCount) {
            arg1.verticesX = new int[vertexCount + 100];
            arg1.verticesY = new int[vertexCount + 100];
            arg1.verticesZ = new int[vertexCount + 100];
        }
        for(int i = 0; i < vertexCount; i++) {
            arg1.verticesX[i] = verticesX[i];
            arg1.verticesY[i] = verticesY[i];
            arg1.verticesZ[i] = verticesZ[i];
        }
        if(arg0)
            arg1.triangleAlphaValues = triangleAlphaValues;
        else {
            arg1.triangleAlphaValues = arg2;
            if(triangleAlphaValues == null) {
                for(int i = 0; i < triangleCount; i++)
                    arg1.triangleAlphaValues[i] = 0;
            } else {
                for(int i = 0; i < triangleCount; i++)
                    arg1.triangleAlphaValues[i] = triangleAlphaValues[i];
            }
        }
        arg1.triangleDrawType = triangleDrawType;
        arg1.triangleColorValues = triangleColorValues;
        arg1.trianglePriorities = trianglePriorities;
        arg1.anInt3197 = anInt3197;
        arg1.anIntArrayArray3176 = anIntArrayArray3176;
        arg1.anIntArrayArray3161 = anIntArrayArray3161;
        arg1.trianglePointsX = trianglePointsX;
        arg1.trianglePointsY = trianglePointsY;
        arg1.trianglePointsZ = trianglePointsZ;
        arg1.triangleHSLA = triangleHSLA;
        arg1.triangleHSLB = triangleHSLB;
        arg1.triangleHSLC = triangleHSLC;
        arg1.texturedTrianglePointsX = texturedTrianglePointsX;
        arg1.texturedTrianglePointsY = texturedTrianglePointsY;
        arg1.texturedTrianglePointsZ = texturedTrianglePointsZ;
        arg1.aBoolean3164 = aBoolean3164;
        arg1.anInt3169 = 0;
        return arg1;
    }

    public void method821(int arg0, int arg1, int arg2) {
        verticesNormal = null;
        anInt3169 = 0;
        for(int i = 0; i < vertexCount; i++) {
            verticesX[i] = verticesX[i] * arg0 / 128;
            verticesY[i] = verticesY[i] * arg1 / 128;
            verticesZ[i] = verticesZ[i] * arg2 / 128;
        }
    }

    public void method822() {
        if(anInt3169 != 3) {
            anInt3169 = 3;
            anInt2861 = 0;
            anInt3175 = 0;
            anInt3171 = 999999;
            anInt3163 = -999999;
            anInt3189 = -99999;
            anInt3177 = 99999;
            for(int i = 0; i < vertexCount; i++) {
                int i_234_ = verticesX[i];
                int i_235_ = verticesY[i];
                int i_236_ = verticesZ[i];
                if(i_234_ < anInt3171)
                    anInt3171 = i_234_;
                if(i_234_ > anInt3163)
                    anInt3163 = i_234_;
                if(i_236_ < anInt3177)
                    anInt3177 = i_236_;
                if(i_236_ > anInt3189)
                    anInt3189 = i_236_;
                if(-i_235_ > anInt2861)
                    anInt2861 = -i_235_;
                if(i_235_ > anInt3175)
                    anInt3175 = i_235_;
            }
        }
    }

    public void method823(int arg0) {
        if(aBooleanArray3224[arg0])
            method814(arg0);
        else {
            int i = trianglePointsX[arg0];
            int i_237_ = trianglePointsY[arg0];
            int i_238_ = trianglePointsZ[arg0];
            R3D.aBoolean2947 = aBooleanArray3201[arg0];
            if(triangleAlphaValues == null)
                R3D.anInt2933 = 0;
            else
                R3D.anInt2933 = triangleAlphaValues[arg0];
            int i_239_;
            if(triangleDrawType == null)
                i_239_ = 0;
            else
                i_239_ = triangleDrawType[arg0] & 0x3;
            if(i_239_ == 0)
                R3D.method706(anIntArray3204[i], anIntArray3204[i_237_], anIntArray3204[i_238_], anIntArray3209[i], anIntArray3209[i_237_], anIntArray3209[i_238_], triangleHSLA[arg0], triangleHSLB[arg0], triangleHSLC[arg0]);
            else if(i_239_ == 1)
                R3D.method712(anIntArray3204[i], anIntArray3204[i_237_], anIntArray3204[i_238_], anIntArray3209[i], anIntArray3209[i_237_], anIntArray3209[i_238_], (anIntArray3202[triangleHSLA[arg0]]));
            else if(i_239_ == 2) {
                int i_240_ = triangleDrawType[arg0] >> 2;
                int i_241_ = texturedTrianglePointsX[i_240_];
                int i_242_ = texturedTrianglePointsY[i_240_];
                int i_243_ = texturedTrianglePointsZ[i_240_];
                R3D.method699(anIntArray3204[i], anIntArray3204[i_237_], anIntArray3204[i_238_], anIntArray3209[i], anIntArray3209[i_237_], anIntArray3209[i_238_], triangleHSLA[arg0], triangleHSLB[arg0], triangleHSLC[arg0], anIntArray3225[i_241_], anIntArray3225[i_242_], anIntArray3225[i_243_], anIntArray3203[i_241_], anIntArray3203[i_242_], anIntArray3203[i_243_], anIntArray3223[i_241_], anIntArray3223[i_242_], anIntArray3223[i_243_], triangleColorValues[arg0]);
            } else if(i_239_ == 3) {
                int i_244_ = triangleDrawType[arg0] >> 2;
                int i_245_ = texturedTrianglePointsX[i_244_];
                int i_246_ = texturedTrianglePointsY[i_244_];
                int i_247_ = texturedTrianglePointsZ[i_244_];
                R3D.method699(anIntArray3204[i], anIntArray3204[i_237_], anIntArray3204[i_238_], anIntArray3209[i], anIntArray3209[i_237_], anIntArray3209[i_238_], triangleHSLA[arg0], triangleHSLA[arg0], triangleHSLA[arg0], anIntArray3225[i_245_], anIntArray3225[i_246_], anIntArray3225[i_247_], anIntArray3203[i_245_], anIntArray3203[i_246_], anIntArray3203[i_247_], anIntArray3223[i_245_], anIntArray3223[i_246_], anIntArray3223[i_247_], triangleColorValues[arg0]);
            }
        }
    }

    public void method824() {
        verticesNormal = null;
        anInt3169 = 0;
        for(int i = 0; i < vertexCount; i++) {
            int i_248_ = verticesZ[i];
            verticesZ[i] = verticesX[i];
            verticesX[i] = -i_248_;
        }
    }

    public void method825(Class40_Sub5_Sub15 arg0, int arg1) {
        if(anIntArrayArray3161 != null && arg1 != -1) {
            verticesNormal = null;
            anInt3169 = 0;
            Class41 class41 = arg0.aClass41Array2794[arg1];
            Class40_Sub13 class40_sub13 = class41.aClass40_Sub13_983;
            anInt3218 = 0;
            anInt3213 = 0;
            anInt3206 = 0;
            for(int i = 0; i < class41.anInt981; i++) {
                int i_249_ = class41.anIntArray984[i];
                method811(class40_sub13.anIntArray2178[i_249_], class40_sub13.anIntArrayArray2168[i_249_], class41.anIntArray982[i], class41.anIntArray987[i], class41.anIntArray986[i]);
            }
        }
    }

    public void method826(int arg0, int arg1, int arg2) {
        int i = anInt3193 >> 16;
        int i_250_ = anInt3193 << 16 >> 16;
        method808(i, i_250_, arg0, arg1, arg2);
    }

    public void method827() {
        if(anInt3169 != 2) {
            anInt3169 = 2;
            anInt3171 = 0;
            for(int i = 0; i < vertexCount; i++) {
                int i_251_ = verticesX[i];
                int i_252_ = verticesY[i];
                int i_253_ = verticesZ[i];
                int i_254_ = i_251_ * i_251_ + i_253_ * i_253_ + i_252_ * i_252_;
                if(i_254_ > anInt3171)
                    anInt3171 = i_254_;
            }
            anInt3171 = (int) (Math.sqrt((double) anInt3171) + 0.99);
            anInt3189 = anInt3171;
            anInt3163 = anInt3171 + anInt3171;
        }
    }

    public void method828(int arg0, int arg1, int arg2) {
        anInt3169 = 0;
        for(int i = 0; i < vertexCount; i++) {
            verticesX[i] += arg0;
            verticesY[i] += arg1;
            verticesZ[i] += arg2;
        }
    }

    public int method829(Model arg0, int arg1) {
        int i = -1;
        int i_301_ = arg0.verticesX[arg1];
        int i_302_ = arg0.verticesY[arg1];
        int i_303_ = arg0.verticesZ[arg1];
        for(int i_304_ = 0; i_304_ < vertexCount; i_304_++) {
            if(i_301_ == verticesX[i_304_] && i_302_ == verticesY[i_304_] && i_303_ == verticesZ[i_304_]) {
                i = i_304_;
                break;
            }
        }
        if(i == -1) {
            verticesX[vertexCount] = i_301_;
            verticesY[vertexCount] = i_302_;
            verticesZ[vertexCount] = i_303_;
            if(arg0.vertexSkins != null)
                vertexSkins[vertexCount] = arg0.vertexSkins[arg1];
            i = vertexCount++;
        }
        return i;
    }
}
