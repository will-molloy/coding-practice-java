package com.wilmol.hackerrank.regex.repetitions.easy;

import java.util.regex.Pattern;

import com.wilmol.hackerrank.regex.Regex;

/**
 * Created by Will on 2019-04-06 at 13:37
 * <p>
 * https://www.hackerrank.com/challenges/matching-zero-or-more-repetitions/problem
 */
class MatchZeroOrMoreRepetitions
    implements
    Regex
{

  private static final Pattern PATTERN = Pattern.compile("^\\d{2,}[a-z]*[A-Z]*$");

  /**
   * *, sequence of any size.
   */
  @Override
  public Pattern pattern()
  {
    return PATTERN;
  }
}
