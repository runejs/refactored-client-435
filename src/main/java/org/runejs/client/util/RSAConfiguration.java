package org.runejs.client.util;

import java.math.BigInteger;

public class RSAConfiguration {
    public final BigInteger modulus;

    public final BigInteger publicKey;

    public RSAConfiguration(BigInteger modulus, BigInteger publicKey) {
        this.modulus = modulus;
        this.publicKey = publicKey;
    }
}
