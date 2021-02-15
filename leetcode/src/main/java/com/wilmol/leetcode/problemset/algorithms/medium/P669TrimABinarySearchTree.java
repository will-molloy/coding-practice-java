package com.wilmol.leetcode.problemset.algorithms.medium;

import com.wilmol.leetcode.common.BinaryTreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/trim-a-binary-search-tree>https://leetcode.com/problems/trim-a-binary-search-tree/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(h)
 *
 * <p>Key: DFS. Three cases to consider:
 *
 * <ol>
 *   <li>Current node too large
 *   <li>Current node too small
 *   <li>Current node ok
 * </ol>
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P669TrimABinarySearchTree {

  public BinaryTreeNode trimBst(BinaryTreeNode node, int l, int r) {
    if (node == null) {
      return null;
    } else if (node.val > r) {
      // current node too large, include only left subtree
      return trimBst(node.left, l, r);
    } else if (node.val < l) {
      // current node too small, include only right subtree
      return trimBst(node.right, l, r);
    } else {
      // keep current node, trim left and right
      node.left = trimBst(node.left, l, r);
      node.right = trimBst(node.right, l, r);
      return node;
    }
  }
}
