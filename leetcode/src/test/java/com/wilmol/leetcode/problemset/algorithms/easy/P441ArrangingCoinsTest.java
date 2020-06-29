package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P441ArrangingCoinsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P441ArrangingCoinsTest {

  private final P441ArrangingCoins p441 = new P441ArrangingCoins();

  @Test
  void example1() {
    assertThat(p441.arrangeCoins(5)).isEqualTo(2);
  }

  @Test
  void example2() {
    assertThat(p441.arrangeCoins(8)).isEqualTo(3);
  }

  @Test
  void fitsExactly() {
    assertThat(p441.arrangeCoins(10)).isEqualTo(4);
  }
}
