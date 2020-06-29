package com.wilmol.hackerrank.interviewpreparationkit.trees.easy;

import static java.lang.Math.max;

import com.wilmol.hackerrank.common.BinaryTreeNode;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=trees>https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=trees</a>
 *
 * <p>Runtime: O(n) - must iterate all nodes
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
final class HeightOfBinaryTree {

  private HeightOfBinaryTree() {}

  static int height(BinaryTreeNode root) {
    if (root == null) {
      return -1;
    }
    return max(height(root.left), height(root.right)) + 1;
  }
}
