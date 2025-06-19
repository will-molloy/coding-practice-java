package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * P120TriangleTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P120TriangleTest {

  private final P120Triangle fun = new P120Triangle();

  @Test
  void example() {
    assertThat(
            fun.minimumTotal(
                List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3))))
        .isEqualTo(11);
  }

  @Test
  void singleRow() {
    assertThat(fun.minimumTotal(List.of(List.of(-10)))).isEqualTo(-10);
  }

  @Test
  void negativeCosts() {
    assertThat(fun.minimumTotal(List.of(List.of(-1), List.of(2, 3), List.of(1, -1, -3))))
        .isEqualTo(-1);
  }
}
