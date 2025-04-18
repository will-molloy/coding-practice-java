package com.willmolloy.hackerrank.regex.assertions.easy;

import com.willmolloy.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/positive-lookahead/problem>https://www.hackerrank.com/challenges/positive-lookahead/problem</a>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class PositiveLookahead implements Regex {

  private static final Pattern PATTERN = Pattern.compile("o(?=oo)");

  /**
   * regex_1(?=regex_2) -> only match regex_1 if it is immediately followed by regex_2.
   *
   * <p>(does not return matches of regex_2).
   */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
