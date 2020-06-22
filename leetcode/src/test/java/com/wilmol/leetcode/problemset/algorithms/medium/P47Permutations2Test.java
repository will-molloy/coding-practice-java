package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

/** Created by wilmol on 2019-12-01. */
class P47Permutations2Test {

  private final P47Permutations2 fun = new P47Permutations2();

  @Test
  void example() {
    assertThat(fun.permuteUnique(new int[] {1, 1, 2}))
        .containsExactly(
            ImmutableList.of(1, 1, 2), ImmutableList.of(1, 2, 1), ImmutableList.of(2, 1, 1));
  }
}
