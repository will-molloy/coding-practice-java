package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
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
            ImmutableList.of(1),
            ImmutableList.of(1, 1),
            ImmutableList.of(1, 2, 1),
            ImmutableList.of(1, 3, 3, 1),
            ImmutableList.of(1, 4, 6, 4, 1))
        .inOrder();
  }

  @Test
  void empty() {
    assertThat(fun.generate(0)).isEmpty();
  }
}
