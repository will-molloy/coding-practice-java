import com.diffplug.gradle.spotless.SpotlessExtension
import com.github.spotbugs.snom.Confidence
import com.github.spotbugs.snom.Effort
import com.github.spotbugs.snom.SpotBugsExtension
import com.github.spotbugs.snom.SpotBugsTask
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

logger.quiet("Java version: ${JavaVersion.current()}")
logger.quiet("Gradle version: ${gradle.gradleVersion}")

plugins {
  id("java-library")
  kotlin("jvm") version libs.versions.kotlin
  alias(libs.plugins.spotless)
  alias(libs.plugins.spotbugs)
  alias(libs.plugins.buildtimetracker)
}

allprojects {
  group = "com.willmolloy"
  repositories {
    mavenCentral()
  }

  apply(plugin = "java")
  configure<JavaPluginExtension> {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
  }

  apply(plugin = "kotlin")
  configure<KotlinJvmProjectExtension> {
    jvmToolchain(21)
  }

  apply(plugin = "com.diffplug.spotless")
  configure<SpotlessExtension> {
    java {
      removeUnusedImports()
      googleJavaFormat()
      trimTrailingWhitespace()
      endWithNewline()
    }
    kotlin {
      ktlint().editorConfigOverride(mapOf("ktlint_standard_package-name" to "disabled"))
      trimTrailingWhitespace()
      endWithNewline()
    }
    kotlinGradle {
      ktlint().editorConfigOverride(mapOf("ktlint_standard_no-empty-file" to "disabled"))
      trimTrailingWhitespace()
      endWithNewline()
    }
  }

  // TODO detekt for kotlin
  apply(plugin = "checkstyle")
  configure<CheckstyleExtension> {
    toolVersion = "10.12.0"
    configFile = rootProject.file("./checkstyle.xml")
    maxErrors = 0
    maxWarnings = 0
    isIgnoreFailures = false
  }

  apply(plugin = "com.github.spotbugs")
  configure<SpotBugsExtension> {
    effort.set(Effort.MAX)
    reportLevel.set(Confidence.LOW)
    ignoreFailures.set(false)
    excludeFilter.set(rootProject.file("./spotbugs-exclude.xml"))
  }
  tasks.withType<SpotBugsTask> {
    reports.create("html").required.set(true)
  }

  tasks.withType<Test> {
    maxParallelForks = Runtime.getRuntime().availableProcessors()
    useJUnitPlatform()
    testLogging {
      events = setOf(TestLogEvent.FAILED, TestLogEvent.SKIPPED)
      exceptionFormat = TestExceptionFormat.FULL
      showExceptions = true
      showCauses = true
      showStackTraces = true
      afterSuite(
        KotlinClosure2({ desc: TestDescriptor, result: TestResult ->
          if (desc.parent == null) {
            println(
              "Results: ${result.resultType} " +
                "(${result.testCount} test${if (result.testCount > 1) "s" else ""}, " +
                "${result.successfulTestCount} passed, " +
                "${result.failedTestCount} failed, " +
                "${result.skippedTestCount} skipped)",
            )
          }
        }),
      )
    }
    finalizedBy(tasks.withType<JacocoReport>())
  }

  apply(plugin = "jacoco")
  tasks.withType<JacocoReport> {
    reports {
      xml.required.set(true)
    }
  }

  val previewFeatures = emptyList<String>()
  tasks.withType<JavaCompile> {
    options.compilerArgs = previewFeatures
  }
  tasks.withType<Test> {
    jvmArgs = previewFeatures
  }
  tasks.withType<JavaExec> {
    jvmArgs = previewFeatures
  }

  dependencies {
    implementation(rootProject.libs.spotbugs.annotations)

    testImplementation(rootProject.libs.junit)
    testImplementation(rootProject.libs.truth)
    testImplementation(rootProject.libs.mockito.core)
    testImplementation(rootProject.libs.mockito.junit)
    testImplementation(rootProject.libs.guava.testlib)
    testImplementation(project(":testlib"))

    configurations.all {
      exclude(group = "org.assertj")
      resolutionStrategy {
        force("com.google.guava:guava:${rootProject.libs.versions.guava.get()}") // exclude android version
      }
    }
  }
}
