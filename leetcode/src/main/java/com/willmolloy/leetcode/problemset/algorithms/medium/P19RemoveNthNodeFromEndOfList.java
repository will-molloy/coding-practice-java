package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.ListNode;

/**
 * <a
 * href=https://leetcode.com/problems/remove-nth-node-from-end-of-list>https://leetcode.com/problems/remove-nth-node-from-end-of-list</a>
 *
 * <p>Runtime: O(n)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P19RemoveNthNodeFromEndOfList {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) {
      return null;
    }
    ListNode beforeHead = new ListNode(0);
    beforeHead.next = head;
    ListNode slow = beforeHead;
    ListNode fast = beforeHead;

    // move fast 'n' spaces forward
    for (int i = 0; i < n; i++) {
      fast = fast.next;
    }

    // fast is now 'n' ahead of slow

    // move fast and slow at same pace, until fast reaches end of list
    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }

    // slow is now at 'nth from end' position - 1
    // e.g. length = 5, n = 2, fast will be at 5, slow will be at 3

    // remove current element pointed at by slow.next, i.e. 4 in above example
    slow.next = slow.next.next;

    // cannot return 'head' directly, in case 'head' was removed
    return beforeHead.next;
  }
}
