package com.jagex.runescape.media;

import com.jagex.runescape.Interface3;

public class Rasterizer3D extends Rasterizer {
    public static int[] anIntArray2929 = new int[2048];
    public static int bottomY;
    public static int center_y;
    public static int[] hsl2rgb = new int[65536];
    public static int alpha = 0;
    public static int anInt2934;
    public static int anInt2935;
    public static boolean opaque = false;
    public static int center_x;
    public static int[] lineOffsets;
    public static Interface3 anInterface3_2939;
    public static int[] shadowDecay = new int[512];
    public static int anInt2941;
    public static int anInt2942;
    public static int[] sinetable = new int[2048];
    public static boolean notTextured = true;
    public static int viewportRx;
    public static int[] cosinetable = new int[2048];
    public static boolean restrict_edges = false;
    public static boolean lowMemory = false;
    private static boolean useLatestShadeLine = true;

    static {
        for(int i = 1; i < 512; i++) {
            shadowDecay[i] = 32768 / i;
        }
        for(int i = 1; i < 2048; i++) {
            anIntArray2929[i] = 65536 / i;
        }
        for(int i = 0; i < 2048; i++) {
            sinetable[i] = (int) (65536.0 * Math.sin((double) i * 0.0030679615));
            cosinetable[i] = (int) (65536.0 * Math.cos((double) i * 0.0030679615));
        }
    }

    public static void drawScanLine(int[] arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        if(restrict_edges) {
            if(arg5 > viewportRx) {
                arg5 = viewportRx;
            }
            if(arg4 < 0) {
                arg4 = 0;
            }
        }
        if(arg4 < arg5) {
            arg1 += arg4;
            arg3 = arg5 - arg4 >> 2;
            if(alpha == 0) {
                while(--arg3 >= 0) {
                    arg0[arg1++] = arg2;
                    arg0[arg1++] = arg2;
                    arg0[arg1++] = arg2;
                    arg0[arg1++] = arg2;
                }
                arg3 = arg5 - arg4 & 0x3;
                while(--arg3 >= 0) {
                    arg0[arg1++] = arg2;
                }
            } else {
                int i = alpha;
                int i_0_ = 256 - alpha;
                arg2 = (((arg2 & 0xff00ff) * i_0_ >> 8 & 0xff00ff) + ((arg2 & 0xff00) * i_0_ >> 8 & 0xff00));
                while(--arg3 >= 0) {
                    arg0[arg1++] = (arg2 + ((arg0[arg1] & 0xff00ff) * i >> 8 & 0xff00ff) + ((arg0[arg1] & 0xff00) * i >> 8 & 0xff00));
                    arg0[arg1++] = (arg2 + ((arg0[arg1] & 0xff00ff) * i >> 8 & 0xff00ff) + ((arg0[arg1] & 0xff00) * i >> 8 & 0xff00));
                    arg0[arg1++] = (arg2 + ((arg0[arg1] & 0xff00ff) * i >> 8 & 0xff00ff) + ((arg0[arg1] & 0xff00) * i >> 8 & 0xff00));
                    arg0[arg1++] = (arg2 + ((arg0[arg1] & 0xff00ff) * i >> 8 & 0xff00ff) + ((arg0[arg1] & 0xff00) * i >> 8 & 0xff00));
                }
                arg3 = arg5 - arg4 & 0x3;
                while(--arg3 >= 0) {
                    arg0[arg1++] = (arg2 + ((arg0[arg1] & 0xff00ff) * i >> 8 & 0xff00ff) + ((arg0[arg1] & 0xff00) * i >> 8 & 0xff00));
                }
            }
        }
    }

