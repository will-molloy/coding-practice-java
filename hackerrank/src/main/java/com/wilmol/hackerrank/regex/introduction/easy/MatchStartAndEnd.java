package com.wilmol.hackerrank.regex.introduction.easy;

import com.wilmol.hackerrank.regex.Regex;

/**
 * Created by Will on 2019-04-04 at 21:58
 * <p>
 * https://www.hackerrank.com/challenges/matching-start-end/problem
 */
class MatchStartAndEnd
    implements
    Regex
{
  @Override
  public String regex()
  {
    // ^ -> start of string to match
    // $ -> end of string to match
    // can use one or both
    return "^\\d\\w{4}.$";
  }
}
