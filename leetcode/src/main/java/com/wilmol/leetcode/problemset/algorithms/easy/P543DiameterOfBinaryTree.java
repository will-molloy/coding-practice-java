package com.wilmol.leetcode.problemset.algorithms.easy;

import com.wilmol.leetcode.common.BinaryTreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/diameter-of-binary-tree>https://leetcode.com/problems/diameter-of-binary-tree</a>
 *
 * <p>Key: the longest path must be between leaf nodes
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
interface P543DiameterOfBinaryTree {

  int diameterOfBinaryTree(BinaryTreeNode root);

  /**
   * Initial solution.
   *
   * <p>Takes sum of left and right subtree heights (for every node) and compares them for the
   * maximum.
   *
   * <p>Runtime: O(n * h) = O(n<sup>2</sup>)
   *
   * <p>Space: O(h) = O(n)
   */
  class Quadratic implements P543DiameterOfBinaryTree {

    @Override
    public int diameterOfBinaryTree(BinaryTreeNode root) {
      // must be a path between leaves
      // so get height of left and right tree and add together
      // do this with every node as root (O(n^2))
      if (root == null) {
        return 0;
      }
      int leftHeight = height(root.left);
      int rightHeight = height(root.right);
      int leftDiameter = diameterOfBinaryTree(root.left);
      int rightDiameter = diameterOfBinaryTree(root.right);
      return Math.max(leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));
    }

    private int height(BinaryTreeNode root) {
      if (root == null) {
        return 0;
      }
      return 1 + Math.max(height(root.left), height(root.right));
    }
  }

  /**
   * Optimised solution.
   *
   * <p>Takes the approach in {@link Quadratic} but realises we can update {@code max} within the
   * {@code height} function, which reduces calls to {@code height}.
   *
   * <p>Runtime: O(n)
   *
   * <p>Space: O(n)
   */
  class Linear implements P543DiameterOfBinaryTree {

    @Override
    public int diameterOfBinaryTree(BinaryTreeNode root) {
      if (root == null) {
        return 0;
      }
      int[] max = {Integer.MIN_VALUE};
      height(root, max);
      return max[0];
    }

    private int height(BinaryTreeNode root, int[] max) {
      if (root == null) {
        return 0;
      }
      int leftHeight = height(root.left, max);
      int rightHeight = height(root.right, max);
      max[0] = Math.max(max[0], leftHeight + rightHeight);
      return 1 + Math.max(leftHeight, rightHeight);
    }
  }
}
