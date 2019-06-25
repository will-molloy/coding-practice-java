package com.wilmol.hackerrank.regex.assertions.easy;

import com.wilmol.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * Created by Will on 2019-04-06 at 20:49
 *
 * <p>https://www.hackerrank.com/challenges/positive-lookahead/problem
 */
class PositiveLookahead implements Regex {

  private static final Pattern PATTERN = Pattern.compile("o(?=oo)");

  /**
   * regex_1(?=regex_2) -> only match regex_1 if it is immediately followed by regex_2
   *
   * <p>(does not return matches of regex_2)
   */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
