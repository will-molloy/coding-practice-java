package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-05-17. */
class P1450NumberOfStudentsDoingHomeworkAtAGivenTimeTest {

  private final P1450NumberOfStudentsDoingHomeworkAtAGivenTime p1450 =
      new P1450NumberOfStudentsDoingHomeworkAtAGivenTime();

  @Test
  void example1() {
    assertThat(p1450.busyStudent(new int[] {1, 2, 3}, new int[] {3, 2, 7}, 4)).isEqualTo(1);
  }

  @Test
  void example2() {
    assertThat(p1450.busyStudent(new int[] {4}, new int[] {4}, 4)).isEqualTo(1);
  }

  @Test
  void example3() {
    assertThat(p1450.busyStudent(new int[] {4}, new int[] {4}, 5)).isEqualTo(0);
  }

  @Test
  void example4() {
    assertThat(p1450.busyStudent(new int[] {1, 1, 1, 1}, new int[] {1, 3, 2, 4}, 7)).isEqualTo(0);
  }

  @Test
  void example5() {
    assertThat(
            p1450.busyStudent(
                new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1},
                new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10},
                5))
        .isEqualTo(5);
  }
}
