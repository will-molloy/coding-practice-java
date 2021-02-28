package com.wilmol.leetcode.problemset.algorithms.medium;

import com.wilmol.leetcode.common.BinaryTreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/convert-bst-to-greater-tree>https://leetcode.com/problems/convert-bst-to-greater-tree/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(h)
 *
 * <p>Key: Visit larger nodes first so visited {@code sum} is the value the current node should
 * have.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P538ConvertBstToGreaterTree {

  private int sum;

  public BinaryTreeNode convertBst(BinaryTreeNode root) {
    sum = 0;
    dfs(root);
    return root;
  }

  private void dfs(BinaryTreeNode node) {
    if (node == null) {
      return;
    }
    dfs(node.right);
    sum += node.val;
    node.val = sum;
    dfs(node.left);
  }
}
