package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * P47Permutations2Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P47Permutations2Test {

  private final P47Permutations2 fun = new P47Permutations2();

  @Test
  void example() {
    assertThat(fun.permuteUnique(new int[] {1, 1, 2}))
        .containsExactly(List.of(1, 1, 2), List.of(1, 2, 1), List.of(2, 1, 1));
  }
}
