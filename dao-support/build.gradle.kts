import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    id("org.springframework.boot") version Dependencies_gradle.VersionManagement.springboot
    id("io.spring.dependency-management") version Dependencies_gradle.VersionManagement.springDependencyManagement
    // https://plugins.gradle.org/plugin/org.jetbrains.kotlin.jvm
    kotlin("plugin.spring") version Dependencies_gradle.VersionManagement.springPlugin
    id("org.jetbrains.kotlin.plugin.jpa") version Dependencies_gradle.VersionManagement.Kotlin.version
}


dependencies {
    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib-jdk8"))
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter") // might remove TODO Lysander 2022: what is the effect?
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

repositories {
    mavenCentral()
}


tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}