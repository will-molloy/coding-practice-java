package com.wilmol.leetcode.problemset.algorithms.easy;

import com.wilmol.leetcode.common.ListNode;

/**
 * Created by Will on 2019-07-22 at 19:45.
 *
 * <p><a
 * href=https://leetcode.com/problems/merge-two-sorted-lists>https://leetcode.com/problems/merge-two-sorted-lists</a>
 *
 * <p>Runtime: O(n), O(1) memory
 *
 * @see com.wilmol.leetcode.problemset.algorithms.hard.P23MergeKSortedLists
 */
class P21MergeTwoSortedLists {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode node = new ListNode(0);
    final ListNode beforeHead = node;

    // merge lists until one is exhausted by picking smallest values
    // do not need to create new objects
    // changing the pointers is sufficient (and allows O(1) memory)
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        node.next = l1;
        l1 = l1.next;
      } else {
        node.next = l2;
        l2 = l2.next;
      }
      node = node.next;
    }

    // append remaining list (if applicable)
    if (l1 != null) {
      node.next = l1;
    }
    if (l2 != null) {
      node.next = l2;
    }

    return beforeHead.next;
  }
}
