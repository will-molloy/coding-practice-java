package com.willmolloy.adventofcode.common.extensions

import com.willmolloy.adventofcode.common.grid.CharGrid
import kotlin.collections.joinToString

fun <T> T.debug(): T {
  val printString = toPrintString()
  println(printString)
  println()
  return this
}

internal fun <T> T.toPrintString(): String =
  when (this) {
    is CharGrid -> toString()
    is IntArray -> joinToString(prefix = "[", postfix = "]")
    is LongArray -> joinToString(prefix = "[", postfix = "]")
    is ByteArray -> joinToString(prefix = "[", postfix = "]")
    is ShortArray -> joinToString(prefix = "[", postfix = "]")
    is DoubleArray -> joinToString(prefix = "[", postfix = "]")
    is FloatArray -> joinToString(prefix = "[", postfix = "]")
    is BooleanArray -> joinToString(prefix = "[", postfix = "]")
    is CharArray -> String(this)
    is Array<*> ->
      if (isArrayOrIterable(firstOrNull())) {
        joinToString("\n") { it.toPrintString() }
      } else {
        joinToString(prefix = "[", postfix = "]") { it.toPrintString() }
      }
    is Iterable<*> ->
      if (isArrayOrIterable(firstOrNull())) {
        joinToString("\n") { it.toPrintString() }
      } else {
        joinToString(prefix = "[", postfix = "]") { it.toPrintString() }
      }
    else -> toString()
  }

private fun isArrayOrIterable(obj: Any?): Boolean =
  when (obj) {
    is IntArray,
    is LongArray,
    is ByteArray,
    is ShortArray,
    is DoubleArray,
    is FloatArray,
    is BooleanArray,
    is CharArray,
    is Array<*>,
    is Iterable<*> -> true
    else -> false
  }
