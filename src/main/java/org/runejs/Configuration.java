package org.runejs;

import org.runejs.client.RSString;
import org.runejs.client.language.Native;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Configuration {
    static final String clientConfigPath = System.getProperty("user.home") + File.separator + "client-435.conf.yaml";


    public static void read() {
        final File configFile = new File(clientConfigPath);
        try {
            final Yaml yaml = new Yaml();
            final FileInputStream inputStream = new FileInputStream(configFile);

            final Map<String, Object> obj = yaml.load(inputStream);

            final Map<String, Object> net = (Map<String, Object>) obj.get("net");
            final Map<String, Object> cache = (Map<String, Object>) obj.get("cache");
            final Map<String, Object> rsa = (Map<String, Object>) obj.get("rsa");
            final Map<String, Object> login = (Map<String, Object>) obj.get("login");
            final Map<String, Object> game = (Map<String, Object>) obj.get("game");

            SERVER_ADDRESS = (String) net.get("address");
            GAME_PORT = (int) net.get("game_port");
            CACHE_NAME = (String) cache.get("cacheDir");
            RSA_PUBLIC_KEY = new BigInteger(String.valueOf((int) rsa.get("rsaPub")));
            RSA_MODULUS = (BigInteger) rsa.get("rsaModulus");
            USE_STATIC_DETAILS = (boolean) login.get("useStaticCredentials");
            USERNAME = (String) login.get("username");
            PASSWORD = (String) login.get("password");
            ROOFS_ENABLED = (boolean) game.get("roofsEnabled");
            SOUND_MUTED = (boolean) game.get("soundMuted");
            FREE_TELEPORTS = (boolean) game.get("freeTeleports");
            DEBUG_CONTEXT = (boolean) game.get("debugContextMenu");
            SERVER_DISPLAY_NAME = (String) obj.get("serverDisplayName");

            if (USERNAME == null) {
                USERNAME = "";
            }

            if (PASSWORD == null) {
                PASSWORD = "";
            }
            
            if (SERVER_DISPLAY_NAME == null) {
                SERVER_DISPLAY_NAME = "Build 435";
            }

        } catch (Exception e) {
            System.out.println("Unable to load client config - using defaults.");
            Map<String, Object> net = new HashMap<String, Object>();

            net.put("address", SERVER_ADDRESS);
            net.put("game_port", GAME_PORT);

            Map<String, Object> cache = new HashMap<String, Object>();
            cache.put("cacheDir", GAME_PORT);

            Map<String, Object> rsa = new HashMap<String, Object>();
            rsa.put("rsaPub", RSA_PUBLIC_KEY);
            rsa.put("rsaModulus", RSA_MODULUS);

            Map<String, Object> login = new HashMap<String, Object>();
            login.put("useStaticCredentials", USE_STATIC_DETAILS);
            login.put("username", USERNAME);
            login.put("password", PASSWORD);

            Map<String, Object> game = new HashMap<String, Object>();
            game.put("roofsEnabled", ROOFS_ENABLED);
            game.put("freeTeleports", FREE_TELEPORTS);
            game.put("debugContextMenu", DEBUG_CONTEXT);
            game.put("soundMuted", SOUND_MUTED);


            Map<String, Object> clientConfig = new HashMap<String, Object>();
            clientConfig.put("serverDisplayName", SERVER_DISPLAY_NAME);
            clientConfig.put("net", net);
            clientConfig.put("cache", cache);
            clientConfig.put("rsa", rsa);
            clientConfig.put("login", login);
            clientConfig.put("game", game);
            final DumperOptions options = new DumperOptions();
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            options.setPrettyFlow(true);
            Yaml yaml = new Yaml(options);
            try {
                FileWriter writer = new FileWriter(configFile);
                yaml.dump(clientConfig, writer);
            } catch (Exception writeExeption) {
                System.out.println("Failed to write default configuration to disk.");

            }
        }
    }

    /**
     * IP Address or Hostname of the server to establish a connection.
     */
    public static String SERVER_ADDRESS = "127.0.0.1";

    /**
     * Name of the cache folder located in the users home directory.
     */
    public static String CACHE_NAME = ".filestore_435";

    /**
     * Port for establishing a connection to the game server.
     */
    public static int GAME_PORT = 43594;

    /**
     * Port for establishing a connection to the on demand service.
     */
    public static int ONDEMAND_PORT = 43594;

    /**
     * Port for establishing a connection to the update server.
     */
    public static int JAGGRAB_PORT = 43595;

    /**
     * Port for establishing a backup connection to the update
     * server in case the initial JAGGRAB connection fails.
     */
    public static int HTTP_PORT = 80;

    /**
     * Whether or not the update server should be used.
     */
    public static boolean JAGGRAB_ENABLED = false;

    /**
     * Whether or not the network packets should be encrypted.
     */
    public static boolean RSA_ENABLED = true;

    /**
     * Public key to be used in RSA network encryption.
     */
    public static BigInteger RSA_PUBLIC_KEY = new BigInteger("65537");

    /**
     * Modulus to be used in the RSA network encryption.
     */
    public static BigInteger RSA_MODULUS = new BigInteger("119568088839203297999728368933573315070738693395974011872885408638642676871679245723887367232256427712869170521351089799352546294030059890127723509653145359924771433131004387212857375068629466435244653901851504845054452735390701003613803443469723435116497545687393297329052988014281948392136928774011011998343");

    /**
     * Use static username/password pair.
     */
    public static boolean USE_STATIC_DETAILS = true;

    /**
     * Static username and password
     */

    public static String USERNAME = "a";
    public static String PASSWORD = "aaaaa";

    /**
     * Do you want to render roofs
     */
    public static boolean ROOFS_ENABLED = true;

    /**
     * Always light up teleports
     */
    public static boolean FREE_TELEPORTS = true;

    /**
     * When rightclicking objects show id and location
     */
    public static boolean DEBUG_CONTEXT = true;

    /**
     * The display name of the game server to use within the client
     */
    public static String SERVER_DISPLAY_NAME = "Build 435";

    /**
     * When hovering over widgets, show useful information
     */
    public static boolean DEBUG_WIDGETS = false;

    /**
     * Should music be muted, overridden when logged in
     */
    private static boolean SOUND_MUTED = true;

    public static boolean isSoundMuted() {
        return SOUND_MUTED;
    }

    public static void setSoundMuted(boolean soundMuted) {
        SOUND_MUTED = soundMuted;
        final File configFile = new File(clientConfigPath);
        final DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        options.setPrettyFlow(true);
        final Yaml yaml = new Yaml(options);
        try {
            final FileInputStream inputStream = new FileInputStream(configFile);
            final Map<String, Object> obj = yaml.load(inputStream);
            final Map<String, Object> game = (Map<String, Object>) obj.get("game");
            game.put("soundMuted", SOUND_MUTED);
            obj.put("game",game);
            FileWriter writer = new FileWriter(configFile);
            yaml.dump(obj, writer);

        } catch (Exception e) {
            System.out.println("Could not write client config.");
        }


    }

    public static RSString getUsername() {
        if(USE_STATIC_DETAILS) {
            return RSString.CreateString(USERNAME);
        } else{
            return Native.string_blank;
        }
    }


    public static RSString getPassword() {
        if(USE_STATIC_DETAILS) {
            return RSString.CreateString(PASSWORD);
        } else{
            return Native.string_blank;
        }
    }
}