    public static void drawTexturedTriangle(int y_a, int y_b, int y_c, int x_a, int x_b, int x_c, int grad_a, int grad_b, int grad_c, int Px, int Mx, int Nx, int Pz, int Mz, int Nz, int Py, int My, int Ny, int t_id) {
        int[] texture = anInterface3_2939.getTexturePixels(56, t_id);
        if(texture == null) {
            int i = anInterface3_2939.method14(true, t_id);
            drawShadedTriangle(y_a, y_b, y_c, x_a, x_b, x_c, method709(i, grad_a), method709(i, grad_b), method709(i, grad_c));
        } else {
            lowMemory = anInterface3_2939.method15(t_id, (byte) -90);
            opaque = anInterface3_2939.method13((byte) -109, t_id);
            Mx = Px - Mx;
            Mz = Pz - Mz;
            My = Py - My;
            Nx -= Px;
            Nz -= Pz;
            Ny -= Py;
            int Oa = Nx * Pz - Nz * Px << 14;
            int i_1_ = Nz * Py - Ny * Pz << 8;
            int Va = Ny * Px - Nx * Py << 5;
            int Ob = Mx * Pz - Mz * Px << 14;
            int i_4_ = Mz * Py - My * Pz << 8;
            int Vb = My * Px - Mx * Py << 5;
            int Oc = Mz * Nx - Mx * Nz << 14;
            int i_7_ = My * Nz - Mz * Ny << 8;
            int Vc = Mx * Ny - My * Nx << 5;
            int x_a_off = 0;
            int grad_a_off = 0;
            if(y_b != y_a) {
                x_a_off = (x_b - x_a << 16) / (y_b - y_a);
                grad_a_off = (grad_b - grad_a << 16) / (y_b - y_a);
            }
            int x_b_off = 0;
            int grad_b_off = 0;
            if(y_c != y_b) {
                x_b_off = (x_c - x_b << 16) / (y_c - y_b);
                grad_b_off = (grad_c - grad_b << 16) / (y_c - y_b);
            }
            int x_c_off = 0;
            int grad_c_off = 0;
            if(y_c != y_a) {
                x_c_off = (x_a - x_c << 16) / (y_a - y_c);
                grad_c_off = (grad_a - grad_c << 16) / (y_a - y_c);
            }
            if(y_a <= y_b && y_a <= y_c) {
                if(y_a >= bottomY) {
                    return;
                }
                if(y_b > bottomY) {
                    y_b = bottomY;
                }
                if(y_c > bottomY) {
                    y_c = bottomY;
                }
                if(y_b < y_c) {
                    x_c = x_a <<= 16;
                    grad_c = grad_a <<= 16;
                    if(y_a < 0) {
                        x_c -= x_c_off * y_a;
                        x_a -= x_a_off * y_a;
                        grad_c -= grad_c_off * y_a;
                        grad_a -= grad_a_off * y_a;
                        y_a = 0;
                    }
                    x_b <<= 16;
                    grad_b <<= 16;
                    if(y_b < 0) {
                        x_b -= x_b_off * y_b;
                        grad_b -= grad_b_off * y_b;
                        y_b = 0;
                    }
                    int jA = y_a - center_y;
                    Oa += Va * jA;
                    Ob += Vb * jA;
                    Oc += Vc * jA;
                    if(y_a != y_b && x_c_off < x_a_off || y_a == y_b && x_c_off > x_b_off) {
                        y_c -= y_b;
                        y_b -= y_a;
                        y_a = lineOffsets[y_a];
                        while(--y_b >= 0) {
                            drawTexturedLine(Rasterizer.destinationPixels, texture, y_a, x_c >> 16, x_a >> 16, grad_c >> 8, grad_a >> 8, 0, 0, Oa, Ob, Oc, i_1_, i_4_, i_7_);
                            x_c += x_c_off;
                            x_a += x_a_off;
                            grad_c += grad_c_off;
                            grad_a += grad_a_off;
                            y_a += Rasterizer.destinationWidth;
                            Oa += Va;
                            Ob += Vb;
                            Oc += Vc;
                        }
                        while(--y_c >= 0) {
                            drawTexturedLine(Rasterizer.destinationPixels, texture, y_a, x_c >> 16, x_b >> 16, grad_c >> 8, grad_b >> 8, 0, 0, Oa, Ob, Oc, i_1_, i_4_, i_7_);
                            x_c += x_c_off;
                            x_b += x_b_off;
                            grad_c += grad_c_off;
                            grad_b += grad_b_off;
                            y_a += Rasterizer.destinationWidth;
                            Oa += Va;
                            Ob += Vb;
                            Oc += Vc;
                        }
                    } else {
                        y_c -= y_b;
                        y_b -= y_a;
                        y_a = lineOffsets[y_a];
                        while(--y_b >= 0) {
                            drawTexturedLine(Rasterizer.destinationPixels, texture, y_a, x_a >> 16, x_c >> 16, grad_a >> 8, grad_c >> 8, 0, 0, Oa, Ob, Oc, i_1_, i_4_, i_7_);
                            x_c += x_c_off;
                            x_a += x_a_off;
                            grad_c += grad_c_off;
                            grad_a += grad_a_off;
                            y_a += Rasterizer.destinationWidth;
                            Oa += Va;
                            Ob += Vb;
                            Oc += Vc;
                        }
                        while(--y_c >= 0) {
                            drawTexturedLine(Rasterizer.destinationPixels, texture, y_a, x_b >> 16, x_c >> 16, grad_b >> 8, grad_c >> 8, 0, 0, Oa, Ob, Oc, i_1_, i_4_, i_7_);
                            x_c += x_c_off;
                            x_b += x_b_off;
                            grad_c += grad_c_off;
                            grad_b += grad_b_off;
                            y_a += Rasterizer.destinationWidth;
                            Oa += Va;
                            Ob += Vb;
                            Oc += Vc;
                        }
                    }
                } else {
                    x_b = x_a <<= 16;
                    grad_b = grad_a <<= 16;
                    if(y_a < 0) {
                        x_b -= x_c_off * y_a;
                        x_a -= x_a_off * y_a;
                        grad_b -= grad_c_off * y_a;
                        grad_a -= grad_a_off * y_a;
                        y_a = 0;
                    }
                    x_c <<= 16;
                    grad_c <<= 16;
                    if(y_c < 0) {
                        x_c -= x_b_off * y_c;
                        grad_c -= grad_b_off * y_c;
                        y_c = 0;
                    }
                    int i_16_ = y_a - center_y;
                    Oa += Va * i_16_;
                    Ob += Vb * i_16_;
                    Oc += Vc * i_16_;
                    if(y_a != y_c && x_c_off < x_a_off || y_a == y_c && x_b_off > x_a_off) {
                        y_b -= y_c;
                        y_c -= y_a;
                        y_a = lineOffsets[y_a];
                        while(--y_c >= 0) {
                            drawTexturedLine(Rasterizer.destinationPixels, texture, y_a, x_b >> 16, x_a >> 16, grad_b >> 8, grad_a >> 8, 0, 0, Oa, Ob, Oc, i_1_, i_4_, i_7_);
                            x_b += x_c_off;
                            x_a += x_a_off;
                            grad_b += grad_c_off;
                            grad_a += grad_a_off;
                            y_a += Rasterizer.destinationWidth;
                            Oa += Va;
                            Ob += Vb;
                            Oc += Vc;
                        }
                        while(--y_b >= 0) {
                            drawTexturedLine(Rasterizer.destinationPixels, texture, y_a, x_c >> 16, x_a >> 16, grad_c >> 8, grad_a >> 8, 0, 0, Oa, Ob, Oc, i_1_, i_4_, i_7_);
                            x_c += x_b_off;
                            x_a += x_a_off;
                            grad_c += grad_b_off;
                            grad_a += grad_a_off;
                            y_a += Rasterizer.destinationWidth;
                            Oa += Va;
                            Ob += Vb;
                            Oc += Vc;
                        }
                    } else {
                        y_b -= y_c;
                        y_c -= y_a;
                        y_a = lineOffsets[y_a];
                        while(--y_c >= 0) {
                            drawTexturedLine(Rasterizer.destinationPixels, texture, y_a, x_a >> 16, x_b >> 16, grad_a >> 8, grad_b >> 8, 0, 0, Oa, Ob, Oc, i_1_, i_4_, i_7_);
                            x_b += x_c_off;
                            x_a += x_a_off;
                            grad_b += grad_c_off;
                            grad_a += grad_a_off;
                            y_a += Rasterizer.destinationWidth;
                            Oa += Va;
                            Ob += Vb;
                            Oc += Vc;
                        }
                        while(--y_b >= 0) {
                            drawTexturedLine(Rasterizer.destinationPixels, texture, y_a, x_a >> 16, x_c >> 16, grad_a >> 8, grad_c >> 8, 0, 0, Oa, Ob, Oc, i_1_, i_4_, i_7_);
                            x_c += x_b_off;
                            x_a += x_a_off;
                            grad_c += grad_b_off;
                            grad_a += grad_a_off;
                            y_a += Rasterizer.destinationWidth;
                            Oa += Va;
                            Ob += Vb;
                            Oc += Vc;
                        }
                    }
                }
            } else if(y_b <= y_c) {
                if(y_b >= bottomY) {
                    return;
                }
                if(y_c > bottomY) {
                    y_c = bottomY;
                }
                if(y_a > bottomY) {
                    y_a = bottomY;
                }
                if(y_c < y_a) {
                    x_a = x_b <<= 16;
                    grad_a = grad_b <<= 16;
                    if(y_b < 0) {
                        x_a -= x_a_off * y_b;
                        x_b -= x_b_off * y_b;
                        grad_a -= grad_a_off * y_b;
                        grad_b -= grad_b_off * y_b;
                        y_b = 0;
                    }
                    x_c <<= 16;
                    grad_c <<= 16;
                    if(y_c < 0) {
                        x_c -= x_c_off * y_c;
                        grad_c -= grad_c_off * y_c;
                        y_c = 0;
                    }
                    int i9 = y_b - center_y;
                    Oa += Va * i9;
                    Ob += Vb * i9;
                    Oc += Vc * i9;
                    if(y_b != y_c && x_a_off < x_b_off || y_b == y_c && x_a_off > x_c_off) {
                        y_a -= y_c;
                        y_c -= y_b;
                        y_b = lineOffsets[y_b];
                        while(--y_c >= 0) {
                            drawTexturedLine(Rasterizer.destinationPixels, texture, y_b, x_a >> 16, x_b >> 16, grad_a >> 8, grad_b >> 8, 0, 0, Oa, Ob, Oc, i_1_, i_4_, i_7_);
                            x_a += x_a_off;
                            x_b += x_b_off;
                            grad_a += grad_a_off;
                            grad_b += grad_b_off;
                            y_b += Rasterizer.destinationWidth;
                            Oa += Va;
                            Ob += Vb;
                            Oc += Vc;
                        }
                        while(--y_a >= 0) {
                            drawTexturedLine(Rasterizer.destinationPixels, texture, y_b, x_a >> 16, x_c >> 16, grad_a >> 8, grad_c >> 8, 0, 0, Oa, Ob, Oc, i_1_, i_4_, i_7_);
                            x_a += x_a_off;
                            x_c += x_c_off;
                            grad_a += grad_a_off;
                            grad_c += grad_c_off;
                            y_b += Rasterizer.destinationWidth;
                            Oa += Va;
                            Ob += Vb;
                            Oc += Vc;
                        }
                    } else {
                        y_a -= y_c;
                        y_c -= y_b;
                        y_b = lineOffsets[y_b];
                        while(--y_c >= 0) {
                            drawTexturedLine(Rasterizer.destinationPixels, texture, y_b, x_b >> 16, x_a >> 16, grad_b >> 8, grad_a >> 8, 0, 0, Oa, Ob, Oc, i_1_, i_4_, i_7_);
                            x_a += x_a_off;
                            x_b += x_b_off;
                            grad_a += grad_a_off;
                            grad_b += grad_b_off;
                            y_b += Rasterizer.destinationWidth;
                            Oa += Va;
                            Ob += Vb;
                            Oc += Vc;
                        }
                        while(--y_a >= 0) {
                            drawTexturedLine(Rasterizer.destinationPixels, texture, y_b, x_c >> 16, x_a >> 16, grad_c >> 8, grad_a >> 8, 0, 0, Oa, Ob, Oc, i_1_, i_4_, i_7_);
                            x_a += x_a_off;
                            x_c += x_c_off;
                            grad_a += grad_a_off;
                            grad_c += grad_c_off;
                            y_b += Rasterizer.destinationWidth;
                            Oa += Va;
                            Ob += Vb;
                            Oc += Vc;
                        }
                    }
                } else {
                    x_c = x_b <<= 16;
                    grad_c = grad_b <<= 16;
                    if(y_b < 0) {
                        x_c -= x_a_off * y_b;
                        x_b -= x_b_off * y_b;
                        grad_c -= grad_a_off * y_b;
                        grad_b -= grad_b_off * y_b;
                        y_b = 0;
                    }
                    x_a <<= 16;
                    grad_a <<= 16;
                    if(y_a < 0) {
                        x_a -= x_c_off * y_a;
                        grad_a -= grad_c_off * y_a;
                        y_a = 0;
                    }
                    int i_18_ = y_b - center_y;
                    Oa += Va * i_18_;
                    Ob += Vb * i_18_;
                    Oc += Vc * i_18_;
                    if(x_a_off < x_b_off) {
                        y_c -= y_a;
                        y_a -= y_b;
                        y_b = lineOffsets[y_b];
                        while(--y_a >= 0) {
                            drawTexturedLine(Rasterizer.destinationPixels, texture, y_b, x_c >> 16, x_b >> 16, grad_c >> 8, grad_b >> 8, 0, 0, Oa, Ob, Oc, i_1_, i_4_, i_7_);
                            x_c += x_a_off;
                            x_b += x_b_off;
                            grad_c += grad_a_off;
                            grad_b += grad_b_off;
                            y_b += Rasterizer.destinationWidth;
                            Oa += Va;
                            Ob += Vb;
                            Oc += Vc;
                        }
                        while(--y_c >= 0) {
                            drawTexturedLine(Rasterizer.destinationPixels, texture, y_b, x_a >> 16, x_b >> 16, grad_a >> 8, grad_b >> 8, 0, 0, Oa, Ob, Oc, i_1_, i_4_, i_7_);
                            x_a += x_c_off;
                            x_b += x_b_off;
                            grad_a += grad_c_off;
                            grad_b += grad_b_off;
                            y_b += Rasterizer.destinationWidth;
                            Oa += Va;
                            Ob += Vb;
                            Oc += Vc;
                        }
                    } else {
                        y_c -= y_a;
                        y_a -= y_b;
                        y_b = lineOffsets[y_b];
                        while(--y_a >= 0) {
                            drawTexturedLine(Rasterizer.destinationPixels, texture, y_b, x_b >> 16, x_c >> 16, grad_b >> 8, grad_c >> 8, 0, 0, Oa, Ob, Oc, i_1_, i_4_, i_7_);
                            x_c += x_a_off;
                            x_b += x_b_off;
                            grad_c += grad_a_off;
                            grad_b += grad_b_off;
                            y_b += Rasterizer.destinationWidth;
                            Oa += Va;
                            Ob += Vb;
                            Oc += Vc;
                        }
                        while(--y_c >= 0) {
                            drawTexturedLine(Rasterizer.destinationPixels, texture, y_b, x_b >> 16, x_a >> 16, grad_b >> 8, grad_a >> 8, 0, 0, Oa, Ob, Oc, i_1_, i_4_, i_7_);
                            x_a += x_c_off;
                            x_b += x_b_off;
                            grad_a += grad_c_off;
                            grad_b += grad_b_off;
                            y_b += Rasterizer.destinationWidth;
                            Oa += Va;
                            Ob += Vb;
                            Oc += Vc;
                        }
                    }
                }
            } else if(y_c < bottomY) {
                if(y_a > bottomY) {
                    y_a = bottomY;
                }
                if(y_b > bottomY) {
                    y_b = bottomY;
                }
                if(y_a < y_b) {
                    x_b = x_c <<= 16;
                    grad_b = grad_c <<= 16;
                    if(y_c < 0) {
                        x_b -= x_b_off * y_c;
                        x_c -= x_c_off * y_c;
                        grad_b -= grad_b_off * y_c;
                        grad_c -= grad_c_off * y_c;
                        y_c = 0;
                    }
                    x_a <<= 16;
                    grad_a <<= 16;
                    if(y_a < 0) {
                        x_a -= x_a_off * y_a;
                        grad_a -= grad_a_off * y_a;
                        y_a = 0;
                    }
                    int i_19_ = y_c - center_y;
                    Oa += Va * i_19_;
                    Ob += Vb * i_19_;
                    Oc += Vc * i_19_;
                    if(x_b_off < x_c_off) {
                        y_b -= y_a;
                        y_a -= y_c;
                        y_c = lineOffsets[y_c];
                        while(--y_a >= 0) {
                            drawTexturedLine(Rasterizer.destinationPixels, texture, y_c, x_b >> 16, x_c >> 16, grad_b >> 8, grad_c >> 8, 0, 0, Oa, Ob, Oc, i_1_, i_4_, i_7_);
                            x_b += x_b_off;
                            x_c += x_c_off;
                            grad_b += grad_b_off;
                            grad_c += grad_c_off;
                            y_c += Rasterizer.destinationWidth;
                            Oa += Va;
                            Ob += Vb;
                            Oc += Vc;
                        }
                        while(--y_b >= 0) {
                            drawTexturedLine(Rasterizer.destinationPixels, texture, y_c, x_b >> 16, x_a >> 16, grad_b >> 8, grad_a >> 8, 0, 0, Oa, Ob, Oc, i_1_, i_4_, i_7_);
                            x_b += x_b_off;
                            x_a += x_a_off;
                            grad_b += grad_b_off;
                            grad_a += grad_a_off;
                            y_c += Rasterizer.destinationWidth;
                            Oa += Va;
                            Ob += Vb;
                            Oc += Vc;
                        }
                    } else {
                        y_b -= y_a;
                        y_a -= y_c;
                        y_c = lineOffsets[y_c];
                        while(--y_a >= 0) {
                            drawTexturedLine(Rasterizer.destinationPixels, texture, y_c, x_c >> 16, x_b >> 16, grad_c >> 8, grad_b >> 8, 0, 0, Oa, Ob, Oc, i_1_, i_4_, i_7_);
                            x_b += x_b_off;
                            x_c += x_c_off;
                            grad_b += grad_b_off;
                            grad_c += grad_c_off;
                            y_c += Rasterizer.destinationWidth;
                            Oa += Va;
                            Ob += Vb;
                            Oc += Vc;
                        }
                        while(--y_b >= 0) {
                            drawTexturedLine(Rasterizer.destinationPixels, texture, y_c, x_a >> 16, x_b >> 16, grad_a >> 8, grad_b >> 8, 0, 0, Oa, Ob, Oc, i_1_, i_4_, i_7_);
                            x_b += x_b_off;
                            x_a += x_a_off;
                            grad_b += grad_b_off;
                            grad_a += grad_a_off;
                            y_c += Rasterizer.destinationWidth;
                            Oa += Va;
                            Ob += Vb;
                            Oc += Vc;
                        }
                    }
                } else {
                    x_a = x_c <<= 16;
                    grad_a = grad_c <<= 16;
                    if(y_c < 0) {
                        x_a -= x_b_off * y_c;
                        x_c -= x_c_off * y_c;
                        grad_a -= grad_b_off * y_c;
                        grad_c -= grad_c_off * y_c;
                        y_c = 0;
                    }
                    x_b <<= 16;
                    grad_b <<= 16;
                    if(y_b < 0) {
                        x_b -= x_a_off * y_b;
                        grad_b -= grad_a_off * y_b;
                        y_b = 0;
                    }
                    int i_20_ = y_c - center_y;
                    Oa += Va * i_20_;
                    Ob += Vb * i_20_;
                    Oc += Vc * i_20_;
                    if(x_b_off < x_c_off) {
                        y_a -= y_b;
                        y_b -= y_c;
                        y_c = lineOffsets[y_c];
                        while(--y_b >= 0) {
                            drawTexturedLine(Rasterizer.destinationPixels, texture, y_c, x_a >> 16, x_c >> 16, grad_a >> 8, grad_c >> 8, 0, 0, Oa, Ob, Oc, i_1_, i_4_, i_7_);
                            x_a += x_b_off;
                            x_c += x_c_off;
                            grad_a += grad_b_off;
                            grad_c += grad_c_off;
                            y_c += Rasterizer.destinationWidth;
                            Oa += Va;
                            Ob += Vb;
                            Oc += Vc;
                        }
                        while(--y_a >= 0) {
                            drawTexturedLine(Rasterizer.destinationPixels, texture, y_c, x_b >> 16, x_c >> 16, grad_b >> 8, grad_c >> 8, 0, 0, Oa, Ob, Oc, i_1_, i_4_, i_7_);
                            x_b += x_a_off;
                            x_c += x_c_off;
                            grad_b += grad_a_off;
                            grad_c += grad_c_off;
                            y_c += Rasterizer.destinationWidth;
                            Oa += Va;
                            Ob += Vb;
                            Oc += Vc;
                        }
                    } else {
                        y_a -= y_b;
                        y_b -= y_c;
                        y_c = lineOffsets[y_c];
                        while(--y_b >= 0) {
                            drawTexturedLine(Rasterizer.destinationPixels, texture, y_c, x_c >> 16, x_a >> 16, grad_c >> 8, grad_a >> 8, 0, 0, Oa, Ob, Oc, i_1_, i_4_, i_7_);
                            x_a += x_b_off;
                            x_c += x_c_off;
                            grad_a += grad_b_off;
                            grad_c += grad_c_off;
                            y_c += Rasterizer.destinationWidth;
                            Oa += Va;
                            Ob += Vb;
                            Oc += Vc;
                        }
                        while(--y_a >= 0) {
                            drawTexturedLine(Rasterizer.destinationPixels, texture, y_c, x_c >> 16, x_b >> 16, grad_c >> 8, grad_b >> 8, 0, 0, Oa, Ob, Oc, i_1_, i_4_, i_7_);
                            x_b += x_a_off;
                            x_c += x_c_off;
                            grad_b += grad_a_off;
                            grad_c += grad_c_off;
                            y_c += Rasterizer.destinationWidth;
                            Oa += Va;
                            Ob += Vb;
                            Oc += Vc;
                        }
                    }
                }
            }
        }
    }

