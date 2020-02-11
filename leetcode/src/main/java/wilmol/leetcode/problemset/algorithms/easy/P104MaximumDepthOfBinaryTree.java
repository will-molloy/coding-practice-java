package wilmol.leetcode.problemset.algorithms.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import wilmol.leetcode.common.BinaryTreeNode;

/**
 * Created by wilmol on 2020-02-11.
 *
 * <p><a
 * href=https://leetcode.com/problems/maximum-depth-of-binary-tree>https://leetcode.com/problems/maximum-depth-of-binary-tree</a>
 */
interface P104MaximumDepthOfBinaryTree {

  // Why is it called maxDepth? depth/height is the same thing?

  int maxDepth(BinaryTreeNode root);

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
    public int maxDepth(BinaryTreeNode root) {
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
   * <p>Space: O(w)
   *
   * <p>Key: queue data structure; caching level size
   */
  class Bfs implements P104MaximumDepthOfBinaryTree {

    @Override
    public int maxDepth(BinaryTreeNode root) {
      if (root == null) {
        return 0;
      }
      Deque<BinaryTreeNode> queue = new ArrayDeque<>();
      queue.add(root);
      int depth = 0;
      while (!queue.isEmpty()) {
        // process all nodes at this level before incrementing depth
        int levelSize = queue.size();
        for (int i = 0; i < levelSize; i++) {
          BinaryTreeNode node = queue.remove();
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
