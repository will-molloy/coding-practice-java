package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P41FirstMissingPositiveTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P41FirstMissingPositiveTest {

  private final P41FirstMissingPositive fun = new P41FirstMissingPositive();

  @Test
  void example1() {
    assertThat(fun.firstMissingPositive(new int[] {1, 2, 0})).isEqualTo(3);
  }

  @Test
  void example2() {
    assertThat(fun.firstMissingPositive(new int[] {3, 4, -1, 1})).isEqualTo(2);
  }

  @Test
  void example3() {
    assertThat(fun.firstMissingPositive(new int[] {7, 8, 9, 11, 12})).isEqualTo(1);
  }

  @Test
  void noneMissingDescendingOrder() {
    assertThat(fun.firstMissingPositive(new int[] {4, 3, 2, 1})).isEqualTo(5);
  }

  @Test
  void noneMissingAscendingOrder() {
    assertThat(fun.firstMissingPositive(new int[] {1, 2, 3, 4})).isEqualTo(5);
  }

  @Test
  void negativeValues() {
    assertThat(fun.firstMissingPositive(new int[] {-1, -2, -3})).isEqualTo(1);
  }

  @Test
  void onlyOnes() {
    assertThat(fun.firstMissingPositive(new int[] {1, 1})).isEqualTo(2);
  }

  @Test
  void onlyTwos() {
    assertThat(fun.firstMissingPositive(new int[] {2, 2})).isEqualTo(1);
  }

  @Test
  void naiveSwapPutsSmallerElementOutOfOrder() {
    assertThat(fun.firstMissingPositive(new int[] {-1, 4, 2, 1, 9, 10})).isEqualTo(3);
  }

  @Test
  void naiveSwapPutsLargerElementOutOfOrder() {
    assertThat(
            fun.firstMissingPositive(
                new int[] {3, 4, 2, 2, 9, 5, 1, 13, -1, -1, -4, 3, 15, -10, 6, 10}))
        .isEqualTo(7);
  }
}
