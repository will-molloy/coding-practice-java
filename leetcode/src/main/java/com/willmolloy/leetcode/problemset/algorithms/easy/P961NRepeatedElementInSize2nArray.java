package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.HashSet;

/**
 * <a
 * href=https://leetcode.com/problems/n-repeated-element-in-size-2n-array>https://leetcode.com/problems/n-repeated-element-in-size-2n-array</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key idea: duplicate detection
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P961NRepeatedElementInSize2nArray {

  public int repeatedNTimes(int[] a) {
    HashSet<Integer> set = new HashSet<>();
    for (int i : a) {
      if (!set.add(i)) {
        return i;
      }
    }
    throw new IllegalArgumentException("No duplicates");
  }
}
