package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.ListNode;

/**
 * <a
 * href=https://leetcode.com/problems/reorder-list>https://leetcode.com/problems/reorder-list/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Break problem into steps.
 *
 * <ol>
 *   <li>Get halves (slow/fast ptr, don't forget to break list at middle!)
 *   <li>Reverse second half (identified this by examining examples)
 *   <li>Interleave halves
 * </ol>
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P206ReverseLinkedList
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P876MiddleOfTheLinkedList
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P143ReorderList {

  public void reorderList(ListNode head) {
    if (head == null) {
      return;
    }

    // get halves
    ListNode first = head;
    ListNode second = middle(head);

    // reverse second half
    second = reverse(second);

    // interleave
    while (first != null && second != null) {
      ListNode firstNext = first.next;
      first.next = second;
      first = firstNext;

      ListNode secondNext = second.next;
      second.next = firstNext;
      second = secondNext;
    }
  }

  private ListNode middle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    ListNode prev = null;
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    if (fast != null) {
      // if odd length, round up
      prev = slow;
      slow = slow.next;
    }
    // (side effect) break list in half
    prev.next = null;
    return slow;
  }

  private ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }
}
