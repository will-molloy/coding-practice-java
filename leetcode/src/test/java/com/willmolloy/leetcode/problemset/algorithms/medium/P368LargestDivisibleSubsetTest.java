package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * P368LargestDivisibleSubsetTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P368LargestDivisibleSubsetTest {

  private final P368LargestDivisibleSubset p368 = new P368LargestDivisibleSubset();

  @Test
  void example1() {
    assertThat(p368.largestDivisibleSubset(new int[] {1, 2, 3}))
        .isAnyOf(List.of(1, 2), List.of(1, 3));
  }

  @Test
  void example2() {
    assertThat(p368.largestDivisibleSubset(new int[] {1, 2, 4, 8})).containsExactly(1, 2, 4, 8);
  }
}
