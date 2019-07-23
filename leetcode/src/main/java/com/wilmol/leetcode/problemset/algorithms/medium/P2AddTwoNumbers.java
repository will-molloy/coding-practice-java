package com.wilmol.leetcode.problemset.algorithms.medium;

import com.wilmol.leetcode.common.ListNode;

/**
 * Created by Will on 2019-06-23 at 20:43.
 *
 * <p><a
 * href=https://leetcode.com/problems/add-two-numbers>https://leetcode.com/problems/add-two-numbers</a>
 *
 * <p>Runtime: O(n + m) - single pass on each list
 */
class P2AddTwoNumbers {

  ListNode addTwoNumbers(ListNode list1, ListNode list2) {
    ListNode node = new ListNode(0);
    ListNode head = node;
    int carry = 0;
    while (list1 != null || list2 != null || carry > 0) {
      int sum = carry;
      if (list1 != null) {
        sum += list1.val;
        list1 = list1.next;
      }
      if (list2 != null) {
        sum += list2.val;
        list2 = list2.next;
      }
      node.next = new ListNode(sum % 10);
      carry = sum / 10;
      node = node.next;
    }
    return head.next;
  }
}
