package com.willmolloy.leetcode.problemset.algorithms.easy;

import com.willmolloy.leetcode.common.ListNode;

/**
 * <a
 * href=https://leetcode.com/problems/palindrome-linked-list>https://leetcode.com/problems/palindrome-linked-list/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: For O(n) time O(1) space: compare first half of list with reversed second half of list.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P234PalindromeLinkedList {

  public boolean isPalindrome(ListNode firstHalfNotReversed) {
    ListNode secondHalfReversed = reverse(middle(firstHalfNotReversed));

    while (firstHalfNotReversed != null && secondHalfReversed != null) {
      if (firstHalfNotReversed.val != secondHalfReversed.val) {
        return false;
      }
      firstHalfNotReversed = firstHalfNotReversed.next;
      secondHalfReversed = secondHalfReversed.next;
    }
    return true;
  }

  private ListNode middle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    ListNode prev = null;
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    return prev;
  }

  private ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }
}
