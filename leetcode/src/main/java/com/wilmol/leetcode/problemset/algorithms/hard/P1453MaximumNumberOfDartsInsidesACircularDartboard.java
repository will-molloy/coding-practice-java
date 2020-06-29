package com.wilmol.leetcode.problemset.algorithms.hard;

/**
 * <a
 * href=https://leetcode.com/problems/maximum-number-of-darts-inside-of-a-circular-dartboard>https://leetcode.com/problems/maximum-number-of-darts-inside-of-a-circular-dartboard/</a>
 *
 * <p>Runtime: O(n<sup>3</sup>)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Finding circle centre.
 *
 * <p>IMO these computational geometry problems should provide formulas/apis you'll need, not
 * everyone knows the math.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1453MaximumNumberOfDartsInsidesACircularDartboard {

  // solution outlined here
  // https://stackoverflow.com/a/3229582/6122976
  // https://leetcode.com/problems/maximum-number-of-darts-inside-of-a-circular-dartboard/discuss/636345/Simple-Python-O(n3)-Solution-with-picture

  public int numPoints(int[][] points, int r) {
    int max = 1;

    for (int[] a : points) {
      for (int[] b : points) {
        int x1 = a[0];
        int x2 = b[0];
        int y1 = a[1];
        int y2 = b[1];

        // delta x and delta y between points a and b
        int dx = x2 - x1;
        int dy = y2 - y1;

        // distance between points a and b
        double q = Math.sqrt(dx * dx + dy * dy);

        if (q <= r * 2d) {
          // there are at most two circles which points a and b lie on (lie on the circles
          // perimeter, not contained within)
          // we want to use such circles as candidate circles for the problem because they try to
          // maximise the number of points contained
          // (refer to picture linked above)

          // below is more math nobody expects you to remember

          // halfway point
          double x3 = (x1 + x2) / 2d;
          double y3 = (y1 + y2) / 2d;

          // distance along the mirror line
          double d = Math.sqrt(r * r - (q / 2) * (q / 2));

          // first circle
          double c1x = x3 - d * dy / q;
          double c1y = y3 + d * dx / q;
          max = Math.max(max, countPoints(points, c1x, c1y, r));

          // second circle
          double c2x = x3 + d * dy / q;
          double c2y = y3 - d * dx / q;
          max = Math.max(max, countPoints(points, c2x, c2y, r));
        }
      }
    }
    return max;
  }

  private int countPoints(int[][] points, double xc, double yc, int r) {
    int count = 0;
    for (int[] point : points) {
      if (inCircle(point, xc, yc, r)) {
        count++;
      }
    }
    return count;
  }

  private boolean inCircle(int[] point, double xc, double yc, int r) {
    double x = Math.abs(point[0] - xc);
    double y = Math.abs(point[1] - yc);
    // need small tolerance due to floating point arithmetic use
    return x * x + y * y <= r * r + 10e-6;
  }
}
