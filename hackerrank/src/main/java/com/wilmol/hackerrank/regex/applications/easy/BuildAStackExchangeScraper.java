package com.wilmol.hackerrank.regex.applications.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/stack-exchange-scraper/problem>https://www.hackerrank.com/challenges/stack-exchange-scraper/problem</a>
 *
 * <p>Trick is to find common patterns in the input. (Hence regex Pattern.)
 *
 * <p>Use capturing group to extract information.
 *
 * <p>Runtime: O(n)
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
final class BuildAStackExchangeScraper {

  private BuildAStackExchangeScraper() {}

  private static final Pattern QUESTION_ID = Pattern.compile("id=\"question-summary-(.*)\">");

  private static final Pattern QUESTION_TITLE =
      Pattern.compile("class=\"question-hyperlink\">(.*)</a></h3>");

  private static final Pattern QUESTION_TIME =
      Pattern.compile("class=\"relativetime\">(.*)</span>");

  static List<String> solve(String input) {
    // split by question
    String[] split = input.split("<div class=\"question-summary\"");
    // skip leading whitespace
    String[] questions = Arrays.copyOfRange(split, 1, split.length);

    // solve
    return digestQuestions(Arrays.asList(questions));
  }

  private static List<String> digestQuestions(List<String> questions) {
    return questions.stream().map(s -> digestQuestion(s)).collect(Collectors.toList());
  }

  private static String digestQuestion(String s) {
    List<Matcher> matchers =
        Stream.of(QUESTION_ID, QUESTION_TITLE, QUESTION_TIME)
            .map(p -> p.matcher(s))
            .collect(Collectors.toList());
    if (matchers.stream().allMatch(Matcher::find)) {
      // group 0 = entire match, group 1 = what's in capturing group
      return matchers.stream().map(matcher -> matcher.group(1)).collect(Collectors.joining(";"));
    }
    throw new IllegalArgumentException("Failed to digest question: " + s);
  }

  public static void main(String[] args) throws IOException {
    try (BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
      // read into one big string
      String input = reader.lines().collect(Collectors.joining("\n"));
      // CHECKSTYLE IGNORE Regexp FOR NEXT 1 LINES
      solve(input).forEach(System.out::println);
    }
  }
}
