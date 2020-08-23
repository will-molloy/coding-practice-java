package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.collect.ImmutableMap.toImmutableMap;
import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.problemset.algorithms.medium.P398RandomPickIndex.Solution;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

/**
 * P398RandomPickIndexTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P398RandomPickIndexTest {

  private static final int NUM_TRIALS = 1_000_000;

  private static final double TOLERANCE = 0.02;

  @Test
  void example() {
    int[] nums = new int[] {1, 2, 3, 3, 3};

    Map<Integer, Double> actualProbabilitiesPick3 = getActualProbabilities(nums, 3);
    assertThat(actualProbabilitiesPick3.keySet()).containsExactly(2, 3, 4);
    assertThat(actualProbabilitiesPick3.values().stream().mapToDouble(i -> i).sum())
        .isWithin(TOLERANCE)
        .of(1);
    assertThat(actualProbabilitiesPick3.get(2)).isWithin(TOLERANCE).of((double) 1 / 3);
    assertThat(actualProbabilitiesPick3.get(3)).isWithin(TOLERANCE).of((double) 1 / 3);
    assertThat(actualProbabilitiesPick3.get(4)).isWithin(TOLERANCE).of((double) 1 / 3);

    Map<Integer, Double> actualProbabilitiesPick1 = getActualProbabilities(nums, 1);
    assertThat(actualProbabilitiesPick1.keySet()).containsExactly(0);
    assertThat(actualProbabilitiesPick1.values().stream().mapToDouble(i -> i).sum()).isEqualTo(1);
    assertThat(actualProbabilitiesPick1.get(0)).isEqualTo(1);
  }

  // helper method to run random trials
  private Map<Integer, Double> getActualProbabilities(int[] nums, int target) {
    Solution solution = new Solution(nums);

    Map<Integer, Long> indexCounts =
        IntStream.range(0, NUM_TRIALS)
            .mapToObj(i -> solution.pick(target))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    return indexCounts.entrySet().stream()
        .collect(toImmutableMap(Map.Entry::getKey, e -> (double) e.getValue() / NUM_TRIALS));
  }
}
