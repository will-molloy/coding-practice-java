package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.primitives.Ints;
import org.junit.jupiter.api.Test;

/** Created by Will on 2019-07-28 at 00:10. */
class P27RemoveElementTest {

  private P27RemoveElement fun = new P27RemoveElement();

  @Test
  void example1() {
    int[] nums = new int[] {3, 2, 2, 3};
    assertThat(fun.removeElement(nums, 2)).isEqualTo(2);
    assertThat(Ints.asList(nums).subList(0, 2)).containsExactly(3, 3).inOrder();
  }

  @Test
  void example2() {
    int[] nums = new int[] {0, 1, 2, 2, 3, 0, 4, 2};
    assertThat(fun.removeElement(nums, 2)).isEqualTo(5);
    assertThat(Ints.asList(nums).subList(0, 5)).containsExactly(0, 1, 3, 0, 4).inOrder();
  }
}
