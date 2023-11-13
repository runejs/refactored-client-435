package org.runejs.client.login;

import org.runejs.client.RSString;
import org.runejs.client.util.RSAConfiguration;

public class LoginRequest {
    public final LoginType type;

    public final int[] seeds;

    public final int uid;

    public final RSString username;

    public final RSString password;

    public final RSAConfiguration rsa;

    public final int clientVersion;

    public final boolean lowMemory;

    public final int[] crcs;

    public LoginRequest(LoginType type, int[] seeds, int uid, RSString username, RSString password, RSAConfiguration rsa, int clientVersion, boolean lowMemory, int[] crcs) {
        this.type = type;
        this.seeds = seeds;
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.rsa = rsa;
        this.clientVersion = clientVersion;
        this.lowMemory = lowMemory;
        this.crcs = crcs;
    }
}
