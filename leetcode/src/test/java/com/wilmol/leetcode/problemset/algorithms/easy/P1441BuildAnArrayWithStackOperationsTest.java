package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-05-10. */
class P1441BuildAnArrayWithStackOperationsTest {

  private final P1441BuildAnArrayWithStackOperations p1441 =
      new P1441BuildAnArrayWithStackOperations();

  @Test
  void example1() {
    assertThat(p1441.buildArray(new int[] {1, 3}, 3))
        .containsExactly("Push", "Push", "Pop", "Push")
        .inOrder();
  }

  @Test
  void example2() {
    assertThat(p1441.buildArray(new int[] {1, 2, 3}, 3))
        .containsExactly("Push", "Push", "Push")
        .inOrder();
  }

  @Test
  void example3() {
    assertThat(p1441.buildArray(new int[] {1, 2}, 4)).containsExactly("Push", "Push").inOrder();
  }

  @Test
  void example4() {
    assertThat(p1441.buildArray(new int[] {2, 3, 4}, 4))
        .containsExactly("Push", "Pop", "Push", "Push", "Push")
        .inOrder();
  }
}
