package com.wilmol.hackerrank.regex.repetitions.easy;

import java.util.regex.Pattern;

import com.wilmol.hackerrank.regex.Regex;

/**
 * Created by Will on 2019-04-06 at 13:24
 * <p>
 * https://www.hackerrank.com/challenges/matching-x-repetitions/problem
 */
class MatchXRepetitions
    implements
    Regex
{

  private static final Pattern PATTERN = Pattern.compile("^[a-zA-Z02468]{40}[13579\\s]{5}$");

  /**
   * {x}, sequence with size x
   */
  @Override
  public Pattern pattern()
  {
    return PATTERN;
  }
}
