package com.willmolloy.hackerrank.regex.introduction.easy;

import com.willmolloy.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/matching-start-end/problem>https://www.hackerrank.com/challenges/matching-start-end/problem</a>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class MatchStartAndEnd implements Regex {

  private static final Pattern PATTERN = Pattern.compile("^\\d\\w{4}.$");

  /**
   * ^ -> start of string to match.
   *
   * <p>$ -> end of string to match.
   *
   * <p>can use one or both.
   */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
