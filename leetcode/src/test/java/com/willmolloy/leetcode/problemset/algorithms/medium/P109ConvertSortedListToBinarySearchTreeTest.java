package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.ListNode;
import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P109ConvertSortedListToBinarySearchTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P109ConvertSortedListToBinarySearchTreeTest {

  private final P109ConvertSortedListToBinarySearchTree fun =
      new P109ConvertSortedListToBinarySearchTree();

  @Test
  void example() {
    ListNode list = ListNode.of(-10, -3, 0, 5, 9);
    TreeNode expected = TreeNode.fromLevelOrder(0, -3, 9, -10, null, 5);
    assertThat(fun.sortedListToBst(list)).isEqualTo(expected);
  }

  @Test
  void oddSizedList() {
    ListNode list = ListNode.of(1, 2, 3, 4, 5);
    TreeNode expected = TreeNode.fromLevelOrder(3, 2, 5, 1, null, 4, null);
    assertThat(fun.sortedListToBst(list)).isEqualTo(expected);
  }

  @Test
  void evenSizedList() {
    ListNode list = ListNode.of(1, 2, 3, 4);
    TreeNode expected = TreeNode.fromLevelOrder(3, 2, 4, 1, null, null, null);
    assertThat(fun.sortedListToBst(list)).isEqualTo(expected);
  }
}
