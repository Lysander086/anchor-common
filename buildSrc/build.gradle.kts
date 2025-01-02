plugins {
    `kotlin-dsl`
    id("org.jetbrains.kotlin.jvm") version "2.1.0"
}

repositories {
    mavenLocal()
    gradlePluginPortal()
    mavenCentral()
    google()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.1.0")
    implementation("org.jetbrains.kotlin:kotlin-script-runtime:1.9.0")
}