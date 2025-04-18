package com.willmolloy.hackerrank.regex.groupingcapturing.easy;

import com.willmolloy.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/capturing-non-capturing-groups/problem>https://www.hackerrank.com/challenges/capturing-non-capturing-groups/problem</a>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class CapturingAndNonCapturingGroups implements Regex {

  private static final Pattern PATTERN = Pattern.compile("(ok){3,}");

  /**
   * () -> creates a group, can then apply quantifiers to that group.
   *
   * <p>can nest groups.
   *
   * <p>(?:) -> non-capturing group.
   */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
