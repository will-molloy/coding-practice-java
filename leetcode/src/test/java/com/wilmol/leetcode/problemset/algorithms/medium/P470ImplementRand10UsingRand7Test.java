package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.collect.ImmutableMap.toImmutableMap;
import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableMap;
import com.wilmol.leetcode.problemset.algorithms.medium.P470ImplementRand10UsingRand7.Solution;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

/**
 * P470ImplementRand10UsingRand7Test.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P470ImplementRand10UsingRand7Test {

  private static final int NUM_TRIALS = 1_000_000;

  private static final double TOLERANCE = 0.02;

  @Test
  void test() {
    Solution solution = new Solution();

    ImmutableMap<Integer, Double> probabilities =
        IntStream.range(0, NUM_TRIALS).mapToObj(i -> solution.rand10())
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
            .stream()
            .collect(toImmutableMap(Map.Entry::getKey, e -> (double) e.getValue() / NUM_TRIALS));

    assertThat(probabilities.values().stream().mapToDouble(Double::doubleValue).sum()).isEqualTo(1);
    assertThat(probabilities.keySet()).containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    for (int i = 1; i <= 10; i++) {
      assertThat(probabilities.get(i)).isWithin(TOLERANCE).of(0.1);
    }
  }
}
