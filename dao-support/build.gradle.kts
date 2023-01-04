import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // specify that we use kotlin instead of java to develop
    kotlin("jvm")
    id("org.springframework.boot") version Dependencies_gradle.VersionManagement.springboot
    // help manage the version of the spring-related dependencies
    id("io.spring.dependency-management") version Dependencies_gradle.VersionManagement.springDependencyManagement
    // Kotlin has classes and their members final by default, which makes it inconvenient to use frameworks and libraries such as Spring AOP that require classes to be open. You can enable the kotlin-spring compiler plugin instead of specifying Spring annotations manually, to mark the class as open without explicitly specifying it.
    kotlin("plugin.spring") version Dependencies_gradle.VersionManagement.springPlugin
    // kotlin-jpa is wrapped on top of no-arg. The plugin specifies @Entity, @Embeddable, and @MappedSuperclass no-arg annotations automatically.
    id("org.jetbrains.kotlin.plugin.jpa") version Dependencies_gradle.VersionManagement.Kotlin.version
}


dependencies {
    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib-jdk8"))
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    //  Spring Boot provides a number of starters that allow us to add jars in the classpath. Spring Boot built-in starters make development easier and rapid. Spring Boot Starters are the dependency descriptors.
    implementation("org.springframework.boot:spring-boot-starter")
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