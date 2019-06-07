package com.wilmol.hackerrank.regex.character_class.easy;

import com.wilmol.hackerrank.regex.Regex;

/**
 * Created by Will on 2019-04-04 at 22:27
 * <p>
 * https://www.hackerrank.com/challenges/excluding-specific-characters/problem
 */
class ExcludeSpecificCharacters
    implements
    Regex
{
  @Override
  public String regex()
  {
    // [^] -> exclude characters in set ([], aka set, aka character class)
    // can put quantifiers in set (e.g. \d) or ranges (e.g. 0-9)
    return "^[^\\d][^aeiou][^bcDF][\\S][^AEIOU][^.,]$";
  }
}
