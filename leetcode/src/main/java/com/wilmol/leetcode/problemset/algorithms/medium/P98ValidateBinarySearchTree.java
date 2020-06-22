package com.wilmol.leetcode.problemset.algorithms.medium;

import com.wilmol.leetcode.common.BinaryTreeNode;

/**
 * Created by wilmol on 2020-02-09.
 *
 * <p><a
 * href=https://leetcode.com/problems/validate-binary-search-tree>https://leetcode.com/problems/validate-binary-search-tree</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key: knowledge of BST structure, pointer manipulation
 */
class P98ValidateBinarySearchTree {

  public boolean isValidBst(BinaryTreeNode root) {
    return isValid(root, Long.MAX_VALUE, Long.MIN_VALUE);
  }

  private boolean isValid(BinaryTreeNode node, long max, long min) {
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
