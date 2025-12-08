package com.willmolloy.adventofcode.common.grid

/**
 * 2D point.
 *
 * @param x x position (column)
 * @param y y position (row)
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
@JvmRecord
data class Point(val x: Long, val y: Long) {

  constructor(x: Int, y: Int) : this(x.toLong(), y.toLong())

  constructor(x: String, y: String) : this(x.toLong(), y.toLong())

  /** Compute the [distance](https://en.wikipedia.org/wiki/Euclidean_distance) to another point. */
  fun dist(q: Point): Long {
    val dx = (x - q.x)
    val dy = (y - q.y)
    // Excluding sqrt to avoid double conversion
    return dx * dx + dy * dy
  }

  /**
   * Move the point.
   *
   * @param dx x distance to move
   * @param dy y distance to move
   */
  fun move(dx: Long, dy: Long): Point = Point(x + dx, y + dy)

  /**
   * Move the point.
   *
   * @param direction direction to move
   * @param d distance to move
   */
  @JvmOverloads
  fun move(direction: Direction, d: Long = 1): Point =
    when (direction) {
      Direction.UP -> move(0, -d)
      Direction.DOWN -> move(0, d)
      Direction.LEFT -> move(-d, 0)
      Direction.RIGHT -> move(d, 0)
      Direction.LEFT_UP -> move(-d, -d)
      Direction.RIGHT_UP -> move(d, -d)
      Direction.LEFT_DOWN -> move(-d, d)
      Direction.RIGHT_DOWN -> move(d, d)
    }
}
