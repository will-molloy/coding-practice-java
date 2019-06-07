package com.wilmol.hackerrank.regex.repetitions.easy;

import com.wilmol.hackerrank.regex.Regex;

/**
 * Created by Will on 2019-04-06 at 13:28
 * <p>
 * https://www.hackerrank.com/challenges/matching-x-y-repetitions/problem
 */
class MatchXYRepetitions
    implements
    Regex
{
  @Override
  public String regex()
  {
    // {x, y} -> sequence with size between x and y (inclusive)
    // {x,} -> sequence with size at least x
    return "^\\d{1,2}[a-zA-Z]{3,}\\.{0,3}$";
  }
}
