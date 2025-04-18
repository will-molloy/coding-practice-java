package com.willmolloy.hackerrank.regex.repetitions.easy;

import com.willmolloy.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/matching-ending-items/problem>https://www.hackerrank.com/challenges/matching-ending-items/problem</a>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class MatchEndingItems implements Regex {

  private static final Pattern PATTERN = Pattern.compile("^[a-zA-Z]*s$");

  /** $ asserts end of string. */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
