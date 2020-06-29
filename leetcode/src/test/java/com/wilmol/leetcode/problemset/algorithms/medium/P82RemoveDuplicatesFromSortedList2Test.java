package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

/**
 * P82RemoveDuplicatesFromSortedList2Test.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P82RemoveDuplicatesFromSortedList2Test {

  private final P82RemoveDuplicatesFromSortedList2 fun = new P82RemoveDuplicatesFromSortedList2();

  @Test
  void example1DupesInMiddle() {
    assertThat(fun.deleteDuplicates(ListNode.of(1, 2, 3, 3, 4, 4, 5)))
        .isEqualTo(ListNode.of(1, 2, 5));
  }

  @Test
  void example2DupeAtStart() {
    assertThat(fun.deleteDuplicates(ListNode.of(1, 1, 1, 2, 3))).isEqualTo(ListNode.of(2, 3));
  }

  @Test
  void dupeAtEnd() {
    assertThat(fun.deleteDuplicates(ListNode.of(1, 2, 3, 3))).isEqualTo(ListNode.of(1, 2));
  }

  @Test
  void allDupes() {
    assertThat(fun.deleteDuplicates(ListNode.of(1, 1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 5, 5))).isNull();
  }

  @Test
  void noDupes() {
    assertThat(fun.deleteDuplicates(ListNode.of(1, 2, 3, 4, 5)))
        .isEqualTo(ListNode.of(1, 2, 3, 4, 5));
  }

  @Test
  void middleAdjacentDupes() {
    assertThat(fun.deleteDuplicates(ListNode.of(1, 2, 2, 3, 3, 4, 5)))
        .isEqualTo(ListNode.of(1, 4, 5));
  }

  @Test
  void middleDisjointDupes() {
    assertThat(fun.deleteDuplicates(ListNode.of(1, 2, 2, 3, 4, 4, 5)))
        .isEqualTo(ListNode.of(1, 3, 5));
  }
}
