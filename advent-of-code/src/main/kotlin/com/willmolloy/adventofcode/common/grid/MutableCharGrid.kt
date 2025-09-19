package com.willmolloy.adventofcode.common.grid

/**
 * Mutable [CharGrid].
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class MutableCharGrid(private val array: Array<CharArray>) : CharGrid(array) {

  /** Set value at a given point. */
  @Throws(ArrayIndexOutOfBoundsException::class)
  operator fun set(point: Point, c: Char) {
    array[point.y.toInt()][point.x.toInt()] = c
  }
}
