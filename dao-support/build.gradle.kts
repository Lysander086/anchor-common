import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    id("org.springframework.boot") version Dependencies_gradle.Versions.springboot
    id("io.spring.dependency-management") version Dependencies_gradle.Versions.springDependencyManagement
    // https://plugins.gradle.org/plugin/org.jetbrains.kotlin.jvm
    kotlin("plugin.spring") version Dependencies_gradle.Versions.springPlugin
    `java-library`
    java

}



dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect") // ingz , could not find the dependency
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")


    implementation("org.springframework.boot:spring-boot-starter")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

repositories {
    gradlePluginPortal() // delz
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