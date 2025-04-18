package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.Arrays;

/**
 * <a
 * href=https://leetcode.com/problems/find-the-distance-value-between-two-arrays>https://leetcode.com/problems/find-the-distance-value-between-two-arrays/</a>
 *
 * <p>Runtime: O(n * m) TODO O(n log m) and even O(n + m) is possible
 *
 * <p>Extra space: O(1)
 *
 * <p>Key idea: Brute force.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1385FindTheDistanceValueBetweenTwoArrays {

  public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
    return (int)
        Arrays.stream(arr1)
            .filter(i -> Arrays.stream(arr2).noneMatch(j -> Math.abs(i - j) <= d))
            .count();
  }
}
