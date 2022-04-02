package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://leetcode.com/problems/single-number-iii>https://leetcode.com/problems/single-number-iii/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n) TODO O(1) space is possible (bit manipulation)
 *
 * <p>Key: Count frequencies.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P136SingleNumber
 * @see P137SingleNumber2
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P260SingleNumber3 {

  public int[] singleNumber(int[] nums) {
    return Arrays.stream(nums)
        .boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet()
        .stream()
        .filter(e -> e.getValue() == 1)
        .mapToInt(Map.Entry::getKey)
        .toArray();
  }
}
