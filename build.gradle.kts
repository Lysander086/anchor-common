plugins {
    id("org.jetbrains.kotlin.jvm")
    id("jvm-conventions")
    id("publishing-conventions")
    id("io.gitlab.arturbosch.detekt") version "1.21.0"
}

allprojects {
    group = "org.anchor"
    version = "0.0.1-SNAPSHOT"
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
        google()
    }
}
subprojects {
    apply(plugin = "jvm-conventions")
    apply(plugin = "publishing-conventions")

    tasks.register<Wrapper>("wrapper") {
        gradleVersion = GradleVersion.current().version
    }

    dependencies {
        compileOnly("org.projectlombok:lombok:1.18.36")
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    }

}