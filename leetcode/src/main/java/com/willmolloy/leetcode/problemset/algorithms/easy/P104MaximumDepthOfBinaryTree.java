package com.willmolloy.leetcode.problemset.algorithms.easy;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a
 * href=https://leetcode.com/problems/maximum-depth-of-binary-tree>https://leetcode.com/problems/maximum-depth-of-binary-tree</a>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface P104MaximumDepthOfBinaryTree {

  // Why is it called maxDepth? depth/height is the same thing?

  int maxDepth(TreeNode root);

  /**
   * DFS solution.
   *
   * <p>Runtime: O(n)
   *
   * <p>Space: O(h)
   *
   * <p>Key: recursion
   */
  class Dfs implements P104MaximumDepthOfBinaryTree {

    @Override
    public int maxDepth(TreeNode root) {
      if (root == null) {
        return 0;
      }
      return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }
  }

  /**
   * BFS solution.
   *
   * <p>Runtime: O(n)
   *
   * <p>Space: O(w) = O(n)
   *
   * <p>Key: queue data structure; caching level size
   */
  class Bfs implements P104MaximumDepthOfBinaryTree {

    @Override
    public int maxDepth(TreeNode root) {
      if (root == null) {
        return 0;
      }
      Deque<TreeNode> queue = new ArrayDeque<>();
      queue.add(root);
      int depth = 0;
      while (!queue.isEmpty()) {
        // process all nodes at this level before incrementing depth
        int levelSize = queue.size();
        for (int i = 0; i < levelSize; i++) {
          TreeNode node = queue.remove();
          if (node.left != null) {
            queue.add(node.left);
          }
          if (node.right != null) {
            queue.add(node.right);
          }
        }
        depth++;
      }
      return depth;
    }
  }
}
