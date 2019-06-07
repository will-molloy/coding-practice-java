package com.wilmol.hackerrank.regex.repetitions.easy;

import com.wilmol.hackerrank.regex.Regex;

/**
 * Created by Will on 2019-04-06 at 13:55
 * <p>
 * https://www.hackerrank.com/challenges/matching-one-or-more-repititions/problem
 */
class MatchOneOrMoreRepetitions
    implements
    Regex
{
  @Override
  public String regex()
  {
    return "^\\d+[A-Z]+[a-z]+$";
  }
}
