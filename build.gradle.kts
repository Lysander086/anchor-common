plugins {
    kotlin("jvm")
    id("kotest-jvm-conventions")
}

allprojects {
    group = "org.verita"
    version = "0.0.1-SNAPSHOT"
    repositories {
        mavenCentral()
    }
}
