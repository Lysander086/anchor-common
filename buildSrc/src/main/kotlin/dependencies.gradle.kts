plugins {
    `java-library`
    kotlin("jvm")
}

dependencies {
}




object Versions {
    const val springboot = "3.0.0"
    const val springDependencyManagement = "1.1.0"
    const val springPlugin = "1.6.21"


    object Java {
        const val jvmTarget = "17"
        val version = JavaVersion.VERSION_17
    }
}

