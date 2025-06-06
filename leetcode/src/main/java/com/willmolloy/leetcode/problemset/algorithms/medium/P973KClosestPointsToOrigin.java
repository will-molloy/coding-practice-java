package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a
 * href=https://leetcode.com/problems/k-closest-points-to-origin>https://leetcode.com/problems/k-closest-points-to-origin/</a>
 *
 * <p>Runtime: O(n log(k))
 *
 * <p>Extra space: O(k)
 *
 * <p>Key idea: Priority queue (heap). Placing the furthest points at the top of the heap such that
 * they are evicted first.
 *
 * @see P347TopKFrequentElements
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P414ThirdMaximumNumber
 * @see P692TopKFrequentWords
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P973KClosestPointsToOrigin {

  public int[][] kClosest(int[][] points, int k) {
    // heap will hold the k closest points
    // put furthest point at top of heap, so its evicted first
    Comparator<int[]> comparator =
        Comparator.comparingInt(
                (int[] a) -> {
                  int x = a[0];
                  int y = a[1];
                  return x * x + y * y;
                })
            .reversed();
    PriorityQueue<int[]> heap = new PriorityQueue<>(comparator);

    for (int[] point : points) {
      heap.add(point);
      if (heap.size() > k) {
        heap.remove();
      }
    }

    return heap.toArray(new int[0][0]);
  }
}
