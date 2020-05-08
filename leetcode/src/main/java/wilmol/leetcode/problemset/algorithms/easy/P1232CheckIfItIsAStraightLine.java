package wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by wilmol on 2020-05-08.
 *
 * <p><a
 * href=https://leetcode.com/problems/check-if-it-is-a-straight-line>https://leetcode.com/problems/check-if-it-is-a-straight-line/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Declare variables as {@code double} before division to avoid divide by zero errors.
 * ({@code double} returns infinity, while {@code int} throws an {@link ArithmeticException}.)
 */
class P1232CheckIfItIsAStraightLine {

  public boolean checkStraightLine(int[][] coordinates) {
    int n = coordinates.length;

    if (n <= 2) {
      return true;
    }

    int[] first = coordinates[0];
    int[] second = coordinates[1];

    double gradient = gradient(first, second);

    for (int i = 1; i < n - 1; i++) {
      if (Double.compare(gradient(coordinates[i], coordinates[i + 1]), gradient) != 0) {
        return false;
      }
    }
    return true;
  }

  private double gradient(int[] first, int[] second) {
    double dy = second[1] - first[1];
    double dx = second[0] - first[0];
    return dy / dx;
  }
}
