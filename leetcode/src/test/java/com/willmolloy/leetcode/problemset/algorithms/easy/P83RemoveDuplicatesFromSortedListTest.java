package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

/**
 * P83RemoveDuplicatesFromSortedListTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P83RemoveDuplicatesFromSortedListTest {

  private final P83RemoveDuplicatesFromSortedList fun = new P83RemoveDuplicatesFromSortedList();

  @Test
  void example1() {
    assertThat(fun.deleteDuplicates(ListNode.of(1, 1, 2))).isEqualTo(ListNode.of(1, 2));
  }

  @Test
  void example2() {
    assertThat(fun.deleteDuplicates(ListNode.of(1, 1, 2, 3, 3))).isEqualTo(ListNode.of(1, 2, 3));
  }

  @Test
  void skipTwiceInARow() {
    assertThat(fun.deleteDuplicates(ListNode.of(1, 1, 1))).isEqualTo(ListNode.of(1));
  }
}
