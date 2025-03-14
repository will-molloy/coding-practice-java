package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a href=https://leetcode.com/problems/gas-station>https://leetcode.com/problems/gas-station</a>
 *
 * <p>Runtime: O(n<sup>2</sup>)
 *
 * <p>Space: O(1)
 *
 * <p>Key idea: Simulate the process.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P134GasStation {

  // TODO O(n) solution, relies on math proof

  public int canCompleteCircuit(int[] gas, int[] cost) {
    final int n = gas.length;
    for (int start = 0; start < n; start++) {
      int gasBalance = 0;
      int steps = 0;
      for (int i = start; true; i = (i + 1) % n, steps++) {
        if (steps == n) {
          return start;
        }
        gasBalance += gas[i];
        gasBalance -= cost[i];
        if (gasBalance < 0) {
          break;
        }
      }
    }
    return -1;
  }
}
