package com.willmolloy.leetcode.problemset.algorithms.easy;

import com.willmolloy.leetcode.common.TreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/minimum-absolute-difference-in-bst>https://leetcode.com/problems/minimum-absolute-difference-in-bst</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(h)
 *
 * <p>Key idea: Tracking prev node (well, just it's value) in the inorder traversal.
 *
 * @see P783MinimumDistanceBetweenBstNodes
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P530MinimumAbsoluteDifferentInBst {

  public int getMinimumDifference(TreeNode root) {
    // all nodes contain non-negative values, so mark null node as -1
    return inorder(root, new int[] {-1, Integer.MAX_VALUE})[1];
  }

  // return {prev node value, current min difference}
  private int[] inorder(TreeNode node, int[] prev) {
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
