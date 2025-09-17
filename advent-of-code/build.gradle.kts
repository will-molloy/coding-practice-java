plugins {
  scala
}

dependencies {
  implementation(libs.scala.library)
  implementation(libs.scala.parallel.collections)
  implementation(libs.guava)
}

// TODO disabling on Kotlin/Scala atm... too many false positives
spotbugs {
  ignoreFailures.set(true)
}
