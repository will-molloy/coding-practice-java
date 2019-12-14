package wilmol.leetcode.problemset.algorithms.medium;

import wilmol.leetcode.common.ListNode;

/**
 * Created by wilmol on 2019-12-14.
 *
 * <p><a
 * href=https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii>https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Key: helper method with recursive call to skip runs of duplicates, even if differing value
 *
 * @see wilmol.leetcode.problemset.algorithms.easy.P83RemoveDuplicatesFromSortedList
 */
class P82RemoveDuplicatesFromSortedList2 {

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
