package com.wilmol.leetcode.problemset.algorithms.easy;

import com.wilmol.leetcode.common.ListNode;

/**
 * <a
 * href=https://leetcode.com/problems/linked-list-cycle>https://leetcode.com/problems/linked-list-cycle/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Fast and slow pointer.
 *
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P142LinkedListCycle2
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P141LinkedListCycle {

  public boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }
}
