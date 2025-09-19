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
        yield(Point(x.toLong(), y.toLong()))
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

  override fun toString(): String = array.joinToString("\n") { String(it) }
}
