package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a
 * href=https://leetcode.com/problems/sequential-digits>https://leetcode.com/problems/sequential-digits/</a>
 *
 * <p>Runtime: O(1)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Generate all paths and then filter. Use BFS so its generated in sorted order.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1291SequentialDigits {

  public List<Integer> sequentialDigits(int low, int high) {
    List<Integer> paths = new ArrayList<>();

    Queue<Integer> queue = new ArrayDeque<>();
    // seed with [1, 9]
    IntStream.rangeClosed(1, 9).forEach(queue::add);

    while (!queue.isEmpty()) {
      int path = queue.remove();
      paths.add(path);

      // i.e. last node in path
      int node = path % 10;
      int next = node + 1;
      if (next <= 9) {
        queue.add(path * 10 + next);
      }
    }

    return paths.stream().filter(i -> i >= low && i <= high).collect(Collectors.toList());
  }
}
