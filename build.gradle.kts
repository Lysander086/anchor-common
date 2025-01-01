plugins {
    kotlin("jvm")
    id("jvm-conventions")
    id("publishing-conventions")
    id("io.gitlab.arturbosch.detekt") version "1.21.0"
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

dependencies{
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.4")
}