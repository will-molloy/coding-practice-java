package com.willmolloy.adventofcode.common.extensions

import com.willmolloy.adventofcode.common.grid.Grid

fun <T> T.debug(): T {
  val printString = toPrintString()
  println(printString)
  println()
  return this
}

internal fun <T> T.toPrintString(): String =
  when (this) {
    is Grid<*, *, *> -> toString()
    is IntArray -> joinToString()
    is LongArray -> joinToString()
    is ByteArray -> joinToString()
    is ShortArray -> joinToString()
    is DoubleArray -> joinToString()
    is FloatArray -> joinToString()
    is BooleanArray -> joinToString()
    is CharArray -> joinToString("")
    is Array<*> ->
      when (firstOrNull()) {
        is IntArray,
        is LongArray,
        is ByteArray,
        is ShortArray,
        is DoubleArray,
        is FloatArray,
        is BooleanArray,
        is CharArray,
        is Array<*> -> joinToString("\n") { it.toPrintString() }
        else -> joinToString { it.toPrintString() }
      }
    is Iterable<*> ->
      when (firstOrNull()) {
        is Iterable<*> -> joinToString("\n") { it.toPrintString() }
        else -> joinToString { it.toPrintString() }
      }
    else -> toString()
  }
