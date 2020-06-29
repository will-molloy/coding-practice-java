package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.primitives.Ints;
import org.junit.jupiter.api.Test;

/**
 * P80RemoveDuplicatesFromSortedArray2Test.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P80RemoveDuplicatesFromSortedArray2Test {

  private final P80RemoveDuplicatesFromSortedArray2 fun = new P80RemoveDuplicatesFromSortedArray2();

  @Test
  void example1() {
    int[] nums = new int[] {1, 1, 1, 2, 2, 3};
    assertThat(fun.removeDuplicates(nums)).isEqualTo(5);
    assertThat(Ints.asList(nums).subList(0, 5)).containsExactly(1, 1, 2, 2, 3).inOrder();
  }

  @Test
  void example2() {
    int[] nums = new int[] {0, 0, 1, 1, 1, 1, 2, 3, 3};
    assertThat(fun.removeDuplicates(nums)).isEqualTo(7);
    assertThat(Ints.asList(nums).subList(0, 7)).containsExactly(0, 0, 1, 1, 2, 3, 3).inOrder();
  }

  @Test
  void singleElement() {
    int[] nums = new int[] {-1};
    assertThat(fun.removeDuplicates(nums)).isEqualTo(1);
    assertThat(Ints.asList(nums).subList(0, 1)).containsExactly(-1).inOrder();
  }

  @Test
  void duplicatesAtEnd() {
    int[] nums = new int[] {1, 2, 2, 2};
    assertThat(fun.removeDuplicates(nums)).isEqualTo(3);
    assertThat(Ints.asList(nums).subList(0, 3)).containsExactly(1, 2, 2).inOrder();
  }
}
