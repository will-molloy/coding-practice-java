package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

/**
 * P39CombinationSumTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P39CombinationSumTest {

  private P39CombinationSum.TopDownRecursive topDownRecursive =
      new P39CombinationSum.TopDownRecursive();

  private P39CombinationSum.BottomUpIterative bottomUpIterative =
      new P39CombinationSum.BottomUpIterative();

  @Test
  void example1TopDown() {
    assertThat(topDownRecursive.combinationSum(new int[] {2, 3, 6, 7}, 7))
        .containsExactly(Collections.singletonList(7), Arrays.asList(2, 2, 3));
  }

  @Test
  void example2TopDown() {
    assertThat(topDownRecursive.combinationSum(new int[] {2, 3, 5}, 8))
        .containsExactly(Arrays.asList(2, 2, 2, 2), Arrays.asList(2, 3, 3), Arrays.asList(3, 5));
  }

  @Test
  void example1BottomUp() {
    assertThat(bottomUpIterative.combinationSum(new int[] {2, 3, 6, 7}, 7))
        .containsExactly(Collections.singletonList(7), Arrays.asList(2, 2, 3));
  }

  @Test
  void example2BottomUp() {
    assertThat(bottomUpIterative.combinationSum(new int[] {2, 3, 5}, 8))
        .containsExactly(Arrays.asList(2, 2, 2, 2), Arrays.asList(2, 3, 3), Arrays.asList(3, 5));
  }
}
