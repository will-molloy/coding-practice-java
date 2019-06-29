package com.wilmol.hackerrank.interviewpreparationkit.trees.easy;

import static java.lang.Math.max;

import com.wilmol.hackerrank.common.BinaryTreeNode;

/**
 * Created by Will on 24/03/2019
 *
 * <p>https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=trees
 *
 * <p>Runtime: O(n) - must iterate all nodes
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
