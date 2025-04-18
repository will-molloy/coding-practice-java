package com.willmolloy.hackerrank.regex.introduction.easy;

import com.willmolloy.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/matching-digits-non-digit-character/problem>https://www.hackerrank.com/challenges/matching-digits-non-digit-character/problem</a>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class MatchDigitsAndNonDigitCharacters implements Regex {

  private static final Pattern PATTERN = Pattern.compile("\\d\\d\\D\\d\\d\\D\\d\\d\\d\\d");

  /**
   * \d -> digit [0-9].
   *
   * <p>\D -> non digit.
   */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
