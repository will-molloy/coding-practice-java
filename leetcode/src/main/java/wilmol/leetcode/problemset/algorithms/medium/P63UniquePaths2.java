package wilmol.leetcode.problemset.algorithms.medium;

/**
 * Created by wilmol on 2019-12-12.
 *
 * <p><a
 * href=https://leetcode.com/problems/unique-paths-ii>https://leetcode.com/problems/unique-paths-ii</a>
 *
 * <p>Runtime: O(numRows * numCols), Space: O(numRows * numCols)
 *
 * <p>Key: filling in base case in reverse order to account for obstacles. I.e. the base case wasn't
 * as trivial compared to first iteration of the problem.
 *
 * @see P62UniquePaths
 */
class P63UniquePaths2 {

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int numRows = obstacleGrid.length;
    int numCols = obstacleGrid[0].length;

    if (obstacleGrid[0][0] == 1) {
      return 0;
    }

    // dp[row][col] = num paths to finish from that position
    int[][] dp = new int[numRows][numCols];

    // base cases, iterate in reverse to account for obstacles
    // bottom border
    for (int col = numCols - 1; col >= 0; col--) {
      if (obstacleGrid[numRows - 1][col] == 1) {
        // obstacle in the way, cannot move right beyond this point
        break;
      }
      dp[numRows - 1][col] = 1;
    }
    // right border
    for (int row = numRows - 1; row >= 0; row--) {
      if (obstacleGrid[row][numCols - 1] == 1) {
        // obstacle in the way, cannot move down beyond this point
        break;
      }
      dp[row][numCols - 1] = 1;
    }

    // bottom up, from bottom right (finish) to top left (start) position
    for (int row = numRows - 2; row >= 0; row--) {
      for (int col = numCols - 2; col >= 0; col--) {
        // if an obstacle then cannot go that direction, so 0 paths in that direction
        int right = obstacleGrid[row][col + 1] == 0 ? dp[row][col + 1] : 0;
        int down = obstacleGrid[row + 1][col] == 0 ? dp[row + 1][col] : 0;
        dp[row][col] = right + down;
      }
    }

    // return num paths from start position
    return dp[0][0];
  }
}
