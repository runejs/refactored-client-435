package com.jagex.runescape.scene.tile;

public class ComplexTile {
    public static int[] screenY = new int[6];
    public static int[] viewspaceZ = new int[6];
    public static int[] screenX = new int[6];
    public static int[] viewspaceX = new int[6];
    public static int[][] shapedTileElementData = new int[][]{{0, 1, 2, 3, 0, 0, 1, 3}, {1, 1, 2, 3, 1, 0, 1, 3}, {0, 1, 2, 3, 1, 0, 1, 3}, {0, 0, 1, 2, 0, 0, 2, 4, 1, 0, 4, 3}, {0, 0, 1, 4, 0, 0, 4, 3, 1, 1, 2, 4}, {0, 0, 4, 3, 1, 0, 1, 2, 1, 0, 2, 4}, {0, 1, 2, 4, 1, 0, 1, 4, 1, 0, 4, 3}, {0, 4, 1, 2, 0, 4, 2, 5, 1, 0, 4, 5, 1, 0, 5, 3}, {0, 4, 1, 2, 0, 4, 2, 3, 0, 4, 3, 5, 1, 0, 4, 5}, {0, 0, 4, 5, 1, 4, 1, 2, 1, 4, 2, 3, 1, 4, 3, 5}, {0, 0, 1, 5, 0, 1, 4, 5, 0, 1, 2, 4, 1, 0, 5, 3, 1, 5, 4, 3, 1, 4, 2, 3}, {1, 0, 1, 5, 1, 1, 4, 5, 1, 1, 2, 4, 0, 0, 5, 3, 0, 5, 4, 3, 0, 4, 2, 3}, {1, 0, 5, 4, 1, 0, 1, 5, 0, 0, 4, 3, 0, 4, 5, 3, 0, 5, 2, 3, 0, 1, 2, 5}};
    public static int[] viewspaceY = new int[6];
    public static int[][] shapedTilePointData = new int[][]{{1, 3, 5, 7}, {1, 3, 5, 7}, {1, 3, 5, 7}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 6}, {1, 3, 5, 7, 2, 6}, {1, 3, 5, 7, 2, 8}, {1, 3, 5, 7, 2, 8}, {1, 3, 5, 7, 11, 12}, {1, 3, 5, 7, 11, 12}, {1, 3, 5, 7, 13, 14}};

    public int[] originalVertexX;
    public int[] triangleTexture;
    public int[] triangleB;
    public int rotation;
    public boolean flat = true;
    public int overlayRGB;
    public int[] triangleHSLA;
    public int[] triangleC;
    public int[] triangleHSLB;
    public int[] triangleHSLC;
    public int shape;
    public int[] triangleA;
    public int[] originalVertexY;
    public int[] originalVertexZ;
    public int underlayRGB;

    public ComplexTile(int tileX, int yA, int yB, int yC, int yD, int tileZ, int rotation, int texture, int shape, int cA, int cAA, int cB, int cBA, int cD, int cDA, int cC, int cCA, int overlayRGB, int underlayRGB) {
        if(yA != yB || yA != yD || yA != yC)
            flat = false;
        this.shape = shape;
        this.rotation = rotation;
        this.underlayRGB = underlayRGB;
        this.overlayRGB = overlayRGB;
        int c = 128;
        int i5 = c / 2;
        int j5 = c / 4;
        int k5 = c * 3 / 4;
        int[] shapedTileMesh = shapedTilePointData[shape];
        int shapedTileMeshLength = shapedTileMesh.length;
        originalVertexX = new int[shapedTileMeshLength];
        originalVertexY = new int[shapedTileMeshLength];
        originalVertexZ = new int[shapedTileMeshLength];
        int[] vertexColourOverlay = new int[shapedTileMeshLength];
        int[] vertexColourUnderlay = new int[shapedTileMeshLength];
        int i6 = tileX * c;
        int j6 = tileZ * c;
        for(int vertex = 0; vertex < shapedTileMeshLength; vertex++) {
            int vertexType = shapedTileMesh[vertex];
            if((vertexType & 0x1) == 0 && vertexType <= 8)
                vertexType = (vertexType - rotation - rotation - 1 & 0x7) + 1;
            if(vertexType > 8 && vertexType <= 12)
                vertexType = (vertexType - 9 - rotation & 0x3) + 9;
            if(vertexType > 12 && vertexType <= 16)
                vertexType = (vertexType - 13 - rotation & 0x3) + 13;
            int vertexX;
            int vertexZ;
            int vertexY;
            int vertexCOverlay;
            int vertexCUnderlay;
            if(vertexType == 1) {
                vertexX = i6;
                vertexZ = j6;
                vertexY = yA;
                vertexCOverlay = cA;
                vertexCUnderlay = cAA;
            } else if(vertexType == 2) {
                vertexX = i6 + i5;
                vertexZ = j6;
                vertexY = yA + yB >> 1;
                vertexCOverlay = cA + cB >> 1;
                vertexCUnderlay = cAA + cBA >> 1;
            } else if(vertexType == 3) {
                vertexX = i6 + c;
                vertexZ = j6;
                vertexY = yB;
                vertexCOverlay = cB;
                vertexCUnderlay = cBA;
            } else if(vertexType == 4) {
                vertexX = i6 + c;
                vertexZ = j6 + i5;
                vertexY = yB + yD >> 1;
                vertexCOverlay = cB + cD >> 1;
                vertexCUnderlay = cBA + cDA >> 1;
            } else if(vertexType == 5) {
                vertexX = i6 + c;
                vertexZ = j6 + c;
                vertexY = yD;
                vertexCOverlay = cD;
                vertexCUnderlay = cDA;
            } else if(vertexType == 6) {
                vertexX = i6 + i5;
                vertexZ = j6 + c;
                vertexY = yD + yC >> 1;
                vertexCOverlay = cD + cC >> 1;
                vertexCUnderlay = cDA + cCA >> 1;
            } else if(vertexType == 7) {
                vertexX = i6;
                vertexZ = j6 + c;
                vertexY = yC;
                vertexCOverlay = cC;
                vertexCUnderlay = cCA;
            } else if(vertexType == 8) {
                vertexX = i6;
                vertexZ = j6 + i5;
                vertexY = yC + yA >> 1;
                vertexCOverlay = cC + cA >> 1;
                vertexCUnderlay = cCA + cAA >> 1;
            } else if(vertexType == 9) {
                vertexX = i6 + i5;
                vertexZ = j6 + j5;
                vertexY = yA + yB >> 1;
                vertexCOverlay = cA + cB >> 1;
                vertexCUnderlay = cAA + cBA >> 1;
            } else if(vertexType == 10) {
                vertexX = i6 + k5;
                vertexZ = j6 + i5;
                vertexY = yB + yD >> 1;
                vertexCOverlay = cB + cD >> 1;
                vertexCUnderlay = cBA + cDA >> 1;
            } else if(vertexType == 11) {
                vertexX = i6 + i5;
                vertexZ = j6 + k5;
                vertexY = yD + yC >> 1;
                vertexCOverlay = cD + cC >> 1;
                vertexCUnderlay = cDA + cCA >> 1;
            } else if(vertexType == 12) {
                vertexX = i6 + j5;
                vertexZ = j6 + i5;
                vertexY = yC + yA >> 1;
                vertexCOverlay = cC + cA >> 1;
                vertexCUnderlay = cCA + cAA >> 1;
            } else if(vertexType == 13) {
                vertexX = i6 + j5;
                vertexZ = j6 + j5;
                vertexY = yA;
                vertexCOverlay = cA;
                vertexCUnderlay = cAA;
            } else if(vertexType == 14) {
                vertexX = i6 + k5;
                vertexZ = j6 + j5;
                vertexY = yB;
                vertexCOverlay = cB;
                vertexCUnderlay = cBA;
            } else if(vertexType == 15) {
                vertexX = i6 + k5;
                vertexZ = j6 + k5;
                vertexY = yD;
                vertexCOverlay = cD;
                vertexCUnderlay = cDA;
            } else {
                vertexX = i6 + j5;
                vertexZ = j6 + k5;
                vertexY = yC;
                vertexCOverlay = cC;
                vertexCUnderlay = cCA;
            }
            originalVertexX[vertex] = vertexX;
            originalVertexY[vertex] = vertexY;
            originalVertexZ[vertex] = vertexZ;
            vertexColourOverlay[vertex] = vertexCOverlay;
            vertexColourUnderlay[vertex] = vertexCUnderlay;
        }
        int[] shapedTileElements = shapedTileElementData[shape];
        int vertexCount = shapedTileElements.length / 4;
        triangleA = new int[vertexCount];
        triangleB = new int[vertexCount];
        triangleC = new int[vertexCount];
        triangleHSLA = new int[vertexCount];
        triangleHSLB = new int[vertexCount];
        triangleHSLC = new int[vertexCount];
        if(texture != -1)
            triangleTexture = new int[vertexCount];
        int offset = 0;
        for(int vertex = 0; vertex < vertexCount; vertex++) {
            int overlayOrUnderlay = shapedTileElements[offset];
            int idxA = shapedTileElements[offset + 1];
            int idxB = shapedTileElements[offset + 2];
            int idxC = shapedTileElements[offset + 3];
            offset += 4;
            if(idxA < 4)
                idxA = idxA - rotation & 0x3;
            if(idxB < 4)
                idxB = idxB - rotation & 0x3;
            if(idxC < 4)
                idxC = idxC - rotation & 0x3;
            triangleA[vertex] = idxA;
            triangleB[vertex] = idxB;
            triangleC[vertex] = idxC;
            if(overlayOrUnderlay == 0) {
                triangleHSLA[vertex] = vertexColourOverlay[idxA];
                triangleHSLB[vertex] = vertexColourOverlay[idxB];
                triangleHSLC[vertex] = vertexColourOverlay[idxC];
                if(triangleTexture != null)
                    triangleTexture[vertex] = -1;
            } else {
                triangleHSLA[vertex] = vertexColourUnderlay[idxA];
                triangleHSLB[vertex] = vertexColourUnderlay[idxB];
                triangleHSLC[vertex] = vertexColourUnderlay[idxC];
                if(triangleTexture != null)
                    triangleTexture[vertex] = texture;
            }
        }
        int i9 = yA;
        int l9 = yB;
        if(yB < i9)
            i9 = yB;
        if(yB > l9)
            l9 = yB;
        if(yD < i9)
            i9 = yD;
        if(yD > l9)
            l9 = yD;
        if(yC < i9)
            i9 = yC;
        if(yC > l9)
            l9 = yC;
        i9 /= 14;
        l9 /= 14;
    }

    public static void method239() {
        screenX = null;
        screenY = null;
        viewspaceX = null;
        viewspaceY = null;
        viewspaceZ = null;
        shapedTilePointData = null;
        shapedTileElementData = null;
    }
}
