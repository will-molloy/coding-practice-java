package com.wilmol.hackerrank.regex.character_class.easy;

import com.wilmol.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * Created by Will on 2019-04-04 at 22:37
 *
 * <p>https://www.hackerrank.com/challenges/matching-range-of-characters/problem
 */
class MatchRangeOfCharacters implements Regex {

  private static final Pattern PATTERN = Pattern.compile("^[a-z][1-9][^a-z][^A-Z][A-Z]");

  /**
   * hyphen in character class denotes range: (from)-(to)
   *
   * <p>e.g. [0-9] -> 01234566789, [x-z] -> xyz
   */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
