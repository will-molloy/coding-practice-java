package com.wilmol.hackerrank.regex.introduction.easy;

import com.wilmol.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * Created by Will on 2019-04-04 at 21:43
 *
 * <p>https://www.hackerrank.com/challenges/matching-word-non-word/problem
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
