package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1422MaximumScoreAfterSplittingAStringTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1422MaximumScoreAfterSplittingAStringTest {

  private final P1422MaximumScoreAfterSplittingAString p1422 =
      new P1422MaximumScoreAfterSplittingAString();

  @Test
  void example1() {
    assertThat(p1422.maxScore("011101")).isEqualTo(5);
  }

  @Test
  void example2() {
    assertThat(p1422.maxScore("00111")).isEqualTo(5);
  }

  @Test
  void example3() {
    assertThat(p1422.maxScore("1111")).isEqualTo(3);
  }

  @Test
  void n2() {
    assertThat(p1422.maxScore("00")).isEqualTo(1);
  }

  @Test
  void noScore() {
    assertThat(p1422.maxScore("10")).isEqualTo(0);
  }
}