    public static int[] method700(int arg0, int arg1, int arg2, int arg3, int[] arg4) {
        viewportRx = arg2 - arg0;
        bottomY = arg3 - arg1;
        if(arg4 == null) {
            int i = bottomY;
            if(i == 0) {
                i++;
            }
            lineOffsets = new int[i];
            for(int i_21_ = 0; i_21_ < i; i_21_++) {
                lineOffsets[i_21_] = (arg1 + i_21_) * Rasterizer.destinationWidth + arg0;
            }
        } else {
            lineOffsets = arg4;
        }
        method702();
        return lineOffsets;
    }

    public static void drawTexturedLine(int[] dest, int[] texture, int dest_off, int start_x, int end_x, int shadeValue, int gradient, int rgb, int loops, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12) {
        if(start_x < end_x) {
            int k3;
            int j3;
            if(restrict_edges) {
                j3 = (gradient - shadeValue) / (end_x - start_x);
                if(end_x > viewportRx) {
                    end_x = viewportRx;
                }
                if(start_x < 0) {
                    shadeValue -= start_x * j3;
                    start_x = 0;
                }
                if(start_x >= end_x) {
                    return;
                }
                k3 = end_x - start_x >> 3;
                j3 <<= 12;
                shadeValue <<= 9;
            } else {
                if(end_x - start_x > 7) {
                    k3 = end_x - start_x >> 3;
                    j3 = (gradient - shadeValue) * shadowDecay[k3] >> 6;
                } else {
                    k3 = 0;
                    j3 = 0;
                }
                shadeValue <<= 9;
            }
            dest_off += start_x;
            if(lowMemory) {
                int i4 = 0;
                int k4 = 0;
                int k6 = start_x - center_x;
                arg7 += (arg10 >> 3) * k6;
                arg8 += (arg11 >> 3) * k6;
                arg9 += (arg12 >> 3) * k6;
                int i5 = arg9 >> 12;
                if(i5 != 0) {
                    rgb = arg7 / i5;
                    loops = arg8 / i5;
                    if(rgb < 0) {
                        rgb = 0;
                    } else if(rgb > 4032) {
                        rgb = 4032;
                    }
                }
                arg7 += arg10;
                arg8 += arg11;
                arg9 += arg12;
                i5 = arg9 >> 12;
                if(i5 != 0) {
                    i4 = arg7 / i5;
                    k4 = arg8 / i5;
                    if(i4 < 7) {
                        i4 = 7;
                    } else if(i4 > 4032) {
                        i4 = 4032;
                    }
                }
                int i7 = i4 - rgb >> 3;
                int k7 = k4 - loops >> 3;
                rgb += (shadeValue & 0x600000) >> 3;
                int i8 = shadeValue >> 23;
                if(opaque) {
                    while(k3-- > 0) {
                        dest[dest_off++] = texture[(loops & 0xfc0) + (rgb >> 6)] >>> i8;
                        rgb += i7;
                        loops += k7;
                        dest[dest_off++] = texture[(loops & 0xfc0) + (rgb >> 6)] >>> i8;
                        rgb += i7;
                        loops += k7;
                        dest[dest_off++] = texture[(loops & 0xfc0) + (rgb >> 6)] >>> i8;
                        rgb += i7;
                        loops += k7;
                        dest[dest_off++] = texture[(loops & 0xfc0) + (rgb >> 6)] >>> i8;
                        rgb += i7;
                        loops += k7;
                        dest[dest_off++] = texture[(loops & 0xfc0) + (rgb >> 6)] >>> i8;
                        rgb += i7;
                        loops += k7;
                        dest[dest_off++] = texture[(loops & 0xfc0) + (rgb >> 6)] >>> i8;
                        rgb += i7;
                        loops += k7;
                        dest[dest_off++] = texture[(loops & 0xfc0) + (rgb >> 6)] >>> i8;
                        rgb += i7;
                        loops += k7;
                        dest[dest_off++] = texture[(loops & 0xfc0) + (rgb >> 6)] >>> i8;
                        rgb = i4;
                        loops = k4;
                        arg7 += arg10;
                        arg8 += arg11;
                        arg9 += arg12;
                        i5 = arg9 >> 12;
                        if(i5 != 0) {
                            i4 = arg7 / i5;
                            k4 = arg8 / i5;
                            if(i4 < 7) {
                                i4 = 7;
                            } else if(i4 > 4032) {
                                i4 = 4032;
                            }
                        }
                        i7 = i4 - rgb >> 3;
                        k7 = k4 - loops >> 3;
                        shadeValue += j3;
                        rgb += (shadeValue & 0x600000) >> 3;
                        i8 = shadeValue >> 23;
                    }
                    k3 = end_x - start_x & 0x7;
                    while(k3-- > 0) {
                        dest[dest_off++] = texture[(loops & 0xfc0) + (rgb >> 6)] >>> i8;
                        rgb += i7;
                        loops += k7;
                    }
                } else {
                    while(k3-- > 0) {
                        int k8;
                        if((k8 = texture[(loops & 0xfc0) + (rgb >> 6)] >>> i8) != 0) {
                            dest[dest_off] = k8;
                        }
                        dest_off++;
                        rgb += i7;
                        loops += k7;
                        if((k8 = texture[(loops & 0xfc0) + (rgb >> 6)] >>> i8) != 0) {
                            dest[dest_off] = k8;
                        }
                        dest_off++;
                        rgb += i7;
                        loops += k7;
                        if((k8 = texture[(loops & 0xfc0) + (rgb >> 6)] >>> i8) != 0) {
                            dest[dest_off] = k8;
                        }
                        dest_off++;
                        rgb += i7;
                        loops += k7;
                        if((k8 = texture[(loops & 0xfc0) + (rgb >> 6)] >>> i8) != 0) {
                            dest[dest_off] = k8;
                        }
                        dest_off++;
                        rgb += i7;
                        loops += k7;
                        if((k8 = texture[(loops & 0xfc0) + (rgb >> 6)] >>> i8) != 0) {
                            dest[dest_off] = k8;
                        }
                        dest_off++;
                        rgb += i7;
                        loops += k7;
                        if((k8 = texture[(loops & 0xfc0) + (rgb >> 6)] >>> i8) != 0) {
                            dest[dest_off] = k8;
                        }
                        dest_off++;
                        rgb += i7;
                        loops += k7;
                        if((k8 = texture[(loops & 0xfc0) + (rgb >> 6)] >>> i8) != 0) {
                            dest[dest_off] = k8;
                        }
                        dest_off++;
                        rgb += i7;
                        loops += k7;
                        if((k8 = texture[(loops & 0xfc0) + (rgb >> 6)] >>> i8) != 0) {
                            dest[dest_off] = k8;
                        }
                        dest_off++;
                        rgb = i4;
                        loops = k4;
                        arg7 += arg10;
                        arg8 += arg11;
                        arg9 += arg12;
                        i5 = arg9 >> 12;
                        if(i5 != 0) {
                            i4 = arg7 / i5;
                            k4 = arg8 / i5;
                            if(i4 < 7) {
                                i4 = 7;
                            } else if(i4 > 4032) {
                                i4 = 4032;
                            }
                        }
                        i7 = i4 - rgb >> 3;
                        k7 = k4 - loops >> 3;
                        shadeValue += j3;
                        rgb += (shadeValue & 0x600000) >> 3;
                        i8 = shadeValue >> 23;
                    }
                    k3 = end_x - start_x & 0x7;
                    while(k3-- > 0) {
                        int i_31_;
                        if((i_31_ = texture[(loops & 0xfc0) + (rgb >> 6)] >>> i8) != 0) {
                            dest[dest_off] = i_31_;
                        }
                        dest_off++;
                        rgb += i7;
                        loops += k7;
                    }
                }
            } else {
                int j4 = 0;
                int l4 = 0;
                int l6 = start_x - center_x;
                arg7 += (arg10 >> 3) * l6;
                arg8 += (arg11 >> 3) * l6;
                arg9 += (arg12 >> 3) * l6;
                int l5 = arg9 >> 14;
                if(l5 != 0) {
                    rgb = arg7 / l5;
                    loops = arg8 / l5;
                    if(rgb < 0) {
                        rgb = 0;
                    } else if(rgb > 16256) {
                        rgb = 16256;
                    }
                }
                arg7 += arg10;
                arg8 += arg11;
                arg9 += arg12;
                l5 = arg9 >> 14;
                if(l5 != 0) {
                    j4 = arg7 / l5;
                    l4 = arg8 / l5;
                    if(j4 < 7) {
                        j4 = 7;
                    } else if(j4 > 16256) {
                        j4 = 16256;
                    }
                }
                int j7 = j4 - rgb >> 3;
                int l7 = l4 - loops >> 3;
                rgb += shadeValue & 0x600000;
                int j8 = shadeValue >> 23;
                if(opaque) {
                    while(k3-- > 0) {
                        dest[dest_off++] = texture[(loops & 0x3f80) + (rgb >> 7)] >>> j8;
                        rgb += j7;
                        loops += l7;
                        dest[dest_off++] = texture[(loops & 0x3f80) + (rgb >> 7)] >>> j8;
                        rgb += j7;
                        loops += l7;
                        dest[dest_off++] = texture[(loops & 0x3f80) + (rgb >> 7)] >>> j8;
                        rgb += j7;
                        loops += l7;
                        dest[dest_off++] = texture[(loops & 0x3f80) + (rgb >> 7)] >>> j8;
                        rgb += j7;
                        loops += l7;
                        dest[dest_off++] = texture[(loops & 0x3f80) + (rgb >> 7)] >>> j8;
                        rgb += j7;
                        loops += l7;
                        dest[dest_off++] = texture[(loops & 0x3f80) + (rgb >> 7)] >>> j8;
                        rgb += j7;
                        loops += l7;
                        dest[dest_off++] = texture[(loops & 0x3f80) + (rgb >> 7)] >>> j8;
                        rgb += j7;
                        loops += l7;
                        dest[dest_off++] = texture[(loops & 0x3f80) + (rgb >> 7)] >>> j8;
                        rgb = j4;
                        loops = l4;
                        arg7 += arg10;
                        arg8 += arg11;
                        arg9 += arg12;
                        l5 = arg9 >> 14;
                        if(l5 != 0) {
                            j4 = arg7 / l5;
                            l4 = arg8 / l5;
                            if(j4 < 7) {
                                j4 = 7;
                            } else if(j4 > 16256) {
                                j4 = 16256;
                            }
                        }
                        j7 = j4 - rgb >> 3;
                        l7 = l4 - loops >> 3;
                        shadeValue += j3;
                        rgb += shadeValue & 0x600000;
                        j8 = shadeValue >> 23;
                    }
                    k3 = end_x - start_x & 0x7;
                    while(k3-- > 0) {
                        dest[dest_off++] = texture[(loops & 0x3f80) + (rgb >> 7)] >>> j8;
                        rgb += j7;
                        loops += l7;
                    }
                } else {
                    while(k3-- > 0) {
                        int i_39_;
                        if((i_39_ = texture[(loops & 0x3f80) + (rgb >> 7)] >>> j8) != 0) {
                            dest[dest_off] = i_39_;
                        }
                        dest_off++;
                        rgb += j7;
                        loops += l7;
                        if((i_39_ = texture[(loops & 0x3f80) + (rgb >> 7)] >>> j8) != 0) {
                            dest[dest_off] = i_39_;
                        }
                        dest_off++;
                        rgb += j7;
                        loops += l7;
                        if((i_39_ = texture[(loops & 0x3f80) + (rgb >> 7)] >>> j8) != 0) {
                            dest[dest_off] = i_39_;
                        }
                        dest_off++;
                        rgb += j7;
                        loops += l7;
                        if((i_39_ = texture[(loops & 0x3f80) + (rgb >> 7)] >>> j8) != 0) {
                            dest[dest_off] = i_39_;
                        }
                        dest_off++;
                        rgb += j7;
                        loops += l7;
                        if((i_39_ = texture[(loops & 0x3f80) + (rgb >> 7)] >>> j8) != 0) {
                            dest[dest_off] = i_39_;
                        }
                        dest_off++;
                        rgb += j7;
                        loops += l7;
                        if((i_39_ = texture[(loops & 0x3f80) + (rgb >> 7)] >>> j8) != 0) {
                            dest[dest_off] = i_39_;
                        }
                        dest_off++;
                        rgb += j7;
                        loops += l7;
                        if((i_39_ = texture[(loops & 0x3f80) + (rgb >> 7)] >>> j8) != 0) {
                            dest[dest_off] = i_39_;
                        }
                        dest_off++;
                        rgb += j7;
                        loops += l7;
                        if((i_39_ = texture[(loops & 0x3f80) + (rgb >> 7)] >>> j8) != 0) {
                            dest[dest_off] = i_39_;
                        }
                        dest_off++;
                        rgb = j4;
                        loops = l4;
                        arg7 += arg10;
                        arg8 += arg11;
                        arg9 += arg12;
                        l5 = arg9 >> 14;
                        if(l5 != 0) {
                            j4 = arg7 / l5;
                            l4 = arg8 / l5;
                            if(j4 < 7) {
                                j4 = 7;
                            } else if(j4 > 16256) {
                                j4 = 16256;
                            }
                        }
                        j7 = j4 - rgb >> 3;
                        l7 = l4 - loops >> 3;
                        shadeValue += j3;
                        rgb += shadeValue & 0x600000;
                        j8 = shadeValue >> 23;
                    }
                    k3 = end_x - start_x & 0x7;
                    while(k3-- > 0) {
                        int i_40_;
                        if((i_40_ = texture[(loops & 0x3f80) + (rgb >> 7)] >>> j8) != 0) {
                            dest[dest_off] = i_40_;
                        }
                        dest_off++;
                        rgb += j7;
                        loops += l7;
                    }
                }
            }
        }
    }

