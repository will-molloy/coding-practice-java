package com.willmolloy.leetcode.problemset.algorithms.hard;

/**
 * <a
 * href=https://leetcode.com/problems/stone-game-iv>https://leetcode.com/problems/stone-game-iv/</a>
 *
 * <p>Runtime: O(n * sqrt(n))
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key idea: Visualise the problem as a tree rooted at n where each child is that of subtracting
 * a non-zero square number (each path leads to zero since you can subtract 1). At each step, test
 * if there is a path where the other player can't win.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P877StoneGame
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1510StoneGame4 {

  public boolean winnerSquareGame(int n) {
    // what does it mean to play optimally???
    // at each step a player has several paths to choose from, playing optimally means they should
    // pick one which leads to the other player being unable to win
    // (this is different from any winning path - since the other player is also playing optimally,
    // we can't simply rely on them picking a losing path)
    // so we win if such a path exists

    // dp[i] = true if you win with i stones remaining
    // (not necessarily alice winning, it just happens that alice makes the first move when there
    // are n stones)
    boolean[] dp = new boolean[n + 1];

    // base case, dp[0] = false (being unable to make a move is the losing condition)

    // recursive case
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j * j <= i; j++) {
        // test there is any path where the other player loses
        dp[i] |= !dp[i - j * j];
      }
    }

    return dp[n];
  }
}
