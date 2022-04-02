package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.ListNode;

/**
 * <a href=https://leetcode.com/problems/sort-list>https://leetcode.com/problems/sort-list/</a>
 *
 * <p>Runtime: O(n * log(n))
 *
 * <p>Extra memory: O(log(n)) (recursion stack) TODO O(1) space
 *
 * <p>Key: Merge sort - split in half, recursively sort halves, combine halves.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P21MergeTwoSortedLists
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P876MiddleOfTheLinkedList
 * @see P147InsertionSortLinkedList
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P148SortLinkedList {

  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      // base case, empty or singleton list is sorted
      return head;
    }

    ListNode mid = mid(head);

    ListNode sortedFirstHalf = sortList(head);
    ListNode sortedSecondHalf = sortList(mid);

    return merge(sortedFirstHalf, sortedSecondHalf);
  }

  // breaks list in two, returning second half
  private ListNode mid(ListNode head) {
    ListNode prev = null;
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    if (prev != null) {
      // cut in half
      prev.next = null;
    }

    return slow;
  }

  // merges sorted lists
  private ListNode merge(ListNode a, ListNode b) {
    ListNode head = new ListNode(-1);
    ListNode node = head;

    while (a != null && b != null) {
      if (a.val <= b.val) {
        node.next = a;
        a = a.next;
      } else {
        node.next = b;
        b = b.next;
      }
      node = node.next;
    }

    if (a != null) {
      node.next = a;
    }
    if (b != null) {
      node.next = b;
    }

    return head.next;
  }
}
