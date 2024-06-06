dependencies {
  val guavaVersion = "33.2.0-jre"
  val log4jVersion = "2.14.1"
  val commonsLangVersion = "3.12.0"
  implementation("com.google.guava:guava:$guavaVersion")
  implementation("org.apache.logging.log4j:log4j-core:$log4jVersion")
  implementation("org.apache.commons:commons-lang3:$commonsLangVersion")
}
