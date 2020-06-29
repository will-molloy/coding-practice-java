package com.wilmol.leetcode.problemset.algorithms.easy;

import com.wilmol.leetcode.common.BinaryTreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/invert-binary-tree>https://leetcode.com/problems/invert-binary-tree</a>
 *
 * <p>Runtime: O(n) - see each node once
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P226InvertBinaryTree {

  BinaryTreeNode invertTree(BinaryTreeNode root) {
    if (root != null) {
      swapChildren(root);
      invertTree(root.right);
      invertTree(root.left);
    }
    return root;
  }

  private void swapChildren(BinaryTreeNode root) {
    BinaryTreeNode temp = root.right;
    root.right = root.left;
    root.left = temp;
  }
}
