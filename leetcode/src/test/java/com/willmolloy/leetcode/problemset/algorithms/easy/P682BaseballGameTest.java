package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P682BaseballGameTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P682BaseballGameTest {

  private final P682BaseballGame fun = new P682BaseballGame();

  @Test
  void example1() {
    assertThat(fun.calPoints(new String[] {"5", "2", "C", "D", "+"})).isEqualTo(30);
  }

  @Test
  void example2() {
    assertThat(fun.calPoints(new String[] {"5", "-2", "4", "C", "D", "9", "+", "+"})).isEqualTo(27);
  }
}
