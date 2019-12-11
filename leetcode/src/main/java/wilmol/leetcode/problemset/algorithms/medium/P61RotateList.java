package wilmol.leetcode.problemset.algorithms.medium;

import wilmol.leetcode.common.ListNode;

/**
 * Created by wilmol on 2019-12-11.
 *
 * <p><a
 * href=https://leetcode.com/problems/rotate-list>https://leetcode.com/problems/rotate-list</a>
 *
 * <p>Runtime: O(2n)
 *
 * <p>Key: get size of list (n) first.
 */
class P61RotateList {

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
      return null;
    }
    // get size of list so can find 'fromLeft' element which is at n - k - 1
    int n = size(head);

    // modulo k for the case where k > n
    // redundant to rotate beyond n (would be idempotent, k/n times)
    k %= n;
    if (k == 0) {
      return head;
    }

    // make last -> head (creating a cycle)
    // and fromLeft -> null (breaks cycle)

    // e.g. 1 -> 2 -> 3 -> 4 -> 5 -> null, k = 2
    // want fromLeft = 3

    ListNode fromLeft = head; // 1
    int i = 1;
    for (; i < n - k; i++) {
      fromLeft = fromLeft.next; // 2, 3
    }

    ListNode last = fromLeft; // 3
    for (; i < n; i++) {
      last = last.next; // 4, 5
    }

    last.next = head; // 5 -> 1 (creates cycle)
    // save newHead before breaking its inward pointer
    ListNode newHead = fromLeft.next; // 4
    fromLeft.next = null; // 3 -> null (breaks cycle)
    return newHead; // 4 -> 5 -> 1 -> 2 -> 3 -> null
  }

  private int size(ListNode head) {
    int size = 0;
    while (head != null) {
      size += 1;
      head = head.next;
    }
    return size;
  }
}
