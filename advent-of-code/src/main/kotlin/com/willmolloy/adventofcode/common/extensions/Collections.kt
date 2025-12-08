package com.willmolloy.adventofcode.common.extensions

fun <T> List<List<T>>.transpose(): List<List<T>> {
  val rows = size
  val cols = if (isEmpty()) 0 else first().size

  val transpose = MutableList(cols) { MutableList<T?>(rows) { null } }

  for (row in 0 until rows) {
    for (col in 0 until cols) {
      transpose[col][row] = this[row][col]
    }
  }

  @Suppress("UNCHECKED_CAST")
  return transpose as List<List<T>>
}
