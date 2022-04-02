package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P179LargestNumberTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P179LargestNumberTest {

  private final P179LargestNumber p179 = new P179LargestNumber();

  @Test
  void example1() {
    assertThat(p179.largestNumber(new int[] {10, 2})).isEqualTo("210");
  }

  @Test
  void example2() {
    assertThat(p179.largestNumber(new int[] {3, 30, 34, 5, 9})).isEqualTo("9534330");
  }

  @Test
  void zeros() {
    assertThat(p179.largestNumber(new int[] {0, 0})).isEqualTo("0");
  }
}
