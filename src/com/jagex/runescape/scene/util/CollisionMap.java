package com.jagex.runescape.scene.util;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.def.UnderlayDefinition;

public class CollisionMap {
    public static int anInt141;
    public static Object anObject162 = new Object();
    public static int anInt163 = -1;
    public static int anInt165 = 0;
    public static Class8 aClass8_166;
    public static RSString str_continue = RSString.CreateString("Continue");
    public static int menuHeight;
    public static byte[] aByteArray169 = new byte[]{95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57};
    public static RSString aClass1_170 = RSString.CreateString("(X");
    public static int anInt172;


    public int insetX;
    public int height;
    public int[][] clippingData;
    public int insetY;
    public int width;

    public CollisionMap(int arg0, int arg1) {

        height = arg1;
        insetY = 0;
        insetX = 0;
        width = arg0;
        clippingData = new int[width][height];
        reset();

    }

    public static void method144(int arg0) {

        Class8.fontMetrics = null;
        Class17.helveticaBold = null;
        if(arg0 == 12433)
            Class26.anImage624 = null;

    }

    public static void method152() {
        aByteArray169 = null;
        anObject162 = null;
        str_continue = null;
        aClass1_170 = null;
        aClass8_166 = null;
    }

    public static int method157(int arg0, int arg1, int arg2) {
        int i = (Class42.method884(-1 + arg1, -1 + arg2, 37821) + Class42.method884(1 + arg1, arg2 - 1, 37821) + Class42.method884(-1 + arg1, 1 + arg2, 37821) + Class42.method884(1 + arg1, arg2 + 1, 37821));
        if(arg0 != 0)
            return 56;
        int i_126_ = (Class42.method884(arg1 - 1, arg2, 37821) + Class42.method884(arg1 + 1, arg2, 37821) - (-Class42.method884(arg1, arg2 - 1, 37821) + -Class42.method884(arg1, 1 + arg2, 37821)));
        int i_127_ = Class42.method884(arg1, arg2, 37821);
        return i / 16 - (-(i_126_ / 8) - i_127_ / 4);
    }

    public void unset(int x, int y, int i) {
        clippingData[x][y] = UnderlayDefinition.bitWiseOR(clippingData[x][y], i);
    }

    public void unmarkConcealed(int x, int y) {
        x -= insetX;
        y -= insetY;
        clippingData[x][y] = HuffmanEncoding.method1021(clippingData[x][y], 0xdfffff);
    }

    public void reset() {
        for(int i = 0; width > i; i++) {
            for(int i_0_ = 0; (height > i_0_); i_0_++) {
                if(i != 0 && i_0_ != 0 && i != width - 1 && i_0_ != -1 + height)
                    clippingData[i][i_0_] = 16777216;
                else
                    clippingData[i][i_0_] = 16777215;
            }
        }
    }

