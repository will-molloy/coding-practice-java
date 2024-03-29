package com.willmolloy.hackerrank.interviewpreparationkit.linkedlists.easy;

import com.willmolloy.hackerrank.common.SinglyLinkedListNode;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/ctci-linked-list-cycle/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists>https://www.hackerrank.com/challenges/ctci-linked-list-cycle/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists</a>
 *
 * <p>Runtime: O(n)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class DetectACycle {

  private DetectACycle() {}

  static boolean hasCycle(SinglyLinkedListNode head) {
    if (head == null) {
      return false;
    }
    SinglyLinkedListNode slow = head;
    SinglyLinkedListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      // don't care about data value, just that the pointers match
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }
}
