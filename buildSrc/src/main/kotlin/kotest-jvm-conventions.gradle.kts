import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins{
   id("java")
}

java {
   withJavadocJar()
   withSourcesJar()
}

// TODO Lysander 2022: what is this for?
tasks.withType<Test>().configureEach {
   useJUnitPlatform()
}



tasks.withType<KotlinCompile>().configureEach {
   // TODO Lysander 2022: what is this for?
   kotlinOptions {
      freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
      jvmTarget = "17"
   }
}

repositories {
   mavenLocal()
   mavenCentral()
   gradlePluginPortal() // tvOS builds need to be able to fetch a kotlin gradle plugin
}
