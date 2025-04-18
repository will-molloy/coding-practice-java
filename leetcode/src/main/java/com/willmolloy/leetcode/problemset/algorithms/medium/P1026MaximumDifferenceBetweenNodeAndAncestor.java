package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.TreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/maximum-difference-between-node-and-ancestor>https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(h)
 *
 * <p>Key idea: Track min/max for each root to leaf path.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1026MaximumDifferenceBetweenNodeAndAncestor {

  private int best;

  public int maxAncestorDiff(TreeNode root) {
    best = Integer.MIN_VALUE;
    dfs(Integer.MAX_VALUE, Integer.MIN_VALUE, root);
    return best;
  }

  private void dfs(int minParent, int maxParent, TreeNode node) {
    if (node == null) {
      best = Math.max(best, maxParent - minParent);
      return;
    }
    minParent = Math.min(minParent, node.val);
    maxParent = Math.max(maxParent, node.val);
    dfs(minParent, maxParent, node.left);
    dfs(minParent, maxParent, node.right);
  }
}
