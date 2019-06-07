package com.wilmol.hackerrank.regex.repetitions.easy;

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
  @Override
  public String regex()
  {
    // {x} -> sequence with size x
    return "^[a-zA-Z02468]{40}[13579\\s]{5}$";
  }
}
