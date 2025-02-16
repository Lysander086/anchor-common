plugins {
    id("org.jetbrains.kotlin.jvm")
    id("java")
    idea
    id("com.github.ben-manes.versions") version "0.47.0"
}

allprojects {
    apply(plugin = "test-convention")
    apply(plugin = "dependency-convention")
    apply(plugin = "java-library")
}

idea {
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}

subprojects {
    apply(plugin = "publishing-conventions")

    dependencies {
        compileOnly("org.projectlombok:lombok:1.18.36")
    }
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

