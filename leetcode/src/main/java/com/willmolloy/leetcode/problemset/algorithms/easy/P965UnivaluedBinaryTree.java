package com.willmolloy.leetcode.problemset.algorithms.easy;

import com.willmolloy.leetcode.common.TreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/univalued-binary-tree>https://leetcode.com/problems/univalued-binary-tree/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(h)
 *
 * <p>Key idea: dfs helper method.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P965UnivaluedBinaryTree {

  public boolean isUnivalTree(TreeNode root) {
    if (root == null) {
      return true;
    }

    int value = root.val;
    return dfs(root.left, value) && dfs(root.right, value);
  }

  private boolean dfs(TreeNode node, int value) {
    if (node == null) {
      return true;
    }
    if (node.val != value) {
      return false;
    }
    return dfs(node.left, value) && dfs(node.right, value);
  }
}
