package com.willmolloy.leetcode.problemset.algorithms.easy;

import com.willmolloy.leetcode.common.TreeNode;

/**
 * <a href=https://leetcode.com/problems/path-sum>https://leetcode.com/problems/path-sum</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(h)
 *
 * <p>Key idea: A leaf is a node with no children.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P113PathSum2
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P437PathSum3
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P112PathSum {

  public boolean hasPathSum(TreeNode root, int sum) {
    return hasPathSum(root, sum, 0);
  }

  private boolean hasPathSum(TreeNode node, int sum, int currentSum) {
    if (node == null) {
      return false;
    }
    currentSum += node.val;
    if (node.left == null && node.right == null) {
      // leaf node
      return sum == currentSum;
    }
    return hasPathSum(node.left, sum, currentSum) || hasPathSum(node.right, sum, currentSum);
  }
}
