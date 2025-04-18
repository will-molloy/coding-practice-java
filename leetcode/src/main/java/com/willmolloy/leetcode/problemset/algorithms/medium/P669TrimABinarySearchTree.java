package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.TreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/trim-a-binary-search-tree>https://leetcode.com/problems/trim-a-binary-search-tree/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(h)
 *
 * <p>Key idea: DFS. Three cases to consider:
 *
 * <ol>
 *   <li>Current node too large
 *   <li>Current node too small
 *   <li>Current node ok
 * </ol>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P669TrimABinarySearchTree {

  public TreeNode trimBst(TreeNode node, int l, int r) {
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
