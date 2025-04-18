package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Arrays;

/**
 * <a
 * href=https://leetcode.com/problems/minimum-elements-to-add-to-form-a-given-sum>https://leetcode.com/problems/minimum-elements-to-add-to-form-a-given-sum/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Greedy. Add {@code limit} until goal is reached.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1785MinimumElementsToAddToFormAGivenSum {

  public int minElements(int[] nums, int limit, int goal) {
    long sum = Arrays.stream(nums).asLongStream().sum();
    // distance to goal: (sum, goal]
    long distance = Math.abs(sum - goal);
    return (int) Math.ceil((double) distance / limit);
  }
}
