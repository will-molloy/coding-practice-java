package com.wilmol.hackerrank.regex.applications.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/hackerrank-tweets/problem>https://www.hackerrank.com/challenges/hackerrank-tweets/problem</a>
 *
 * <p>Runtime: O(n)
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
final class HackerRankTweets {

  private HackerRankTweets() {}

  private static final Pattern PATTERN = Pattern.compile("hackerrank", Pattern.CASE_INSENSITIVE);

  static boolean containsHackerrank(String string) {
    return PATTERN.asPredicate().test(string);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
    reader.readLine();
    long count =
        reader
            .lines()
            .mapToInt(
                line -> {
                  Matcher m = PATTERN.matcher(line);
                  return m.find() ? 1 : 0;
                })
            .sum();
    // CHECKSTYLE IGNORE Regexp FOR NEXT 1 LINES
    System.out.println(count);
  }
}
