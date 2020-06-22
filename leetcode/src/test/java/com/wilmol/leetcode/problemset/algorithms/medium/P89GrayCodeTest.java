package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-02-07. */
class P89GrayCodeTest {

  private final P89GrayCode func = new P89GrayCode();

  @Test
  void n0() {
    assertThat(func.grayCode(0)).containsExactly(0);
  }

  @Test
  void n1() {
    assertThat(func.grayCode(1)).containsExactly(0, 1).inOrder();
  }

  @Test
  void n2() {
    assertThat(func.grayCode(2))
        .isAnyOf(ImmutableList.of(0, 2, 3, 1), ImmutableList.of(0, 1, 3, 2));
  }

  @Test
  void n3() {
    // technically other answers are valid... but didn't bother computing
    assertThat(func.grayCode(3)).containsExactly(0, 1, 3, 2, 6, 7, 5, 4).inOrder();
  }

  @Test
  void n4() {
    // technically other answers are valid... but didn't bother computing
    assertThat(func.grayCode(4))
        .containsExactly(0, 1, 3, 2, 6, 7, 5, 4, 12, 13, 15, 14, 10, 11, 9, 8)
        .inOrder();
  }
}
