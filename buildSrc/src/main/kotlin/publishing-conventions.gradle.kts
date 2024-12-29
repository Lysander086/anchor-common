plugins {
    `java-library`
    `maven-publish`
}

val publications: PublicationContainer = (extensions.getByName("publishing") as PublishingExtension).publications


java {
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "org.anchor"
            artifactId = "anchor-common"
            version = "0.0.1-SNAPSHOT"
            from(components["java"])
        }
    }
}