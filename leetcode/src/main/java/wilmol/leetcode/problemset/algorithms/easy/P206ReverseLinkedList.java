package wilmol.leetcode.problemset.algorithms.easy;

import wilmol.leetcode.common.ListNode;

/**
 * Created by wilmol on 2020-02-08.
 *
 * <p><a
 * href=https://leetcode.com/problems/reverse-linked-list>https://leetcode.com/problems/reverse-linked-list</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key: pointer manipulation, and using temporary variable for swap
 */
class P206ReverseLinkedList {

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
