package com.willmolloy.adventofcode.common.grid

/**
 * 2D char grid.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
open class CharGrid(private val array: Array<CharArray>) : Grid<Char, CharGrid, MutableCharGrid> {

  override fun height(): Int = array.size

  override fun width(): Int = array[0].size

  override fun size(): Int = height() * width()

  override fun points(): Sequence<Point> = sequence {
    for (y in 0 until height()) {
      for (x in 0 until width()) {
        yield(Point(x, y))
      }
    }
  }

  // check height before width, potential IOOB
  override fun inbounds(point: Point): Boolean =
    point.y in 0 until height() && point.x in 0 until width()

  override fun toMutable(): MutableCharGrid {
    val clone = array.map { it.clone() }.toTypedArray()
    return MutableCharGrid(clone)
  }

  /** Get value at a given point. */
  @Throws(ArrayIndexOutOfBoundsException::class)
  operator fun get(point: Point): Char = array[point.y.toInt()][point.x.toInt()]

  @Throws(ArrayIndexOutOfBoundsException::class)
  operator fun get(row: Int, col: Int): Char = array[row][col]

  override fun toString(): String = array.joinToString("\n") { String(it) }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as CharGrid

    return array.contentDeepEquals(other.array)
  }

  override fun hashCode(): Int {
    return array.contentDeepHashCode()
  }
}
