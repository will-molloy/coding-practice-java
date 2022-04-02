package com.willmolloy.hackerrank.interviewpreparationkit.trees.medium;

import com.willmolloy.hackerrank.common.BinaryTreeNode;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=trees>https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=trees</a>
 *
 * <p>Runtime: O(n) - must check all nodes
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class IsThisABinarySearchTree {

  private IsThisABinarySearchTree() {}

  static boolean checkBst(BinaryTreeNode root) {
    return checkBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private static boolean checkBst(BinaryTreeNode node, int minValue, int maxValue) {
    return node == null
        || node.data >= minValue
            && node.data <= maxValue
            && checkBst(node.left, minValue, node.data - 1)
            && checkBst(node.right, node.data + 1, maxValue);
  }
}
