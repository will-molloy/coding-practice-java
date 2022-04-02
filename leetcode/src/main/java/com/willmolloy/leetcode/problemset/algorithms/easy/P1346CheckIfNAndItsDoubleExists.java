package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/check-if-n-and-its-double-exist>https://leetcode.com/problems/check-if-n-and-its-double-exist/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(n)
 *
 * <p>Key: Make memory tradeoff with set to achieve O(n) time (otherwise best is O(n * log(n))).
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1346CheckIfNAndItsDoubleExists {

  public boolean checkIfExist(int[] arr) {
    Set<Integer> set = new HashSet<>();
    for (int i : arr) {
      if (set.contains(i * 2) || i % 2 == 0 && set.contains(i / 2)) {
        return true;
      }
      set.add(i);
    }
    return false;
  }
}
