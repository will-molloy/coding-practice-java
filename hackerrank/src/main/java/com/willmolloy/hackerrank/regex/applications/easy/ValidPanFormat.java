package com.willmolloy.hackerrank.regex.applications.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/valid-pan-format/problem>https://www.hackerrank.com/challenges/valid-pan-format/problem</a>
 *
 * <p>Runtime: O(n)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class ValidPanFormat {

  private ValidPanFormat() {}

  private static final String CHAR = "[A-Z]";

  private static final String DIGIT = "[0-9]";

  private static final Pattern PAN_PATTERN =
      Pattern.compile("^" + CHAR + "{5}" + DIGIT + "{4}" + CHAR + "$");

  static boolean isValid(String line) {
    Matcher m = PAN_PATTERN.matcher(line);
    return m.matches();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
    reader.readLine(); // ignore (num lines)
    reader
        .lines()
        .forEach(
            line -> {
              if (isValid(line)) {
                // CHECKSTYLE IGNORE Regexp FOR NEXT 3 LINES
                System.out.println("YES");
              } else {
                System.out.println("NO");
              }
            });
  }
}
