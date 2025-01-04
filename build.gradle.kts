import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("publishing-conventions")
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

//tasks.register("prepareKotlinBuildScriptModel") {}

//tasks.register<Wrapper>("wrapper") {
//    gradleVersion = GradleVersion.current().version
//}