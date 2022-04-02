package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

/**
 * P216CombinationSum3Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P216CombinationSum3Test {

  private final P216CombinationSum3 p216 = new P216CombinationSum3();

  @Test
  void example1() {
    assertThat(p216.combinationSum3(3, 7)).containsExactly(ImmutableList.of(1, 2, 4));
  }

  @Test
  void example2() {
    assertThat(p216.combinationSum3(3, 9))
        .containsExactly(
            ImmutableList.of(1, 2, 6), ImmutableList.of(1, 3, 5), ImmutableList.of(2, 3, 4));
  }
}