    public void markWall(int x, int orientation, boolean impenetrable, int y, int position) {
        x -= insetX;
        y -= insetY;
        if(position == 0) {
            if(orientation == 0) {
                orClipTable(x, y, 128);
                orClipTable(-1 + x, y, 8);
            }
            if(orientation == 1) {
                orClipTable(x, y, 2);
                orClipTable(x, y + 1, 32);
            }
            if(orientation == 2) {
                orClipTable(x, y, 8);
                orClipTable(1 + x, y, 128);
            }
            if(orientation == 3) {
                orClipTable(x, y, 32);
                orClipTable(x, -1 + y, 2);
            }
        }
        if(position == 1 || position == 3) {
            if(orientation == 0) {
                orClipTable(x, y, 1);
                orClipTable(-1 + x, y + 1, 16);
            }
            if(orientation == 1) {
                orClipTable(x, y, 4);
                orClipTable(1 + x, 1 + y, 64);
            }
            if(orientation == 2) {
                orClipTable(x, y, 16);
                orClipTable(x + 1, -1 + y, 1);
            }
            if(orientation == 3) {
                orClipTable(x, y, 64);
                orClipTable(-1 + x, y - 1, 4);
            }
        }
        if(position == 2) {
            if(orientation == 0) {
                orClipTable(x, y, 130);
                orClipTable(-1 + x, y, 8);
                orClipTable(x, y + 1, 32);
            }
            if(orientation == 1) {
                orClipTable(x, y, 10);
                orClipTable(x, 1 + y, 32);
                orClipTable(1 + x, y, 128);
            }
            if(orientation == 2) {
                orClipTable(x, y, 40);
                orClipTable(x + 1, y, 128);
                orClipTable(x, -1 + y, 2);
            }
            if(orientation == 3) {
                orClipTable(x, y, 160);
                orClipTable(x, -1 + y, 2);
                orClipTable(x + -1, y, 8);
            }
        }
        if(impenetrable) {
            if(position == 0) {
                if(orientation == 0) {
                    orClipTable(x, y, 65536);
                    orClipTable(x + -1, y, 4096);
                }
                if(orientation == 1) {
                    orClipTable(x, y, 1024);
                    orClipTable(x, 1 + y, 16384);
                }
                if(orientation == 2) {
                    orClipTable(x, y, 4096);
                    orClipTable(1 + x, y, 65536);
                }
                if(orientation == 3) {
                    orClipTable(x, y, 16384);
                    orClipTable(x, -1 + y, 1024);
                }
            }
            if(position == 1 || position == 3) {
                if(orientation == 0) {
                    orClipTable(x, y, 512);
                    orClipTable(x + -1, y + 1, 8192);
                }
                if(orientation == 1) {
                    orClipTable(x, y, 2048);
                    orClipTable(1 + x, 1 + y, 32768);
                }
                if(orientation == 2) {
                    orClipTable(x, y, 8192);
                    orClipTable(1 + x, y - 1, 512);
                }
                if(orientation == 3) {
                    orClipTable(x, y, 32768);
                    orClipTable(x + -1, y - 1, 2048);
                }
            }
            if(position == 2) {
                if(orientation == 0) {
                    orClipTable(x, y, 66560);
                    orClipTable(x + -1, y, 4096);
                    orClipTable(x, y + 1, 16384);
                }
                if(orientation == 1) {
                    orClipTable(x, y, 5120);
                    orClipTable(x, y + 1, 16384);
                    orClipTable(1 + x, y, 65536);
                }
                if(orientation == 2) {
                    orClipTable(x, y, 20480);
                    orClipTable(1 + x, y, 65536);
                    orClipTable(x, y - 1, 1024);
                }
                if(orientation == 3) {
                    orClipTable(x, y, 81920);
                    orClipTable(x, -1 + y, 1024);
                    orClipTable(-1 + x, y, 4096);
                }
            }
        }
    }

    public void markSolidOccupant(int objectX, int objectY, int objectSizeX, int objectSizeY, int orient, boolean impenetrable) {
        int occupied = 256;
        if(impenetrable)
            occupied += 0x20000;
        objectX -= insetX;
        objectY -= insetY;
        if(orient == 1 || orient == 3) {
            int temp = objectSizeX;
            objectSizeX = objectSizeY;
            objectSizeY = temp;
        }
        for(int x = objectX; (objectSizeX + objectX > x); x++) {
            if(x >= 0 && (x < width)) {
                for(int y = objectY; (objectSizeY + objectY > y); y++) {
                    if(y >= 0 && height > y)
                        orClipTable(x, y, occupied);
                }
            }
        }
    }

