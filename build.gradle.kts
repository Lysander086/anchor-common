plugins {
    id("org.jetbrains.kotlin.jvm")
}

allprojects {
    apply(plugin = "test-convention")
    apply(plugin = "dependency-convention")
}

subprojects {
    apply(plugin = "java-library")
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

