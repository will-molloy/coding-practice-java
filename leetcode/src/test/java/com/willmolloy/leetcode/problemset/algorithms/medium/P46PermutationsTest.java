package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
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
            ImmutableList.of(1, 2, 3),
            ImmutableList.of(1, 3, 2),
            ImmutableList.of(2, 1, 3),
            ImmutableList.of(2, 3, 1),
            ImmutableList.of(3, 1, 2),
            ImmutableList.of(3, 2, 1));
  }
}
