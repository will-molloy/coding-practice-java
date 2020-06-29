package com.wilmol.leetcode.problemset.algorithms.easy;

import com.wilmol.leetcode.common.BinaryTreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/minimum-distance-between-bst-nodes>https://leetcode.com/problems/minimum-distance-between-bst-nodes</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(h)
 *
 * <p>Key: Tracking prev node (well, just it's value) in the inorder traversal.
 *
 * @see P530MinimumAbsoluteDifferentInBst
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P783MinimumDistanceBetweenBstNodes {

  public int minDiffInBst(BinaryTreeNode root) {
    // all nodes contain non-negative values, so mark null node as -1
    return inorder(root, new int[] {-1, Integer.MAX_VALUE})[1];
  }

  // return {prev node value, current min difference}
  private int[] inorder(BinaryTreeNode node, int[] prev) {
    if (node == null) {
      return prev;
    }
    prev = inorder(node.left, prev);
    int min = prev[1];
    if (prev[0] > -1) {
      int diff = node.val - prev[0];
      min = Math.min(min, diff);
    }
    return inorder(node.right, new int[] {node.val, min});
  }
}
