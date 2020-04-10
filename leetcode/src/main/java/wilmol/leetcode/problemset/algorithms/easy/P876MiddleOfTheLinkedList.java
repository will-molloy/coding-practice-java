package wilmol.leetcode.problemset.algorithms.easy;

import wilmol.leetcode.common.ListNode;

/**
 * Created by wilmol on 2020-04-10.
 *
 * <p><a
 * href=https://leetcode.com/problems/middle-of-the-linked-list>https://leetcode.com/problems/middle-of-the-linked-list</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key: slow and faster pointer
 */
class P876MiddleOfTheLinkedList {

  public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}
