plugins {
    `maven-publish`
}

subprojects {
    apply {
        plugin("maven-publish")
    }

    publishing {
        publications {
            create<MavenPublication>("maven") {
                from(components["java"])
            }
        }
    }
}
