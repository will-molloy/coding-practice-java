package com.wilmol.hackerrank.regex.characterclass.easy;

import com.wilmol.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/excluding-specific-characters/problem>https://www.hackerrank.com/challenges/excluding-specific-characters/problem</a>
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
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
