//Adding the KMP plugin
plugins {
    alias(libs.plugins.kotlinMultiplatform)
}

//Group name and version
group = "me.user"
version = "1.0-SNAPSHOT"

//Repositories to find Dependencies
repositories {
    mavenCentral()
}

kotlin {
    //Defines the folders where the .def and headers are kept
    val nativeLinuxResDir = "src/nativeInterop/cinterop"
    //Defines the folders where native libraries are kept
    val nativeLinuxLibsDir = "$nativeLinuxResDir/libs"
    
    //Add Linux 64 bit target
    linuxX64() {
        binaries {
            //Produces a native linux executable file
            executable {
                //The entry point of the program
                entryPoint = "main"

                //Configure Runtime Path of the executable
                linkerOpts = mutableListOf(
                    "-rpath=${project.projectDir}/$nativeLinuxLibsDir",
                    "-ldemo"
                )
            }
        }

        /* All the headers and .def files should be kept in src/nativeInterop/cinterop/
         * All shared and static libs should be kept in src/nativeInterop/cinterop/libs/
         * This is done to maintain good practices.
         */

        //Settings for Main compilation process
        compilations.getByName("main") {
            cinterops {
                //Create a Cinterop process
                val demo by creating {
                    //Sets the .def file
                    definitionFile.set(project.file("$nativeLinuxResDir/demo.def"))

                    //Sets the package name where the generated bindings will be kept
                    packageName("demo")

                    //Directory to find headers
                    includeDirs(nativeLinuxResDir)
                }
            }
        }

        //Settings for Test compilation process
        compilations.getByName("test") {
            cinterops {
                //Create a Cinterop process
                val demo by creating {
                    //Sets the .def file
                    definitionFile.set(project.file("$nativeLinuxResDir/demo.def"))

                    //Sets the package name where the generated bindings will be kept
                    packageName("demo")

                    //Directory to find headers
                    includeDirs(nativeLinuxResDir)
                }
            }
        }
    }

    sourceSets {
        //Dependencies for Linux 64 bit target
        linuxX64Main.dependencies {
        }
    }
}
