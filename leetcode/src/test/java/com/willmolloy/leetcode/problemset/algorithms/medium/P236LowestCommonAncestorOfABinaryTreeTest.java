package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P236LowestCommonAncestorOfABinaryTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P236LowestCommonAncestorOfABinaryTreeTest {

  private final P236LowestCommonAncestorOfABinaryTree p236 =
      new P236LowestCommonAncestorOfABinaryTree();

  @Test
  void example1RootIsLca() {
    TreeNode root = TreeNode.fromLevelOrder(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
    TreeNode p = root.left;
    TreeNode q = root.right;
    assertThat(p236.lowestCommonAncestor(root, p, q)).isSameInstanceAs(root);
  }

  @Test
  void example2PIsLca() {
    TreeNode root = TreeNode.fromLevelOrder(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
    TreeNode p = root.left;
    TreeNode q = root.left.right.right;
    assertThat(p236.lowestCommonAncestor(root, p, q)).isSameInstanceAs(p);
  }

  @Test
  void qIsLca() {
    TreeNode root = TreeNode.fromLevelOrder(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
    TreeNode p = root.left.right.left;
    TreeNode q = root.left.right;
    assertThat(p236.lowestCommonAncestor(root, p, q)).isSameInstanceAs(q);
  }

  @Test
  void nonRootPNorQIsLca() {
    TreeNode root = TreeNode.fromLevelOrder(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
    TreeNode p = root.left.left;
    TreeNode q = root.left.right;
    TreeNode lca = root.left;
    assertThat(p236.lowestCommonAncestor(root, p, q)).isSameInstanceAs(lca);
  }
}
