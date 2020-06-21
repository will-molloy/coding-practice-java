package wilmol.leetcode.problemset.algorithms.hard;

/**
 * Created by wilmol on 2020-06-21.
 *
 * <p><a
 * href=https://leetcode.com/problems/dungeon-game>https://leetcode.com/problems/dungeon-game/</a>
 *
 * <p>Runtime: O(numRows * numCols)
 *
 * <p>Extra space: O(numRows * numCols)
 *
 * <p>Key: Dynamic programming, choice is either right or down. Helps to fill in the dp table on
 * paper.
 *
 * @see wilmol.leetcode.problemset.algorithms.medium.P62UniquePaths
 * @see wilmol.leetcode.problemset.algorithms.medium.P63UniquePaths2
 * @see wilmol.leetcode.problemset.algorithms.medium.P64MinimumPathSum
 * @see wilmol.leetcode.problemset.algorithms.medium.P120Triangle
 */
class P174DungeonGame {

  public int calculateMinimumHP(int[][] dungeon) {
    int numRows = dungeon.length;
    int numCols = dungeon[0].length;

    // dp[row][col] = answer from (row, col)
    int[][] dp = new int[numRows][numCols];

    // base cases
    // bottom right
    dp[numRows - 1][numCols - 1] = Math.max(1 - dungeon[numRows - 1][numCols - 1], 1);
    // bottom border - can only move right
    for (int col = numCols - 2; col >= 0; col--) {
      int right = dp[numRows - 1][col + 1];
      dp[numRows - 1][col] = Math.max(right - dungeon[numRows - 1][col], 1);
    }
    // right border - can only move down
    for (int row = numRows - 2; row >= 0; row--) {
      int down = dp[row + 1][numCols - 1];
      dp[row][numCols - 1] = Math.max(down - dungeon[row][numCols - 1], 1);
    }

    // recursive case
    // choice is right or down, pick minimum
    for (int row = numRows - 2; row >= 0; row--) {
      for (int col = numCols - 2; col >= 0; col--) {
        int right = dp[row][col + 1];
        int down = dp[row + 1][col];
        dp[row][col] = Math.max(Math.min(right, down) - dungeon[row][col], 1);
      }
    }

    // return answer from top left
    return dp[0][0];
  }
}
