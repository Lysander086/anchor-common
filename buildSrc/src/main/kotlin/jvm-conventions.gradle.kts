import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


// TODO Lysander 2022: what is this for?
tasks.withType<Test>().configureEach {
   useJUnitPlatform()
}

tasks.withType<KotlinCompile>().configureEach {
   // TODO Lysander 2022: what is this for?
   kotlinOptions {
      freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
      jvmTarget = VersionManagement.Java.jvmTarget
   }
}

repositories {
   mavenLocal()
   mavenCentral()
   gradlePluginPortal() // tvOS builds need to be able to fetch a kotlin gradle plugin
}
