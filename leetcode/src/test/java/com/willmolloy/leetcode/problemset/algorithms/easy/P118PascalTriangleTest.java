package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * P118PascalTriangleTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P118PascalTriangleTest {

  private final P118PascalTriangle fun = new P118PascalTriangle();

  @Test
  void example() {
    assertThat(fun.generate(5))
        .containsExactly(
            List.of(1),
            List.of(1, 1),
            List.of(1, 2, 1),
            List.of(1, 3, 3, 1),
            List.of(1, 4, 6, 4, 1))
        .inOrder();
  }

  @Test
  void empty() {
    assertThat(fun.generate(0)).isEmpty();
  }
}
