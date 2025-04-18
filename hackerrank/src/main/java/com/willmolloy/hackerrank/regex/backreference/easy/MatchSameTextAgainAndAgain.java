package com.willmolloy.hackerrank.regex.backreference.easy;

import com.willmolloy.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/matching-same-text-again-again/problem>https://www.hackerrank.com/challenges/matching-same-text-again-again/problem</a>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class MatchSameTextAgainAndAgain implements Regex {

  private static final Pattern PATTERN =
      Pattern.compile("^([a-z]\\w\\s\\W\\d\\D[A-Z][a-zA-Z][aeiouAEIOU]\\S)\\1$");

  /**
   * \{x} -> back reference to what the x capturing group matched e.g. \1 -> back reference to what
   * the first capturing group matched NOTE different to quantifying the group
   *
   * <p>e.g.
   *
   * <p>(\d)\1 matches 00 11 22 33 44 55 66 77 88 99
   *
   * <p>while
   *
   * <p>(\d){2} matches 01 02 03 .. 97 98 99 etc.
   */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
