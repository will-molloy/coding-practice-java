dependencies {
  val guavaVersion = "33.4.0-jre"
  val log4jVersion = "2.24.3"
  val commonsLangVersion = "3.17.0"
  implementation("com.google.guava:guava:$guavaVersion")
  implementation("org.apache.logging.log4j:log4j-core:$log4jVersion")
  implementation("org.apache.commons:commons-lang3:$commonsLangVersion")
}
