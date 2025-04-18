package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.TreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/validate-binary-search-tree>https://leetcode.com/problems/validate-binary-search-tree</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key idea: knowledge of BST structure, pointer manipulation
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P700SearchInABinarySearchTree
 * @see P701InsertIntoABinarySearchTree
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P98ValidateBinarySearchTree {

  public boolean isValidBst(TreeNode root) {
    return isValid(root, Long.MAX_VALUE, Long.MIN_VALUE);
  }

  private boolean isValid(TreeNode node, long max, long min) {
    if (node == null) {
      // all nodes checked
      return true;
    }

    return node.val < max
        && node.val > min
        // left BST max is this node
        && isValid(node.left, node.val, min)
        // right BST min is this node
        && isValid(node.right, max, node.val);
  }
}
