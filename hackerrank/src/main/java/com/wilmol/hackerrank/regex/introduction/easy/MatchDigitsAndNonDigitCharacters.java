package com.wilmol.hackerrank.regex.introduction.easy;

import com.wilmol.hackerrank.regex.Regex;

/**
 * Created by Will on 2019-04-02 at 21:08
 * <p>
 * https://www.hackerrank.com/challenges/matching-digits-non-digit-character/problem
 */
class MatchDigitsAndNonDigitCharacters
    implements
    Regex
{
  @Override
  public String regex()
  {
    // \d -> digit [0-9]
    // \D -> non digit
    return "\\d\\d\\D\\d\\d\\D\\d\\d\\d\\d";
  }
}
