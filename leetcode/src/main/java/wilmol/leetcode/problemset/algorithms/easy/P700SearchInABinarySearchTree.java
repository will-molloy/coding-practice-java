package wilmol.leetcode.problemset.algorithms.easy;

import wilmol.leetcode.common.BinaryTreeNode;

/**
 * Created by wilmol on 2020-06-09.
 *
 * <p><a
 * href=https://leetcode.com/problems/search-in-a-binary-search-tree>https://leetcode.com/problems/search-in-a-binary-search-tree/</a>
 *
 * <p>Key: In BST larger values are on the right, smaller on left.
 */
interface P700SearchInABinarySearchTree {

  BinaryTreeNode searchBst(BinaryTreeNode root, int val);

  /**
   * Recursive solution.
   *
   * <p>Runtime: O(h)
   *
   * <p>Extra space: O(h)
   */
  class Recursive implements P700SearchInABinarySearchTree {

    @Override
    public BinaryTreeNode searchBst(BinaryTreeNode root, int val) {
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
    public BinaryTreeNode searchBst(BinaryTreeNode root, int val) {
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
