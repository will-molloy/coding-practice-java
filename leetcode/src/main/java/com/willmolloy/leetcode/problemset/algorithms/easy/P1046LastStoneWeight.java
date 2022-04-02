package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a
 * href=https://leetcode.com/problems/last-stone-weight>https://leetcode.com/problems/last-stone-weight</a>
 *
 * <p>Runtime: O(n log n)
 *
 * <p>Space: O(n)
 *
 * <p>Key: heap ({@link PriorityQueue})
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1046LastStoneWeight {

  public int lastStoneWeight(int[] stones) {
    // dump into max heap
    PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
    for (int stone : stones) {
      heap.add(stone);
    }

    // simulate the process
    while (heap.size() > 1) {
      int y = heap.remove();
      int x = heap.remove();
      if (x != y) {
        heap.add(y - x);
      }
    }
    return heap.isEmpty() ? 0 : heap.peek();
  }
}
