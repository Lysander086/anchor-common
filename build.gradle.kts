import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm"
}

allprojects {
    group = "org.anchor"
    version = "0.0.1-SNAPSHOT"
apply(plugin = "publishing-conventions")
    repositories {
        mavenLocal()
        gradlePluginPortal()
        mavenCentral()
        google()
    }

    tasks.withType<KotlinCompile> {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
    }
}

subprojects {
    apply(plugin = "java")
    dependencies {
        compileOnly("org.projectlombok:lombok:1.18.36")
        testImplementation("org.junit:junit-bom:5.7.2")
        testImplementation("org.junit.jupiter:junit-jupiter-api")
    }
}

tasks.named("build") {
    finalizedBy("publishToMavenLocal")
}