package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P873LengthOfLongestFibonacciSequenceTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P873LengthOfLongestFibonacciSequenceTest {

  private final P873LengthOfLongestFibonacciSequence fun =
      new P873LengthOfLongestFibonacciSequence();

  @Test
  void example1() {
    assertThat(fun.lenLongestFibSubseq(new int[] {1, 2, 3, 4, 5, 6, 7, 8})).isEqualTo(5);
  }

  @Test
  void example2() {
    assertThat(fun.lenLongestFibSubseq(new int[] {1, 3, 7, 11, 12, 14, 18})).isEqualTo(3);
  }

  @Test
  void noFibSequence() {
    assertThat(fun.lenLongestFibSubseq(new int[] {1, 2, 4, 10})).isEqualTo(0);
  }
}
