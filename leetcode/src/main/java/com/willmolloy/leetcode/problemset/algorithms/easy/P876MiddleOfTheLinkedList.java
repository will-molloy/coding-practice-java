package com.willmolloy.leetcode.problemset.algorithms.easy;

import com.willmolloy.leetcode.common.ListNode;

/**
 * <a
 * href=https://leetcode.com/problems/middle-of-the-linked-list>https://leetcode.com/problems/middle-of-the-linked-list</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key idea: slow and faster pointer
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P148SortLinkedList
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P876MiddleOfTheLinkedList {

  public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}
