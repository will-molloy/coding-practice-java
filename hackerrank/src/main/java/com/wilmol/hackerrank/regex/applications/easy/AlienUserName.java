package com.wilmol.hackerrank.regex.applications.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Will on 2019-04-07 at 13:45.
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/alien-username/problem>https://www.hackerrank.com/challenges/alien-username/problem</a>
 *
 * <p>Runtime: O(n)
 */
final class AlienUserName {

  private AlienUserName() {}

  private static final Pattern USER_NAME_PATTERN = Pattern.compile("^(_|[.])\\d+[a-zA-Z]*_?$");

  static boolean isValidUserName(String userName) {
    Matcher m = USER_NAME_PATTERN.matcher(userName);
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
              if (isValidUserName(line)) {
                // CHECKSTYLE IGNORE Regexp FOR NEXT 3 LINES
                System.out.println("VALID");
              } else {
                System.out.println("INVALID");
              }
            });
  }
}
