package com.willmolloy.adventofcode.common.grid;

/**
 * 2D point.
 *
 * @param x x position (column)
 * @param y y position (row)
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
public record Point(long x, long y) {

  /**
   * Move the point.
   *
   * @param dx x distance to move
   * @param dy y distance to move
   */
  public Point move(long dx, long dy) {
    return new Point(x + dx, y + dy);
  }

  /**
   * Move the point (1 distance).
   *
   * @param direction direction to move
   */
  public Point move(Direction direction) {
    return move(direction, 1);
  }

  /**
   * Move the point.
   *
   * @param direction direction to move
   * @param d distance to move
   */
  public Point move(Direction direction, long d) {
    return switch (direction) {
      case UP -> move(0, -d);
      case DOWN -> move(0, d);
      case LEFT -> move(-d, 0);
      case RIGHT -> move(d, 0);
      case LEFT_UP -> move(-d, -d);
      case RIGHT_UP -> move(d, -d);
      case LEFT_DOWN -> move(-d, d);
      case RIGHT_DOWN -> move(d, d);
    };
  }
}
