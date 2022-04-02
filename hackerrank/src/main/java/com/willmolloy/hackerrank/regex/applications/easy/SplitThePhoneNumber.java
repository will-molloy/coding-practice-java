package com.willmolloy.hackerrank.regex.applications.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/split-number/problem>https://www.hackerrank.com/challenges/split-number/problem</a>
 *
 * <p>Runtime: O(n)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class SplitThePhoneNumber {

  private SplitThePhoneNumber() {}

  // not using other capturing groups (e.g. (-| )) so its simpler to extract the groups
  private static final Pattern PHONE_NUMBER_PATTERN =
      Pattern.compile("^(\\d{1,3})[\\- ](\\d{1,3})[\\- ](\\d{4,10})$");

  static String splitNumber(String phoneNumber) {
    Matcher m = PHONE_NUMBER_PATTERN.matcher(phoneNumber);
    if (m.matches()) {
      // group 0 is the overall match
      return String.format(
          "CountryCode=%s,LocalAreaCode=%s,Number=%s", m.group(1), m.group(2), m.group(3));
    }
    throw new IllegalArgumentException("Invalid phone number: " + phoneNumber);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
    reader.readLine(); // ignore (num lines)
    reader
        .lines()
        .map(line -> splitNumber(line))
        // CHECKSTYLE IGNORE Regexp FOR NEXT 1 LINES
        .forEach(System.out::println);
  }
}
