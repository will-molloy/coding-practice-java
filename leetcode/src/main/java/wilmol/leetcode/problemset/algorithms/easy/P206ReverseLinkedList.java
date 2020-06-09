package wilmol.leetcode.problemset.algorithms.easy;

import wilmol.leetcode.common.ListNode;

/**
 * Created by wilmol on 2020-02-08.
 *
 * <p><a
 * href=https://leetcode.com/problems/reverse-linked-list>https://leetcode.com/problems/reverse-linked-list/</a>
 *
 * <p>Key: pointer manipulation, and using temporary variable for swap.
 *
 * @see wilmol.leetcode.problemset.algorithms.medium.P92ReverseLinkedList2
 */
interface P206ReverseLinkedList {

  ListNode reverseList(ListNode head);

  /**
   * Iterative solution.
   *
   * <p>Runtime: O(n)
   *
   * <p>Space: O(1)
   */
  class Iterative implements P206ReverseLinkedList {

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
  class Recursive implements P206ReverseLinkedList {

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
