package com.willmolloy.leetcode.problemset.algorithms.easy;

import com.willmolloy.leetcode.common.TreeNode;
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
 * <p>Key idea: Level order = BFS. Use {@code long} to avoid integer overflow in addition.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P637AverageOfLevelsInBinaryTree {

  public List<Double> averageOfLevels(TreeNode root) {
    Queue<TreeNode> bfs = new ArrayDeque<>();
    bfs.add(root);

    List<Double> answer = new ArrayList<>();

    while (!bfs.isEmpty()) {
      long sum = 0;
      int size = bfs.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = bfs.remove();
        sum += node.val;
        Stream.of(node.left, node.right).filter(Objects::nonNull).forEach(bfs::add);
      }
      answer.add((double) sum / size);
    }
    return answer;
  }
}
