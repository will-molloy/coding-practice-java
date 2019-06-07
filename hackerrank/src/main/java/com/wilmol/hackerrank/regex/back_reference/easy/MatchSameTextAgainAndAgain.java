package com.wilmol.hackerrank.regex.back_reference.easy;

import com.wilmol.hackerrank.regex.Regex;

/**
 * Created by Will on 2019-04-06 at 18:06
 * <p>
 * https://www.hackerrank.com/challenges/matching-same-text-again-again/problem
 */
class MatchSameTextAgainAndAgain
    implements
    Regex
{
  @Override
  public String regex()
  {
    // \{x} -> back reference to what the x capturing group matched
    // e.g. \1 -> back reference to what the first capturing group matched
    // NOTE different to quantifying the group
    // e.g.
    // (\d)\1 matches 00 11 22 33 44 55 66 77 88 99
    // while
    // (\d){2} matches 01 02 03 .. 97 98 99 etc.
    return "^([a-z]\\w\\s\\W\\d\\D[A-Z][a-zA-Z][aeiouAEIOU]\\S)\\1$";
  }
}
