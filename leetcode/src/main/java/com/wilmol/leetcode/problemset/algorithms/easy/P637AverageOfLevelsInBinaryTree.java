package com.wilmol.leetcode.problemset.algorithms.easy;

import com.wilmol.leetcode.common.BinaryTreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * <a
 * href=https://leetcode.com/problems/average-of-levels-in-binary-tree>https://leetcode.com/problems/average-of-levels-in-binary-tree/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(n)
 *
 * <p>Key: Level order = BFS. Use {@code long} to avoid integer overflow in addition.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P637AverageOfLevelsInBinaryTree {

  public List<Double> averageOfLevels(BinaryTreeNode root) {
    Queue<BinaryTreeNode> bfs = new ArrayDeque<>();
    bfs.add(root);

    List<Double> answer = new ArrayList<>();

    while (!bfs.isEmpty()) {
      long sum = 0;
      int size = bfs.size();
      for (int i = 0; i < size; i++) {
        BinaryTreeNode node = bfs.remove();
        sum += node.val;
        Stream.of(node.left, node.right).filter(Objects::nonNull).forEach(bfs::add);
      }
      answer.add((double) sum / size);
    }
    return answer;
  }
}
