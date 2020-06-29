package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/xor-operation-in-an-array>https://leetcode.com/problems/xor-operation-in-an-array/</a>
 *
 * <p>Runtime: O(n) TODO O(1) is possible, need math knowledge
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Can start from {@code start}.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1486XorOperationInAnArray {

  public int xorOperation(int n, int start) {
    int xor = start;
    for (int i = 1; i < n; i++) {
      xor ^= start + 2 * i;
    }
    return xor;
  }
}
