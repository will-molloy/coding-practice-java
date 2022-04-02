package com.willmolloy.hackerrank.regex.applications.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/saying-hi/problem>https://www.hackerrank.com/challenges/saying-hi/problem</a>
 *
 * <p>Runtime: O(n)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class SayingHi {

  private SayingHi() {}

  private static final Pattern HI_PATTERN =
      Pattern.compile("^hi [^d].*$", Pattern.CASE_INSENSITIVE);

  static boolean isCorrect(String line) {
    return HI_PATTERN.matcher(line).matches();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
    reader.readLine(); // ignore (num lines)
    reader
        .lines()
        .filter(line -> isCorrect(line))
        // CHECKSTYLE IGNORE Regexp FOR NEXT 3 LINES
        .forEach(System.out::println);
  }
}
