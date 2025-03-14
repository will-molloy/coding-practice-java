package com.willmolloy.leetcode.problemset.algorithms.easy;

import com.willmolloy.leetcode.common.TreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/search-in-a-binary-search-tree>https://leetcode.com/problems/search-in-a-binary-search-tree/</a>
 *
 * <p>Key idea: In BST larger values are on the right, smaller on left.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P98ValidateBinarySearchTree
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P701InsertIntoABinarySearchTree
 * @see com.willmolloy.dsa.trees.TreeSearch
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface P700SearchInABinarySearchTree {

  TreeNode searchBst(TreeNode root, int val);

  /**
   * Recursive solution.
   *
   * <p>Runtime: O(h)
   *
   * <p>Extra space: O(h)
   */
  class Recursive implements P700SearchInABinarySearchTree {

    @Override
    public TreeNode searchBst(TreeNode root, int val) {
      if (root == null || root.val == val) {
        return root;
      }
      if (val > root.val) {
        return searchBst(root.right, val);
      } else {
        return searchBst(root.left, val);
      }
    }
  }

  /**
   * Iterative solution.
   *
   * <p>Runtime: O(h)
   *
   * <p>Extra space: O(1)
   */
  class Iterative implements P700SearchInABinarySearchTree {

    @Override
    public TreeNode searchBst(TreeNode root, int val) {
      while (root != null) {
        if (root.val == val) {
          break;
        } else if (root.val < val) {
          root = root.right;
        } else {
          root = root.left;
        }
      }
      return root;
    }
  }
}
