package com.willmolloy.leetcode.problemset.algorithms.easy;

import com.willmolloy.leetcode.common.ListNode;

/**
 * <a
 * href=https://leetcode.com/problems/reverse-linked-list>https://leetcode.com/problems/reverse-linked-list/</a>
 *
 * <p>Key idea: pointer manipulation, and using temporary variable for swap.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P92ReverseLinkedList2
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
sealed interface P206ReverseLinkedList {

  ListNode reverseList(ListNode head);

  /**
   * Iterative solution.
   *
   * <p>Runtime: O(n)
   *
   * <p>Space: O(1)
   */
  final class Iterative implements P206ReverseLinkedList {

    @Override
    public ListNode reverseList(ListNode head) {
      ListNode prev = null;
      ListNode node = head;
      while (node != null) {
        // temporarily save next node
        ListNode next = node.next;
        // flip pointer
        node.next = prev;
        // continue iterating
        prev = node;
        node = next;
      }
      return prev;
    }
  }

  /**
   * Recursive solution.
   *
   * <p>Runtime: O(n)
   *
   * <p>Space: O(n)
   */
  final class Recursive implements P206ReverseLinkedList {

    @Override
    public ListNode reverseList(ListNode head) {
      if (head == null || head.next == null) {
        // base case, 0 or 1 nodes
        return head;
      }

      // recursively, prev node becomes head (i.e. reversal of tail list)
      ListNode prev = reverseList(head.next);

      // next node points at current node
      head.next.next = head;
      // break cycle
      head.next = null;
      return prev;
    }
  }
}
