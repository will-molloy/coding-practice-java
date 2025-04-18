package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.TreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/binary-tree-pruning>https://leetcode.com/problems/binary-tree-pruning/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(h)
 *
 * <p>Key idea: Prune leaves recursively.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P814BinaryTreePruning {

  public TreeNode pruneTree(TreeNode root) {
    if (dfs(root)) {
      return null;
    }
    return root;
  }

  // return true if 'node' should be deleted (it's a leaf with val = 0)
  private boolean dfs(TreeNode node) {
    if (node == null) {
      return false;
    }

    if (dfs(node.left)) {
      node.left = null;
    }
    if (dfs(node.right)) {
      node.right = null;
    }

    return node.left == null && node.right == null && node.val == 0;
  }
}
