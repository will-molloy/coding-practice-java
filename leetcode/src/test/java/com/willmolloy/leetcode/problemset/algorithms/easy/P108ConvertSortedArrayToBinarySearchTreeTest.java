package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

/**
 * P108ConvertSortedArrayToBinarySearchTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P108ConvertSortedArrayToBinarySearchTreeTest {

  private final P108ConvertSortedArrayToBinarySearchTree fun =
      new P108ConvertSortedArrayToBinarySearchTree();

  @Test
  void oddSizedArray() {
    BinaryTreeNode expected = BinaryTreeNode.fromLevelOrder(3, 1, 4, null, 2, null, 5);
    assertThat(fun.sortedArrayToBst(new int[] {1, 2, 3, 4, 5})).isEqualTo(expected);
  }

  @Test
  void evenSizedArray() {
    BinaryTreeNode expected = BinaryTreeNode.fromLevelOrder(2, 1, 3, null, null, null, 4);
    assertThat(fun.sortedArrayToBst(new int[] {1, 2, 3, 4})).isEqualTo(expected);
  }
}
