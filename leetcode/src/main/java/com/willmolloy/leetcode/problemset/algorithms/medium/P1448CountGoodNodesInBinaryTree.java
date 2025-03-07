package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.TreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/count-good-nodes-in-binary-tree>https://leetcode.com/problems/count-good-nodes-in-binary-tree/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(h)
 *
 * <p>Key: DFS with global count. Track max in path from root to current node.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1448CountGoodNodesInBinaryTree {

  private int count;

  public int goodNodes(TreeNode root) {
    count = 0;
    dfs(root, Integer.MIN_VALUE);
    return count;
  }

  private void dfs(TreeNode node, int maxInPathFromRoot) {
    if (node == null) {
      return;
    }

    if (node.val >= maxInPathFromRoot) {
      count++;
    }

    maxInPathFromRoot = Math.max(node.val, maxInPathFromRoot);

    dfs(node.left, maxInPathFromRoot);
    dfs(node.right, maxInPathFromRoot);
  }
}
