package wilmol.leetcode.problemset.algorithms.medium;

import wilmol.leetcode.common.BinaryTreeNode;

/**
 * Created by wilmol on 2020-04-04.
 *
 * <p><a
 * href=https://leetcode.com/problems/delete-leaves-with-a-given-value>https://leetcode.com/problems/delete-leaves-with-a-given-value</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n) (worst case recursive stack size - nodes form a linked list)
 *
 * <p>Key: reach depth before deleting nodes
 */
class P1325DeleteLeavesWithAGivenValue {

  public BinaryTreeNode removeLeafNodes(BinaryTreeNode node, int target) {
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
