package com.willmolloy.leetcode.problemset.algorithms.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a
 * href=https://leetcode.com/problems/find-median-from-data-stream>https://leetcode.com/problems/find-median-from-data-stream</a>
 *
 * <p>Runtime: see methods
 *
 * <p>Space: O(n)
 *
 * <p>Key: heap data structure ({@link PriorityQueue} in Java)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P295FindMedianFromDataStream {

  // 2 heaps, keep sizes balanced (within 1 difference)
  // minHeap holds larger values
  // maxHeap holds smaller values
  // therefore heads contain middle values overall
  private final PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());
  private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

  // O(log n)
  public void addNum(int num) {
    if (maxHeap.isEmpty() || num < maxHeap.peek()) {
      // put with smaller values
      maxHeap.add(num);
    } else {
      // put with larger values
      minHeap.add(num);
    }
    // rebalance
    while (minHeap.size() - maxHeap.size() > 1) {
      maxHeap.add(minHeap.remove());
    }
    while (maxHeap.size() - minHeap.size() > 1) {
      minHeap.add(maxHeap.remove());
    }
  }

  // O(1)
  public double findMedian() {
    if (minHeap.size() == maxHeap.size()) {
      return (minHeap.peek() + maxHeap.peek()) / 2d;
    }
    if (minHeap.size() > maxHeap.size()) {
      return minHeap.peek();
    } else {
      return maxHeap.peek();
    }
  }
}
