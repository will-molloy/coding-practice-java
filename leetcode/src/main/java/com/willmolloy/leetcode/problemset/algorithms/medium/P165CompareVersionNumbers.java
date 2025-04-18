package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Arrays;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/compare-version-numbers>https://leetcode.com/problems/compare-version-numbers/</a>
 *
 * <p>Runtime: O(v1 + v2)
 *
 * <p>Extra memory: O(v1 + v2)
 *
 * <p>Key idea: Compare number sequences in lockstep.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P165CompareVersionNumbers {

  public int compareVersion(String version1, String version2) {
    List<String> v1 = Arrays.asList(version1.split("[.]"));
    List<String> v2 = Arrays.asList(version2.split("[.]"));
    return compare(v1, v2);
  }

  private int compare(List<String> v1, List<String> v2) {
    if (v1.isEmpty() && v2.isEmpty()) {
      return 0;
    }
    int compare = Integer.compare(parseHead(v1), parseHead(v2));
    if (compare == 0) {
      return compare(tail(v1), tail(v2));
    } else {
      return compare;
    }
  }

  private int parseHead(List<String> v) {
    return v.isEmpty() ? 0 : Integer.parseInt(v.get(0));
  }

  private List<String> tail(List<String> v) {
    return v.isEmpty() ? v : v.subList(1, v.size());
  }
}
