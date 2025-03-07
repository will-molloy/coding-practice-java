package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.TreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/delete-leaves-with-a-given-value>https://leetcode.com/problems/delete-leaves-with-a-given-value</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n) (worst case recursive stack size - nodes form a linked list)
 *
 * <p>Key: reach depth before deleting nodes
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1325DeleteLeavesWithAGivenValue {

  public TreeNode removeLeafNodes(TreeNode node, int target) {
    if (node == null) {
      return null;
    }
    // reach depth first
    node.left = removeLeafNodes(node.left, target);
    node.right = removeLeafNodes(node.right, target);
    // now delete leaf node, so covers case if this node became a leaf
    if (node.left == null && node.right == null && node.val == target) {
      return null;
    }
    return node;
  }
}