    public static void method702() {
        center_x = viewportRx / 2;
        center_y = bottomY / 2;
        anInt2942 = -center_x;
        anInt2934 = viewportRx - center_x;
        anInt2935 = -center_y;
        anInt2941 = bottomY - center_y;
    }

    public static void method703(Interface3 arg0) {
        anInterface3_2939 = arg0;
    }

    public static void method704() {
        lineOffsets = null;
        hsl2rgb = null;
        anInterface3_2939 = null;
        shadowDecay = null;
        anIntArray2929 = null;
        sinetable = null;
        cosinetable = null;
    }

    //562 drawshadedline
    //has vertex blending :O
    public static void drawShadedLine562(int dest[], int dest_off, int startX, int endX, int colorIndex, int grad) {
        int off = 0;
        int color;
        int loops;
        if (restrict_edges) {
            if (endX > viewportRx) {
                endX = viewportRx;
            }
            if (startX < 0) {
                //colorIndex -= startX * off;//not sure if needed
                startX = 0;
            }
        }
        if (startX < endX) {
            dest_off += startX - 1;
            colorIndex += off * startX;
            if (notTextured) {
                loops = endX - startX >> 2;
                if (loops > 0) {
                    off = (grad - colorIndex) * shadowDecay[loops] >> 15;
                } else {
                    off = 0;
                }
                if (alpha == 0) {
                    if (loops > 0) {
                        do {
                            color = hsl2rgb[colorIndex >> 8];
                            colorIndex += off;
                            dest[++dest_off] = color;
                            dest[++dest_off] = color;
                            dest[++dest_off] = color;
                            dest[++dest_off] = color;
                        } while (--loops > 0);
                    }
                    loops = endX - startX & 0x3;
                    if (loops > 0) {
                        color = hsl2rgb[colorIndex >> 8];
                        do {
                            dest[++dest_off] = color;
                        }
                        while (--loops > 0);
                    }
                } else {
                    int src_alpha = alpha;
                    int dest_alpha = 256 - alpha;
                    if (loops > 0) {
                        do {
                            color = hsl2rgb[colorIndex >> 8];
                            colorIndex += off;
                            color = (((color & 0xff00ff) * dest_alpha >> 8 & 0xff00ff) + ((color & 0xff00) * dest_alpha >> 8 & 0xff00));
                            int i_169_ = dest[++dest_off];
                            dest[dest_off] = (color + ((i_169_ & 0xff00ff) * src_alpha >> 8 & 0xff00ff) + ((i_169_ & 0xff00) * src_alpha >> 8 & 0xff00));
                            i_169_ = dest[++dest_off];
                            dest[dest_off] = (color + ((i_169_ & 0xff00ff) * src_alpha >> 8 & 0xff00ff) + ((i_169_ & 0xff00) * src_alpha >> 8 & 0xff00));
                            i_169_ = dest[++dest_off];
                            dest[dest_off] = (color + ((i_169_ & 0xff00ff) * src_alpha >> 8 & 0xff00ff) + ((i_169_ & 0xff00) * src_alpha >> 8 & 0xff00));
                            i_169_ = dest[++dest_off];
                            dest[dest_off] = (color + ((i_169_ & 0xff00ff) * src_alpha >> 8 & 0xff00ff) + ((i_169_ & 0xff00) * src_alpha >> 8 & 0xff00));
                        } while (--loops > 0);
                    }
                    loops = endX - startX & 0x3;
                    if (loops > 0) {
                        color = hsl2rgb[colorIndex >> 8];
                        color = (((color & 0xff00ff) * dest_alpha >> 8 & 0xff00ff) + ((color & 0xff00) * dest_alpha >> 8 & 0xff00));
                        do {
                            int i_170_ = dest[++dest_off];
                            dest[dest_off] = (color + ((i_170_ & 0xff00ff) * src_alpha >> 8 & 0xff00ff) + ((i_170_ & 0xff00) * src_alpha >> 8 & 0xff00));
                        } while (--loops > 0);
                    }
                }
            } else {
                loops = endX - startX;
                if (alpha == 0) {
                    do {
                        dest[++dest_off] = hsl2rgb[colorIndex >> 8];
                        colorIndex += off;
                    } while (--loops > 0);
                } else {
                    int i = alpha;
                    int i_171_ = 256 - alpha;
                    do {
                        color = hsl2rgb[colorIndex >> 8];
                        colorIndex += off;
                        color = (((color & 0xff00ff) * i_171_ >> 8 & 0xff00ff) + ((color & 0xff00) * i_171_ >> 8 & 0xff00));
                        int i_ = dest[++dest_off];
                        dest[dest_off] = (color + ((i_ & 0xff00ff) * i >> 8 & 0xff00ff) + ((i_ & 0xff00) * i >> 8 & 0xff00));
                    } while (--loops > 0);
                }
            }
        }
    }

