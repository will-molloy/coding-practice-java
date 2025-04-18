package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableMap;
import com.willmolloy.leetcode.problemset.algorithms.medium.P470ImplementRand10UsingRand7.Solution;
import com.willmolloy.testlib.RandomTrials;
import org.junit.jupiter.api.Test;

/**
 * P470ImplementRand10UsingRand7Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P470ImplementRand10UsingRand7Test {

  private static final double TOLERANCE = 0.02;

  @Test
  void test() {
    Solution solution = new Solution();

    ImmutableMap<Integer, Double> actualProbabilities =
        RandomTrials.getActualProbabilities(() -> solution.rand10());

    assertThat(actualProbabilities.keySet()).containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    for (int i = 1; i <= 10; i++) {
      assertThat(actualProbabilities.get(i)).isWithin(TOLERANCE).of(0.1);
    }
  }
}
