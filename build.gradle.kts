import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	`kotlin-dsl`
	`java-library`
	id("org.springframework.boot") version Dependencies_gradle.Versions.springboot
	id("io.spring.dependency-management") version Dependencies_gradle.Versions.springDependencyManagement
	// https://plugins.gradle.org/plugin/org.jetbrains.kotlin.jvm
	kotlin("jvm")
	kotlin("plugin.spring") version Dependencies_gradle.Versions.springPlugin
}

group = "org.verita"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
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