    public static void drawShadedLine(int[] dest, int dest_off, int start_x, int end_x, int color_index, int grad) {
        if (!useLatestShadeLine) {//divert all calls to the new method as its better
            drawShadedLine562(dest, dest_off, start_x, end_x, color_index, grad);
            return;
        }
        int color;
        int loops;
        if(notTextured) {
            int off;
            if(restrict_edges) {
                if(end_x - start_x > 3) {
                    off = (grad - color_index) / (end_x - start_x);
                } else {
                    off = 0;
                }
                if(end_x > viewportRx) {
                    end_x = viewportRx;
                }
                if(start_x < 0) {
                    color_index -= start_x * off;
                    start_x = 0;
                }
                if(start_x >= end_x) {
                    return;
                }
                dest_off += start_x;
                loops = end_x - start_x >> 2;
                off <<= 2;
            } else {
                if(start_x >= end_x) {
                    return;
                }
                dest_off += start_x;
                loops = end_x - start_x >> 2;
                if(loops > 0) {
                    off = (grad - color_index) * shadowDecay[loops] >> 15;
                } else {
                    off = 0;
                }
            }
            if(alpha == 0) {
                while(--loops >= 0) {
                    color = hsl2rgb[color_index >> 8];
                    color_index += off;
                    dest[dest_off++] = color;
                    dest[dest_off++] = color;
                    dest[dest_off++] = color;
                    dest[dest_off++] = color;
                }
                loops = end_x - start_x & 0x3;
                if(loops > 0) {
                    color = hsl2rgb[color_index >> 8];
                    do {
                        dest[dest_off++] = color;
                    } while(--loops > 0);
                }
            } else {
                int src_alpha = alpha;
                int dest_alpha = 256 - alpha;
                while(--loops >= 0) {
                    color = hsl2rgb[color_index >> 8];
                    color_index += off;
                    color = (((color & 0xff00ff) * dest_alpha >> 8 & 0xff00ff) + ((color & 0xff00) * dest_alpha >> 8 & 0xff00));
                    dest[dest_off++] = (color + ((dest[dest_off] & 0xff00ff) * src_alpha >> 8 & 0xff00ff) + ((dest[dest_off] & 0xff00) * src_alpha >> 8 & 0xff00));
                    dest[dest_off++] = (color + ((dest[dest_off] & 0xff00ff) * src_alpha >> 8 & 0xff00ff) + ((dest[dest_off] & 0xff00) * src_alpha >> 8 & 0xff00));
                    dest[dest_off++] = (color + ((dest[dest_off] & 0xff00ff) * src_alpha >> 8 & 0xff00ff) + ((dest[dest_off] & 0xff00) * src_alpha >> 8 & 0xff00));
                    dest[dest_off++] = (color + ((dest[dest_off] & 0xff00ff) * src_alpha >> 8 & 0xff00ff) + ((dest[dest_off] & 0xff00) * src_alpha >> 8 & 0xff00));
                }
                loops = end_x - start_x & 0x3;
                if(loops > 0) {
                    color = hsl2rgb[color_index >> 8];
                    color = (((color & 0xff00ff) * dest_alpha >> 8 & 0xff00ff) + ((color & 0xff00) * dest_alpha >> 8 & 0xff00));
                    do {
                        dest[dest_off++] = (color + ((dest[dest_off] & 0xff00ff) * src_alpha >> 8 & 0xff00ff) + ((dest[dest_off] & 0xff00) * src_alpha >> 8 & 0xff00));
                    }
                    while(--loops > 0);
                }
            }
        } else {
            if(start_x < end_x) {
                int i = (grad - color_index) / (end_x - start_x);
                if(restrict_edges) {
                    if(end_x > viewportRx) {
                        end_x = viewportRx;
                    }
                    if(start_x < 0) {
                        color_index -= start_x * i;
                        start_x = 0;
                    }
                    if(start_x >= end_x) {
                        return;
                    }
                }
                dest_off += start_x;
                loops = end_x - start_x;
                if(alpha == 0) {
                    do {
                        dest[dest_off++] = hsl2rgb[color_index >> 8];
                        color_index += i;
                    } while(--loops > 0);
                } else {
                    int i_43_ = alpha;
                    int i_44_ = 256 - alpha;
                    do {
                        color = hsl2rgb[color_index >> 8];
                        color_index += i;
                        color = (((color & 0xff00ff) * i_44_ >> 8 & 0xff00ff) + ((color & 0xff00) * i_44_ >> 8 & 0xff00));
                        dest[dest_off++] = (color + ((dest[dest_off] & 0xff00ff) * i_43_ >> 8 & 0xff00ff) + ((dest[dest_off] & 0xff00) * i_43_ >> 8 & 0xff00));
                    } while(--loops > 0);
                }
            }
        }
    }

