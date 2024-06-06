dependencies {
  val guavaVersion = "33.2.1-jre"
  val log4jVersion = "2.23.1"
  val commonsLangVersion = "3.14.0"
  implementation("com.google.guava:guava:$guavaVersion")
  implementation("org.apache.logging.log4j:log4j-core:$log4jVersion")
  implementation("org.apache.commons:commons-lang3:$commonsLangVersion")
}
