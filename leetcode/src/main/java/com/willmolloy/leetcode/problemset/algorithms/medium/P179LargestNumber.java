package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://leetcode.com/problems/largest-number>https://leetcode.com/problems/largest-number</a>
 *
 * <p>Runtime: O(n log n)
 *
 * <p>Space: O(n) (create string for each int)
 *
 * <p>Key: Sorting.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P179LargestNumber {

  public String largestNumber(int[] nums) {
    String result =
        Arrays.stream(nums)
            .mapToObj(String::valueOf)
            // sort descending such that largest digits are first
            // (compare each combination a ^ b and b ^ a)
            .sorted((a, b) -> (b + a).compareTo(a + b))
            .collect(Collectors.joining());
    return result.startsWith("0") ? "0" : result;
  }
}
