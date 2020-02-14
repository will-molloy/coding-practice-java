package wilmol.leetcode.problemset.algorithms.medium;

import wilmol.leetcode.common.BinaryTreeNode;
import wilmol.leetcode.common.ListNode;

/**
 * Created by wilmol on 2020-02-14.
 *
 * <p><a
 * href=https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree>https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree</a>
 *
 * <p>Runtime: O(n lg n) (recurrence T(n) = 2T(n/2) + O(n))
 *
 * <p>Space: O(lg n)
 *
 * <p>Key: checking for singleton list; so can assume list of size 2 when splitting in half, which
 * avoids NPE
 *
 * @see wilmol.leetcode.problemset.algorithms.easy.P108ConvertSortedArrayToBinarySearchTree
 */
class P109ConvertSortedListToBinarySearchTree {

  public BinaryTreeNode sortedListToBst(ListNode head) {
    if (head == null) {
      // empty list; empty tree
      return null;
    }
    if (head.next == null) {
      // singleton list; singleton tree
      return new BinaryTreeNode(head.val);
    }
    // same idea as array; build tree by taking middle element at each step
    ListNode mid = getMidAndSplit(head);
    BinaryTreeNode node = new BinaryTreeNode(mid.val);
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