    public void unmarkWall(int x, int y, int position, int orientation, boolean impenetrable) {
        x -= insetX;
        y -= insetY;
        if(position == 0) {
            if(orientation == 0) {
                unset(x, y, 128);
                unset(x - 1, y, 8);
            }
            if(orientation == 1) {
                unset(x, y, 2);
                unset(x, 1 + y, 32);
            }
            if(orientation == 2) {
                unset(x, y, 8);
                unset(1 + x, y, 128);
            }
            if(orientation == 3) {
                unset(x, y, 32);
                unset(x, y + -1, 2);
            }
        }
        if(position == 1 || position == 3) {
            if(orientation == 0) {
                unset(x, y, 1);
                unset(-1 + x, y + 1, 16);
            }
            if(orientation == 1) {
                unset(x, y, 4);
                unset(1 + x, 1 + y, 64);
            }
            if(orientation == 2) {
                unset(x, y, 16);
                unset(1 + x, -1 + y, 1);
            }
            if(orientation == 3) {
                unset(x, y, 64);
                unset(-1 + x, y + -1, 4);
            }
        }
        if(position == 2) {
            if(orientation == 0) {
                unset(x, y, 130);
                unset(-1 + x, y, 8);
                unset(x, 1 + y, 32);
            }
            if(orientation == 1) {
                unset(x, y, 10);
                unset(x, 1 + y, 32);
                unset(1 + x, y, 128);
            }
            if(orientation == 2) {
                unset(x, y, 40);
                unset(x + 1, y, 128);
                unset(x, -1 + y, 2);
            }
            if(orientation == 3) {
                unset(x, y, 160);
                unset(x, y - 1, 2);
                unset(x + -1, y, 8);
            }
        }
        if(impenetrable) {
            if(position == 0) {
                if(orientation == 0) {
                    unset(x, y, 65536);
                    unset(-1 + x, y, 4096);
                }
                if(orientation == 1) {
                    unset(x, y, 1024);
                    unset(x, 1 + y, 16384);
                }
                if(orientation == 2) {
                    unset(x, y, 4096);
                    unset(1 + x, y, 65536);
                }
                if(orientation == 3) {
                    unset(x, y, 16384);
                    unset(x, -1 + y, 1024);
                }
            }
            if(position == 1 || position == 3) {
                if(orientation == 0) {
                    unset(x, y, 512);
                    unset(-1 + x, 1 + y, 8192);
                }
                if(orientation == 1) {
                    unset(x, y, 2048);
                    unset(x + 1, y + 1, 32768);
                }
                if(orientation == 2) {
                    unset(x, y, 8192);
                    unset(1 + x, y - 1, 512);
                }
                if(orientation == 3) {
                    unset(x, y, 32768);
                    unset(x - 1, -1 + y, 2048);
                }
            }
            if(position == 2) {
                if(orientation == 0) {
                    unset(x, y, 66560);
                    unset(-1 + x, y, 4096);
                    unset(x, 1 + y, 16384);
                }
                if(orientation == 1) {
                    unset(x, y, 5120);
                    unset(x, y + 1, 16384);
                    unset(1 + x, y, 65536);
                }
                if(orientation == 2) {
                    unset(x, y, 20480);
                    unset(1 + x, y, 65536);
                    unset(x, -1 + y, 1024);
                }
                if(orientation == 3) {
                    unset(x, y, 81920);
                    unset(x, y + -1, 1024);
                    unset(x - 1, y, 4096);
                }
            }
        }
    }

    public void markBlocked(int y, int x) {
        x -= insetX;
        y -= insetY;
        clippingData[x][y] = UnderlayDefinition.bitWiseOR(clippingData[x][y], 2097152);
    }

    public boolean reachedFacingObject(int currentX, int currentY, int goalX, int goalY, int goalDX, int goalDY, int surroundings) {
        int goalX2 = goalX + goalDX + -1;
        int goalY2 = -1 + goalY + goalDY;
        if(goalX <= currentX && goalX2 >= currentX && goalY <= currentY && goalY2 >= currentY)
            return true;
        if(goalX + -1 == currentX && goalY <= currentY && (goalY2 >= currentY) && (clippingData[-insetX + currentX][-insetY + currentY] & 0x8) == 0 && (surroundings & 0x8) == 0)
            return true;
        if(currentX == goalX2 + 1 && goalY <= currentY && currentY <= goalY2 && (clippingData[currentX - insetX][currentY + -insetY] & 0x80) == 0 && (0x2 & surroundings) == 0)
            return true;
        if(goalY - 1 == currentY && goalX <= currentX && goalX2 >= currentX && (clippingData[currentX - insetX][currentY - insetY] & 0x2) == 0 && (surroundings & 0x4) == 0)
            return true;
        return currentY == 1 + goalY2 && currentX >= goalX && currentX <= goalX2 && (clippingData[-insetX + currentX][currentY - insetY] & 0x20) == 0 && (0x1 & surroundings) == 0;
    }

