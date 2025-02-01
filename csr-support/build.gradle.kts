plugins {
    id("org.springframework.boot") version VersionManagement.springboot
    // help manage the version of the spring-related dependencies
    id("io.spring.dependency-management") version VersionManagement.springDependencyManagement
    // Kotlin has classes and their members final by default, which makes it inconvenient to use frameworks and libraries such as Spring AOP that require classes to be open. You can enable the kotlin-spring compiler plugin instead of specifying Spring annotations manually, to mark the class as open without explicitly specifying it.
    kotlin("plugin.spring") version VersionManagement.springPlugin
    // kotlin-jpa is wrapped on top of no-arg. The plugin specifies @Entity, @Embeddable, and @MappedSuperclass no-arg annotations automatically.
    id("org.jetbrains.kotlin.plugin.jpa") version VersionManagement.Kotlin.version
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
    api("jakarta.persistence:jakarta.persistence-api:3.2.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("com.h2database:h2:2.3.232")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${VersionManagement.Kotlin.version}")
    implementation("org.hibernate:hibernate-core:6.1.5.Final")
}



