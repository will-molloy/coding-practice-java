package com.willmolloy.adventofcode.common.grid

/**
 * [Point] which will wrap around when moved out of bounds.
 *
 * @param x x position (column)
 * @param y y position (row)
 * @param xBound x bound
 * @param yBound y bound
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
data class BoundedPoint(val x: Long, val y: Long, val xBound: Long, val yBound: Long) {

  constructor(x: Long, y: Long) : this(x, y, Long.MAX_VALUE, Long.MAX_VALUE)

  init {
    require(x in 0 until xBound) { "x must be in bounds [0, $xBound)" }
    require(y in 0 until yBound) { "y must be in bounds [0, $yBound)" }
  }

  fun withBound(xBound: Long, yBound: Long): BoundedPoint = BoundedPoint(x, y, xBound, yBound)

  fun move(dx: Long, dy: Long): BoundedPoint =
    BoundedPoint(wrap(x + dx, xBound), wrap(y + dy, yBound), xBound, yBound)

  private fun wrap(value: Long, mod: Long): Long =
    if (mod == Long.MAX_VALUE) value else ((value % mod) + mod) % mod
}
