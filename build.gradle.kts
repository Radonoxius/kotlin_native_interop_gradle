plugins {
    alias(libs.plugins.kotlinMultiplatform)
}

group = "me.user"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    linuxX64() {
        binaries {
            executable {
                entryPoint = "main"
                linkerOpts = mutableListOf(
                    "-rpath=${project.projectDir}/src/nativeInterop/cinterop/libs",
                    "-ldemo"
                )
            }
        }

        compilations.getByName("main") {
            cinterops {
                val demo by creating {
                    definitionFile.set(project.file("src/nativeInterop/cinterop/demo.def"))
                    packageName("demo")
                    includeDirs("src/nativeInterop/cinterop")
                    compilerOpts("-L${project.projectDir}/src/nativeInterop/cinterop/libs", "-ldemo")
                }
            }
        }

        compilations.getByName("test") {
            cinterops {
                val demo by creating {
                    definitionFile.set(project.file("src/nativeInterop/cinterop/demo.def"))
                    packageName("demo")
                    includeDirs("src/nativeInterop/cinterop")
                    compilerOpts("-L${project.projectDir}/src/nativeInterop/cinterop/libs", "-ldemo")
                }
            }
        }
    }

    sourceSets {
        linuxX64Main.dependencies {
        }
    }
}
