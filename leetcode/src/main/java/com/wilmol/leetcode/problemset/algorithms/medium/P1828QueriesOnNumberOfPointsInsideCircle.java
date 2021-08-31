package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle>https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/</a>
 *
 * <p>Runtime: O(p * c)
 *
 * <p>Extra memory: O(1) if not counting output
 *
 * <p>Key: Brute force. Need to know geometry: for a point to be inside a circle, the euclidean
 * distance between it and the circle's center needs to be less than or equal to the radius.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1828QueriesOnNumberOfPointsInsideCircle {

  public int[] countPoints(int[][] points, int[][] circles) {
    int n = circles.length;
    int[] result = new int[n];

    for (int i = 0; i < n; i++) {
      int cx = circles[i][0];
      int cy = circles[i][1];
      int r = circles[i][2];

      for (int[] point : points) {
        int px = point[0];
        int py = point[1];

        int dx = px - cx;
        int dy = py - cy;

        if (dx * dx + dy * dy <= r * r) {
          result[i]++;
        }
      }
    }
    return result;
  }
}
