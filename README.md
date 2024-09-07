# RuneJS Java Client #435

A RuneScape game client from October 2006 which has been modified to work with RuneJS, a RuneScape game server written in NodeJS and TypeScript. **This client is not for OldSchool RuneScape** - client #435 pre-dates the very first OSRS client by quite some time.

We've no interest in OSRS client hacking, this client exists as a means to develop on RuneJS game servers and will not work with other server emulators.

## Usage

Running the client can be done either with the pre-built client `.jar` file from this repository's [releases](https://github.com/runejs/refactored-client-435/releases) page, or by building the Java code and running it manually in an IDE.

### Pre-Built Client

Running the pre-built client requires having Java installed: <https://www.java.com/en/>

Once installed, go to the [releases](https://github.com/runejs/refactored-client-435/releases) page, download the latest release, and simply double-click the `.jar` file  file to run it. Alternatively if executing the `.jar` file does not work, the command `java -jar client-435-0.3.jar` can be used.

The client will use a set of default configurations if no file is provided. The default client configuration matches up to the default RuneJS server configuration for quick and easy initial setup. It's highly advised that you generate your own RSA public and private keys for long term use.

To provide your own configurations, copy the file [`./config/client-435.conf.example.yml`](./config/client-435.conf.example.yaml) to `client-435.conf.yaml` in your user's home directory, and modify the given configuration for your specific needs.

### Gradle

Gradle provides a wrapper script which downloads the build system to a local cache. This allows you to run the client
without the help of an IDE such as IntelliJ. Gradle is also configured to automatically download dependencies.

The following examples use the unix executable `./gradlew`, however Windows can replace these with `./gradlew.bat`.

#### Running via Gradle

The `application` gradle plugin provides the `run` task, which starts up the Main client class. With this option,
arguments can be provided via `--args`.

```bash
./gradlew run
```

#### Building a `.jar` file

The `jar` task can be used to build a jar, which is generated in the `build/libs` directory.

```bash
./gradlew jar
java -jar ./build/libs/client-435-0.3.jar
```

#### Gradle and Java versions

As of 2024-09-04, our manual builds are done with the following Gradle and Java versions - both appear to produce a similar result:

```bash
gradle -v
```

```text
------------------------------------------------------------
Gradle 8.10
------------------------------------------------------------

Build time:    2024-08-14 12:23:39 UTC
Revision:      <unknown>

Kotlin:        1.9.24
Groovy:        3.0.22
Ant:           Apache Ant(TM) version 1.10.14 compiled on August 16 2023
Launcher JVM:  1.8.0_422 (Arch Linux 25.422-b05)
Daemon JVM:    /usr/lib/jvm/java-8-openjdk (no JDK specified, using current Java home)
OS:            Linux 6.10.6-arch1-1 amd64
```

```text
------------------------------------------------------------
Gradle 7.2
------------------------------------------------------------

Build time:   2021-08-17 09:59:03 UTC
Revision:     a773786b58bb28710e3dc96c4d1a7063628952ad

Kotlin:       1.5.21
Groovy:       3.0.8
Ant:          Apache Ant(TM) version 1.10.9 compiled on September 27 2020
JVM:          17.0.10 (Azul Systems, Inc. 17.0.10+7-LTS)
OS:           Mac OS X 14.4.1 aarch64
```

You can also view our [GitHub actions workflow](./.github/workflows/build-and-publish.yml) to see the automated build setup.

## Creating tags and releases

Our [GitHub actions workflow](./.github/workflows/build-and-publish.yml) is configured to build a new `.jar` file upon a `tag` push event. If you create a release in GitHub, the workflow will fail, because its purpose is to *create* the release.

The proper process for creating a new build is as follows:

1. `git fetch --all` (ensures everything is up to date - helps prevent creating a tag that someone else already created)
2. `git pull origin master` (sync your local repository with the latest changes)
3. `git tag -a -s v0.0.X`
4. `git push origin v0.0.X`

Swap out `v0.0.X` for your actual version, and please try to use the `-s` flag if you can - using GPG keys to sign tags is preferred.

In a few minutes, a new `.jar` and release will be ready on the releases page!
