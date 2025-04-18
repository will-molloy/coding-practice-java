package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://leetcode.com/problems/single-number-ii>https://leetcode.com/problems/single-number-ii/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(n) TODO O(1) is possible (bitwise operators)
 *
 * <p>Key idea: Count num frequencies.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P136SingleNumber
 * @see P260SingleNumber3
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P137SingleNumber2 {

  public int singleNumber(int[] nums) {
    Map<Integer, Long> map =
        Arrays.stream(nums)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    return map.entrySet().stream()
        .filter(e -> e.getValue() == 1)
        .findFirst()
        .map(e -> e.getKey())
        .get();
  }
}
