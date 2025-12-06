package com.willmolloy.adventofcode.common

import kotlin.math.max
import kotlin.math.min

fun <T> T.debug(): T {
  println(this)
  println()
  return this
}

fun <T> List<List<T>>.transpose(): List<List<T>> {
  val rows = size
  val cols = if (isEmpty()) 0 else first().size

  val transpose = MutableList(cols) { MutableList<T?>(rows) { null } }

  for (row in 0 until rows) {
    for (col in 0 until cols) {
      transpose[col][row] = this[row][col]
    }
  }

  return transpose.map { it.requireNoNulls() }
}

val IntRange.size: Int
  get() = endInclusive - start + 1

val LongRange.size: Long
  get() = endInclusive - start + 1

fun IntRange.span(other: IntRange) = min(start, other.start)..max(endInclusive, other.endInclusive)

fun LongRange.span(other: LongRange) =
  min(start, other.start)..max(endInclusive, other.endInclusive)
