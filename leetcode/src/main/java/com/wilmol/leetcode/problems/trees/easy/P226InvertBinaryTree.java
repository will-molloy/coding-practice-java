package com.wilmol.leetcode.problems.trees.easy;

import com.wilmol.leetcode.common.BinaryTreeNode;

/**
 * Created by Will on 2019-03-30 at 21:43
 *
 * <p>https://leetcode.com/problems/invert-binary-tree/
 *
 * <p>Runtime: O(n)
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