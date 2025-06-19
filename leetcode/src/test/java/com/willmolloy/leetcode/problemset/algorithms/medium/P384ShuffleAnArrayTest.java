package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * P384ShuffleAnArrayTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P384ShuffleAnArrayTest {

  @Test
  void example() {
    P384ShuffleAnArray.Solution solution = new P384ShuffleAnArray.Solution(new int[] {1, 2, 3});
    assertThat(solution.shuffle())
        .asList()
        .isAnyOf(
            List.of(1, 2, 3),
            List.of(1, 3, 2),
            List.of(2, 1, 3),
            List.of(2, 3, 1),
            List.of(3, 1, 2),
            List.of(3, 2, 1));
    assertThat(solution.reset()).asList().containsExactly(1, 2, 3).inOrder();
    assertThat(solution.shuffle())
        .asList()
        .isAnyOf(
            List.of(1, 2, 3),
            List.of(1, 3, 2),
            List.of(2, 1, 3),
            List.of(2, 3, 1),
            List.of(3, 1, 2),
            List.of(3, 2, 1));
  }
}
