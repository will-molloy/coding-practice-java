package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/largest-triangle-area>https://leetcode.com/problems/largest-triangle-area</a>
 *
 * <p>Runtime: O(n<sup>3</sup>)
 *
 * <p>Space: O(1)
 *
 * <p>Key idea: <a href=https://en.wikipedia.org/wiki/Shoelace_formula>Formula to compute polygon
 * area given cartesian coordinates.</a>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P812LargestTriangleArea {

  public double largestTriangleArea(int[][] points) {
    double max = 0;
    for (int[] x : points) {
      for (int[] y : points) {
        for (int[] z : points) {
          double area = area(x, y, z);
          max = Math.max(max, area);
        }
      }
    }
    return max;
  }

  private double area(int[] x, int[] y, int[] z) {
    // need this formula https://en.wikipedia.org/wiki/Shoelace_formula
    // cause the triangle may not form a base/height along the x/y axis
    return Math.abs(
            x[0] * y[1] + y[0] * z[1] + z[0] * x[1] - x[1] * y[0] - y[1] * z[0] - z[1] * x[0])
        / 2d;
  }
}
