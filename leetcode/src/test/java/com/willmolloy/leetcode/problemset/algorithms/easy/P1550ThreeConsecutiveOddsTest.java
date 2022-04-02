package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1550ThreeConsecutiveOddsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1550ThreeConsecutiveOddsTest {

  private final P1550ThreeConsecutiveOdds p1550 = new P1550ThreeConsecutiveOdds();

  @Test
  void example1() {
    assertThat(p1550.threeConsecutiveOdds(new int[] {2, 6, 4, 1})).isFalse();
  }

  @Test
  void example2() {
    assertThat(p1550.threeConsecutiveOdds(new int[] {1, 2, 34, 3, 4, 5, 7, 23, 12})).isTrue();
  }
}