    public static void drawShadedTriangle(int y_a, int y_b, int y_c, int x_a, int x_b, int x_c, int z_a, int z_b, int z_c) {
        int x_a_off = 0;
        int z_a_off = 0;
        if(y_b != y_a) {
            x_a_off = (x_b - x_a << 16) / (y_b - y_a);
            z_a_off = (z_b - z_a << 15) / (y_b - y_a);
        }
        int x_b_off = 0;
        int z_b_off = 0;
        if(y_c != y_b) {
            x_b_off = (x_c - x_b << 16) / (y_c - y_b);
            z_b_off = (z_c - z_b << 15) / (y_c - y_b);
        }
        int x_c_off = 0;
        int z_c_off = 0;
        if(y_c != y_a) {
            x_c_off = (x_a - x_c << 16) / (y_a - y_c);
            z_c_off = (z_a - z_c << 15) / (y_a - y_c);
        }
        if(y_a <= y_b && y_a <= y_c) {
            if(y_a >= bottomY) {
                return;
            }
            if(y_b > bottomY) {
                y_b = bottomY;
            }
            if(y_c > bottomY) {
                y_c = bottomY;
            }
            if(y_b < y_c) {
                x_c = x_a <<= 16;
                z_c = z_a <<= 15;
                if(y_a < 0) {
                    x_c -= x_c_off * y_a;
                    x_a -= x_a_off * y_a;
                    z_c -= z_c_off * y_a;
                    z_a -= z_a_off * y_a;
                    y_a = 0;
                }
                x_b <<= 16;
                z_b <<= 15;
                if(y_b < 0) {
                    x_b -= x_b_off * y_b;
                    z_b -= z_b_off * y_b;
                    y_b = 0;
                }
                if(y_a != y_b && x_c_off < x_a_off || y_a == y_b && x_c_off > x_b_off) {
                    y_c -= y_b;
                    y_b -= y_a;
                    y_a = lineOffsets[y_a];
                    while(--y_b >= 0) {
                        drawShadedLine(Rasterizer.destinationPixels, y_a, x_c >> 16, x_a >> 16, z_c >> 7, z_a >> 7);
                        x_c += x_c_off;
                        x_a += x_a_off;
                        z_c += z_c_off;
                        z_a += z_a_off;
                        y_a += Rasterizer.destinationWidth;
                    }
                    while(--y_c >= 0) {
                        drawShadedLine(Rasterizer.destinationPixels, y_a, x_c >> 16, x_b >> 16, z_c >> 7, z_b >> 7);
                        x_c += x_c_off;
                        x_b += x_b_off;
                        z_c += z_c_off;
                        z_b += z_b_off;
                        y_a += Rasterizer.destinationWidth;
                    }
                } else {
                    y_c -= y_b;
                    y_b -= y_a;
                    y_a = lineOffsets[y_a];
                    while(--y_b >= 0) {
                        drawShadedLine(Rasterizer.destinationPixels, y_a, x_a >> 16, x_c >> 16, z_a >> 7, z_c >> 7);
                        x_c += x_c_off;
                        x_a += x_a_off;
                        z_c += z_c_off;
                        z_a += z_a_off;
                        y_a += Rasterizer.destinationWidth;
                    }
                    while(--y_c >= 0) {
                        drawShadedLine(Rasterizer.destinationPixels, y_a, x_b >> 16, x_c >> 16, z_b >> 7, z_c >> 7);
                        x_c += x_c_off;
                        x_b += x_b_off;
                        z_c += z_c_off;
                        z_b += z_b_off;
                        y_a += Rasterizer.destinationWidth;
                    }
                }
            } else {
                x_b = x_a <<= 16;
                z_b = z_a <<= 15;
                if(y_a < 0) {
                    x_b -= x_c_off * y_a;
                    x_a -= x_a_off * y_a;
                    z_b -= z_c_off * y_a;
                    z_a -= z_a_off * y_a;
                    y_a = 0;
                }
                x_c <<= 16;
                z_c <<= 15;
                if(y_c < 0) {
                    x_c -= x_b_off * y_c;
                    z_c -= z_b_off * y_c;
                    y_c = 0;
                }
                if(y_a != y_c && x_c_off < x_a_off || y_a == y_c && x_b_off > x_a_off) {
                    y_b -= y_c;
                    y_c -= y_a;
                    y_a = lineOffsets[y_a];
                    while(--y_c >= 0) {
                        drawShadedLine(Rasterizer.destinationPixels, y_a, x_b >> 16, x_a >> 16, z_b >> 7, z_a >> 7);
                        x_b += x_c_off;
                        x_a += x_a_off;
                        z_b += z_c_off;
                        z_a += z_a_off;
                        y_a += Rasterizer.destinationWidth;
                    }
                    while(--y_b >= 0) {
                        drawShadedLine(Rasterizer.destinationPixels, y_a, x_c >> 16, x_a >> 16, z_c >> 7, z_a >> 7);
                        x_c += x_b_off;
                        x_a += x_a_off;
                        z_c += z_b_off;
                        z_a += z_a_off;
                        y_a += Rasterizer.destinationWidth;
                    }
                } else {
                    y_b -= y_c;
                    y_c -= y_a;
                    y_a = lineOffsets[y_a];
                    while(--y_c >= 0) {
                        drawShadedLine(Rasterizer.destinationPixels, y_a, x_a >> 16, x_b >> 16, z_a >> 7, z_b >> 7);
                        x_b += x_c_off;
                        x_a += x_a_off;
                        z_b += z_c_off;
                        z_a += z_a_off;
                        y_a += Rasterizer.destinationWidth;
                    }
                    while(--y_b >= 0) {
                        drawShadedLine(Rasterizer.destinationPixels, y_a, x_a >> 16, x_c >> 16, z_a >> 7, z_c >> 7);
                        x_c += x_b_off;
                        x_a += x_a_off;
                        z_c += z_b_off;
                        z_a += z_a_off;
                        y_a += Rasterizer.destinationWidth;
                    }
                }
            }
        } else {
            if(y_b <= y_c) {
                if(y_b < bottomY) {
                    if(y_c > bottomY) {
                        y_c = bottomY;
                    }
                    if(y_a > bottomY) {
                        y_a = bottomY;
                    }
                    if(y_c < y_a) {
                        x_a = x_b <<= 16;
                        z_a = z_b <<= 15;
                        if(y_b < 0) {
                            x_a -= x_a_off * y_b;
                            x_b -= x_b_off * y_b;
                            z_a -= z_a_off * y_b;
                            z_b -= z_b_off * y_b;
                            y_b = 0;
                        }
                        x_c <<= 16;
                        z_c <<= 15;
                        if(y_c < 0) {
                            x_c -= x_c_off * y_c;
                            z_c -= z_c_off * y_c;
                            y_c = 0;
                        }
                        if(y_b != y_c && x_a_off < x_b_off || y_b == y_c && x_a_off > x_c_off) {
                            y_a -= y_c;
                            y_c -= y_b;
                            y_b = lineOffsets[y_b];
                            while(--y_c >= 0) {
                                drawShadedLine(Rasterizer.destinationPixels, y_b, x_a >> 16, x_b >> 16, z_a >> 7, z_b >> 7);
                                x_a += x_a_off;
                                x_b += x_b_off;
                                z_a += z_a_off;
                                z_b += z_b_off;
                                y_b += Rasterizer.destinationWidth;
                            }
                            while(--y_a >= 0) {
                                drawShadedLine(Rasterizer.destinationPixels, y_b, x_a >> 16, x_c >> 16, z_a >> 7, z_c >> 7);
                                x_a += x_a_off;
                                x_c += x_c_off;
                                z_a += z_a_off;
                                z_c += z_c_off;
                                y_b += Rasterizer.destinationWidth;
                            }
                        } else {
                            y_a -= y_c;
                            y_c -= y_b;
                            y_b = lineOffsets[y_b];
                            while(--y_c >= 0) {
                                drawShadedLine(Rasterizer.destinationPixels, y_b, x_b >> 16, x_a >> 16, z_b >> 7, z_a >> 7);
                                x_a += x_a_off;
                                x_b += x_b_off;
                                z_a += z_a_off;
                                z_b += z_b_off;
                                y_b += Rasterizer.destinationWidth;
                            }
                            while(--y_a >= 0) {
                                drawShadedLine(Rasterizer.destinationPixels, y_b, x_c >> 16, x_a >> 16, z_c >> 7, z_a >> 7);
                                x_a += x_a_off;
                                x_c += x_c_off;
                                z_a += z_a_off;
                                z_c += z_c_off;
                                y_b += Rasterizer.destinationWidth;
                            }
                        }
                    } else {
                        x_c = x_b <<= 16;
                        z_c = z_b <<= 15;
                        if(y_b < 0) {
                            x_c -= x_a_off * y_b;
                            x_b -= x_b_off * y_b;
                            z_c -= z_a_off * y_b;
                            z_b -= z_b_off * y_b;
                            y_b = 0;
                        }
                        x_a <<= 16;
                        z_a <<= 15;
                        if(y_a < 0) {
                            x_a -= x_c_off * y_a;
                            z_a -= z_c_off * y_a;
                            y_a = 0;
                        }
                        if(x_a_off < x_b_off) {
                            y_c -= y_a;
                            y_a -= y_b;
                            y_b = lineOffsets[y_b];
                            while(--y_a >= 0) {
                                drawShadedLine(Rasterizer.destinationPixels, y_b, x_c >> 16, x_b >> 16, z_c >> 7, z_b >> 7);
                                x_c += x_a_off;
                                x_b += x_b_off;
                                z_c += z_a_off;
                                z_b += z_b_off;
                                y_b += Rasterizer.destinationWidth;
                            }
                            while(--y_c >= 0) {
                                drawShadedLine(Rasterizer.destinationPixels, y_b, x_a >> 16, x_b >> 16, z_a >> 7, z_b >> 7);
                                x_a += x_c_off;
                                x_b += x_b_off;
                                z_a += z_c_off;
                                z_b += z_b_off;
                                y_b += Rasterizer.destinationWidth;
                            }
                        } else {
                            y_c -= y_a;
                            y_a -= y_b;
                            y_b = lineOffsets[y_b];
                            while(--y_a >= 0) {
                                drawShadedLine(Rasterizer.destinationPixels, y_b, x_b >> 16, x_c >> 16, z_b >> 7, z_c >> 7);
                                x_c += x_a_off;
                                x_b += x_b_off;
                                z_c += z_a_off;
                                z_b += z_b_off;
                                y_b += Rasterizer.destinationWidth;
                            }
                            while(--y_c >= 0) {
                                drawShadedLine(Rasterizer.destinationPixels, y_b, x_b >> 16, x_a >> 16, z_b >> 7, z_a >> 7);
                                x_a += x_c_off;
                                x_b += x_b_off;
                                z_a += z_c_off;
                                z_b += z_b_off;
                                y_b += Rasterizer.destinationWidth;
                            }
                        }
                    }
                }
            } else if(y_c < bottomY) {
                if(y_a > bottomY) {
                    y_a = bottomY;
                }
                if(y_b > bottomY) {
                    y_b = bottomY;
                }
                if(y_a < y_b) {
                    x_b = x_c <<= 16;
                    z_b = z_c <<= 15;
                    if(y_c < 0) {
                        x_b -= x_b_off * y_c;
                        x_c -= x_c_off * y_c;
                        z_b -= z_b_off * y_c;
                        z_c -= z_c_off * y_c;
                        y_c = 0;
                    }
                    x_a <<= 16;
                    z_a <<= 15;
                    if(y_a < 0) {
                        x_a -= x_a_off * y_a;
                        z_a -= z_a_off * y_a;
                        y_a = 0;
                    }
                    if(x_b_off < x_c_off) {
                        y_b -= y_a;
                        y_a -= y_c;
                        y_c = lineOffsets[y_c];
                        while(--y_a >= 0) {
                            drawShadedLine(Rasterizer.destinationPixels, y_c, x_b >> 16, x_c >> 16, z_b >> 7, z_c >> 7);
                            x_b += x_b_off;
                            x_c += x_c_off;
                            z_b += z_b_off;
                            z_c += z_c_off;
                            y_c += Rasterizer.destinationWidth;
                        }
                        while(--y_b >= 0) {
                            drawShadedLine(Rasterizer.destinationPixels, y_c, x_b >> 16, x_a >> 16, z_b >> 7, z_a >> 7);
                            x_b += x_b_off;
                            x_a += x_a_off;
                            z_b += z_b_off;
                            z_a += z_a_off;
                            y_c += Rasterizer.destinationWidth;
                        }
                    } else {
                        y_b -= y_a;
                        y_a -= y_c;
                        y_c = lineOffsets[y_c];
                        while(--y_a >= 0) {
                            drawShadedLine(Rasterizer.destinationPixels, y_c, x_c >> 16, x_b >> 16, z_c >> 7, z_b >> 7);
                            x_b += x_b_off;
                            x_c += x_c_off;
                            z_b += z_b_off;
                            z_c += z_c_off;
                            y_c += Rasterizer.destinationWidth;
                        }
                        while(--y_b >= 0) {
                            drawShadedLine(Rasterizer.destinationPixels, y_c, x_a >> 16, x_b >> 16, z_a >> 7, z_b >> 7);
                            x_b += x_b_off;
                            x_a += x_a_off;
                            z_b += z_b_off;
                            z_a += z_a_off;
                            y_c += Rasterizer.destinationWidth;
                        }
                    }
                } else {
                    x_a = x_c <<= 16;
                    z_a = z_c <<= 15;
                    if(y_c < 0) {
                        x_a -= x_b_off * y_c;
                        x_c -= x_c_off * y_c;
                        z_a -= z_b_off * y_c;
                        z_c -= z_c_off * y_c;
                        y_c = 0;
                    }
                    x_b <<= 16;
                    z_b <<= 15;
                    if(y_b < 0) {
                        x_b -= x_a_off * y_b;
                        z_b -= z_a_off * y_b;
                        y_b = 0;
                    }
                    if(x_b_off < x_c_off) {
                        y_a -= y_b;
                        y_b -= y_c;
                        y_c = lineOffsets[y_c];
                        while(--y_b >= 0) {
                            drawShadedLine(Rasterizer.destinationPixels, y_c, x_a >> 16, x_c >> 16, z_a >> 7, z_c >> 7);
                            x_a += x_b_off;
                            x_c += x_c_off;
                            z_a += z_b_off;
                            z_c += z_c_off;
                            y_c += Rasterizer.destinationWidth;
                        }
                        while(--y_a >= 0) {
                            drawShadedLine(Rasterizer.destinationPixels, y_c, x_b >> 16, x_c >> 16, z_b >> 7, z_c >> 7);
                            x_b += x_a_off;
                            x_c += x_c_off;
                            z_b += z_a_off;
                            z_c += z_c_off;
                            y_c += Rasterizer.destinationWidth;
                        }
                    } else {
                        y_a -= y_b;
                        y_b -= y_c;
                        y_c = lineOffsets[y_c];
                        while(--y_b >= 0) {
                            drawShadedLine(Rasterizer.destinationPixels, y_c, x_c >> 16, x_a >> 16, z_c >> 7, z_a >> 7);
                            x_a += x_b_off;
                            x_c += x_c_off;
                            z_a += z_b_off;
                            z_c += z_c_off;
                            y_c += Rasterizer.destinationWidth;
                        }
                        while(--y_a >= 0) {
                            drawShadedLine(Rasterizer.destinationPixels, y_c, x_c >> 16, x_b >> 16, z_c >> 7, z_b >> 7);
                            x_b += x_a_off;
                            x_c += x_c_off;
                            z_b += z_a_off;
                            z_c += z_c_off;
                            y_c += Rasterizer.destinationWidth;
                        }
                    }
                }
            }
        }
    }

