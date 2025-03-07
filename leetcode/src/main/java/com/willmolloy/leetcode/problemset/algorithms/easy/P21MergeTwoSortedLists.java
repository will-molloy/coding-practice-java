package com.willmolloy.leetcode.problemset.algorithms.easy;

import com.willmolloy.leetcode.common.ListNode;

/**
 * <a
 * href=https://leetcode.com/problems/merge-two-sorted-lists>https://leetcode.com/problems/merge-two-sorted-lists/</a>
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P23MergeKSortedLists
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P148SortLinkedList
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P1305AllElementsInTwoBinarySearchTrees
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface P21MergeTwoSortedLists {

  ListNode mergeTwoLists(ListNode l1, ListNode l2);

  /**
   * Runtime: O(n)
   *
   * <p>Extra space: O(1)
   *
   * <p>Key idea: Choose smaller node.
   */
  class Iterative implements P21MergeTwoSortedLists {

    @Override
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

  /**
   * Runtime: O(n)
   *
   * <p>Extra space: O(n)
   *
   * <p>Key idea: Choose smaller node.
   */
  class Recursive implements P21MergeTwoSortedLists {

    @Override
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if (l1 == null) {
        return l2;
      }
      if (l2 == null) {
        return l1;
      }

      if (l1.val < l2.val) {
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
      } else {
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
      }
    }
  }
}
