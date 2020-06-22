package com.wilmol.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-18. */
class P57InsertIntervalTest {

  private final P57InsertInterval p57 = new P57InsertInterval();

  @Test
  void insertHeadNoMerge() {
    assertThat(p57.insert(new int[][] {{2, 3}, {4, 5}}, new int[] {0, 1}))
        .isEqualTo(new int[][] {{0, 1}, {2, 3}, {4, 5}});
  }

  @Test
  void insertMiddleNoMerge() {
    assertThat(p57.insert(new int[][] {{0, 1}, {4, 5}}, new int[] {2, 3}))
        .isEqualTo(new int[][] {{0, 1}, {2, 3}, {4, 5}});
  }

  @Test
  void insertLastNoMerge() {
    assertThat(p57.insert(new int[][] {{0, 1}, {2, 3}}, new int[] {4, 5}))
        .isEqualTo(new int[][] {{0, 1}, {2, 3}, {4, 5}});
  }

  @Test
  void example1() {
    assertThat(p57.insert(new int[][] {{1, 3}, {6, 9}}, new int[] {2, 5}))
        .isEqualTo(new int[][] {{1, 5}, {6, 9}});
  }

  @Test
  void example2() {
    assertThat(
            p57.insert(new int[][] {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[] {4, 8}))
        .isEqualTo(new int[][] {{1, 2}, {3, 10}, {12, 16}});
  }

  @Test
  void newIntervalEatsAll() {
    assertThat(
            p57.insert(new int[][] {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[] {0, 50}))
        .isEqualTo(new int[][] {{0, 50}});
  }

  @Test
  void newIntervalGetsEaten() {
    assertThat(p57.insert(new int[][] {{1, 5}}, new int[] {2, 3})).isEqualTo(new int[][] {{1, 5}});
  }

  @Test
  void empty() {
    assertThat(p57.insert(new int[0][0], new int[] {0, 50})).isEqualTo(new int[][] {{0, 50}});
  }
}
