plugins {
  scala
}

// Allow Scala to access Kotlin
tasks.withType<ScalaCompile> {
  classpath += files(tasks.compileKotlin.get().destinationDirectory)
  if (name == "compileTestScala") {
    classpath += files(tasks.compileTestKotlin.get().destinationDirectory)
  }
}

dependencies {
  implementation(libs.scala.library)
  implementation(libs.scala.parallel.collections)
  implementation(libs.kotlin.coroutines)
}

// TODO disabling on Kotlin/Scala atm... too many false positives
spotbugs {
  ignoreFailures.set(true)
}
