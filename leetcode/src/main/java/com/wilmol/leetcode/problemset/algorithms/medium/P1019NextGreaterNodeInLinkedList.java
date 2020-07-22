package com.wilmol.leetcode.problemset.algorithms.medium;

import com.wilmol.leetcode.common.ListNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/next-greater-node-in-linked-list>https://leetcode.com/problems/next-greater-node-in-linked-list/</a>
 *
 * <p>Runtime: O(n) (amortised analysis - add each element to stack once so <b>total</b> runtime of
 * {@code while} loop is O(n))
 *
 * <p>Extra memory: O(n) (recursion stack space)
 *
 * <p>Key: Monotonic queue.
 *
 * @see P739DailyTemperatures
 * @see P901OnlineStockSpan
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1019NextGreaterNodeInLinkedList {

  public int[] nextLargerNodes(ListNode head) {
    // get things running
    List<Integer> result = new ArrayList<>();
    nextLargerNode(head, result, new ArrayDeque<>());

    // convert to required output
    // java specific, arraylist inefficient to insert at front so need reversal
    Collections.reverse(result);
    // leetcode wants array...
    return result.stream().mapToInt(i -> i).toArray();
  }

  private void nextLargerNode(ListNode head, List<Integer> result, Deque<Integer> deque) {
    if (head == null) {
      return;
    }

    // process in reverse order
    nextLargerNode(head.next, result, deque);

    // the deque holds elements in increasing order (monotonic)
    // only holds elements which could become part of the results
    // i.e. those larger than current element, since future processed elements would use the current
    // element as the next larger element over any smaller elements
    while (!deque.isEmpty() && head.val >= deque.peekFirst()) {
      deque.removeFirst();
    }

    // next must be larger (not equal) so get from deque now before adding current element
    int nextLargerValue = deque.isEmpty() ? 0 : deque.peekFirst();
    result.add(nextLargerValue);

    deque.addFirst(head.val);
  }
}
