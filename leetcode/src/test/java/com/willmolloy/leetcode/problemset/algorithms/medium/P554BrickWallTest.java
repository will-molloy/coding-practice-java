package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * P554BrickWallTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P554BrickWallTest {

  private final P554BrickWall fun = new P554BrickWall();

  @Test
  void example() {
    assertThat(
            fun.leastBricks(
                List.of(
                    List.of(1, 2, 2, 1),
                    List.of(3, 1, 2),
                    List.of(1, 3, 2),
                    List.of(2, 4),
                    List.of(3, 1, 2),
                    List.of(1, 3, 1, 1))))
        .isEqualTo(2);
  }

  @Test
  void crossBrickInEveryRow() {
    assertThat(fun.leastBricks(List.of(List.of(1), List.of(1), List.of(1)))).isEqualTo(3);
  }
}
