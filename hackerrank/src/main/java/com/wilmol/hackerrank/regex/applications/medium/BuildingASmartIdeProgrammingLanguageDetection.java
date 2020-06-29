package com.wilmol.hackerrank.regex.applications.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/programming-language-detection/problem>https://www.hackerrank.com/challenges/programming-language-detection/problem</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Key: exhaustiveness, don't need to check for Python since if its not Java or C it must be
 * Python per the problem statement.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
final class BuildingASmartIdeProgrammingLanguageDetection {

  private BuildingASmartIdeProgrammingLanguageDetection() {}

  /** Language type. */
  enum Language {
    JAVA("Java"),
    C("C"),
    PYTHON("Python");

    private final String language;

    Language(String language) {
      this.language = language;
    }
  }

  static Language detectLanguage(List<String> input) {
    // yes simple but passes all tests lol
    // ideally would strip strings and comments first because they could contain anything
    String join = String.join("", input);
    // (?s) is the inline version of Pattern.DOTALL
    // simple '.contains' regex (kinda redundant but... this is a regex problem)
    if (join.matches("(?s).*#include.*")) {
      return Language.C;
    } else if (join.matches("(?s).*import java.*")) {
      return Language.JAVA;
    } else {
      return Language.PYTHON;
    }
  }

  public static void main(String[] args) throws IOException {
    try (BufferedReader bufferedReader =
        new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
      List<String> input = bufferedReader.lines().collect(Collectors.toList());
      // CHECKSTYLE IGNORE Regexp FOR NEXT 1 LINES
      System.out.println(detectLanguage(input).language);
    }
  }
}
