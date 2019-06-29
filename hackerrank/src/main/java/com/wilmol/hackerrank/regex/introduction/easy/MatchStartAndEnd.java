package com.wilmol.hackerrank.regex.introduction.easy;

import com.wilmol.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * Created by Will on 2019-04-04 at 21:58
 *
 * <p>https://www.hackerrank.com/challenges/matching-start-end/problem
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
