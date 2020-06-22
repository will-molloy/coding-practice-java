package com.wilmol.hackerrank.regex.assertions.easy;

import com.wilmol.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * Created by Will on 2019-04-06 at 21:29.
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/negative-lookbehind/problem>https://www.hackerrank.com/challenges/negative-lookbehind/problem</a>
 */
class NegativeLookbehind implements Regex {

  private static final Pattern PATTERN = Pattern.compile("(?<![aeiouAEIOU]).");

  /**
   * (?<!regex_2)regex_1 -> only match regex_1 if it is not immediately preceded by regex_2.
   *
   * <p>match all characters not immediately preceded by a vowel
   */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}