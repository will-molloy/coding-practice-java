package com.willmolloy.adventofcode.common.extensions

import com.google.common.truth.Truth.assertThat
import com.willmolloy.adventofcode.common.grid.CharGrid
import com.willmolloy.adventofcode.common.grid.Point
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource

class DebugTest {

  @ParameterizedTest
  @MethodSource
  fun test_toPrintString(obj: Any, expected: String) {
    assertThat(obj.toPrintString()).isEqualTo(expected)
  }

  companion object {
    @JvmStatic
    fun test_toPrintString(): List<Arguments> {
      return listOf(
        // flat objects
        arguments(Point(1, 2), "Point(x=1, y=2)"),
        arguments(
          CharGrid(arrayOf(charArrayOf('a', 'b', 'c'), charArrayOf('x', 'y', 'z'))),
          "abc\nxyz",
        ),
        // 1D arrays/iterables
        arguments(intArrayOf(1, 2, 3), "1, 2, 3"),
        arguments(longArrayOf(1, 2, 3), "1, 2, 3"),
        arguments(byteArrayOf(1, 2, 3), "1, 2, 3"),
        arguments(shortArrayOf(1, 2, 3), "1, 2, 3"),
        arguments(floatArrayOf(1F, 2F, 3F), "1.0, 2.0, 3.0"),
        arguments(doubleArrayOf(1.0, 2.0, 3.0), "1.0, 2.0, 3.0"),
        arguments(booleanArrayOf(true, false), "true, false"),
        arguments(charArrayOf('a', 'b', 'c'), "abc"),
        arguments(arrayOf("Hello", "World"), "Hello, World"),
        arguments(listOf("Hello", "World"), "Hello, World"),
        // 2D arrays
        arguments(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)), "1, 2, 3\n4, 5, 6"),
        arguments(arrayOf(longArrayOf(1, 2, 3), longArrayOf(4, 5, 6)), "1, 2, 3\n4, 5, 6"),
        arguments(arrayOf(byteArrayOf(1, 2, 3), byteArrayOf(4, 5, 6)), "1, 2, 3\n4, 5, 6"),
        arguments(arrayOf(shortArrayOf(1, 2, 3), shortArrayOf(4, 5, 6)), "1, 2, 3\n4, 5, 6"),
        arguments(
          arrayOf(floatArrayOf(1F, 2F, 3F), floatArrayOf(4f, 5f, 6f)),
          "1.0, 2.0, 3.0\n4.0, 5.0, 6.0",
        ),
        arguments(
          arrayOf(doubleArrayOf(1.0, 2.0, 3.0), doubleArrayOf(4.0, 5.0, 6.0)),
          "1.0, 2.0, 3.0\n4.0, 5.0, 6.0",
        ),
        arguments(
          arrayOf(booleanArrayOf(true, false), booleanArrayOf(false, true)),
          "true, false\nfalse, true",
        ),
        arguments(arrayOf(charArrayOf('a', 'b', 'c'), charArrayOf('x', 'y', 'z')), "abc\nxyz"),
        arguments(
          arrayOf(arrayOf("Hello", "World"), arrayOf("Bye", "World")),
          "Hello, World\nBye, World",
        ),
        // 2D iterables
        arguments(
          listOf(listOf("Hello", "World"), listOf("Bye", "World")),
          "Hello, World\nBye, World",
        ),
        // TODO iterables/arrays nesting each other... unlikely to happen though
      )
    }
  }
}
