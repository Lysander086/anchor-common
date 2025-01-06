plugins {
    kotlin("jvm")
    `java-library`
    `maven-publish`
}

java {
    withJavadocJar()
    withSourcesJar()
}

repositories {
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
    google()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.20")
    implementation("org.jetbrains.kotlin:kotlin-script-runtime:1.9.0")
}

group = "org.anchor"
version = "1.0.0"


val libraryName = "anchor-common"

publishing {
    publications {
        create<MavenPublication>(libraryName) {
            from(components["java"])
        }
    }

    repositories {
        mavenLocal()
    }
}

kotlin {
    jvmToolchain(17)
}