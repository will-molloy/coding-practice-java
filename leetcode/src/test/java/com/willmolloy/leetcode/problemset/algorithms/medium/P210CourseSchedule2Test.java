package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

/**
 * P210CourseSchedule2Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P210CourseSchedule2Test {

  private final P210CourseSchedule2 p210 = new P210CourseSchedule2();

  @Test
  void example1() {
    assertThat(p210.findOrder(2, new int[][] {{1, 0}})).asList().containsExactly(0, 1).inOrder();
  }

  @Test
  void example2() {
    assertThat(p210.findOrder(4, new int[][] {{1, 0}, {2, 0}, {3, 1}, {3, 2}}))
        .asList()
        .isAnyOf(ImmutableList.of(0, 1, 2, 3), ImmutableList.of(0, 2, 1, 3));
  }

  @Test
  void cycle() {
    assertThat(p210.findOrder(2, new int[][] {{0, 1}, {1, 0}})).isEmpty();
  }
}
