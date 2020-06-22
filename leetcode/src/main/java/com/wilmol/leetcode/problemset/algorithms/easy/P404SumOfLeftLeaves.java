package com.wilmol.leetcode.problemset.algorithms.easy;

import com.wilmol.leetcode.common.BinaryTreeNode;

/**
 * Created by wilmol on 2020-04-08.
 *
 * <p><a
 * href=https://leetcode.com/problems/sum-of-left-leaves>https://leetcode.com/problems/sum-of-left-leaves</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(h)
 *
 * <p>Key: how to update the sum, could add to sub problem results (then base case needs to be zero)
 * or update within sub problems (then base case needs to be the current sum)
 *
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P1315SumOfNodesWithEvenValuedGrandparent
 */
class P404SumOfLeftLeaves {

  public int sumOfLeftLeaves(BinaryTreeNode root) {
    return sum(root, 0);
  }

  private int sum(BinaryTreeNode node, int sum) {
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
