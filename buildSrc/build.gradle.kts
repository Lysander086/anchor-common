plugins {
    // allow us to use kotlin for gradle build scripts
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    // define the kotlin jvm version also
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.21")
}


