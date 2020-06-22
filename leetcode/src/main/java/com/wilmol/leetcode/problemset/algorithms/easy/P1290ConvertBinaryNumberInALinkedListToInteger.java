package com.wilmol.leetcode.problemset.algorithms.easy;

import com.wilmol.leetcode.common.ListNode;

/**
 * Created by wilmol on 2020-04-14.
 *
 * <p><a
 * href=https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer>https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key: Bubble up result from the end of the list (dfs/dp).
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
