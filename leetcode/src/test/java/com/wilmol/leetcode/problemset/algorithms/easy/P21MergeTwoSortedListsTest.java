package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

/** Created by Will on 2019-07-23 at 20:29. */
class P21MergeTwoSortedListsTest {

  private final P21MergeTwoSortedLists function = new P21MergeTwoSortedLists();

  @Test
  void example() {
    assertThat(function.mergeTwoLists(ListNode.of(1, 2, 4), ListNode.of(1, 3, 4)))
        .isEqualTo(ListNode.of(1, 1, 2, 3, 4, 4));
  }

  @Test
  void singleList() {
    assertThat(function.mergeTwoLists(ListNode.of(1, 2, 4), ListNode.of()))
        .isEqualTo(ListNode.of(1, 2, 4));
    assertThat(function.mergeTwoLists(ListNode.of(), ListNode.of(1, 3, 4)))
        .isEqualTo(ListNode.of(1, 3, 4));
  }

  @Test
  void listsDontOverlap() {
    assertThat(function.mergeTwoLists(ListNode.of(1, 2, 3), ListNode.of(7, 8, 9)))
        .isEqualTo(ListNode.of(1, 2, 3, 7, 8, 9));
  }

  @Test
  void bothEmpty() {
    assertThat(function.mergeTwoLists(ListNode.of(), ListNode.of())).isEqualTo(ListNode.of());
  }
}
