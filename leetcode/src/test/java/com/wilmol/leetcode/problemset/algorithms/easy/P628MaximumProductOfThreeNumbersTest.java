package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-03-29. */
class P628MaximumProductOfThreeNumbersTest {

  private final P628MaximumProductOfThreeNumbers fun = new P628MaximumProductOfThreeNumbers();

  @Test
  void example1() {
    assertThat(fun.maximumProduct(new int[] {1, 2, 3})).isEqualTo(6);
  }

  @Test
  void example2() {
    assertThat(fun.maximumProduct(new int[] {1, 2, 3, 4})).isEqualTo(24);
  }

  @Test
  void unsorted() {
    assertThat(fun.maximumProduct(new int[] {5, 10, 4, 3, 2, 1, 10, 7, 8, 9, 10})).isEqualTo(1000);
  }

  @Test
  void usesNegativeNums() {
    assertThat(fun.maximumProduct(new int[] {1000, -1000, 1000, -1000, 999}))
        .isEqualTo(1_000_000_000);
  }
}
