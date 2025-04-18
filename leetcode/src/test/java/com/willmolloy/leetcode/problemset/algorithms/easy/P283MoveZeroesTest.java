package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P283MoveZeroesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P283MoveZeroesTest {

  private final P283MoveZeroes fun = new P283MoveZeroes();

  @Test
  void example() {
    int[] nums = {0, 1, 0, 3, 12};
    fun.moveZeroes(nums);
    assertThat(nums).asList().containsExactly(1, 3, 12, 0, 0).inOrder();
  }

  @Test
  void noZeroes() {
    int[] nums = {1, 2, 3};
    fun.moveZeroes(nums);
    assertThat(nums).asList().containsExactly(1, 2, 3).inOrder();
  }

  @Test
  void zeroAtStart() {
    int[] nums = {0, 1, 2, 3};
    fun.moveZeroes(nums);
    assertThat(nums).asList().containsExactly(1, 2, 3, 0).inOrder();
  }

  @Test
  void zeroAtEnd() {
    int[] nums = {1, 2, 3, 0};
    fun.moveZeroes(nums);
    assertThat(nums).asList().containsExactly(1, 2, 3, 0).inOrder();
  }

  @Test
  void onlyZeroes() {
    int[] nums = {0, 0, 0};
    fun.moveZeroes(nums);
    assertThat(nums).asList().containsExactly(0, 0, 0).inOrder();
  }
}
