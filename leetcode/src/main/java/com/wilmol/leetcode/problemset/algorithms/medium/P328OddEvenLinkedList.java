package com.wilmol.leetcode.problemset.algorithms.medium;

import com.wilmol.leetcode.common.ListNode;

/**
 * <a
 * href=https://leetcode.com/problems/odd-even-linked-list>https://leetcode.com/problems/odd-even-linked-list/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Track odds/evens separately and link them at the end.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P328OddEvenLinkedList {

  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode odds = head;
    ListNode evens = head.next;
    ListNode evensHead = evens;

    // need to create the lists together like this (i.e. not separately) cause we're changing the
    // pointers as we go
    // otherwise, we'd lose reference to the second created lists nodes
    ListNode node = head.next.next;
    for (int i = 1; node != null; i++) {
      if (isEven(i)) {
        evens.next = node;
        evens = evens.next;
      } else {
        odds.next = node;
        odds = odds.next;
      }
      node = node.next;
    }

    // cut evens list otherwise get a cycle
    evens.next = null;
    odds.next = evensHead;

    return head;
  }

  private static boolean isEven(int i) {
    return i % 2 == 0;
  }
}
