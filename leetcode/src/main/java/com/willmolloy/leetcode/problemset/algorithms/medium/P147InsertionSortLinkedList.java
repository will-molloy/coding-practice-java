package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.ListNode;

/**
 * <a
 * href=https://leetcode.com/problems/insertion-sort-list>https://leetcode.com/problems/insertion-sort-list/</a>
 *
 * <p>Runtime: O(n<sup>2</sup>)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Insert one node each iteration (growing sorted list by 1). Will need previous and
 * next pointer to do the insertion.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 * @see P148SortLinkedList
 */
final class P147InsertionSortLinkedList {

  public ListNode insertionSortList(ListNode head) {
    // dummy head in case we need to insert at the start of the list
    ListNode newHead = new ListNode(Integer.MIN_VALUE);

    ListNode curr = head;

    while (curr != null) {
      // insert 'curr'

      // find insertion point
      // prev -> curr -> next
      ListNode prev = newHead;
      ListNode next = newHead.next;
      while (next != null) {
        if (curr.val < next.val) {
          break;
        }
        prev = next;
        next = next.next;
      }

      // do insertion
      ListNode nextTemp = curr.next;
      prev.next = curr;
      curr.next = next;

      // go next
      curr = nextTemp;
    }
    return newHead.next;
  }
}
