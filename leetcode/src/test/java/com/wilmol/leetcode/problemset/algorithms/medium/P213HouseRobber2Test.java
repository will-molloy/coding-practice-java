package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P213HouseRobber2Test.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P213HouseRobber2Test {

  private final P213HouseRobber2 fun = new P213HouseRobber2();

  @Test
  void example1() {
    assertThat(fun.rob(new int[] {2, 3, 2})).isEqualTo(3);
  }

  @Test
  void example2() {
    assertThat(fun.rob(new int[] {1, 2, 3, 1})).isEqualTo(4);
  }

  @Test
  void empty() {
    assertThat(fun.rob(new int[0])).isEqualTo(0);
  }

  @Test
  void needHead() {
    assertThat(fun.rob(new int[] {500, 1, 2, 3, 4})).isEqualTo(503);
  }

  @Test
  void needLast() {
    assertThat(fun.rob(new int[] {4, 3, 2, 1, 500})).isEqualTo(503);
  }

  @Test
  void needSecondAndSecondLast() {
    assertThat(fun.rob(new int[] {2, 50, 1, 50, 2})).isEqualTo(100);
  }
}
