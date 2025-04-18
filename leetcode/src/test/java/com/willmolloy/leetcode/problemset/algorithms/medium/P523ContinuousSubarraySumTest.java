package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P523ContinuousSubarraySumTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P523ContinuousSubarraySumTest {
  private final P523ContinuousSubarraySum fun = new P523ContinuousSubarraySum();

  @Test
  void example1() {
    assertThat(fun.checkSubarraySum(new int[] {23, 2, 4, 6, 7}, 6)).isTrue();
  }

  @Test
  void example2() {
    assertThat(fun.checkSubarraySum(new int[] {23, 2, 6, 4, 7}, 6)).isTrue();
  }

  @Test
  void kEquals0True() {
    assertThat(fun.checkSubarraySum(new int[] {1, 2, 3, 0, 0, 4, 5, 6}, 0)).isTrue();
  }

  @Test
  void kEquals0False() {
    assertThat(fun.checkSubarraySum(new int[] {1, 2, 3, 0, 4, 5, 6}, 0)).isFalse();
  }

  @Test
  void subsequenceMustBeContiguous() {
    assertThat(fun.checkSubarraySum(new int[] {5, 1, 5}, 10)).isFalse();
  }

  @Test
  void subsequenceMustHaveSizeGreaterThan1() {
    assertThat(fun.checkSubarraySum(new int[] {5, 1, 5}, 5)).isFalse();
  }

  @Test
  void multipleOfZeroIsAnything() {
    assertThat(fun.checkSubarraySum(new int[] {0, 0}, 42)).isTrue();
  }
}
