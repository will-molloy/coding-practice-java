package com.willmolloy.hackerrank.regex.introduction.easy;

import com.willmolloy.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/matching-whitespace-non-whitespace-character/problem>https://www.hackerrank.com/challenges/matching-whitespace-non-whitespace-character/problem</a>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class MatchWhiteSpaceAndNonWhiteSpaceCharacter implements Regex {

  private static final Pattern PATTERN = Pattern.compile("(\\S{2}\\s){2}\\S{2}");

  /**
   * \s -> whitespace [\r\n\t\f].
   *
   * <p>\S -> non whitespace.
   */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
