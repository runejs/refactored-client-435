# RuneJS Java Client #435

A RuneScape game client from October 2006 which has been modified to work with RuneJS, a RuneScape game server written in NodeJS and TypeScript. **This client is not for OldSchool RuneScape** - client #435 pre-dates the very first OSRS client by quite some time. 

We've no interest in OSRS client hacking, this client exists as a means to develop on RuneJS game servers and will not work with other server emulators.

## Usage

Running the client can be done either with the pre-built client JAR file or by building the Java code and running it manually in an IDE.

### Pre-Built Client

Running the pre-built client requires having Java installed: https://www.java.com/en/

Once installed, go into the `/prebuilt/` and simply double-click the JAR file to run it. Alternatively, if double clicking the JAR does not work, you can use the command `java -jar client-435.jar` from the `/prebuilt/` directory.

The client will use a set of default configurations if no file is provided. The default client configuration matches up to the default RuneJS server configuration for quick and easy initial setup. It's highly advised that you generate your own RSA public and private keys for long term use.

To provide your own configurations, create a file named `client-435.conf.yaml` in your User Home directory with the following content:

```yaml
net:
  address: 127.0.0.1
  game_port: 43594
cache:
  cacheDir: .filestore_435
rsa:
  rsaPub: YOUR_RSA_PUBLIC_KEY (default dev pair provided in the example file)
  rsaModulus: YOUR_RSA_PRIVATE_KEY (default dev pair provided in the example file)
login:
  useStaticCredentials: true
  username: a
  password: a
game:
  roofsEnabled: true
  freeTeleports: false
  debugContextMenu: true
serverDisplayName: Build 435
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
./gradlew run
```

**Building a Jar**

The `jar` task can be used to build a jar, which is generated in the `build/libs` directory.

```
./gradlew jar
java -jar ./build/libs/client-435-0.1.jar
```
