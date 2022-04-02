package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.List;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/count-items-matching-a-rule>https://leetcode.com/problems/count-items-matching-a-rule/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: filter and count. Initially looking up item index is nice.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1773CountItemsMatchingARule {

  private static final Map<String, Integer> MAP = Map.of("type", 0, "color", 1, "name", 2);

  public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
    int i = MAP.get(ruleKey);

    return (int) items.stream().filter(item -> item.get(i).equals(ruleValue)).count();
  }
}
