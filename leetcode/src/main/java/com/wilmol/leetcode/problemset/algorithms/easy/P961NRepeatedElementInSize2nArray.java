package com.wilmol.leetcode.problemset.algorithms.easy;

import java.util.HashSet;

/**
 * Created by wilmol on 2020-04-04.
 *
 * <p><a
 * href=https://leetcode.com/problems/n-repeated-element-in-size-2n-array>https://leetcode.com/problems/n-repeated-element-in-size-2n-array</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key: duplicate detection
 */
class P961NRepeatedElementInSize2nArray {

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
