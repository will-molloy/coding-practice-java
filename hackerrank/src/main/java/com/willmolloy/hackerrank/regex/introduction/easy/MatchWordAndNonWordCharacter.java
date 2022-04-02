package com.willmolloy.hackerrank.regex.introduction.easy;

import com.willmolloy.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/matching-word-non-word/problem>https://www.hackerrank.com/challenges/matching-word-non-word/problem</a>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class MatchWordAndNonWordCharacter implements Regex {

  private static final Pattern PATTERN = Pattern.compile("\\w{3}\\W\\w{10}\\W\\w{3}");

  /**
   * \w -> words [a-zA-Z0-9_].
   *
   * <p>\W -> non words.
   */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
