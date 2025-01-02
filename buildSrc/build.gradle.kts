plugins {
    `kotlin-dsl`
    id("org.jetbrains.kotlin.jvm") version "1.8.0"
}

repositories {
    mavenLocal()
    gradlePluginPortal()
    mavenCentral()
    google()
}

dependencies {
    // ingz define the kotlin jvm version also
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
    implementation("org.jetbrains.kotlin:kotlin-script-runtime:1.9.0")
}