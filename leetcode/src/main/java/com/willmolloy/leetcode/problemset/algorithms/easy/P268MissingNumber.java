package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * <a
 * href=https://leetcode.com/problems/missing-number>https://leetcode.com/problems/missing-number/</a>
 *
 * <p>Difficulty: Easy.
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key idea: Summing the numbers.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P268MissingNumber {

  public int missingNumber(int[] nums) {
    int sum = Arrays.stream(nums).sum();
    int wholeSum = IntStream.rangeClosed(1, nums.length).sum();
    // difference must contain the missing number
    // e.g. (0 + 1 + 2 + 3) - (0 + 1 + 3) = 2
    return wholeSum - sum;
  }
}
