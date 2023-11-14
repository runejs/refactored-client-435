package org.runejs.client.cache;

/**
 * Represents a mapping between a list of file ids and their corresponding hash.
 *
 * These are stored as a list of pairs, that is:
 *  - element `0`: hashed file #1 name
 *  - element `1`: file #1 id
 *  - element `2`: hashed file #2 name
 *  - element `3`: file #2 id
 */
public class NameHashCollection {
    private static final int NOT_FOUND = -1;

    private int[] hashTable;

    public NameHashCollection(int[] nameHashes) {
        int size = calculateInitialSize(nameHashes.length);
        hashTable = new int[size * 2];

        // initialise the table with empty values
        for(int i = 0; hashTable.length > i; i++)
            hashTable[i] = -1;

        populateHashTable(size, nameHashes);
    }

    public int getIdByName(int nameHash) {
        int size = hashTable.length - 2;
        int current = nameHash << 1 & size;

        while (hashTable[current] != NOT_FOUND) {
            if (hashTable[current] == nameHash) {
                return hashTable[current + 1];
            }

            current = (current + 2) & size;
        }

        return NOT_FOUND;
    }

    private void populateHashTable(int size, int[] nameHashes) {
        for(int nameHashIndex = 0; nameHashes.length > nameHashIndex; nameHashIndex++) {
            int firstEmptySlot = findNextAvailableSlot(size, nameHashes[nameHashIndex]);
            hashTable[firstEmptySlot + firstEmptySlot] = nameHashes[nameHashIndex];
            hashTable[1 + firstEmptySlot + firstEmptySlot] = nameHashIndex;
        }
    }

    private int findNextAvailableSlot(int size, int start) {
        int current = start & size - 1;

        while (hashTable[current * 2 + 1] != NOT_FOUND) {
            current = current + 1 & -1 + size;
        }

        return current;
    }

    private int calculateInitialSize(int length) {
        int size = 1;

        while((length >> 1) + length >= size) {
            size <<= 1;
        }

        return size;
    }
}
