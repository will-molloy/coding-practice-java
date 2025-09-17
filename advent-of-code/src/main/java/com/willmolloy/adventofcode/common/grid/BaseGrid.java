package com.willmolloy.adventofcode.common.grid;

import java.util.Iterator;
import java.util.stream.Stream;

/**
 * 2D grid abstraction.
 *
 * @param <T> type of element stored in the grid
 * @param <GridT> grid type
 * @param <MutableGridT> mutable grid type
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface BaseGrid<T, GridT extends BaseGrid<T, GridT, MutableGridT>, MutableGridT extends GridT>
    extends Iterable<Point> {

  int height();

  int width();

  int size();

  /** Get all points on the grid. */
  Stream<Point> points();

  /** Check point is in bounds on the grid. */
  boolean inbounds(Point point);

  /**
   * Convert to mutable grid.
   *
   * @implSpec {@code this} grid must remain immutable.
   */
  MutableGridT toMutable();

  @Override
  default Iterator<Point> iterator() {
    return points().iterator();
  }
}
