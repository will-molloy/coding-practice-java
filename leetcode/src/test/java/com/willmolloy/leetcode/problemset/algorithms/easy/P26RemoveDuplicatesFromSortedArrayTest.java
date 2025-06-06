package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.primitives.Ints;
import org.junit.jupiter.api.Test;

/**
 * P26RemoveDuplicatesFromSortedArrayTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P26RemoveDuplicatesFromSortedArrayTest {

  private final P26RemoveDuplicatesFromSortedArray fun = new P26RemoveDuplicatesFromSortedArray();

  @Test
  void example1() {
    int[] nums = new int[] {1, 1, 2};
    assertThat(fun.removeDuplicates(nums)).isEqualTo(2);
    assertThat(Ints.asList(nums).subList(0, 2)).containsExactly(1, 2).inOrder();
  }

  @Test
  void example2() {
    int[] nums = new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    assertThat(fun.removeDuplicates(nums)).isEqualTo(5);
    assertThat(Ints.asList(nums).subList(0, 5)).containsExactly(0, 1, 2, 3, 4).inOrder();
  }

  @Test
  void singleElement() {
    int[] nums = new int[] {-1};
    assertThat(fun.removeDuplicates(nums)).isEqualTo(1);
    assertThat(Ints.asList(nums).subList(0, 1)).containsExactly(-1).inOrder();
  }
}
