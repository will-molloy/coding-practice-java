package wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by wilmol on 2020-05-11.
 *
 * <p><a href=https://leetcode.com/problems/flood-fill>https://leetcode.com/problems/flood-fill/</a>
 *
 * <p>Runtime: O(rows * cols)
 *
 * <p>Extra space: O(rows * cols)
 *
 * <p>Key: Need to check {@code image[row][col] == replaceColor} so only replace pixels of the same
 * color. Also need to check {@code replaceColor != newColor} otherwise won't halt cause its
 * 'pinging' between adjacent pixels.
 *
 * @see wilmol.leetcode.problemset.algorithms.medium.P200NumberOfIslands
 * @see wilmol.leetcode.problemset.algorithms.medium.P130SurroundedRegions
 * @see wilmol.leetcode.problemset.algorithms.medium.P695MaxAreaOfIsland
 */
class P733FloodFill {

  public int[][] floodFill(int[][] image, int startRow, int startCol, int newColor) {
    // dfs
    int replaceColor = image[startRow][startCol];
    dfs(image, startRow, startCol, replaceColor, newColor);
    return image;
  }

  private void dfs(int[][] image, int row, int col, int replaceColor, int newColor) {
    if ((row >= 0 && row < image.length)
        && (col >= 0 && col < image[row].length)
        && image[row][col] == replaceColor
        && replaceColor != newColor) {
      image[row][col] = newColor;
      dfs(image, row + 1, col, replaceColor, newColor);
      dfs(image, row - 1, col, replaceColor, newColor);
      dfs(image, row, col + 1, replaceColor, newColor);
      dfs(image, row, col - 1, replaceColor, newColor);
    }
  }
}
