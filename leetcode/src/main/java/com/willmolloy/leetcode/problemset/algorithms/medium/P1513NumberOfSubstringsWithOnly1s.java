package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/number-of-substrings-with-only-1s>https://leetcode.com/problems/number-of-substrings-with-only-1s/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(n)
 *
 * <p>Key idea: Hard part is the mod, need to use {@code long} when computing sum otherwise it
 * overflows.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1513NumberOfSubstringsWithOnly1s {

  private static final int MOD = (int) 1e9 + 7;

  public int numSub(String s) {
    long count = 0;

    // get all runs of 1s
    String[] runs = s.split("0");
    for (String run : runs) {
      // number of substrings is sum [1, n]
      count += sum(run.length()) % MOD;
    }
    return (int) count;
  }

  private long sum(long n) {
    // O(1)
    return (n * (n + 1)) / 2;
  }
}
