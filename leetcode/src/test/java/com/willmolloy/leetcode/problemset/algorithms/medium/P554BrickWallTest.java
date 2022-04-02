package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

/**
 * P554BrickWallTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P554BrickWallTest {

  private final P554BrickWall fun = new P554BrickWall();

  @Test
  void example() {
    assertThat(
            fun.leastBricks(
                ImmutableList.of(
                    ImmutableList.of(1, 2, 2, 1),
                    ImmutableList.of(3, 1, 2),
                    ImmutableList.of(1, 3, 2),
                    ImmutableList.of(2, 4),
                    ImmutableList.of(3, 1, 2),
                    ImmutableList.of(1, 3, 1, 1))))
        .isEqualTo(2);
  }

  @Test
  void crossBrickInEveryRow() {
    assertThat(
            fun.leastBricks(
                ImmutableList.of(ImmutableList.of(1), ImmutableList.of(1), ImmutableList.of(1))))
        .isEqualTo(3);
  }
}
