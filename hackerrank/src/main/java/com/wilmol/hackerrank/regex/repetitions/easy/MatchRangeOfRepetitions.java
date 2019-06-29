package com.wilmol.hackerrank.regex.repetitions.easy;

import com.wilmol.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * Created by Will on 2019-04-06 at 13:28
 *
 * <p>https://www.hackerrank.com/challenges/matching-x-y-repetitions/problem
 */
class MatchRangeOfRepetitions implements Regex {

  private static final Pattern PATTERN = Pattern.compile("^\\d{1,2}[a-zA-Z]{3,}\\.{0,3}$");

  /**
   * {x, y}, sequence with size between x and y (inclusive, i.e. a closed ranged).
   *
   * <p>{x,}, sequence with size at least x.
   *
   * <p>for at most x use: {0, x}.
   */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
