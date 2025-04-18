package com.willmolloy.leetcode.problemset.algorithms.easy;

import com.willmolloy.leetcode.common.TreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/balanced-binary-tree>https://leetcode.com/problems/balanced-binary-tree</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(h)
 *
 * <p>Key idea: encoding result into another algorithm to reduce work done (getting height of each
 * child and then calling {@code isBalanced} on each child would be O(n<sup>2</sup>) runtime)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P110BalancedBinaryTree {

  public boolean isBalanced(TreeNode root) {
    // encoding -1 height as unbalanced tree to propagate unbalanced result
    // i.e. if child is unbalanced, parent node must be unbalanced, essentially bottom up algorithm
    return height(root) != -1;
  }

  private int height(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftHeight = height(root.left);
    if (leftHeight == -1) {
      return -1;
    }
    int rightHeight = height(root.right);
    if (rightHeight == -1) {
      return -1;
    }
    if (Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    }
    return Math.max(leftHeight, rightHeight) + 1;
  }
}
