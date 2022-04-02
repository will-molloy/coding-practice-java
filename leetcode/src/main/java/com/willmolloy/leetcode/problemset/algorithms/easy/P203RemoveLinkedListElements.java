package com.willmolloy.leetcode.problemset.algorithms.easy;

import com.willmolloy.leetcode.common.ListNode;

/**
 * <a
 * href=https://leetcode.com/problems/remove-linked-list-elements>https://leetcode.com/problems/remove-linked-list-elements/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Dummy node to handle case head needs to be removed.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P203RemoveLinkedListElements {

  public ListNode removeElements(ListNode node, int val) {
    ListNode dummy = new ListNode(-1);
    dummy.next = node;
    ListNode prev = dummy;

    while (node != null) {
      if (node.val == val) {
        // remove current node, keep prev same, haven't tested next node yet
        prev.next = node.next;
      } else {
        // go next
        prev = node;
      }
      // go next
      node = node.next;
    }
    return dummy.next;
  }
}
