plugins {
    `kotlin-dsl`
    id("org.jetbrains.kotlin.jvm") version "2.0.20"
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

kotlin {
    jvmToolchain(17)
}