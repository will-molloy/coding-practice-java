package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1232CheckIfItIsAStraightLineTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1232CheckIfItIsAStraightLineTest {

  private final P1232CheckIfItIsAStraightLine p1232 = new P1232CheckIfItIsAStraightLine();

  @Test
  void example1() {
    assertThat(
            p1232.checkStraightLine(new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}))
        .isTrue();
  }

  @Test
  void example2() {
    assertThat(
            p1232.checkStraightLine(new int[][] {{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}}))
        .isFalse();
  }

  @Test
  void divideByZero() {
    assertThat(
            p1232.checkStraightLine(
                new int[][] {{-1, 1}, {-6, -4}, {-6, 2}, {2, 0}, {-1, -2}, {0, -4}}))
        .isFalse();
  }

  @Test
  void outOfOrder() {
    assertThat(p1232.checkStraightLine(new int[][] {{-4, -3}, {1, 0}, {3, -1}, {0, -1}, {-5, 2}}))
        .isFalse();
  }

  @Test
  void horizontalLine() {
    assertThat(p1232.checkStraightLine(new int[][] {{0, 1}, {1, 1}, {2, 1}, {3, 1}, {4, 1}}))
        .isTrue();
  }

  @Test
  void verticalLine() {
    assertThat(p1232.checkStraightLine(new int[][] {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}}))
        .isTrue();
  }

  @Test
  void twoPoints() {
    assertThat(p1232.checkStraightLine(new int[][] {{-1234, 4567}, {7890, -12345}})).isTrue();
  }

  @Test
  void negativeZeroEqualsPositiveZero() {
    assertThat(
            p1232.checkStraightLine(new int[][] {{-3, -2}, {-1, -2}, {2, -2}, {-2, -2}, {0, -2}}))
        .isTrue();
  }
}
