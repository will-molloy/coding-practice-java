package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.TreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/insert-into-a-binary-search-tree>https://leetcode.com/problems/insert-into-a-binary-search-tree/</a>
 *
 * <p>Runtime: O(h)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Easiest to insert onto a leaf.
 *
 * @see P98ValidateBinarySearchTree
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P700SearchInABinarySearchTree
 * @see com.willmolloy.dsa.trees.TreeInsert
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P701InsertIntoABinarySearchTree {

  // CHECKSTYLE IGNORE AbbreviationAsWordInName FOR NEXT 1 LINES
  public TreeNode insertIntoBST(TreeNode root, int val) {
    // find leaf to insert onto (parent = leaf after loop finishes)
    // essentially tree search algorithm
    TreeNode parent = null;
    TreeNode node = root;
    while (node != null) {
      parent = node;
      if (val < node.val) {
        node = node.left;
      } else {
        node = node.right;
      }
    }

    // insert the new node
    if (parent == null) {
      // root was null (empty tree)
      // make new singleton tree
      return new TreeNode(val);
    }
    if (val < parent.val) {
      parent.left = new TreeNode(val);
    } else {
      parent.right = new TreeNode(val);
    }
    return root;
  }
}
