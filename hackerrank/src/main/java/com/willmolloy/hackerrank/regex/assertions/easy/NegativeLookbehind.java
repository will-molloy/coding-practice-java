package com.willmolloy.hackerrank.regex.assertions.easy;

import com.willmolloy.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/negative-lookbehind/problem>https://www.hackerrank.com/challenges/negative-lookbehind/problem</a>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class NegativeLookbehind implements Regex {

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
