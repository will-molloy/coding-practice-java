package com.wilmol.leetcode.problemset.algorithms.easy;

import com.wilmol.leetcode.common.BinaryTreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * <a
 * href=https://leetcode.com/problems/binary-tree-level-order-traversal-ii>https://leetcode.com/problems/binary-tree-level-order-traversal-ii</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(w) = O(n)
 *
 * <p>Key: implicitly reverse levels by inserting each level into front TODO is this cheating? No
 * way to view the leave nodes first...
 *
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P102BinaryTreeLevelOrderTraversal
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P107BinaryTreeLevelOrderTraversal2 {

  public List<List<Integer>> levelOrderBottom(BinaryTreeNode root) {
    // LinkedList has more efficient head insertion than array based list
    LinkedList<List<Integer>> levels = new LinkedList<>();
    if (root == null) {
      return levels;
    }

    // BFS
    Queue<BinaryTreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      int levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        BinaryTreeNode node = queue.remove();
        level.add(node.val);
        Stream.of(node.left, node.right).filter(Objects::nonNull).forEach(queue::add);
      }
      // this time insert into front of levels, so get last level (leaves) first
      levels.addFirst(level);
    }
    return levels;
  }
}
