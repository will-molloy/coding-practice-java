package wilmol.leetcode.problemset.algorithms.easy;

import wilmol.leetcode.common.BinaryTreeNode;

/**
 * Created by wilmol on 2020-05-07.
 *
 * <p><a
 * href=https://leetcode.com/problems/cousins-in-binary-tree>https://leetcode.com/problems/cousins-in-binary-tree/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(h)
 *
 * <p>Key: The target node data must be stored in global variables (when doing DFS) because
 * otherwise the updates are only seen when data is passed down the tree (not across).
 */
class P993CousinsInBinaryTree {

  private BinaryTreeNode xParent;

  private int xDepth;

  private BinaryTreeNode yParent;

  private int yDepth;

  public boolean isCousins(BinaryTreeNode root, int x, int y) {
    xParent = null;
    xDepth = -1;
    yParent = null;
    yDepth = -1;

    return dfs(null, root, x, y, 0);
  }

  private boolean dfs(BinaryTreeNode parent, BinaryTreeNode node, int x, int y, int depth) {
    // null check
    if (node == null) {
      return false;
    }

    // initialise target node data
    if (node.val == x) {
      xDepth = depth;
      xParent = parent;
    }
    if (node.val == y) {
      yDepth = depth;
      yParent = parent;
    }

    if (xParent != null && yParent != null) {
      // both target nodes have been seen so can test for cousin
      if (xParent != yParent && xDepth == yDepth) {
        return true;
      }
      // short circuit (not needed for correctness)
      return false;
    }

    return dfs(node, node.left, x, y, depth + 1) || dfs(node, node.right, x, y, depth + 1);
  }
}