    public void unmarkSolidOccupant(int x, int y, int width, int height, int orientation, boolean impenetrable) {
        int occupied = 256;
        x -= insetX;
        y -= insetY;
        if(impenetrable)
            occupied += 0x20000;
        if(orientation == 1 || orientation == 3) {
            int temp = width;
            width = height;
            height = temp;
        }
        for(int _x = x; _x < x + width; _x++) {
            if(_x >= 0 && _x < this.width) {
                for(int _y = y; (_y < height + y); _y++) {
                    if(_y >= 0 && _y < this.height)
                        unset(_x, _y, occupied);
                }
            }
        }
    }

    public boolean reachedWall(int currentX, int currentY, int goalX, int goalY, int goalPosition, int goalOrientation) {
        if(goalX == currentX && goalY == currentY)
            return true;
        currentX -= insetX;
        goalX -= insetX;
        currentY -= insetY;
        goalY -= insetY;
        if(goalPosition == 0) {
            if(goalOrientation == 0) {
                if(goalX + -1 == currentX && currentY == goalY)
                    return true;
                if(goalX == currentX && currentY == goalY + 1 && (clippingData[currentX][currentY] & 0x1280120) == 0)
                    return true;
                if(goalX == currentX && -1 + goalY == currentY && (0x1280102 & clippingData[currentX][currentY]) == 0)
                    return true;
            } else if(goalOrientation == 1) {
                if(goalX == currentX && 1 + goalY == currentY)
                    return true;
                if(currentX == -1 + goalX && currentY == goalY && ((clippingData[currentX][currentY] & 0x1280108) == 0))
                    return true;
                if(1 + goalX == currentX && currentY == goalY && (clippingData[currentX][currentY] & 0x1280180) == 0)
                    return true;
            } else if(goalOrientation == 2) {
                if(currentX == goalX + 1 && goalY == currentY)
                    return true;
                if(currentX == goalX && currentY == goalY + 1 && ((clippingData[currentX][currentY] & 0x1280120) == 0))
                    return true;
                if(goalX == currentX && currentY == goalY + -1 && ((clippingData[currentX][currentY] & 0x1280102) == 0))
                    return true;
            } else if(goalOrientation == 3) {
                if(goalX == currentX && goalY - 1 == currentY)
                    return true;
                if(-1 + goalX == currentX && goalY == currentY && ((clippingData[currentX][currentY] & 0x1280108) == 0))
                    return true;
                if(currentX == 1 + goalX && currentY == goalY && (0x1280180 & clippingData[currentX][currentY]) == 0)
                    return true;
            }
        }
        if(goalPosition == 2) {
            if(goalOrientation == 0) {
                if(currentX == -1 + goalX && currentY == goalY)
                    return true;
                if(currentX == goalX && currentY == goalY + 1)
                    return true;
                if(currentX == goalX + 1 && goalY == currentY && (clippingData[currentX][currentY] & 0x1280180) == 0)
                    return true;
                if(goalX == currentX && currentY == goalY - 1 && (0x1280102 & clippingData[currentX][currentY]) == 0)
                    return true;
            } else if(goalOrientation == 1) {
                if(currentX == -1 + goalX && currentY == goalY && ((clippingData[currentX][currentY] & 0x1280108) == 0))
                    return true;
                if(currentX == goalX && currentY == goalY + 1)
                    return true;
                if(currentX == goalX + 1 && goalY == currentY)
                    return true;
                if(currentX == goalX && currentY == goalY + -1 && (clippingData[currentX][currentY] & 0x1280102) == 0)
                    return true;
            } else if(goalOrientation == 2) {
                if(goalX + -1 == currentX && currentY == goalY && (clippingData[currentX][currentY] & 0x1280108) == 0)
                    return true;
                if(goalX == currentX && goalY + 1 == currentY && (0x1280120 & clippingData[currentX][currentY]) == 0)
                    return true;
                if(1 + goalX == currentX && goalY == currentY)
                    return true;
                if(currentX == goalX && goalY + -1 == currentY)
                    return true;
            } else if(goalOrientation == 3) {
                if(currentX == -1 + goalX && currentY == goalY)
                    return true;
                if(currentX == goalX && (currentY == goalY + 1) && (0x1280120 & clippingData[currentX][currentY]) == 0)
                    return true;
                if(currentX == goalX + 1 && goalY == currentY && (0x1280180 & clippingData[currentX][currentY]) == 0)
                    return true;
                if(goalX == currentX && goalY + -1 == currentY)
                    return true;
            }
        }
        if(goalPosition == 9) {
            if(goalX == currentX && currentY == 1 + goalY && ((0x20 & clippingData[currentX][currentY]) == 0))
                return true;
            if(currentX == goalX && currentY == -1 + goalY && (0x2 & clippingData[currentX][currentY]) == 0)
                return true;
            if(currentX == -1 + goalX && currentY == goalY && ((0x8 & clippingData[currentX][currentY]) == 0))
                return true;
            return 1 + goalX == currentX && goalY == currentY && ((clippingData[currentX][currentY] & 0x80) == 0);
        }
        return false;
    }

