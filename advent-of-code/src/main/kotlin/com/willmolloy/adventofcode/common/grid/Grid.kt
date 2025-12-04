package com.willmolloy.adventofcode.common.grid

/**
 * 2D grid abstraction.
 *
 * @param T type of element stored in the grid
 * @param GridT grid type
 * @param MutableGridT mutable grid type
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface Grid<T, GridT : Grid<T, GridT, MutableGridT>, MutableGridT : GridT> : Iterable<Point> {

  fun height(): Int

  fun width(): Int

  fun size(): Int

  /** Get all points on the grid. */
  fun points(): Sequence<Point>

  /** Check point is in bounds on the grid. */
  fun inbounds(point: Point): Boolean

  /**
   * Convert to mutable grid.
   *
   * `this` grid will remain immutable.
   */
  fun toMutable(): MutableGridT

  override fun iterator(): Iterator<Point> = points().iterator()
}
