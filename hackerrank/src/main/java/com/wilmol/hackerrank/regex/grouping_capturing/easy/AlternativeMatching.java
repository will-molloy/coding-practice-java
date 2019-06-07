package com.wilmol.hackerrank.regex.grouping_capturing.easy;

import com.wilmol.hackerrank.regex.Regex;

/**
 * Created by Will on 2019-04-06 at 15:22
 * <p>
 * https://www.hackerrank.com/challenges/alternative-matching/problem
 */
class AlternativeMatching
    implements
    Regex
{
  @Override
  public String regex()
  {
    // | in capturing group -> match single item out of the possibilities
    return "^(M(r(|s)|s)|(D|E)r)\\.[a-zA-Z]+$";
  }
}
