package com.willmolloy.hackerrank.interviewpreparationkit.recursionbacktracking.medium;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=recursion-backtracking>https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=recursion-backtracking</a>
 *
 * <p>Not sure why it is categorised under recursion? Top-down recursive solution times out.
 *
 * <p>Also not sure why it asks for modulo of the answer, it passes without doing that, and using
 * int.
 *
 * <p>Runtime: O(3^n) (recursive top down) O(n) (iterative/tail recursive bottom up).
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class RecursionDavisStaircase {

  private RecursionDavisStaircase() {}

  static int stepPerms(int n) {
    // since the steps are 1, 2, or 3, this is actually an extension of the fibonacci sequence
    // i.e. no dynamic programming fancy stuff needed (like with the coin change problem)

    // however... using iterative solution (just with tail recursion) otherwise get TLE
    // kinda weird its categorised under recursion if that is the case... tail recursion isn't
    // really recursion

    if (n < 0) {
      throw new IllegalArgumentException();
    }
    if (n == 0) {
      return 1;
    }
    if (n == 1 || n == 2) {
      return n;
    }
    // n >= 3
    // bottom up
    return stepPerms(1, 2, 4, 3, n);
  }

  private static int stepPerms(
      int waysNMinus2, int waysNMinus1, int currentWays, int currentN, int n) {
    if (currentN == n) {
      return currentWays;
    }
    // calculate new ways for new n, and shift old ways over
    return stepPerms(
        waysNMinus1, currentWays, waysNMinus2 + waysNMinus1 + currentWays, currentN + 1, n);
  }
}
