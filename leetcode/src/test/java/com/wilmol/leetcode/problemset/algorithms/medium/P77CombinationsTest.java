package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.Test;

/**
 * P77CombinationsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P77CombinationsTest {

  private final P77Combinations fun = new P77Combinations();

  @Test
  void n4k2() {
    assertThat(fun.combine(4, 2))
        .containsExactly(
            List.of(1, 2),
            List.of(1, 3),
            List.of(1, 4),
            List.of(2, 3),
            List.of(2, 4),
            List.of(3, 4));
  }
}
