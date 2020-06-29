package com.wilmol.hackerrank.regex.assertions.easy;

import com.wilmol.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/positive-lookbehind/problem>https://www.hackerrank.com/challenges/positive-lookbehind/problem</a>
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class PositiveLookbehind implements Regex {

  private static final Pattern PATTERN = Pattern.compile("(?<=[13579]\\d)");

  /**
   * (?<=regex_2)regex_1 -> only match regex_1 if it is immediately preceded by regex_2.
   *
   * <p>match digits immediately preceded by odd digits.
   */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
