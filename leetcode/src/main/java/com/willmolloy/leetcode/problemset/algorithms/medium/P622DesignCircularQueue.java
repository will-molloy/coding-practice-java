package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a
 * href=https://leetcode.com/problems/design-circular-queue>https://leetcode.com/problems/design-circular-queue/</a>
 *
 * <p>Runtime: O(1) for all operations
 *
 * <p>Extra memory: O(1) for all operations
 *
 * <p>Key idea: Delegate to {@link Deque}.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P622DesignCircularQueue {

  /** MyCircularQueue. */
  static final class MyCircularQueue {

    private final Deque<Integer> q = new ArrayDeque<>();
    private final int k;

    MyCircularQueue(int k) {
      this.k = k;
    }

    public boolean enQueue(int value) {
      if (isFull()) {
        return false;
      }
      // add to the TAIL (FIFO)
      q.addLast(value);
      return true;
    }

    public boolean deQueue() {
      if (isEmpty()) {
        return false;
      }
      // remove the HEAD (FIFO)
      q.removeFirst();
      return true;
    }

    public int front() {
      return isEmpty() ? -1 : q.getFirst();
    }

    public int rear() {
      return isEmpty() ? -1 : q.getLast();
    }

    public boolean isEmpty() {
      return q.isEmpty();
    }

    public boolean isFull() {
      return q.size() == k;
    }
  }
}
