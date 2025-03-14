package com.willmolloy.leetcode.problemset.algorithms.easy;

import com.willmolloy.leetcode.common.TreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/binary-tree-tilt>https://leetcode.com/problems/binary-tree-tilt/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(h)
 *
 * <p>Key idea: Post order traversal, bubble up val sum and tilt sum.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P563BinaryTreeTilt {

  public int findTilt(TreeNode root) {
    return dfs(root)[1];
  }

  // returns {val sum, tilt sum}
  private int[] dfs(TreeNode node) {
    if (node == null) {
      return new int[] {0, 0};
    }
    int[] left = dfs(node.left);
    int[] right = dfs(node.right);
    int valSum = node.val + left[0] + right[0];
    // tilt determined from child val sums
    int tilt = Math.abs(left[0] - right[0]);
    int tiltSum = tilt + left[1] + right[1];
    return new int[] {valSum, tiltSum};
  }
}
