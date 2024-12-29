plugins {
    kotlin("jvm")
    id("jvm-conventions")
    id("publishing-conventions")
}

allprojects {
    group = "org.anchor"
    version = "0.0.1-SNAPSHOT"
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "jvm-conventions")
    apply(plugin = "publishing-conventions")
}