package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1304FindNUniqueIntegersSumUpToZeroTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1304FindNUniqueIntegersSumUpToZeroTest {

  private final P1304FindNUniqueIntegersSumUpToZero p1304 =
      new P1304FindNUniqueIntegersSumUpToZero();

  @Test
  void even() {
    assertThat(p1304.sumZero(2)).asList().containsExactly(-1, 1).inOrder();
  }

  @Test
  void odd() {
    assertThat(p1304.sumZero(3)).asList().containsExactly(-1, 0, 1).inOrder();
  }

  @Test
  void one() {
    assertThat(p1304.sumZero(1)).asList().containsExactly(0);
  }
}
