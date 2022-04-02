package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

/**
 * P114FlattenBinaryTreeToLinkedListTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P114FlattenBinaryTreeToLinkedListTest {

  private final P114FlattenBinaryTreeToLinkedList fun = new P114FlattenBinaryTreeToLinkedList();

  @Test
  void example() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(1, 2, 5, 3, 4, null, 6);
    fun.flatten(root);
    BinaryTreeNode newRoot = new BinaryTreeNode(1);
    newRoot.right = new BinaryTreeNode(2);
    newRoot.right.right = new BinaryTreeNode(3);
    newRoot.right.right.right = new BinaryTreeNode(4);
    newRoot.right.right.right.right = new BinaryTreeNode(5);
    newRoot.right.right.right.right.right = new BinaryTreeNode(6);
    assertThat(root).isEqualTo(newRoot);
  }

  @Test
  void emptyTree() {
    fun.flatten(null);
  }
}
