package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a
 * href=https://leetcode.com/problems/maximum-width-of-binary-tree>https://leetcode.com/problems/maximum-width-of-binary-tree</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(w) = O(n)
 *
 * <p>Key idea: labelling nodes, in this case [0, n)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P662MaximumWidthOfBinaryTree {

  public int widthOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }

    // get biggest level, bfs
    Queue<NodeWrapper> queue = new ArrayDeque<>();
    queue.add(new NodeWrapper(root, 0));
    int maxWidth = 1;

    while (!queue.isEmpty()) {
      // process next level
      int levelSize = queue.size();
      int firstInLevel = -1;
      for (int i = 0; i < levelSize; i++) {
        NodeWrapper node = queue.remove();
        if (node.node != null) {
          queue.add(new NodeWrapper(node.node.left, node.index * 2));
          queue.add(new NodeWrapper(node.node.right, node.index * 2 + 1));
          if (firstInLevel == -1) {
            firstInLevel = node.index;
          }
          maxWidth = Math.max(maxWidth, node.index - firstInLevel + 1);
        }
      }
    }
    return maxWidth;
  }

  /**
   * Wraps a node with its 'index' (i.e. index if the binary tree were serialised into a 1d array).
   */
  private static final class NodeWrapper {
    private final TreeNode node;
    private final int index;

    private NodeWrapper(TreeNode node, int index) {
      this.node = node;
      this.index = index;
    }
  }
}
