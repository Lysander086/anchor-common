import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // specify that we use kotlin instead of java to develop
    kotlin("jvm")
    id("org.springframework.boot") version VersionManagement.springboot
    // help manage the version of the spring-related dependencies
    id("io.spring.dependency-management") version VersionManagement.springDependencyManagement
    // Kotlin has classes and their members final by default, which makes it inconvenient to use frameworks and libraries such as Spring AOP that require classes to be open. You can enable the kotlin-spring compiler plugin instead of specifying Spring annotations manually, to mark the class as open without explicitly specifying it.
    kotlin("plugin.spring") version VersionManagement.springPlugin
    // kotlin-jpa is wrapped on top of no-arg. The plugin specifies @Entity, @Embeddable, and @MappedSuperclass no-arg annotations automatically.
    id("org.jetbrains.kotlin.plugin.jpa") version VersionManagement.Kotlin.version
    id("publishing-conventions")
}


// disable spring boot packaging
tasks.getByName("bootJar") {
    enabled = false
}

tasks.getByName<Jar>("jar") {
    enabled = true
}

dependencies {
    implementation(kotlin("reflect"))
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    //  Spring Boot provides a number of starters that allow us to add jars in the classpath. Spring Boot built-in starters make development easier and rapid. Spring Boot Starters are the dependency descriptors.
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