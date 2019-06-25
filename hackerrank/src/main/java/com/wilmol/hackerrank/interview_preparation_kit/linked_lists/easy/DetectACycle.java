package com.wilmol.hackerrank.interview_preparation_kit.linked_lists.easy;

import com.wilmol.hackerrank.common.SinglyLinkedListNode;

/**
 * Created by Will on 26/03/2019
 *
 * <p>https://www.hackerrank.com/challenges/ctci-linked-list-cycle/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists
 *
 * <p>Runtime: O(n)
 */
class DetectACycle {

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