    public void orClipTable(int x, int y, int flag) {
        clippingData[x][y] = HuffmanEncoding.method1021(clippingData[x][y], -flag + 16777215);
    }

    public boolean reachedWallDecoration(int currentX, int currentY, int goalX, int goalY, int goalPosition, int goalOrientation) {
        if(goalX == currentX && currentY == goalY)
            return true;
        currentX -= insetX;
        goalX -= insetX;
        currentY -= insetY;
        goalY -= insetY;
        if(goalPosition == 6 || goalPosition == 7) {
            if(goalPosition == 7)
                goalOrientation = goalOrientation + 2 & 0x3;
            if(goalOrientation == 0) {
                if(1 + goalX == currentX && currentY == goalY && (clippingData[currentX][currentY] & 0x80) == 0)
                    return true;
                if(goalX == currentX && -1 + goalY == currentY && (0x2 & clippingData[currentX][currentY]) == 0)
                    return true;
            } else if(goalOrientation == 1) {
                if(currentX == goalX + -1 && goalY == currentY && ((clippingData[currentX][currentY] & 0x8) == 0))
                    return true;
                if(currentX == goalX && currentY == goalY + -1 && (clippingData[currentX][currentY] & 0x2) == 0)
                    return true;
            } else if(goalOrientation == 2) {
                if(currentX == goalX + -1 && goalY == currentY && (clippingData[currentX][currentY] & 0x8) == 0)
                    return true;
                if(currentX == goalX && currentY == 1 + goalY && (0x20 & clippingData[currentX][currentY]) == 0)
                    return true;
            } else if(goalOrientation == 3) {
                if(goalX + 1 == currentX && goalY == currentY && (clippingData[currentX][currentY] & 0x80) == 0)
                    return true;
                if(currentX == goalX && currentY == goalY + 1 && (0x20 & clippingData[currentX][currentY]) == 0)
                    return true;
            }
        }
        if(goalPosition == 8) {
            if(currentX == goalX && currentY == goalY + 1 && (clippingData[currentX][currentY] & 0x20) == 0)
                return true;
            if(goalX == currentX && currentY == goalY + -1 && (clippingData[currentX][currentY] & 0x2) == 0)
                return true;
            if(currentX == goalX - 1 && goalY == currentY && (clippingData[currentX][currentY] & 0x8) == 0)
                return true;
            return 1 + goalX == currentX && currentY == goalY && ((0x80 & clippingData[currentX][currentY]) == 0);
        }
        return false;
    }
}
