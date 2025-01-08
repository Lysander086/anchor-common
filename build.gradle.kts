import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm")
//    `publishing-conventions`
}

allprojects {

    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
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
//    apply(plugin = "publishing-conventions")

    dependencies {
        compileOnly("org.projectlombok:lombok:1.18.36")
        testImplementation("org.junit:junit-bom:5.7.2")
        testImplementation("org.junit.jupiter:junit-jupiter-api")
    }


}

tasks.named("build") {
    finalizedBy("publishToMavenLocal")
}

tasks.jar {
    manifest {
        attributes(
            mapOf(
                "Implementation-Title" to project.name,
                "Implementation-Version" to project.version
            )
        )
    }
}

// ingz build タスクにはルート モジュールのみが含まれますが、サブモジュールは公開されません。