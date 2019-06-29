package com.wilmol.hackerrank.regex.characterclass.easy;

import com.wilmol.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * Created by Will on 2019-04-04 at 22:27
 *
 * <p>https://www.hackerrank.com/challenges/excluding-specific-characters/problem
 */
class ExcludeSpecificCharacters implements Regex {

  private static final Pattern PATTERN =
      Pattern.compile("^[^\\d][^aeiou][^bcDF][\\S][^AEIOU][^.,]$");

  /**
   * [^] -> exclude characters in set ([], aka set, aka character class)
   *
   * <p>can put quantifiers in set (e.g. \d) or ranges (e.g. 0-9)
   */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
