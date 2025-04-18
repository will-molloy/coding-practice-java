package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableMap;
import com.willmolloy.leetcode.problemset.algorithms.medium.P398RandomPickIndex.Solution;
import com.willmolloy.testlib.RandomTrials;
import org.junit.jupiter.api.Test;

/**
 * P398RandomPickIndexTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P398RandomPickIndexTest {

  private static final double TOLERANCE = 0.02;

  @Test
  void example() {
    int[] nums = new int[] {1, 2, 3, 3, 3};
    Solution solution = new Solution(nums);

    ImmutableMap<Integer, Double> actualProbabilitiesPick3 =
        RandomTrials.getActualProbabilities(() -> solution.pick(3));
    assertThat(actualProbabilitiesPick3.keySet()).containsExactly(2, 3, 4);
    assertThat(actualProbabilitiesPick3.get(2)).isWithin(TOLERANCE).of((double) 1 / 3);
    assertThat(actualProbabilitiesPick3.get(3)).isWithin(TOLERANCE).of((double) 1 / 3);
    assertThat(actualProbabilitiesPick3.get(4)).isWithin(TOLERANCE).of((double) 1 / 3);

    ImmutableMap<Integer, Double> actualProbabilitiesPick1 =
        RandomTrials.getActualProbabilities(() -> solution.pick(1));
    assertThat(actualProbabilitiesPick1.keySet()).containsExactly(0);
    assertThat(actualProbabilitiesPick1.get(0)).isEqualTo(1);
  }
}
