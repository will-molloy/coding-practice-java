package com.wilmol.hackerrank.regex.assertions.easy;

import com.wilmol.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * Created by Will on 2019-04-06 at 21:01
 *
 * <p>https://www.hackerrank.com/challenges/negative-lookahead/problem
 */
class NegativeLookAhead implements Regex {

  private static final Pattern PATTERN = Pattern.compile("(.)(?!\\1)");

  /**
   * regex_1(?!regex_2) -> match regex_1 only if regex_2 does not appear immediately after it.
   *
   * <p>match character which is not immediately matched by the same character.
   */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
