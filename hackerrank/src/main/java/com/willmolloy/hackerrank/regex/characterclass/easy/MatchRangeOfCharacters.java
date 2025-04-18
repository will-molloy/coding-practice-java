package com.willmolloy.hackerrank.regex.characterclass.easy;

import com.willmolloy.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/matching-range-of-characters/problem>https://www.hackerrank.com/challenges/matching-range-of-characters/problem</a>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class MatchRangeOfCharacters implements Regex {

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
