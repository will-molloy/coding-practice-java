package wilmol.leetcode.problemset.algorithms.medium;

import wilmol.leetcode.common.ListNode;

/**
 * Created by Will on 2019-07-25 at 19:52.
 *
 * <p><a
 * href=https://leetcode.com/problems/swap-nodes-in-pairs>https://leetcode.com/problems/swap-nodes-in-pairs</a>
 *
 * <p>Runtime: O(n)
 */
class P24SwapNodesInPairs {

  public ListNode swapPairs(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode second = head.next;
    if (second == null) {
      return head;
    }

    ListNode third = second.next;
    // swap first two nodes and concat with rest of list
    second.next = head;
    head.next = swapPairs(third);
    return second;
  }
}
