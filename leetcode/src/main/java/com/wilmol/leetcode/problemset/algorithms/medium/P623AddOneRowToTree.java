package com.wilmol.leetcode.problemset.algorithms.medium;

import com.wilmol.leetcode.common.BinaryTreeNode;

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
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P623AddOneRowToTree {

  public BinaryTreeNode addOneRow(BinaryTreeNode root, int v, int d) {
    if (d == 1) {
      BinaryTreeNode newRoot = new BinaryTreeNode(v);
      newRoot.left = root;
      return newRoot;
    } else {
      dfs(root, v, d, 1);
      return root;
    }
  }

  private void dfs(BinaryTreeNode node, int v, int d, int depth) {
    if (node == null) {
      return;
    }
    if (depth == d - 1) {
      BinaryTreeNode newLeft = new BinaryTreeNode(v);
      newLeft.left = node.left;
      BinaryTreeNode newRight = new BinaryTreeNode(v);
      newRight.right = node.right;

      node.left = newLeft;
      node.right = newRight;
      return;
    }
    dfs(node.left, v, d, depth + 1);
    dfs(node.right, v, d, depth + 1);
  }
}
