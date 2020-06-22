package com.wilmol.leetcode.problemset.algorithms.medium;

import com.wilmol.leetcode.common.BinaryTreeNode;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * Created by wilmol on 2020-03-16.
 *
 * <p><a
 * href=https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree>https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key: BFS to traverse level by level
 */
class P1161MaximumLevelSumOfABinaryTree {

  public int maxLevelSum(BinaryTreeNode root) {
    if (root == null) {
      return 0;
    }

    int maxLevel = 1;
    int maxSum = Integer.MIN_VALUE;

    // Bfs
    Queue<BinaryTreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    int level = 1;
    while (!queue.isEmpty()) {
      int sum = 0;
      int levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        BinaryTreeNode node = queue.remove();
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
