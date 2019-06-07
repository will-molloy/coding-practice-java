package com.wilmol.hackerrank.regex.grouping_capturing.easy;

import com.wilmol.hackerrank.regex.Regex;

/**
 * Created by Will on 2019-04-06 at 15:11
 * <p>
 * https://www.hackerrank.com/challenges/capturing-non-capturing-groups/problem
 */
class CapturingAndNonCapturingGroups
    implements
    Regex
{
  @Override
  public String regex()
  {
    // () -> creates a group, can then apply quantifiers to that group
    // can nest groups
    // (?:) -> non-capturing group
    return "(ok){3,}";
  }
}
