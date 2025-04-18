package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.ListNode;

/**
 * <a
 * href=https://leetcode.com/problems/linked-list-cycle-ii>https://leetcode.com/problems/linked-list-cycle-ii/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Slow and fast pointer. Once cycle is detected, move in lockstep from list head and
 * around the cycle from where slow/fast met, the first same node is the cycle start.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P141LinkedListCycle
 * @see P287FindTheDuplicateNumber
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P142LinkedListCycle2 {

  public ListNode detectCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {

        // find the start of the cycle
        // move in lockstep from list head and around the cycle from where slow/fast met, the first
        // same node is the cycle start

        // let x1 = distance from head to start of cycle
        // let x2 = distance from start of cycle to where slow/fast meet
        // let x3 = distance from where slow/fast meet to start of cycle

        // fast = x1 + x2 + x3 + x2
        // slow = x1 + x2
        // fast = 2 * slow

        // x1 + x2 + x3 + x2 = 2(x1 + x2)
        // -(2x2 + x1) both sides
        // x3 = x1

        ListNode result = head;
        while (slow != result) {
          slow = slow.next;
          result = result.next;
        }
        return result;
      }
    }
    return null;
  }
}
