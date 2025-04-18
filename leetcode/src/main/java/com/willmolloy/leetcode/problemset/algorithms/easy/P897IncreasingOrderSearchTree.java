package com.willmolloy.leetcode.problemset.algorithms.easy;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/increasing-order-search-tree>https://leetcode.com/problems/increasing-order-search-tree/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key idea: Inorder traversal, dumping nodes in list before changing pointers. TODO cheating?
 * How about a solution that just manipulates pointers.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P897IncreasingOrderSearchTree {

  // CHECKSTYLE IGNORE AbbreviationAsWordInName FOR NEXT 1 LINES
  public TreeNode increasingBST(TreeNode root) {
    List<TreeNode> list = new ArrayList<>();
    inorder(root, list);

    for (int i = 0; i < list.size(); i++) {
      list.get(i).left = null;
      if (i < list.size() - 1) {
        list.get(i).right = list.get(i + 1);
      }
    }
    return list.get(0);
  }

  private void inorder(TreeNode node, List<TreeNode> list) {
    if (node == null) {
      return;
    }
    inorder(node.left, list);
    list.add(node);
    inorder(node.right, list);
  }
}
