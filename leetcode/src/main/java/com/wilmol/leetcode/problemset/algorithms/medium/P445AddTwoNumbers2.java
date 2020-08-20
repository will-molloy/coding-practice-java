package com.wilmol.leetcode.problemset.algorithms.medium;

import com.wilmol.leetcode.common.ListNode;
import java.util.ArrayDeque;

/**
 * <a
 * href=https://leetcode.com/problems/add-two-numbers-ii>https://leetcode.com/problems/add-two-numbers-ii/</a>
 *
 * <p>Runtime: O(l1 + l2)
 *
 * <p>Extra memory: O(l1 + l2)
 *
 * <p>Key: Convert lists to stacks (naturally reverses them). Don't forget to construct result list
 * in reverse too!
 *
 * @see P2AddTwoNumbers
 * @see com.wilmol.leetcode.problemset.algorithms.easy.P67AddBinary
 * @see com.wilmol.leetcode.problemset.algorithms.easy.P415AddStrings
 * @see
 *     com.wilmol.leetcode.problemset.algorithms.easy.P1290ConvertBinaryNumberInALinkedListToInteger
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P445AddTwoNumbers2 {

  // TODO any cheeky recursion approach like P1019NextGreaterNodeInLinkedList?

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ArrayDeque<ListNode> s1 = toStack(l1);
    ArrayDeque<ListNode> s2 = toStack(l2);
    int carry = 0;
    ListNode result = null;

    while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
      int sum = carry;
      if (!s1.isEmpty()) {
        sum += s1.pop().val;
      }
      if (!s2.isEmpty()) {
        sum += s2.pop().val;
      }

      ListNode next = new ListNode(sum % 10);
      next.next = result;
      carry = sum / 10;
      result = next;
    }
    return result;
  }

  private ArrayDeque<ListNode> toStack(ListNode head) {
    ArrayDeque<ListNode> stack = new ArrayDeque<>();
    while (head != null) {
      stack.push(head);
      head = head.next;
    }
    return stack;
  }
}
