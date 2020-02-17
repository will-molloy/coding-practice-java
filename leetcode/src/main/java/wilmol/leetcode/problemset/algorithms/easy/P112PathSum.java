package wilmol.leetcode.problemset.algorithms.easy;

import wilmol.leetcode.common.BinaryTreeNode;

/**
 * Created by wilmol on 2020-02-17.
 *
 * <p><a href=https://leetcode.com/problems/path-sum>https://leetcode.com/problems/path-sum</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(h)
 *
 * <p>Key: A leaf is a node with no children.
 */
class P112PathSum {

  public boolean hasPathSum(BinaryTreeNode root, int sum) {
    return hasPathSum(root, sum, 0);
  }

  private boolean hasPathSum(BinaryTreeNode node, int sum, int currentSum) {
    if (node == null) {
      return false;
    }
    currentSum += node.val;
    if (node.left == null && node.right == null) {
      // leaf node
      return sum == currentSum;
    }
    return hasPathSum(node.left, sum, currentSum) || hasPathSum(node.right, sum, currentSum);
  }
}
