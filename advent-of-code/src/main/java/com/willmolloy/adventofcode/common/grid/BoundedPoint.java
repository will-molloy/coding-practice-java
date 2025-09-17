package com.willmolloy.adventofcode.common.grid;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * {@link Point} which will wrap around when moved out of bounds.
 *
 * @param x x position (column)
 * @param y y position (row)
 * @param xBound x bound
 * @param yBound y bound
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
public record BoundedPoint(long x, long y, long xBound, long yBound) {
  public BoundedPoint {
    checkArgument(x >= 0 && x < xBound);
    checkArgument(y >= 0 && y < yBound);
  }

  public BoundedPoint withBound(long xBound, long yBound) {
    return new BoundedPoint(x, y, xBound, yBound);
  }

  public BoundedPoint move(long dx, long dy) {
    return new BoundedPoint(wrap(x + dx, xBound), wrap(y + dy, yBound), xBound, yBound);
  }

  private static long wrap(long value, long mod) {
    return (mod == Long.MAX_VALUE) ? value : ((value % mod) + mod) % mod;
  }

  public static BoundedPoint unknownBound(long x, long y) {
    return new BoundedPoint(x, y, Long.MAX_VALUE, Long.MAX_VALUE);
  }
}
