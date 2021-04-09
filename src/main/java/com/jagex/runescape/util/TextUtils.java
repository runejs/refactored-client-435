package com.jagex.runescape.util;

public class TextUtils {

    public static final char VALID_CHARACTERS[] = {
            '_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };
    private static char[] message = new char[100];

    public static long nameToLong(String name) {
        long longName = 0L;
        for(int i = 0; i < name.length() && i < 12; i++) {
            char ch = name.charAt(i);
            longName *= 37L;
            if(ch >= 'A' && ch <= 'Z') {
                longName += 1 + ch - 65;
            } else if(ch >= 'a' && ch <= 'z') {
                longName += 1 + ch - 97;
            } else if(ch >= '0' && ch <= '9') {
                longName += 27 + ch - 48;
            }
        }

        for(; longName % 37L == 0L && longName != 0L; longName /= 37L) {
            ;
        }
        return longName;
    }

    public static String longToName(long longName) {
        if(longName <= 0L || longName >= 0x5b5b57f8a98a5dd1L) {
            return "invalid_name";
        }
        if(longName % 37L == 0L) {
            return "invalid_name";
        }
        int length = 0;
        char name[] = new char[12];
        while(longName != 0L) {
            long tmp = longName;
            longName /= 37L;
            name[11 - length++] = VALID_CHARACTERS[(int) (tmp - longName * 37L)];
        }
        return new String(name, 12 - length, length);
    }

    public static long spriteToHash(String sprite) {
        sprite = sprite.toUpperCase();
        long spriteHash = 0L;
        for(int index = 0; index < sprite.length(); index++) {
            spriteHash = spriteHash * 61L + sprite.charAt(index) - 32L;
            spriteHash = spriteHash + (spriteHash >> 56) & 0xffffffffffffffL;
        }
        return spriteHash;
    }

    public static String decodeAddress(int address) {
        return (address >> 24 & 0xff) + "." + (address >> 16 & 0xff) + "." + (address >> 8 & 0xff) + "." +
                (address & 0xff);
    }

    public static String formatName(String name) {
        if(name.length() > 0) {
            char formatedName[] = name.toCharArray();
            for(int pos = 0; pos < formatedName.length; pos++) {
                if(formatedName[pos] == '_') {
                    formatedName[pos] = ' ';
                    if(pos + 1 < formatedName.length && formatedName[pos + 1] >= 'a' && formatedName[pos + 1] <= 'z') {
                        formatedName[pos + 1] = (char) (formatedName[pos + 1] + 65 - 97);
                    }
                }
            }

            if(formatedName[0] >= 'a' && formatedName[0] <= 'z') {
                formatedName[0] = (char) (formatedName[0] + 65 - 97);
            }
            return new String(formatedName);
        } else {
            return name;
        }
    }

    public static String censorPassword(String password) {
        if(password == null || password.length() < 1) {
            return "";
        }

        StringBuffer censoredPassword = new StringBuffer();
        for(int index = 0; index < password.length(); index++) {
            censoredPassword.append("*");
        }
        return censoredPassword.toString();
    }


}
