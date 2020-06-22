package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-05-29. */
class P207CourseScheduleTest {

  private final P207CourseSchedule p207 = new P207CourseSchedule();

  @Test
  void example1() {
    assertThat(p207.canFinish(2, new int[][] {{1, 0}})).isTrue();
  }

  @Test
  void example2() {
    assertThat(p207.canFinish(2, new int[][] {{1, 0}, {0, 1}})).isFalse();
  }

  @Test
  void validScheduleTwoPaths() {
    assertThat(p207.canFinish(4, new int[][] {{0, 1}, {0, 2}, {1, 2}, {2, 3}})).isTrue();
  }

  @Test
  void invalidScheduleDisjointGraphSecondGroupInvalid() {
    assertThat(p207.canFinish(6, new int[][] {{0, 1}, {2, 3}, {3, 4}, {4, 5}, {5, 2}})).isFalse();
  }
}
