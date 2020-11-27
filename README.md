# RuneScape Java Client #435

A RuneScape game client from October of 2006 - the client has been modified specifically for use with RuneJS, a RuneScape game server emulator written in ES6 and TypeScript. **This client is not for OldSchool RuneScape** - it actually pre-dates the very first OSRS client by quite some time. 

The game client is written in Java, as the original was in 2006. As RuneJS is meant to be a learning experience for game content development, there are no plans to create a JavaScript based RuneJS client at this time.

The purpose of this project being open source is to better understand how the game works under the hood, allowing for a better RuneJS game server. Obfuscation cleanup is always welcome! :)

We've no interest in OSRS client hacking, this client exists solely to log into RuneJS and has been modified accordingly.

## Usage

Running the client can be done either with the pre-built client JAR file or by building the Java code and running it manually in an IDE.

### Pre-Built Client

Running the pre-built client requires having Java installed: https://www.java.com/en/

Once installed, go into the `/prebuilt/` and simply double-click the JAR file to run it. Alternatively, if double clicking the JAR does not work, you can use the command `java -jar RuneJS_Client.jar` from the `/prebuilt/` directory.

The client will use a set of default configurations if no file is provided. The default client configuration matches up to the default RuneJS server configuration for quick and easy initial setup. It's highly advised that you generate your own RSA public and private keys for long term use.

To provide your own configurations, create a file named `runejs-client.yaml` in your User Home directory with the following content:

```yaml
net:
  address: 127.0.0.1
  game_port: 43594
cache:
  cacheDir: .runejs_cache
  jaggrabEnabled: false
rsa:
  rsaPub: YOUR_RSA_PUBLIC_KEY
  rsaModulus: YOUR_RSA_PRIVATE_KEY
login:
  useStaticCredentials: false
game:
  roofsEnabled: true
  freeTeleports: false
  debugContextMenu: true
```

Make sure to modify the given configuration for your specific needs.

### Gradle

Gradle provides a wrapper script which downloads the build system to a local cache. This allows you to run the client
without the help of an IDE such as IntelliJ. Gradle is also configured to automatically download dependencies.

The following examples use the unix executable `./gradlew`, however Windows can replace these with `./gradlew.bat`.

**Running via Gradle**

The `application` gradle plugin provides the `run` task, which starts up the Main client class. With this option,
arguments can be provided via `--args`.

```
./gradlew run --args="1 live live highmem members"
```

**Building a Jar**

The `jar` task can be used to build a jar, which is generated in the `build/libs` directory.

```
./gradlew jar
java -jar ./build/libs/435-client-0.1.jar 1 live live highmem members
```
