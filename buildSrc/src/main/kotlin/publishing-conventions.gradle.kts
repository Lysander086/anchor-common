plugins {
    `java-library`
    `maven-publish`
}

java {
    withJavadocJar()
    withSourcesJar()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.20")
    implementation("org.jetbrains.kotlin:kotlin-script-runtime:1.9.0")
}

val groupName = "org.anchor"
val versionVal = "1.0.0"

val baseName = "anchor-common"

val projectName = project.name

publishing {

    tasks.withType<PublishToMavenRepository>().configureEach {
        doFirst {
            println("Starting publication to Maven repository...")
        }
    }

    publications {
        create<MavenPublication>("maven") {
            groupId = groupName
            artifactId = baseName+"_" + project.name
            version =  versionVal

            from(components["java"])
        }
    }

    tasks.withType<PublishToMavenRepository>().configureEach {
        doLast {
            println("Publication to Maven repository completed.")
        }
    }
}


