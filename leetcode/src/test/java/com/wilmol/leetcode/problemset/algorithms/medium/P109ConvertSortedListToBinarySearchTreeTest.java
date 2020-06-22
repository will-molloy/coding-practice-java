package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.BinaryTreeNode;
import com.wilmol.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-02-14. */
class P109ConvertSortedListToBinarySearchTreeTest {

  private final P109ConvertSortedListToBinarySearchTree fun =
      new P109ConvertSortedListToBinarySearchTree();

  @Test
  void example() {
    ListNode list = ListNode.of(-10, -3, 0, 5, 9);
    BinaryTreeNode expected = BinaryTreeNode.fromLevelOrder(0, -3, 9, -10, null, 5);
    assertThat(fun.sortedListToBst(list)).isEqualTo(expected);
  }

  @Test
  void oddSizedList() {
    ListNode list = ListNode.of(1, 2, 3, 4, 5);
    BinaryTreeNode expected = BinaryTreeNode.fromLevelOrder(3, 2, 5, 1, null, 4, null);
    assertThat(fun.sortedListToBst(list)).isEqualTo(expected);
  }

  @Test
  void evenSizedList() {
    ListNode list = ListNode.of(1, 2, 3, 4);
    BinaryTreeNode expected = BinaryTreeNode.fromLevelOrder(3, 2, 4, 1, null, null, null);
    assertThat(fun.sortedListToBst(list)).isEqualTo(expected);
  }
}
