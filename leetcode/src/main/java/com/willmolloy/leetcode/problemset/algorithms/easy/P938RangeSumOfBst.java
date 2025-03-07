package com.willmolloy.leetcode.problemset.algorithms.easy;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * <a
 * href=https://leetcode.com/problems/range-sum-of-bst>https://leetcode.com/problems/range-sum-of-bst</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key: binary tree traversal
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P938RangeSumOfBst {

  public int rangeSumBst(TreeNode root, int l, int r) {
    // traverse the tree somehow, chose BFS here

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    int sum = 0;

    while (!queue.isEmpty()) {
      TreeNode node = queue.remove();
      if (node.val >= l && node.val <= r) {
        sum += node.val;
      }
      Stream.of(node.left, node.right).filter(Objects::nonNull).forEach(queue::add);
    }

    return sum;
  }
}
