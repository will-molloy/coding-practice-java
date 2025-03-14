package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <a
 * href=https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix>https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/</a>
 *
 * <p>Runtime: O(rows * (cols + log(k)) = O(rows * cols + rows * log(k))
 *
 * <p>Extra memory: O(rows)
 *
 * <p>Key idea: Process score for each row ([index, soldier count]). Store in priority queue for k
 * weakest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1337TheKWeakestRowsInAMatrix {

  public int[] kWeakestRows(int[][] mat, int k) {
    // inner list of [index, soldier count]
    // sort by soldier count and then index
    Comparator<List<Integer>> comparator =
        Comparator.comparing((List<Integer> l) -> l.get(1))
            .thenComparing((List<Integer> l) -> l.get(0));
    // reversed so strongest are on top and therefore removed first
    PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>(comparator.reversed());

    for (int row = 0; row < mat.length; row++) {
      int count = 0;
      for (int col : mat[row]) {
        if (col == 1) {
          count++;
        } else {
          break;
        }
      }
      priorityQueue.add(List.of(row, count));
      // bound to k weakest
      if (priorityQueue.size() > k) {
        priorityQueue.remove();
      }
    }

    int[] ans = new int[k];
    for (int i = k - 1; i >= 0; i--) {
      ans[i] = priorityQueue.remove().get(0);
    }
    return ans;
  }
}
