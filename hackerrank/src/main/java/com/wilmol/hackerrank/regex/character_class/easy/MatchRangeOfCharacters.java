package com.wilmol.hackerrank.regex.character_class.easy;

import com.wilmol.hackerrank.regex.Regex;

/**
 * Created by Will on 2019-04-04 at 22:37
 * <p>
 * https://www.hackerrank.com/challenges/matching-range-of-characters/problem
 */
class MatchRangeOfCharacters
    implements
    Regex
{
  @Override
  public String regex()
  {
    // hyphen in character class denotes range: (from)-(to)
    // e.g. [0-9] -> 01234566789, [x-z] -> xyz
    return "^[a-z][1-9][^a-z][^A-Z][A-Z]";
  }
}
