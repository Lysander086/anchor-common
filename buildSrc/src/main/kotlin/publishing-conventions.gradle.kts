plugins {
    `java-library`
    `maven-publish`
}

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