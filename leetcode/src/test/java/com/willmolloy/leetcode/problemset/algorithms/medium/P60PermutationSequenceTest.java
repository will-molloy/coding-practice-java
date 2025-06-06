package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P60PermutationSequenceTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P60PermutationSequenceTest {

  private final P60PermutationSequence fun = new P60PermutationSequence();

  @Test
  void example1() {
    assertThat(fun.getPermutation(3, 3)).isEqualTo("213");
  }

  @Test
  void example2() {
    assertThat(fun.getPermutation(4, 9)).isEqualTo("2314");
  }
}
