package com.wilmol.leetcode.problemset.algorithms.medium;

import com.wilmol.leetcode.common.BinaryTreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by wilmol on 2020-02-11.
 *
 * <p><a
 * href=https://leetcode.com/problems/binary-tree-level-order-traversal>https://leetcode.com/problems/binary-tree-level-order-traversal</a>
 *
 * @see P103BinaryTreeZigzagLevelOrderTraversal
 * @see com.wilmol.leetcode.problemset.algorithms.easy.P107BinaryTreeLevelOrderTraversal2
 */
interface P102BinaryTreeLevelOrderTraversal {

  List<List<Integer>> levelOrder(BinaryTreeNode root);

  /**
   * Dfs; tracks depth to know level to insert node into.
   *
   * <p>Runtime: O(n)
   *
   * <p>Space: O(h) (i.e. height of tree, corresponds to max recursion stack size)
   *
   * <p>Key: recursion, knowledge of BT traversal
   */
  class Dfs implements P102BinaryTreeLevelOrderTraversal {

    @Override
    public List<List<Integer>> levelOrder(BinaryTreeNode root) {
      return levelOrder(new ArrayList<>(), root, 0);
    }

    public List<List<Integer>> levelOrder(
        List<List<Integer>> levels, BinaryTreeNode node, int depth) {
      if (node == null) {
        return levels;
      }

      if (!(levels.size() > depth)) {
        levels.add(new ArrayList<>());
      }
      levels.get(depth).add(node.val);

      levelOrder(levels, node.left, depth + 1);
      levelOrder(levels, node.right, depth + 1);
      return levels;
    }

    @Override
    public String toString() {
      return getClass().getSimpleName();
    }
  }

  /**
   * Bfs; uses a queue to traverse nodes breadth first (naturally in level order).
   *
   * <p>Runtime: O(n)
   *
   * <p>Space: O(w) = O(n) (i.e. max width of tree, corresponds to max queue size)
   *
   * <p>Key: caching the queue size before processing nodes in the queue
   */
  class Bfs implements P102BinaryTreeLevelOrderTraversal {

    @Override
    public List<List<Integer>> levelOrder(BinaryTreeNode root) {
      List<List<Integer>> levels = new ArrayList<>();
      if (root == null) {
        return levels;
      }

      Deque<BinaryTreeNode> queue = new ArrayDeque<>();
      queue.add(root);

      while (!queue.isEmpty()) {
        List<Integer> level = new ArrayList<>();
        // cache size since we'll be adding the next level's nodes
        int levelSize = queue.size();
        for (int i = 0; i < levelSize; i++) {
          // remove from front of queue
          BinaryTreeNode node = queue.removeFirst();
          level.add(node.val);
          // add to back of queue
          if (node.left != null) {
            queue.addLast(node.left);
          }
          if (node.right != null) {
            queue.addLast(node.right);
          }
        }
        levels.add(level);
      }
      return levels;
    }

    @Override
    public String toString() {
      return getClass().getSimpleName();
    }
  }
}
