plugins {
    `java-library`
}

repositories {
    mavenLocal()

    gradlePluginPortal()
    google()
}


dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${VersionManagement.Kotlin.VERSION}")
}