package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1465MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCutsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1465MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCutsTest {

  private final P1465MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts p1465 =
      new P1465MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts();

  @Test
  void example1() {
    assertThat(p1465.maxArea(5, 4, new int[] {1, 2, 4}, new int[] {1, 3})).isEqualTo(4);
  }

  @Test
  void example2() {
    assertThat(p1465.maxArea(5, 4, new int[] {3, 1}, new int[] {1})).isEqualTo(6);
  }

  @Test
  void example3() {
    assertThat(p1465.maxArea(5, 4, new int[] {3}, new int[] {3})).isEqualTo(9);
  }

  @Test
  void integerOverflow() {
    assertThat(p1465.maxArea(1_000_000_000, 1_000_000_000, new int[] {1}, new int[] {1}))
        .isEqualTo(64);
  }
}
