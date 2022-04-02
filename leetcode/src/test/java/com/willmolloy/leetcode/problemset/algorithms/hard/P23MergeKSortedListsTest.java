package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

/**
 * P23MergeKSortedListsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P23MergeKSortedListsTest {

  private final P23MergeKSortedLists fun = new P23MergeKSortedLists();

  @Test
  void example() {
    assertThat(
            fun.mergeKLists(
                new ListNode[] {ListNode.of(1, 4, 5), ListNode.of(1, 3, 4), ListNode.of(2, 6)}))
        .isEqualTo(ListNode.of(1, 1, 2, 3, 4, 4, 5, 6));
  }
}
