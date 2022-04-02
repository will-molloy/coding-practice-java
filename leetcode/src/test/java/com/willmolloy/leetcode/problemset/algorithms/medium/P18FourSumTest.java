package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * P18FourSumTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P18FourSumTest {

  private final P18FourSum function = new P18FourSum();

  @Test
  void example() {
    assertThat(function.fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0))
        .containsExactly(
            Arrays.asList(-1, 0, 0, 1), Arrays.asList(-2, -1, 1, 2), Arrays.asList(-2, 0, 0, 2));
  }

  @Test
  void mustFilterDuplicateResults() {
    assertThat(function.fourSum(new int[] {-3, -2, -1, 0, 0, 1, 2, 3}, 0))
        .containsExactly(
            Arrays.asList(-3, -2, 2, 3),
            Arrays.asList(-3, -1, 1, 3),
            Arrays.asList(-3, 0, 0, 3),
            Arrays.asList(-3, 0, 1, 2),
            Arrays.asList(-2, -1, 0, 3),
            Arrays.asList(-2, -1, 1, 2),
            Arrays.asList(-2, 0, 0, 2),
            Arrays.asList(-1, 0, 0, 1));
  }

  @Test
  void singleSolutionAllZeroes() {
    assertThat(function.fourSum(new int[] {0, 0, 0, 0}, 0))
        .containsExactly(Arrays.asList(0, 0, 0, 0));
  }

  @Test
  void moreChancesOfDuplicates() {
    assertThat(function.fourSum(new int[] {-1, -5, -5, -3, 2, 5, 0, 4}, -7))
        .containsExactly(Arrays.asList(-5, -5, -1, 4), Arrays.asList(-5, -3, -1, 2));
  }
}
