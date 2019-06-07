package com.wilmol.leetcode.problems.trees.easy;

import com.wilmol.leetcode.common.TreeNode;

/**
 * Created by Will on 2019-03-30 at 21:43
 * <p>
 * https://leetcode.com/problems/invert-binary-tree/
 * <p>
 * Runtime: O(n)
 * <p>
 * TODO TESTS
 */
class P226_InvertBinaryTree
{

  TreeNode invertTree(TreeNode root)
  {
    if (root != null)
    {
      swapChildren(root);
      invertTree(root.right);
      invertTree(root.left);
    }
    return root;
  }

  private void swapChildren(TreeNode root)
  {
    TreeNode temp = root.right;
    root.right = root.left;
    root.left = temp;
  }

}
