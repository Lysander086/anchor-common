plugins {
    `java-library`
    `maven-publish`
}

val publications: PublicationContainer = (extensions.getByName("publishing") as PublishingExtension).publications

group = "org.verita"
version  = "0.0.1-SNAPSHOT"


val javadoc: TaskProvider<Task> = tasks.named("javadoc")

val javadocJar by tasks.creating(Jar::class) {
    group = JavaBasePlugin.DOCUMENTATION_GROUP
    description = "Assembles java doc to jar"
    archiveClassifier.set("javadoc")
    from(javadoc)
}

publishing {
    publications.withType<MavenPublication>().forEach {
        it.apply {
            artifact(javadocJar)
        }
    }
    publications {
        create<MavenPublication>("verita-library") {
            from(components["java"])  // represents JAR artifact and its metadata
        }
    }
}