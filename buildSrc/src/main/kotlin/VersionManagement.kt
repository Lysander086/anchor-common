import org.gradle.api.JavaVersion

object VersionManagement {
    const val springboot = "3.0.0"
    const val springDependencyManagement = "1.1.0"
    const val springPlugin = "1.8.0"


    object Java {
        const val jvmTarget = "17"
        val version = JavaVersion.VERSION_17
    }

    object Kotlin {
        const val version = "1.8.0"
    }
}

