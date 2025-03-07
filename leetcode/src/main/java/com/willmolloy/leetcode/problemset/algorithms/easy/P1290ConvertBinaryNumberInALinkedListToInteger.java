package com.willmolloy.leetcode.problemset.algorithms.easy;

import com.willmolloy.leetcode.common.ListNode;

/**
 * <a
 * href=https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer>https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key idea: Bubble up result from the end of the list (dfs/dp).
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P2AddTwoNumbers
 * @see P67AddBinary
 * @see P415AddStrings
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P445AddTwoNumbers2
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1290ConvertBinaryNumberInALinkedListToInteger {

  // example: head = [1, 0, 1] -> 1*2^2 + 0*2^1 + 1*2^0 = 5

  public int getDecimalValue(ListNode head) {
    return solve(head)[0];
  }

  // return {result, length}
  private int[] solve(ListNode node) {
    if (node == null) {
      return new int[] {0, -1};
    }
    int[] next = solve(node.next);
    int length = next[1] + 1;
    int result = next[0] + node.val * pow2(length);
    return new int[] {result, length};
  }

  private int pow2(int exp) {
    return 1 << exp;
  }
}
