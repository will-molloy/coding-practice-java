package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P221MaximalSquareTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P221MaximalSquareTest {

  private final P221MaximalSquare p221 = new P221MaximalSquare();

  @Test
  void example() {
    assertThat(
            p221.maximalSquare(
                new char[][] {
                  {'1', '0', '1', '0', '0'},
                  {'1', '0', '1', '1', '1'},
                  {'1', '1', '1', '1', '1'},
                  {'1', '0', '0', '1', '0'}
                }))
        .isEqualTo(4);
  }
}
