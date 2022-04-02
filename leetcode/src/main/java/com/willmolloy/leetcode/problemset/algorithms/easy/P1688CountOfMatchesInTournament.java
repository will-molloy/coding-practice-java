package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/count-of-matches-in-tournament>https://leetcode.com/problems/count-of-matches-in-tournament/</a>
 *
 * <p>Runtime: O(log(n))
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Simulate each round (either odd/even n).
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1688CountOfMatchesInTournament {

  public int numberOfMatches(int n) {
    int c = 0;
    while (n > 1) {
      if (n % 2 == 0) {
        c += n / 2;
        n /= 2;
      } else {
        c += n / 2;
        n = n / 2 + 1;
      }
    }
    return c;
  }
}
