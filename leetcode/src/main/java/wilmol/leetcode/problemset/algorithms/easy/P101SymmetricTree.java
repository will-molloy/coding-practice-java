package wilmol.leetcode.problemset.algorithms.easy;

import wilmol.leetcode.common.BinaryTreeNode;

/**
 * Created by wilmol on 2020-02-10.
 *
 * <p><a
 * href=https://leetcode.com/problems/symmetric-tree>https://leetcode.com/problems/symmetric-tree</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(log n) best case, O(n) worst case (recursion stack size)
 *
 * <p>Key: recursion, knowledge of BT structure
 */
class P101SymmetricTree {

  public boolean isSymmetric(BinaryTreeNode root) {
    if (root == null) {
      return true;
    }
    return isMirror(root.left, root.right);
  }

  private boolean isMirror(BinaryTreeNode left, BinaryTreeNode right) {
    if (left == null && right == null) {
      return true;
    }
    if (left == null || right == null) {
      return false;
    }
    return left.val == right.val
        && isMirror(left.left, right.right)
        && isMirror(left.right, right.left);
  }
}
