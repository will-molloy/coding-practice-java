package com.willmolloy.adventofcode.common.extensions

fun <T> List<List<T>>.transpose(): List<List<T>> {
  val rows = size
  val cols = if (isEmpty()) 0 else first().size

  val transposed = MutableList(cols) { MutableList<T?>(rows) { null } }

  for (row in 0 until rows) {
    for (col in 0 until cols) {
      transposed[col][row] = this[row][col]
    }
  }

  @Suppress("UNCHECKED_CAST")
  return transposed as List<List<T>>
}

fun <T> Iterable<T>.pairs(): List<Pair<T, T>> {
  val list = this.toList()
  return buildList {
    for (i in 0 until list.size) {
      for (j in i + 1 until list.size) {
        add(list[i] to list[j])
      }
    }
  }
}

fun Iterable<Int>.product() = reduce { a, b -> a * b }

fun Iterable<Long>.product() = reduce { a, b -> a * b }
