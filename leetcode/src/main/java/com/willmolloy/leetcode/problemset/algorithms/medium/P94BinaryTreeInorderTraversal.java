package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/binary-tree-inorder-traversal>https://leetcode.com/problems/binary-tree-inorder-traversal</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key idea: recursion to traverse depth first
 *
 * @see P1305AllElementsInTwoBinarySearchTrees
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P94BinaryTreeInorderTraversal {

  // iterative solutions (stack and more space efficient 'morris' traversal):
  // https://leetcode.com/problems/binary-tree-inorder-traversal/solution/

  // on leetcode its called 'TreeNode', fields may differ too...

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> traversal = new ArrayList<>();
    inorderTraversal(traversal, root);
    return traversal;
  }

  private void inorderTraversal(List<Integer> traversal, TreeNode root) {
    if (root == null) {
      return;
    }
    inorderTraversal(traversal, root.left);
    traversal.add(root.val);
    inorderTraversal(traversal, root.right);
  }
}
