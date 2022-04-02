package com.willmolloy.hackerrank.regex.applications.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/ide-identifying-comments/problem>https://www.hackerrank.com/challenges/ide-identifying-comments/problem</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Key: joining into one string first to account for multiline comments more easily.
 *
 * <p>Also using DOTALL flag such that '.' matches on '\n' (essentially required for the {@code
 * String#join('\n')} to work).
 *
 * <p>Also using lazy quantifier such that it doesn't just detect the first comment as the rest of
 * the string.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class BuildingASmartIdeIdentifyingComments {

  private BuildingASmartIdeIdentifyingComments() {}

  private static final Pattern COMMENT_PATTERN =
      Pattern.compile("(/\\*.*?\\*/|//.*?\n)", Pattern.DOTALL);

  static List<String> extractComments(List<String> sourceCodeLines) {
    // just join into one string so we can account for the multi line comments
    String joined = String.join("\n", sourceCodeLines) + "\n";

    // standard find + capturing group loop
    Matcher commentMatcher = COMMENT_PATTERN.matcher(joined);
    List<String> comments = new ArrayList<>();
    while (commentMatcher.find()) {
      String comment = commentMatcher.group(1);
      // remove leading whitespace from each line
      List<String> trimmedComment =
          Arrays.stream(comment.split("\n"))
              .map(s -> s.replaceAll("^\\s+", ""))
              .collect(Collectors.toList());
      comments.addAll(trimmedComment);
    }
    return comments;
  }

  public static void main(String[] args) throws IOException {
    try (BufferedReader bufferedReader =
        new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
      List<String> lines = bufferedReader.lines().collect(Collectors.toList());
      List<String> comments = extractComments(lines);
      // CHECKSTYLE IGNORE Regexp FOR NEXT 1 LINES
      comments.forEach(System.out::println);
    }
  }
}
