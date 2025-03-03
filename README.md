# Kotlin/Native interop with Rust

Kotlin/Native and Rust Interop with Gradle support

# Prerequisites
MSRV is 1.85 (stable), Rust 2024 edition,
 
IntelliJ Idea, uses kotlin version 2.1.10 and

Linux (Ubuntu/Debian based).

(This is what I used. The versions should not be a problem)

# Building Rust(CLI)
To get the shared library, run this command inside rust/demo folder:

```
cargo b --release
```

A file named libdemo.so should be generated in the
target/release folder of the cargo project

Move the library to /src/nativeDemo/cinterop/libs folder for proper functionality,
or modify the gradle files.

# Running the executable(CLI)
To run the executable, run the following commands
in the root folder of the project:

```
chmod +x gradlew
```

Then, do this:

```
./gradlew runReleaseExecutableLinuxX64
```

Hopefully, you should see the following:

>Task :runReleaseExecutableLinuxX64
>
>15.0
>
>
>BUILD SUCCESSFUL in 4s
>
>4 actionable tasks: 1 executed, 3 up-to-date

Hope this project is useful!
