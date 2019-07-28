package wilmol.hackerrank.interviewpreparationkit.graphs.hard;

/**
 * Created by Will on 2019-03-30 at 21:52
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=graphs>https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=graphs</a>
 *
 * <p>Runtime: O(n) ... see each element once ... ????
 */
final class DfsConnectedCellInAGrid {

  private DfsConnectedCellInAGrid() {}

  static int maxRegion(int[][] grid) {
    int largestRegion = Integer.MIN_VALUE;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          int regionSize = dfs(grid, i, j);
          largestRegion = Math.max(largestRegion, regionSize);
        }
      }
    }
    return largestRegion;
  }

  // dfs -> use stack e.g. recursion
  private static int dfs(int[][] grid, int row, int col) {
    if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length) {
      // out of bounds
      return 0;
    }
    if (grid[row][col] == 0) {
      // already seen or never part of a region
      return 0;
    }
    // mark as seen
    grid[row][col] = 0;
    // search all 8 directions recursively
    int size = 1;
    for (int i = row - 1; i <= row + 1; i++) {
      for (int j = col - 1; j <= col + 1; j++) {
        if (i == row && j == col) {
          // this node, already marked as seen, but saves the large out of bounds check
          continue;
        }
        size += dfs(grid, i, j);
      }
    }
    return size;
  }
}
