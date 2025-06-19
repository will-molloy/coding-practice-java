package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * P46PermutationsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P46PermutationsTest {

  private final P46Permutations fun = new P46Permutations();

  @Test
  void example() {
    assertThat(fun.permute(new int[] {1, 2, 3}))
        .containsExactly(
            List.of(1, 2, 3),
            List.of(1, 3, 2),
            List.of(2, 1, 3),
            List.of(2, 3, 1),
            List.of(3, 1, 2),
            List.of(3, 2, 1));
  }
}
