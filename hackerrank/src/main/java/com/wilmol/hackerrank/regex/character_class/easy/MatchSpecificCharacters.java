package com.wilmol.hackerrank.regex.character_class.easy;

import java.util.regex.Pattern;

import com.wilmol.hackerrank.regex.Regex;

/**
 * Created by Will on 2019-04-04 at 22:20
 * <p>
 * https://www.hackerrank.com/challenges/matching-specific-characters/problem
 */
class MatchSpecificCharacters
    implements
    Regex
{

  private static final Pattern PATTERN = Pattern.compile("^[123][120][xs0][30Aa][xsu][.,]$");

  /**
   * [] -> match single character in set ([], aka set, aka character class)
   * <p>
   * can put quantifiers in set (e.g. \d) or ranges (e.g. 0-9)
   */
  @Override
  public Pattern pattern()
  {
    return PATTERN;
  }
}
