package com.wilmol.hackerrank.regex.assertions.easy;

import com.wilmol.hackerrank.regex.Regex;

/**
 * Created by Will on 2019-04-06 at 21:06
 * <p>
 * https://www.hackerrank.com/challenges/positive-lookbehind/problem
 */
class PositiveLookbehind
    implements
    Regex
{
  @Override
  public String regex()
  {
    // (?<=regex_2)regex_1 -> only match regex_1 if it is immediately preceded by regex_2

    // match digits immediately preceded by odd digits
    return "(?<=[13579]\\d)";
  }
}
