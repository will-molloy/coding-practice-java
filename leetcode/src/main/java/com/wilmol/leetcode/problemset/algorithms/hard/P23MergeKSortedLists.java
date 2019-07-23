package com.wilmol.leetcode.problemset.algorithms.hard;

import com.wilmol.leetcode.common.ListNode;

/**
 * Created by Will on 2019-07-23 at 21:33.
 *
 * <p><a
 * href=https://leetcode.com/problems/merge-k-sorted-lists>https://leetcode.com/problems/merge-k-sorted-lists</a>
 *
 * <p>Runtime: O(n * k), n = length of joined lists, k = number of lists. O(1) memory
 *
 * <p>TODO Can be done in O(n log k)
 *
 * @see com.wilmol.leetcode.problemset.algorithms.easy.P21MergeTwoSortedLists
 */
class P23MergeKSortedLists {

  public ListNode mergeKLists(ListNode[] lists) {
    ListNode node = new ListNode(0);
    ListNode beforeHead = node;
    while (true) {
      int indexMinVal = indexOfMinNode(lists);
      if (indexMinVal == -1) {
        return beforeHead.next;
      }
      node.next = lists[indexMinVal];
      node = node.next;
      lists[indexMinVal] = lists[indexMinVal].next;
    }
  }

  private int indexOfMinNode(ListNode[] lists) {
    int minVal = Integer.MAX_VALUE;
    int indexMinVal = -1;
    for (int i = 0; i < lists.length; i++) {
      ListNode node = lists[i];
      if (node != null && node.val < minVal) {
        minVal = node.val;
        indexMinVal = i;
      }
    }
    return indexMinVal;
  }
}
