package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.ListNode;

/**
 * <a
 * href=https://leetcode.com/problems/partition-list>https://leetcode.com/problems/partition-list</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key idea: partition into two lists and join at the end, also dummy nodes to avoid null
 * problems
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P86PartitionList {

  public ListNode partition(final ListNode head, int x) {
    // partition into lessThan list and greaterThanEqual list
    // use dummy node to avoid NPE in case the list is empty
    ListNode ltList = new ListNode(0);
    final ListNode ltHead = ltList;
    ListNode gteList = new ListNode(0);
    final ListNode gteHead = gteList;

    ListNode node = head;
    while (node != null) {
      if (node.val >= x) {
        gteList.next = node;
        gteList = node;
      } else {
        ltList.next = node;
        ltList = node;
      }
      node = node.next;
    }

    // join the lists
    gteList.next = null; // done first to avoid cycle when debugging
    ltList.next = gteHead.next;
    return ltHead.next;
  }
}
