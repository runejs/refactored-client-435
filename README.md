# Refactored Client #435

## Usage

You'll need an update server running to run the client. RuneJS provides an update server for the 435 revision that this client is compatible with. 

This client pairs well with [RuneJS](https://github.com/rune-js), a RuneScape game server written entirely in TypeScript for revision #435 of RuneScape. 

To run the client, use the following arguments: `1 live live highmem members`

### Via Gradle

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