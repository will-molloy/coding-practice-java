package com.wilmol.hackerrank.regex.introduction.easy;

import com.wilmol.hackerrank.regex.Regex;

/**
 * Created by Will on 2019-04-04 at 20:09
 * <p>
 * https://www.hackerrank.com/challenges/matching-whitespace-non-whitespace-character/problem
 */
class MatchWhiteSpaceAndNonWhiteSpaceCharacter
    implements
    Regex
{

  @Override
  public String regex()
  {
    // \s -> whitespace [\r\n\t\f]
    // \S -> non whitespace
    return "(\\S{2}\\s){2}\\S{2}";
  }

}
