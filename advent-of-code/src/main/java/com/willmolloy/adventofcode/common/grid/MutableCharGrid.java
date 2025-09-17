package com.willmolloy.adventofcode.common.grid;

/**
 * Mutable {@link CharGrid}.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
public final class MutableCharGrid extends CharGrid {
  private final char[][] array;

  public MutableCharGrid(char[][] array) {
    super(array);
    this.array = array;
  }

  /** Set value at a given point. */
  public void set(Point point, char c) throws ArrayIndexOutOfBoundsException {
    array[(int) point.y()][(int) point.x()] = c;
  }
}
