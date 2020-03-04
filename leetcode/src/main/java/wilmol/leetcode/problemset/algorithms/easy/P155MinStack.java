package wilmol.leetcode.problemset.algorithms.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * Created by wilmol on 2020-03-04.
 *
 * <p><a href=https://leetcode.com/problems/min-stack>https://leetcode.com/problems/min-stack</a>
 *
 * <p>Runtime: see methods
 *
 * <p>Space: O(n)
 *
 * <p>Key: priority queue to track minimum
 */
class P155MinStack {

  // TODO probably way to do it with all operations O(1)

  private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();

  private final Deque<Integer> stack = new ArrayDeque<>();

  // O(log n)
  public void push(int x) {
    stack.addFirst(x);
    minHeap.add(x);
  }

  // O(n)
  public void pop() {
    int x = stack.removeFirst();
    minHeap.remove(x);
  }

  // O(1)
  public int top() {
    return stack.peek();
  }

  // O(1)
  public int getMin() {
    return minHeap.peek();
  }
}
