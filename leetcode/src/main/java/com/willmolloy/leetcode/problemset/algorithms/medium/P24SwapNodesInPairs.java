package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.ListNode;

/**
 * <a
 * href=https://leetcode.com/problems/swap-nodes-in-pairs>https://leetcode.com/problems/swap-nodes-in-pairs</a>
 *
 * <p>Runtime: O(n)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P24SwapNodesInPairs {

  public ListNode swapPairs(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode second = head.next;
    if (second == null) {
      return head;
    }

    ListNode third = second.next;
    // swap first two nodes and concat with rest of list
    second.next = head;
    head.next = swapPairs(third);
    return second;
  }
}
