package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1664WaysToMakeAFairArrayTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1664WaysToMakeAFairArrayTest {

  private final P1664WaysToMakeAFairArray p1664 = new P1664WaysToMakeAFairArray();

  @Test
  void example1() {
    assertThat(p1664.waysToMakeFair(new int[] {2, 1, 6, 4})).isEqualTo(1);
  }

  @Test
  void example2() {
    assertThat(p1664.waysToMakeFair(new int[] {1, 1, 1})).isEqualTo(3);
  }

  @Test
  void example3() {
    assertThat(p1664.waysToMakeFair(new int[] {1, 2, 3})).isEqualTo(0);
  }
}
