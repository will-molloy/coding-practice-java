package com.willmolloy.leetcode.problemset.algorithms.hard;

import com.willmolloy.leetcode.common.ListNode;

/**
 * <a
 * href=https://leetcode.com/problems/reverse-nodes-in-k-group>https://leetcode.com/problems/reverse-nodes-in-k-group</a>
 *
 * <p>Runtime: O(n) - does not scale with k, larger k means fewer recursive calls
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P25ReverseNodesInKGroup {

  public ListNode reverseKGroup(ListNode head, int k) {
    if (k == 1) {
      return head;
    }

    int length = 0;
    ListNode node = head;
    ListNode prev = null;
    while (node != null && length < k) {
      ListNode next = node.next;
      node.next = prev;
      prev = node;
      node = next;
      length += 1;
    }

    if (length < k) {
      // undo reversal, since k did not fit into the list/sublist
      return reverse(prev);
    }

    head.next = reverseKGroup(node, k);
    return prev;
  }

  private ListNode reverse(ListNode node) {
    ListNode prev = null;
    while (node != null) {
      ListNode next = node.next;
      node.next = prev;
      prev = node;
      node = next;
    }
    return prev;
  }
}
