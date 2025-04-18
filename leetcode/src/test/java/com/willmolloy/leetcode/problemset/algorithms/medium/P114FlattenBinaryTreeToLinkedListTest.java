package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P114FlattenBinaryTreeToLinkedListTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P114FlattenBinaryTreeToLinkedListTest {

  private final P114FlattenBinaryTreeToLinkedList fun = new P114FlattenBinaryTreeToLinkedList();

  @Test
  void example() {
    TreeNode root = TreeNode.fromLevelOrder(1, 2, 5, 3, 4, null, 6);
    fun.flatten(root);
    TreeNode newRoot = new TreeNode(1);
    newRoot.right = new TreeNode(2);
    newRoot.right.right = new TreeNode(3);
    newRoot.right.right.right = new TreeNode(4);
    newRoot.right.right.right.right = new TreeNode(5);
    newRoot.right.right.right.right.right = new TreeNode(6);
    assertThat(root).isEqualTo(newRoot);
  }

  @Test
  void emptyTree() {
    fun.flatten(null);
  }
}
