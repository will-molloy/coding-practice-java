package com.wilmol.hackerrank.regex.applications.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Will on 2019-04-07 at 19:01.
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/detecting-valid-latitude-and-longitude/problem>https://www.hackerrank.com/challenges/detecting-valid-latitude-and-longitude/problem</a>
 *
 * <p>Runtime: O(n)
 */
public final class DetectingValidLatitudeAndLongitudePairs {

  private DetectingValidLatitudeAndLongitudePairs() {}

  private static final Pattern PATTERN =
      Pattern.compile(
          // CHECKSTYLE IGNORE LineLength FOR NEXT 1 LINES
          "^[(]([+\\-])?(90([.]0+)?|([1-8]?[\\d])([.]\\d+)?), ([+\\-])?(180([.]0+)?|(1[0-7][\\d]|[1-9]?[\\d])([.]\\d+)?)[)]$");

  static boolean isValid(String latitudeLongitudePair) {
    Matcher m = PATTERN.matcher(latitudeLongitudePair);
    return m.matches();
  }

  /** Process the input. */
  public static void main(String[] args) throws IOException {
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
    reader.readLine(); // ignore (num lines)
    reader.lines().map(line -> isValid(line) ? "Valid" : "Invalid").forEach(System.out::println);
  }
}
