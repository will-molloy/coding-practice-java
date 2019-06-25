package com.wilmol.leetcode.problems.linkedlist.medium;

import com.wilmol.leetcode.common.ListNode;

/**
 * Created by Will on 2019-06-23 at 20:43
 *
 * <p>Runtime: O(n)
 */
public class P2_AddTwoNumbers {

  public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
    ListNode node = new ListNode(0);
    ListNode head = node;
    int carry = 0;
    while (list1 != null || list2 != null || carry > 0) {
      int sum = carry;
      if (list1 != null) {
        sum += list1.value;
        list1 = list1.next;
      }
      if (list2 != null) {
        sum += list2.value;
        list2 = list2.next;
      }
      node.next = new ListNode(sum % 10);
      carry = sum / 10;
      node = node.next;
    }
    return head.next;
  }
}
