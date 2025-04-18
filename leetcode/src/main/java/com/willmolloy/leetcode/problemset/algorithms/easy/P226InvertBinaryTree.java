package com.willmolloy.leetcode.problemset.algorithms.easy;

import com.willmolloy.leetcode.common.TreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/invert-binary-tree>https://leetcode.com/problems/invert-binary-tree</a>
 *
 * <p>Runtime: O(n) - see each node once
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P226InvertBinaryTree {

  TreeNode invertTree(TreeNode root) {
    if (root != null) {
      swapChildren(root);
      invertTree(root.right);
      invertTree(root.left);
    }
    return root;
  }

  private void swapChildren(TreeNode root) {
    TreeNode temp = root.right;
    root.right = root.left;
    root.left = temp;
  }
}
