package com.willmolloy.hackerrank.regex.applications.medium;

import static com.google.common.truth.Truth.assertThat;
import static com.willmolloy.hackerrank.regex.applications.medium.BuildingASmartIdeProgrammingLanguageDetection.detectLanguage;

import com.willmolloy.hackerrank.regex.applications.medium.BuildingASmartIdeProgrammingLanguageDetection.Language;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * BuildingASmartIdeProgrammingLanguageDetectionTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class BuildingASmartIdeProgrammingLanguageDetectionTest {

  @Test
  void java() {
    assertThat(detectLanguage(List.of("import java.io.BufferedReader;"))).isEqualTo(Language.JAVA);
  }

  @Test
  void c() {
    assertThat(detectLanguage(List.of("#include<stdio.h>"))).isEqualTo(Language.C);
  }

  @Test
  void python() {
    assertThat(
            detectLanguage(
                List.of(
                    "# You can use Lists as Stacks in Python",
                    "stack = [10,9,8,7,6,5]",
                    "# Original contents of the stack",
                    "print \"Original Contents of the Stack\"",
                    "print stack",
                    "# Appending to a list is the same as pushing to a stack",
                    "stack.append(1)",
                    "stack.append(2)",
                    "# In the two steps above we push 1 and 2 onto the stack",
                    "print \"After pushing 1 and 2 onto the stack it looks like:\"",
                    "print stack")))
        .isEqualTo(Language.PYTHON);
  }
}
