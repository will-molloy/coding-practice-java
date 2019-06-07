package com.wilmol.hackerrank.regex.introduction.easy;

import com.wilmol.hackerrank.regex.Regex;

/**
 * Created by Will on 2019-04-02 at 21:07
 * <p>
 * https://www.hackerrank.com/challenges/matching-specific-string/problem
 */
class MatchSpecificString
    implements
    Regex
{
  @Override
  public String regex()
  {
    // only match this word
    return "hackerrank";
  }
}
