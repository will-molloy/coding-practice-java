package com.wilmol.hackerrank.regex.applications.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Will on 2019-04-07 at 19:22
 *
 * <p>https://www.hackerrank.com/challenges/hackerrank-tweets/problem
 *
 * <p>Runtime: O(n)
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
    System.out.println(count);
  }
}
