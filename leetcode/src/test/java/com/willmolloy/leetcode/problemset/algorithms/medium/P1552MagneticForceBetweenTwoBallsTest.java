package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1552MagneticForceBetweenTwoBallsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1552MagneticForceBetweenTwoBallsTest {

  private final P1552MagneticForceBetweenTwoBalls p1552 = new P1552MagneticForceBetweenTwoBalls();

  @Test
  void example1() {
    assertThat(p1552.maxDistance(new int[] {1, 2, 3, 4, 7}, 3)).isEqualTo(3);
  }

  @Test
  void example2() {
    assertThat(p1552.maxDistance(new int[] {5, 4, 3, 2, 1, 1000000000}, 2)).isEqualTo(999999999);
  }

  @Test
  void example1Place4Balls() {
    assertThat(p1552.maxDistance(new int[] {1, 2, 3, 4, 7}, 4)).isEqualTo(1);
  }

  @Test
  void example1NoBasketAt4() {
    assertThat(p1552.maxDistance(new int[] {1, 2, 3, 7}, 3)).isEqualTo(2);
  }
}
