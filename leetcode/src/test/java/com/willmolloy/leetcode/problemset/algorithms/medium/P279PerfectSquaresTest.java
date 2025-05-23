package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P279PerfectSquaresTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P279PerfectSquaresTest {

  private final P279PerfectSquares p279 = new P279PerfectSquares();

  @Test
  void example1() {
    // 4 + 4 + 4
    assertThat(p279.numSquares(12)).isEqualTo(3);
  }

  @Test
  void example2() {
    // 9 + 4
    assertThat(p279.numSquares(13)).isEqualTo(2);
  }
}
