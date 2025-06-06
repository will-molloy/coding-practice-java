package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.TreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes>https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(h)
 *
 * <p>Key idea: Smallest subtree is the same as the lowest common ancestor. If heights are same
 * return current node, else return node with larger height.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P865SmallestSubtreeWithAllTheDeepestNodes {

  public TreeNode subtreeWithAllDeepest(TreeNode root) {
    return dfs(root).node;
  }

  private TreeNodeLevel dfs(TreeNode node) {
    if (node == null) {
      return new TreeNodeLevel(null, 0);
    }
    TreeNodeLevel left = dfs(node.left);
    TreeNodeLevel right = dfs(node.right);

    // return subtree with largest height
    // +1 to that height
    if (left.level > right.level) {
      return new TreeNodeLevel(left.node, left.level + 1);
    } else if (right.level > left.level) {
      return new TreeNodeLevel(right.node, right.level + 1);
    } else {
      return new TreeNodeLevel(node, left.level + 1);
    }
  }

  private static final class TreeNodeLevel {
    TreeNode node;
    int level;

    TreeNodeLevel(TreeNode node, int level) {
      this.node = node;
      this.level = level;
    }
  }
}
