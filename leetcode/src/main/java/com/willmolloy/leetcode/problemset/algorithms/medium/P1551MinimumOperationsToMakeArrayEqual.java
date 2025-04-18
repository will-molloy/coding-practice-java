package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/minimum-operations-to-make-array-equal>https://leetcode.com/problems/minimum-operations-to-make-array-equal/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key idea: Make every element the median (smallest total distance), each turn change 2 so its
 * sum distance from median divide 2.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1551MinimumOperationsToMakeArrayEqual {

  public int minOperations(int n) {
    // odd n, [1, 3, 5], median = 3, res = 2
    // even n, [1, 3, 5, 7, 9, 11], median = 6, res = 9

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = (2 * i) + 1;
    }

    int med;
    if (n % 2 == 0) {
      med = arr[n / 2] - 1;
    } else {
      med = arr[n / 2];
    }

    int res = 0;
    for (int i = 0; i < n / 2; i++) {
      res += med - arr[i];
    }
    return res;
  }
}