    public static int method707(int arg0, double arg1) {
        double d = (double) (arg0 >> 16) / 256.0;
        double d_50_ = (double) (arg0 >> 8 & 0xff) / 256.0;
        double d_51_ = (double) (arg0 & 0xff) / 256.0;
        d = Math.pow(d, arg1);
        d_50_ = Math.pow(d_50_, arg1);
        d_51_ = Math.pow(d_51_, arg1);
        int i = (int) (d * 256.0);
        int i_52_ = (int) (d_50_ * 256.0);
        int i_53_ = (int) (d_51_ * 256.0);
        return (i << 16) + (i_52_ << 8) + i_53_;
    }

    public static int[] method708(int[] arg0) {
        return method700(Rasterizer.viewportLeft, Rasterizer.viewportTop, Rasterizer.viewportRight, Rasterizer.viewportBottom, arg0);
    }

    public static int method709(int arg0, int arg1) {
        arg1 = (127 - arg1) * (arg0 & 0x7f) >> 7;
        if(arg1 < 2) {
            arg1 = 2;
        } else if(arg1 > 126) {
            arg1 = 126;
        }
        return (arg0 & 0xff80) + arg1;
    }

    public static void method710(int arg0, int arg1) {
        int i = lineOffsets[0];
        int i_54_ = i / Rasterizer.destinationWidth;
        int i_55_ = i - i_54_ * Rasterizer.destinationWidth;
        center_x = arg0 - i_55_;
        center_y = arg1 - i_54_;
        anInt2942 = -center_x;
        anInt2934 = viewportRx - center_x;
        anInt2935 = -center_y;
        anInt2941 = bottomY - center_y;
    }

    public static void method711(double arg0) {
        method714(arg0, 0, 512);
    }

