package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by wilmol on 2020-06-22.
 *
 * <p><a
 * href=https://leetcode.com/problems/single-number-ii>https://leetcode.com/problems/single-number-ii/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(n) TODO O(1) is possible (bitwise operators)
 *
 * <p>Key: Count num frequencies.
 *
 * @see com.wilmol.leetcode.problemset.algorithms.easy.P136SingleNumber
 */
class P137SingleNumber2 {

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
