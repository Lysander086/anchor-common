
plugins {
    kotlin("jvm")
    kotlin("plugin.spring") version Dependencies_gradle.VersionManagement.springPlugin
}

group = "org.verita"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

allprojects {
    group = "org.verita"
    version = "0.0.1-SNAPSHOT"
}
