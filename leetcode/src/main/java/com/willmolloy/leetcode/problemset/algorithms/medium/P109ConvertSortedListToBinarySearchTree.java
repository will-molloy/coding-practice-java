package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.ListNode;
import com.willmolloy.leetcode.common.TreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree>https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree</a>
 *
 * <p>Runtime: O(n lg n) (recurrence T(n) = 2T(n/2) + O(n))
 *
 * <p>Space: O(lg n)
 *
 * <p>Key idea: checking for singleton list; so can assume list of size 2 when splitting in half,
 * which avoids NPE
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P108ConvertSortedArrayToBinarySearchTree
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P109ConvertSortedListToBinarySearchTree {

  public TreeNode sortedListToBst(ListNode head) {
    if (head == null) {
      // empty list; empty tree
      return null;
    }
    if (head.next == null) {
      // singleton list; singleton tree
      return new TreeNode(head.val);
    }
    // same idea as array; build tree by taking middle element at each step
    ListNode mid = getMidAndSplit(head);
    TreeNode node = new TreeNode(mid.val);
    node.left = sortedListToBst(head);
    node.right = sortedListToBst(mid.next);
    return node;
  }

  private ListNode getMidAndSplit(ListNode head) {
    ListNode prevSlow = null;
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      prevSlow = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    // split list at middle, so can get left list
    // (safe from NPE because given list has at least two elements)
    prevSlow.next = null;
    return slow;
  }
}
