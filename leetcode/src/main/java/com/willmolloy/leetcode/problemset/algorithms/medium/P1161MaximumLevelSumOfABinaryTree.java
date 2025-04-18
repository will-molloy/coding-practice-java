package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * <a
 * href=https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree>https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key idea: BFS to traverse level by level
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1161MaximumLevelSumOfABinaryTree {

  public int maxLevelSum(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int maxLevel = 1;
    int maxSum = Integer.MIN_VALUE;

    // Bfs
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    int level = 1;
    while (!queue.isEmpty()) {
      int sum = 0;
      int levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.remove();
        sum += node.val;
        Stream.of(node.left, node.right).filter(Objects::nonNull).forEach(queue::add);
      }
      if (sum > maxSum) {
        maxSum = sum;
        maxLevel = level;
      }
      level++;
    }
    return maxLevel;
  }
}
