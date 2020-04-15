package wilmol.leetcode.problemset.algorithms.easy;

import wilmol.leetcode.common.BinaryTreeNode;

/**
 * Created by wilmol on 2020-04-16.
 *
 * <p><a
 * href=https://leetcode.com/problems/minimum-absolute-difference-in-bst>https://leetcode.com/problems/minimum-absolute-difference-in-bst</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(h)
 *
 * <p>Key: Tracking prev node (well, just it's value) in the inorder traversal.
 *
 * @see P783MinimumDistanceBetweenBstNodes
 */
class P530MinimumAbsoluteDifferentInBst {

  public int getMinimumDifference(BinaryTreeNode root) {
    // all nodes contain non-negative values, so mark null node as -1
    return inorder(root, new int[] {-1, Integer.MAX_VALUE})[1];
  }

  // return {prev node value, current min difference}
  private int[] inorder(BinaryTreeNode node, int[] prev) {
    if (node == null) {
      return prev;
    }
    prev = inorder(node.left, prev);
    int min = prev[1];
    if (prev[0] > -1) {
      int diff = node.val - prev[0];
      min = Math.min(min, diff);
    }
    return inorder(node.right, new int[] {node.val, min});
  }
}
