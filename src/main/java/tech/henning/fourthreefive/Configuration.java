package tech.henning.fourthreefive;

import com.jagex.runescape.RSString;
import com.jagex.runescape.language.Native;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.util.Map;

public class Configuration {


    public static void read() {
        try {
            final Yaml yaml = new Yaml();
            final FileInputStream inputStream = new FileInputStream(new File("./config/client-config.yaml"));
            final Map<String, Object> obj = yaml.load(inputStream);

            final Map<String, Object> net = (Map<String, Object>) obj.get("net");
            final Map<String, Object> cache = (Map<String, Object>) obj.get("cache");
            final Map<String, Object> rsa = (Map<String, Object>) obj.get("rsa");
            final Map<String, Object> login = (Map<String, Object>) obj.get("login");
            final Map<String, Object> game = (Map<String, Object>) obj.get("game");

            SERVER_ADDRESS = (String) net.get("address");
            GAME_PORT = (int) net.get("game_port");
            JAGGRAB_PORT = (int) net.get("jaggrab_port");
            ONDEMAND_PORT = (int) net.get("ondemand_port");
            HTTP_PORT = (int) net.get("http_port");
            CACHE_NAME = (String) cache.get("cacheDir");
            JAGGRAB_ENABLED = (boolean) cache.get("jaggrabEnabled");
            RSA_PUBLIC_KEY = new BigInteger(String.valueOf((int) rsa.get("rsaPub")));
            RSA_MODULUS = (BigInteger) rsa.get("rsaModulus");
            USE_STATIC_DETAILS = (boolean) login.get("useStaticCredentials");
            USERNAME = (String) login.get("username");
            PASSWORD = (String) login.get("password");
            ROOFS_ENABLED = (boolean) game.get("roofsEnabled");
            FREE_TELEPORTS = (boolean) game.get("freeTeleports");
            DEBUG_CONTEXT = (boolean) game.get("debugContextMenu");

            if (USERNAME == null) {
                USERNAME = "";
            }

            if (PASSWORD == null) {
                PASSWORD = "";
            }

        } catch (Exception e) {
            System.out.println("Unable to load client-config.yaml. Please use EXAMPLE-client-config.yaml to create one.");
        }
    }

    /**
     * IP Address or Hostname of the server to establish a connection.
     */
    public static String SERVER_ADDRESS = "127.0.0.1";

    /**
     * Name of the cache folder located in the users home directory.
     */
    public static String CACHE_NAME = ".435cache";

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

    public static String USERNAME = "Promises";
    public static String PASSWORD = "Testing";

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