package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a
 * href=https://leetcode.com/problems/even-odd-tree>https://leetcode.com/problems/even-odd-tree/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(w) = O(n)
 *
 * <p>Key idea: Straight forward. Test each level. Use BFS to traverse level by level.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1609EvenOddTree {

  public boolean isEvenOddTree(TreeNode root) {
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    boolean even = true;

    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      int prevVal = even ? Integer.MIN_VALUE : Integer.MAX_VALUE;

      for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.remove();
        if (even) {
          // For every even-indexed level, all nodes at the level have odd integer values in
          // strictly increasing order (from left to right).
          if (node.val % 2 == 0 || node.val <= prevVal) {
            return false;
          }
        } else {
          // For every odd-indexed level, all nodes at the level have even integer values in
          // strictly decreasing order (from left to right).
          if (node.val % 2 != 0 || node.val >= prevVal) {
            return false;
          }
        }
        prevVal = node.val;
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      even = !even;
    }
    return true;
  }
}
