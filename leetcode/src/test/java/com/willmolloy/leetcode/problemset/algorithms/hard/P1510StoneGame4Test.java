package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1510StoneGame4Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1510StoneGame4Test {

  private final P1510StoneGame4 p1510 = new P1510StoneGame4();

  @Test
  void example1() {
    assertThat(p1510.winnerSquareGame(1)).isTrue();
  }

  @Test
  void example2() {
    assertThat(p1510.winnerSquareGame(2)).isFalse();
  }

  @Test
  void example3() {
    assertThat(p1510.winnerSquareGame(4)).isTrue();
  }

  @Test
  void example4() {
    assertThat(p1510.winnerSquareGame(7)).isFalse();
  }

  @Test
  void example5() {
    assertThat(p1510.winnerSquareGame(17)).isFalse();
  }
}
