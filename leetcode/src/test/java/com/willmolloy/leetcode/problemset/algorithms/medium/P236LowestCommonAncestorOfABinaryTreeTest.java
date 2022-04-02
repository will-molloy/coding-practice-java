package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

/**
 * P236LowestCommonAncestorOfABinaryTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P236LowestCommonAncestorOfABinaryTreeTest {

  private final P236LowestCommonAncestorOfABinaryTree p236 =
      new P236LowestCommonAncestorOfABinaryTree();

  @Test
  void example1RootIsLca() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
    BinaryTreeNode p = root.left;
    BinaryTreeNode q = root.right;
    assertThat(p236.lowestCommonAncestor(root, p, q)).isSameInstanceAs(root);
  }

  @Test
  void example2PIsLca() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
    BinaryTreeNode p = root.left;
    BinaryTreeNode q = root.left.right.right;
    assertThat(p236.lowestCommonAncestor(root, p, q)).isSameInstanceAs(p);
  }

  @Test
  void qIsLca() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
    BinaryTreeNode p = root.left.right.left;
    BinaryTreeNode q = root.left.right;
    assertThat(p236.lowestCommonAncestor(root, p, q)).isSameInstanceAs(q);
  }

  @Test
  void nonRootPNorQIsLca() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
    BinaryTreeNode p = root.left.left;
    BinaryTreeNode q = root.left.right;
    BinaryTreeNode lca = root.left;
    assertThat(p236.lowestCommonAncestor(root, p, q)).isSameInstanceAs(lca);
  }
}
