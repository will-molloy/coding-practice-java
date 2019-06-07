package com.wilmol.hackerrank.regex.repetitions.easy;

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
  @Override
  public String regex()
  {
    return "^\\d{2,}[a-z]*[A-Z]*$";
  }
}
