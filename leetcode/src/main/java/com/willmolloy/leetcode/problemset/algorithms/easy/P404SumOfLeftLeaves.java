package com.willmolloy.leetcode.problemset.algorithms.easy;

import com.willmolloy.leetcode.common.TreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/sum-of-left-leaves>https://leetcode.com/problems/sum-of-left-leaves</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(h)
 *
 * <p>Key idea: how to update the sum, could add to sub problem results (then base case needs to be
 * zero) or update within sub problems (then base case needs to be the current sum)
 *
 * @see
 *     com.willmolloy.leetcode.problemset.algorithms.medium.P1315SumOfNodesWithEvenValuedGrandparent
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P404SumOfLeftLeaves {

  public int sumOfLeftLeaves(TreeNode root) {
    return sum(root, 0);
  }

  private int sum(TreeNode node, int sum) {
    if (node == null) {
      return sum;
    }
    if (node.left != null && node.left.left == null && node.left.right == null) {
      sum += node.left.val;
    }
    sum = sum(node.left, sum);
    sum = sum(node.right, sum);
    return sum;
  }
}
