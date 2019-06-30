package com.wilmol.hackerrank.regex.repetitions.easy;

import com.wilmol.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * Created by Will on 2019-04-06 at 13:17.
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/matching-ending-items/problem>https://www.hackerrank.com/challenges/matching-ending-items/problem</a>
 */
class MatchEndingItems implements Regex {

  private static final Pattern PATTERN = Pattern.compile("^[a-zA-Z]*s$");

  /** $ asserts end of string. */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
