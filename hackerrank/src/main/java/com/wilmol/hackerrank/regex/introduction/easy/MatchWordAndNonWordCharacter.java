package com.wilmol.hackerrank.regex.introduction.easy;

import com.wilmol.hackerrank.regex.Regex;

/**
 * Created by Will on 2019-04-04 at 21:43
 * <p>
 * https://www.hackerrank.com/challenges/matching-word-non-word/problem
 */
class MatchWordAndNonWordCharacter
    implements
    Regex
{
  @Override
  public String regex()
  {
    // \w -> words [a-zA-Z0-9_]
    // \W -> non words
    return "\\w{3}\\W\\w{10}\\W\\w{3}";
  }
}
