package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P918MaximumSumCircularSubarrayTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P918MaximumSumCircularSubarrayTest {

  private final P918MaximumSumCircularSubarray p918 = new P918MaximumSumCircularSubarray();

  @Test
  void example1() {
    assertThat(p918.maxSubarraySumCircular(new int[] {1, -2, 3, -2})).isEqualTo(3);
  }

  @Test
  void example2() {
    assertThat(p918.maxSubarraySumCircular(new int[] {5, -3, 5})).isEqualTo(10);
  }

  @Test
  void example3() {
    assertThat(p918.maxSubarraySumCircular(new int[] {3, -1, 2, -1})).isEqualTo(4);
  }

  @Test
  void example4() {
    assertThat(p918.maxSubarraySumCircular(new int[] {3, -2, 2, -3})).isEqualTo(3);
  }

  @Test
  void example5() {
    assertThat(p918.maxSubarraySumCircular(new int[] {-2, -3, -1})).isEqualTo(-1);
  }

  @Test
  void wrapsAroundOnZero() {
    assertThat(p918.maxSubarraySumCircular(new int[] {2, -2, 2, 7, 8, 0})).isEqualTo(19);
  }
}
