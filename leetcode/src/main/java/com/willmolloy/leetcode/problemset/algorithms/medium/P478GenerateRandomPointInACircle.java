package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.concurrent.ThreadLocalRandom;

/**
 * <a
 * href=https://leetcode.com/problems/generate-random-point-in-a-circle>https://leetcode.com/problems/generate-random-point-in-a-circle/</a>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
abstract class P478GenerateRandomPointInACircle {

  protected final ThreadLocalRandom rng = ThreadLocalRandom.current();

  protected final double radius;
  protected final double xCentre;
  protected final double yCentre;

  P478GenerateRandomPointInACircle(double radius, double xCentre, double yCentre) {
    this.radius = radius;
    this.xCentre = xCentre;
    this.yCentre = yCentre;
  }

  public abstract double[] randPoint();

  /**
   * Solution which picks a random point in the square around the circle until that point is in the
   * circle.
   *
   * <p>Runtime: all operations are O(1)
   *
   * <p>Extra memory: O(1)
   *
   * <p>Key: Use Pythagorean theorem to determine if the point is in the circle (i.e. less than or
   * equal to hypotenuse, where hypotenuse is the circles radius).
   */
  static class RejectionSamplingFromSquare extends P478GenerateRandomPointInACircle {

    RejectionSamplingFromSquare(double radius, double xCentre, double yCentre) {
      super(radius, xCentre, yCentre);
    }

    @Override
    public double[] randPoint() {
      while (true) {
        double x = 2 * radius * rng.nextDouble() - radius;
        double y = 2 * radius * rng.nextDouble() - radius;
        if (x * x + y * y <= radius * radius) {
          return new double[] {xCentre + x, yCentre + y};
        }
      }
    }
  }

  /**
   * Solution which uses polar coordinates/notation.
   *
   * <p>Runtime: all operations are O(1)
   *
   * <p>Extra memory: O(1)
   *
   * <p>Point {@code (x, y)} in polar notation is defined as {@code (x = r * cos(theta), y = r *
   * sin(theta))}.
   *
   * <p>So need uniformly random radius and theta.
   *
   * <p>Theta is picked uniformly from [0, 2 * PI). Radius is picked uniformly from circles area, so
   * need square root.
   */
  static class PolarCoordinates extends P478GenerateRandomPointInACircle {

    PolarCoordinates(double radius, double xCentre, double yCentre) {
      super(radius, xCentre, yCentre);
    }

    @Override
    public double[] randPoint() {
      double theta = rng.nextDouble(2 * Math.PI);
      double radius = this.radius * Math.sqrt(rng.nextDouble(1));
      return new double[] {xCentre + radius * Math.cos(theta), yCentre + radius * Math.sin(theta)};
    }
  }
}
