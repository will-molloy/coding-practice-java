package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.ListNode;

/**
 * <a
 * href=https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii>https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Key idea: helper method with recursive call to skip runs of duplicates, even if differing
 * value
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P83RemoveDuplicatesFromSortedList
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P82RemoveDuplicatesFromSortedList2 {

  public ListNode deleteDuplicates(ListNode head) {
    // Skip any starting dupes
    if (isDupe(head)) {
      head = nextNonDupeVal(head);
    }

    // maintain head ptr
    ListNode node = head;

    while (node != null) {
      // if next node is duplicate then skip over it (and its entire duplicate run)
      if (isDupe(node.next)) {
        node.next = nextNonDupeVal(node.next);
      }
      node = node.next;
    }

    return head;
  }

  private boolean isDupe(ListNode node) {
    // extra null check as node.next is passed in
    return node != null && node.next != null && node.val == node.next.val;
  }

  private ListNode nextNonDupeVal(ListNode node) {
    // assumed input is duplicate, so find next node with differing value
    int val = node.val;
    while (node != null && node.val == val) {
      node = node.next;
    }
    // node may still be duplicate (just on a different value) so check again
    return isDupe(node) ? nextNonDupeVal(node) : node;
  }
}
