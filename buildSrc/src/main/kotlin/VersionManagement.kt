import org.gradle.api.JavaVersion

object VersionManagement {
    const val springboot = "3.0.0"
    const val springDependencyManagement = "1.1.0"
    const val springPlugin = "2.0.20"


    object Java {
        const val jvmTarget = "17"
        val version = JavaVersion.VERSION_17
    }

    object Kotlin {
        const val version = "2.0.20"
    }
}