    public static void drawFlatTriangle(int xA, int yA, int xB, int yB, int xC, int yC, int colour) {
        int mAB = 0;
        if(yB != yA) {
            mAB = (xB - xA << 16) / (yB - yA);
        }
        int mBC = 0;
        if(yC != yB) {
            mBC = (xC - xB << 16) / (yC - yB);
        }
        int mCA = 0;
        if(yC != yA) {
            mCA = (xA - xC << 16) / (yA - yC);
        }
        if (yA <= yB && yA <= yC) {
            if(yA >= bottomY) {
                return;
            }
            if(yB > bottomY) {
                yB = bottomY;
            }
            if(yC > bottomY) {
                yC = bottomY;
            }
            if (yB < yC) {
                xC = xA <<= 16;
                if(yA < 0) {
                    xC -= mCA * yA;
                    xA -= mAB * yA;
                    yA = 0;
                }
                xB <<= 16;
                if(yB < 0) {
                    xB -= mBC * yB;
                    yB = 0;
                }
                if(yA != yB && mCA < mAB || yA == yB && mCA > mBC) {
                    yC -= yB;
                    yB -= yA;
                    yA = lineOffsets[yA];
                    while(--yB >= 0) {
                        drawScanLine(Rasterizer.destinationPixels, yA, colour, 0, xC >> 16, xA >> 16);
                        xC += mCA;
                        xA += mAB;
                        yA += Rasterizer.destinationWidth;
                    }
                    while(--yC >= 0) {
                        drawScanLine(Rasterizer.destinationPixels, yA, colour, 0, xC >> 16, xB >> 16);
                        xC += mCA;
                        xB += mBC;
                        yA += Rasterizer.destinationWidth;
                    }
                } else {
                    yC -= yB;
                    yB -= yA;
                    yA = lineOffsets[yA];
                    while(--yB >= 0) {
                        drawScanLine(Rasterizer.destinationPixels, yA, colour, 0, xA >> 16, xC >> 16);
                        xC += mCA;
                        xA += mAB;
                        yA += Rasterizer.destinationWidth;
                    }
                    while(--yC >= 0) {
                        drawScanLine(Rasterizer.destinationPixels, yA, colour, 0, xB >> 16, xC >> 16);
                        xC += mCA;
                        xB += mBC;
                        yA += Rasterizer.destinationWidth;
                    }
                }
            } else {
                xB = xA <<= 16;
                if(yA < 0) {
                    xB -= mCA * yA;
                    xA -= mAB * yA;
                    yA = 0;
                }
                xC <<= 16;
                if(yC < 0) {
                    xC -= mBC * yC;
                    yC = 0;
                }
                if(yA != yC && mCA < mAB || yA == yC && mBC > mAB) {
                    yB -= yC;
                    yC -= yA;
                    yA = lineOffsets[yA];
                    while(--yC >= 0) {
                        drawScanLine(Rasterizer.destinationPixels, yA, colour, 0, xB >> 16, xA >> 16);
                        xB += mCA;
                        xA += mAB;
                        yA += Rasterizer.destinationWidth;
                    }
                    while(--yB >= 0) {
                        drawScanLine(Rasterizer.destinationPixels, yA, colour, 0, xC >> 16, xA >> 16);
                        xC += mBC;
                        xA += mAB;
                        yA += Rasterizer.destinationWidth;
                    }
                } else {
                    yB -= yC;
                    yC -= yA;
                    yA = lineOffsets[yA];
                    while(--yC >= 0) {
                        drawScanLine(Rasterizer.destinationPixels, yA, colour, 0, xA >> 16, xB >> 16);
                        xB += mCA;
                        xA += mAB;
                        yA += Rasterizer.destinationWidth;
                    }
                    while(--yB >= 0) {
                        drawScanLine(Rasterizer.destinationPixels, yA, colour, 0, xA >> 16, xC >> 16);
                        xC += mBC;
                        xA += mAB;
                        yA += Rasterizer.destinationWidth;
                    }
                }
            }
        } else {
            if(yB <= yC) {
                if(yB < bottomY) {
                    if(yC > bottomY) {
                        yC = bottomY;
                    }
                    if(yA > bottomY) {
                        yA = bottomY;
                    }
                    if(yC < yA) {
                        xA = xB <<= 16;
                        if(yB < 0) {
                            xA -= mAB * yB;
                            xB -= mBC * yB;
                            yB = 0;
                        }
                        xC <<= 16;
                        if(yC < 0) {
                            xC -= mCA * yC;
                            yC = 0;
                        }
                        if(yB != yC && mAB < mBC || yB == yC && mAB > mCA) {
                            yA -= yC;
                            yC -= yB;
                            yB = lineOffsets[yB];
                            while(--yC >= 0) {
                                drawScanLine(Rasterizer.destinationPixels, yB, colour, 0, xA >> 16, xB >> 16);
                                xA += mAB;
                                xB += mBC;
                                yB += Rasterizer.destinationWidth;
                            }
                            while(--yA >= 0) {
                                drawScanLine(Rasterizer.destinationPixels, yB, colour, 0, xA >> 16, xC >> 16);
                                xA += mAB;
                                xC += mCA;
                                yB += Rasterizer.destinationWidth;
                            }
                        } else {
                            yA -= yC;
                            yC -= yB;
                            yB = lineOffsets[yB];
                            while(--yC >= 0) {
                                drawScanLine(Rasterizer.destinationPixels, yB, colour, 0, xB >> 16, xA >> 16);
                                xA += mAB;
                                xB += mBC;
                                yB += Rasterizer.destinationWidth;
                            }
                            while(--yA >= 0) {
                                drawScanLine(Rasterizer.destinationPixels, yB, colour, 0, xC >> 16, xA >> 16);
                                xA += mAB;
                                xC += mCA;
                                yB += Rasterizer.destinationWidth;
                            }
                        }
                    } else {
                        xC = xB <<= 16;
                        if(yB < 0) {
                            xC -= mAB * yB;
                            xB -= mBC * yB;
                            yB = 0;
                        }
                        xA <<= 16;
                        if(yA < 0) {
                            xA -= mCA * yA;
                            yA = 0;
                        }
                        if(mAB < mBC) {
                            yC -= yA;
                            yA -= yB;
                            yB = lineOffsets[yB];
                            while(--yA >= 0) {
                                drawScanLine(Rasterizer.destinationPixels, yB, colour, 0, xC >> 16, xB >> 16);
                                xC += mAB;
                                xB += mBC;
                                yB += Rasterizer.destinationWidth;
                            }
                            while(--yC >= 0) {
                                drawScanLine(Rasterizer.destinationPixels, yB, colour, 0, xA >> 16, xB >> 16);
                                xA += mCA;
                                xB += mBC;
                                yB += Rasterizer.destinationWidth;
                            }
                        } else {
                            yC -= yA;
                            yA -= yB;
                            yB = lineOffsets[yB];
                            while(--yA >= 0) {
                                drawScanLine(Rasterizer.destinationPixels, yB, colour, 0, xB >> 16, xC >> 16);
                                xC += mAB;
                                xB += mBC;
                                yB += Rasterizer.destinationWidth;
                            }
                            while(--yC >= 0) {
                                drawScanLine(Rasterizer.destinationPixels, yB, colour, 0, xB >> 16, xA >> 16);
                                xA += mCA;
                                xB += mBC;
                                yB += Rasterizer.destinationWidth;
                            }
                        }
                    }
                }
            } else if(yC < bottomY) {
                if(yA > bottomY) {
                    yA = bottomY;
                }
                if(yB > bottomY) {
                    yB = bottomY;
                }
                if(yA < yB) {
                    xB = xC <<= 16;
                    if(yC < 0) {
                        xB -= mBC * yC;
                        xC -= mCA * yC;
                        yC = 0;
                    }
                    xA <<= 16;
                    if(yA < 0) {
                        xA -= mAB * yA;
                        yA = 0;
                    }
                    if(mBC < mCA) {
                        yB -= yA;
                        yA -= yC;
                        yC = lineOffsets[yC];
                        while(--yA >= 0) {
                            drawScanLine(Rasterizer.destinationPixels, yC, colour, 0, xB >> 16, xC >> 16);
                            xB += mBC;
                            xC += mCA;
                            yC += Rasterizer.destinationWidth;
                        }
                        while(--yB >= 0) {
                            drawScanLine(Rasterizer.destinationPixels, yC, colour, 0, xB >> 16, xA >> 16);
                            xB += mBC;
                            xA += mAB;
                            yC += Rasterizer.destinationWidth;
                        }
                    } else {
                        yB -= yA;
                        yA -= yC;
                        yC = lineOffsets[yC];
                        while(--yA >= 0) {
                            drawScanLine(Rasterizer.destinationPixels, yC, colour, 0, xC >> 16, xB >> 16);
                            xB += mBC;
                            xC += mCA;
                            yC += Rasterizer.destinationWidth;
                        }
                        while(--yB >= 0) {
                            drawScanLine(Rasterizer.destinationPixels, yC, colour, 0, xA >> 16, xB >> 16);
                            xB += mBC;
                            xA += mAB;
                            yC += Rasterizer.destinationWidth;
                        }
                    }
                } else {
                    xA = xC <<= 16;
                    if(yC < 0) {
                        xA -= mBC * yC;
                        xC -= mCA * yC;
                        yC = 0;
                    }
                    xB <<= 16;
                    if(yB < 0) {
                        xB -= mAB * yB;
                        yB = 0;
                    }
                    if(mBC < mCA) {
                        yA -= yB;
                        yB -= yC;
                        yC = lineOffsets[yC];
                        while(--yB >= 0) {
                            drawScanLine(Rasterizer.destinationPixels, yC, colour, 0, xA >> 16, xC >> 16);
                            xA += mBC;
                            xC += mCA;
                            yC += Rasterizer.destinationWidth;
                        }
                        while(--yA >= 0) {
                            drawScanLine(Rasterizer.destinationPixels, yC, colour, 0, xB >> 16, xC >> 16);
                            xB += mAB;
                            xC += mCA;
                            yC += Rasterizer.destinationWidth;
                        }
                    } else {
                        yA -= yB;
                        yB -= yC;
                        yC = lineOffsets[yC];
                        while(--yB >= 0) {
                            drawScanLine(Rasterizer.destinationPixels, yC, colour, 0, xC >> 16, xA >> 16);
                            xA += mBC;
                            xC += mCA;
                            yC += Rasterizer.destinationWidth;
                        }
                        while(--yA >= 0) {
                            drawScanLine(Rasterizer.destinationPixels, yC, colour, 0, xC >> 16, xB >> 16);
                            xB += mAB;
                            xC += mCA;
                            yC += Rasterizer.destinationWidth;
                        }
                    }
                }
            }
        }
    }

    public static int[] method713() {
        return lineOffsets;
    }

    public static void method714(double arg0, int arg1, int arg2) {
        arg0 += Math.random() * 0.03 - 0.015;
        int i = arg1 * 128;
        for(int i_58_ = arg1; i_58_ < arg2; i_58_++) {
            double d = (double) (i_58_ >> 3) / 64.0 + 0.0078125;
            double d_59_ = (double) (i_58_ & 0x7) / 8.0 + 0.0625;
            for(int i_60_ = 0; i_60_ < 128; i_60_++) {
                double d_61_ = (double) i_60_ / 128.0;
                double d_62_ = d_61_;
                double d_63_ = d_61_;
                double d_64_ = d_61_;
                if(d_59_ != 0.0) {
                    double d_65_;
                    if(d_61_ < 0.5) {
                        d_65_ = d_61_ * (1.0 + d_59_);
                    } else {
                        d_65_ = d_61_ + d_59_ - d_61_ * d_59_;
                    }
                    double d_66_ = 2.0 * d_61_ - d_65_;
                    double d_67_ = d + 0.3333333333333333;
                    if(d_67_ > 1.0) {
                        d_67_--;
                    }
                    double d_68_ = d;
                    double d_69_ = d - 0.3333333333333333;
                    if(d_69_ < 0.0) {
                        d_69_++;
                    }
                    if(6.0 * d_67_ < 1.0) {
                        d_62_ = d_66_ + (d_65_ - d_66_) * 6.0 * d_67_;
                    } else if(2.0 * d_67_ < 1.0) {
                        d_62_ = d_65_;
                    } else if(3.0 * d_67_ < 2.0) {
                        d_62_ = d_66_ + ((d_65_ - d_66_) * (0.6666666666666666 - d_67_) * 6.0);
                    } else {
                        d_62_ = d_66_;
                    }
                    if(6.0 * d_68_ < 1.0) {
                        d_63_ = d_66_ + (d_65_ - d_66_) * 6.0 * d_68_;
                    } else if(2.0 * d_68_ < 1.0) {
                        d_63_ = d_65_;
                    } else if(3.0 * d_68_ < 2.0) {
                        d_63_ = d_66_ + ((d_65_ - d_66_) * (0.6666666666666666 - d_68_) * 6.0);
                    } else {
                        d_63_ = d_66_;
                    }
                    if(6.0 * d_69_ < 1.0) {
                        d_64_ = d_66_ + (d_65_ - d_66_) * 6.0 * d_69_;
                    } else if(2.0 * d_69_ < 1.0) {
                        d_64_ = d_65_;
                    } else if(3.0 * d_69_ < 2.0) {
                        d_64_ = d_66_ + ((d_65_ - d_66_) * (0.6666666666666666 - d_69_) * 6.0);
                    } else {
                        d_64_ = d_66_;
                    }
                }
                int i_70_ = (int) (d_62_ * 256.0);
                int i_71_ = (int) (d_63_ * 256.0);
                int i_72_ = (int) (d_64_ * 256.0);
                int i_73_ = (i_70_ << 16) + (i_71_ << 8) + i_72_;
                i_73_ = method707(i_73_, arg0);
                if(i_73_ == 0) {
                    i_73_ = 1;
                }
                hsl2rgb[i++] = i_73_;
            }
        }
    }
}
