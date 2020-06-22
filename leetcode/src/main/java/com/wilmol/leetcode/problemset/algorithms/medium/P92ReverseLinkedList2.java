package com.wilmol.leetcode.problemset.algorithms.medium;

import com.wilmol.leetcode.common.ListNode;

/**
 * Created by wilmol on 2020-02-08.
 *
 * <p><a
 * href=https://leetcode.com/problems/reverse-linked-list-ii>https://leetcode.com/problems/reverse-linked-list-ii</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key: dummy node, pointer manipulation, understanding once list is joined problem is solved
 * (since unlike an array, the contents are already present as if they were processed), using array
 * to return tuple to achieve 1-pass requirement
 *
 * @see com.wilmol.leetcode.problemset.algorithms.easy.P206ReverseLinkedList
 */
class P92ReverseLinkedList2 {

  // m and n are 1-indexed and represent a closed range [m, n]

  public ListNode reverseBetween(ListNode head, int m, int n) {
    // dummy node to mark new head, in case head needs to be moved (i.e. m = 1)
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode node = dummy;

    // scan forward to reversed section
    for (int i = 1; i < m; i++) {
      node = node.next;
    }

    // reverse the sublist in range [m, n]
    ListNode[] reverse = reverse(node.next, n - m + 1);

    // insert the sublist:
    // temporarily save next
    ListNode next = node.next;
    // reversed[0]: head of reversed sublist
    node.next = reverse[0];
    // reversed[1]: beyond reversed sublist
    next.next = reverse[1];

    return dummy.next;
  }

  private ListNode[] reverse(ListNode node, int length) {
    ListNode prev = null;
    ListNode next = null;
    for (int i = 0; i < length; i++) {
      // standard linked list reversal
      next = node.next;
      node.next = prev;
      prev = node;
      node = next;
    }
    // return prev (head of reversed sublist) AND next (beyond reversed sublist) to achieve 1-pass
    // requirement (otherwise have to scan over reversed sublist again)
    return new ListNode[] {prev, next};
  }
}
