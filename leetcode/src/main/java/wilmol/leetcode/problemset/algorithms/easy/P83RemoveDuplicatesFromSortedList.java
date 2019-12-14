package wilmol.leetcode.problemset.algorithms.easy;

import wilmol.leetcode.common.ListNode;

/**
 * Created by wilmol on 2019-12-14.
 *
 * <p><a
 * href=https://leetcode.com/problems/remove-duplicates-from-sorted-list>https://leetcode.com/problems/remove-duplicates-from-sorted-list</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Key: inner while loop to skip runs of duplicate elements greater than size 2
 *
 * @see wilmol.leetcode.problemset.algorithms.medium.P82RemoveDuplicatesFromSortedList2
 */
class P83RemoveDuplicatesFromSortedList {

  public ListNode deleteDuplicates(ListNode head) {
    // maintain head ptr
    ListNode node = head;

    while (node != null) {
      // if current val is same as next val then skip over next node
      while (node.next != null && node.val == node.next.val) {
        node.next = node.next.next;
      }
      node = node.next;
    }

    return head;
  }
}
