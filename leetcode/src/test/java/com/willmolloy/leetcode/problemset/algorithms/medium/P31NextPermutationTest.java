package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P31NextPermutationTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P31NextPermutationTest {

  private final P31NextPermutation fun = new P31NextPermutation();

  @Test
  void example1() {
    int[] nums = new int[] {1, 2, 3};
    fun.nextPermutation(nums);
    assertThat(nums).asList().containsExactly(1, 3, 2).inOrder();
  }

  @Test
  void example2() {
    int[] nums = new int[] {3, 2, 1};
    fun.nextPermutation(nums);
    assertThat(nums).asList().containsExactly(1, 2, 3).inOrder();
  }

  @Test
  void example3() {
    int[] nums = new int[] {1, 1, 5};
    fun.nextPermutation(nums);
    assertThat(nums).asList().containsExactly(1, 5, 1).inOrder();
  }

  @Test
  void longerExample() {
    int[] nums = new int[] {1, 2, 3, 5, 4};
    fun.nextPermutation(nums);
    assertThat(nums).asList().containsExactly(1, 2, 4, 3, 5).inOrder();
  }

  @Test
  void sameElementRepeated() {
    int[] nums = new int[] {1, 1};
    fun.nextPermutation(nums);
    assertThat(nums).asList().containsExactly(1, 1).inOrder();
  }

  @Test
  void descendingOrderWithRepeatedElements() {
    int[] nums = new int[] {5, 1, 1};
    fun.nextPermutation(nums);
    assertThat(nums).asList().containsExactly(1, 1, 5).inOrder();
  }
}
