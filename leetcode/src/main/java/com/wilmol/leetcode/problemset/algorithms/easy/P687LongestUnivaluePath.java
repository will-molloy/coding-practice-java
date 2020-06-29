package com.wilmol.leetcode.problemset.algorithms.easy;

import com.wilmol.leetcode.common.BinaryTreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/longest-univalue-path>https://leetcode.com/problems/longest-univalue-path/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(h)
 *
 * <p>Key: Path is count of edges not nodes. Think about what the DFS should return; path can only
 * go up and down through one node, so have to return max of left/right not combine them.
 *
 * @see com.wilmol.leetcode.problemset.algorithms.hard.P124BinaryTreeMaximumPathSum
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P687LongestUnivaluePath {

  // global answer
  private int ans;

  public int longestUnivaluePath(BinaryTreeNode root) {
    ans = 0;
    dfs(root);
    return ans;
  }

  // return longest path going strictly down from the given node
  private int dfs(BinaryTreeNode node) {
    if (node == null) {
      return 0;
    }

    int left = dfs(node.left);
    int leftThroughNode = 0;
    if (node.left != null && node.left.val == node.val) {
      // this node is able to extend the left path (+1 edge)
      leftThroughNode = left + 1;
    }

    int right = dfs(node.right);
    int rightThroughNode = 0;
    if (node.right != null && node.right.val == node.val) {
      // this node is able to extend the right path (+1 edge)
      rightThroughNode = right + 1;
    }

    // update global answer, so consider each node as a root node
    ans = Math.max(ans, leftThroughNode + rightThroughNode);

    return Math.max(leftThroughNode, rightThroughNode);
  }
}
