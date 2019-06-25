package com.wilmol.hackerrank.regex.grouping_capturing.easy;

import com.wilmol.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * Created by Will on 2019-04-06 at 15:11
 *
 * <p>https://www.hackerrank.com/challenges/capturing-non-capturing-groups/problem
 */
class CapturingAndNonCapturingGroups implements Regex {

  private static final Pattern PATTERN = Pattern.compile("(ok){3,}");

  /**
   * () -> creates a group, can then apply quantifiers to that group
   *
   * <p>can nest groups
   *
   * <p>(?:) -> non-capturing group
   */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
