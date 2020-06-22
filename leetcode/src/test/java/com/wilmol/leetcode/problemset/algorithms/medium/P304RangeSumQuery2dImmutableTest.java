package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-03-29. */
class P304RangeSumQuery2dImmutableTest {

  @Test
  void example() {
    P304RangeSumQuery2dImmutable.NumMatrix numMatrix =
        new P304RangeSumQuery2dImmutable.NumMatrix(
            new int[][] {
              {3, 0, 1, 4, 2},
              {5, 6, 3, 2, 1},
              {1, 2, 0, 1, 5},
              {4, 1, 0, 1, 7},
              {1, 0, 3, 0, 5}
            });
    assertAll(
        () -> assertThat(numMatrix.sumRegion(2, 1, 4, 3)).isEqualTo(8),
        () -> assertThat(numMatrix.sumRegion(1, 1, 2, 2)).isEqualTo(11),
        () -> assertThat(numMatrix.sumRegion(1, 2, 2, 4)).isEqualTo(12));
  }

  @Test
  void singleRow() {
    P304RangeSumQuery2dImmutable.NumMatrix numMatrix =
        new P304RangeSumQuery2dImmutable.NumMatrix(
            new int[][] {
              {-4, -5},
            });
    assertAll(
        () -> assertThat(numMatrix.sumRegion(0, 0, 0, 0)).isEqualTo(-4),
        () -> assertThat(numMatrix.sumRegion(0, 0, 0, 1)).isEqualTo(-9),
        () -> assertThat(numMatrix.sumRegion(0, 1, 0, 1)).isEqualTo(-5));
  }

  @Test
  void singleColumn() {
    P304RangeSumQuery2dImmutable.NumMatrix numMatrix =
        new P304RangeSumQuery2dImmutable.NumMatrix(
            new int[][] {
              {-4}, {-5},
            });
    assertAll(
        () -> assertThat(numMatrix.sumRegion(0, 0, 0, 0)).isEqualTo(-4),
        () -> assertThat(numMatrix.sumRegion(0, 0, 1, 0)).isEqualTo(-9),
        () -> assertThat(numMatrix.sumRegion(1, 0, 1, 0)).isEqualTo(-5));
  }

  @Test
  void constructNoRows() {
    assertDoesNotThrow(() -> new P304RangeSumQuery2dImmutable.NumMatrix(new int[][] {}));
  }

  @Test
  void constructNoColumns() {
    assertDoesNotThrow(() -> new P304RangeSumQuery2dImmutable.NumMatrix(new int[][] {{}}));
  }
}
