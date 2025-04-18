package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero>https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Just use the range: [-n/2, n/2].
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1304FindNUniqueIntegersSumUpToZero {

  public int[] sumZero(int n) {
    int[] result = new int[n];
    int count = 0;
    for (int i = -n / 2; i <= n / 2; i++) {
      if (n % 2 == 0 && i == 0) {
        continue;
      }
      result[count++] = i;
    }
    return result;
  }
}
