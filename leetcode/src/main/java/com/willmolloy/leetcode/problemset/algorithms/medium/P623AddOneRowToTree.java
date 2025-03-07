package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.TreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/add-one-row-to-tree>https://leetcode.com/problems/add-one-row-to-tree/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(h)
 *
 * <p>Key: Need extra code for the special case (when root is changed) otherwise its a
 * straightforward DFS.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P623AddOneRowToTree {

  public TreeNode addOneRow(TreeNode root, int v, int d) {
    if (d == 1) {
      TreeNode newRoot = new TreeNode(v);
      newRoot.left = root;
      return newRoot;
    } else {
      dfs(root, v, d, 1);
      return root;
    }
  }

  private void dfs(TreeNode node, int v, int d, int depth) {
    if (node == null) {
      return;
    }
    if (depth == d - 1) {
      TreeNode newLeft = new TreeNode(v);
      newLeft.left = node.left;
      TreeNode newRight = new TreeNode(v);
      newRight.right = node.right;

      node.left = newLeft;
      node.right = newRight;
      return;
    }
    dfs(node.left, v, d, depth + 1);
    dfs(node.right, v, d, depth + 1);
  }
}
