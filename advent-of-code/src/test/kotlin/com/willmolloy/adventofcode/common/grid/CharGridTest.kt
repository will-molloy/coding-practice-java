package com.willmolloy.adventofcode.common.grid

import com.google.common.truth.Truth.assertThat
import java.util.stream.Stream
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

/**
 * Unit tests for [CharGrid].
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
internal class CharGridTest {
  private val grid =
    CharGrid(arrayOf(charArrayOf('a', 'x'), charArrayOf('b', 'y'), charArrayOf('c', 'z')))

  @Test
  fun testHeight() {
    assertThat(grid.height()).isEqualTo(3)
  }

  @Test
  fun testWidth() {
    assertThat(grid.width()).isEqualTo(2)
  }

  @Test
  fun testSize() {
    assertThat(grid.size()).isEqualTo(6)
  }

  @Test
  fun testPoints() {
    assertThat(grid.points().toList())
      .containsExactly(Point(0, 0), Point(1, 0), Point(0, 1), Point(1, 1), Point(0, 2), Point(1, 2))
      .inOrder()
  }

  @Test
  fun testIterator() {
    assertThat(grid).containsExactlyElementsIn(grid.points().toList())
  }

  @ParameterizedTest
  @MethodSource
  fun testInbounds(point: Point, expected: Boolean) {
    assertThat(grid.inbounds(point)).isEqualTo(expected)
  }

  @Test
  fun testInbounds_emptyGrid() {
    val grid = CharGrid(emptyArray())
    assertThat(grid.inbounds(Point(0, 0))).isFalse()
  }

  @Test
  fun testToMutable_doesNotMutateOriginalGrid() {
    val mutableGrid = grid.toMutable()
    val point = Point(1, 2)

    mutableGrid[point] = '.'

    assertThat(grid[point]).isEqualTo('z')
    assertThat(mutableGrid[point]).isEqualTo('.')
  }

  @ParameterizedTest
  @MethodSource
  fun testGet(point: Point, expected: Char) {
    assertThat(grid[point]).isEqualTo(expected)
  }

  @Test
  fun testToString() {
    assertThat(grid.toString()).isEqualTo("ax\nby\ncz")
  }

  companion object {
    @JvmStatic
    fun testInbounds(): Stream<Arguments> {
      return Stream.of(
        Arguments.of(Point(0, 0), true),
        Arguments.of(Point(1, 0), true),
        Arguments.of(Point(0, 1), true),
        Arguments.of(Point(1, 1), true),
        Arguments.of(Point(0, 2), true),
        Arguments.of(Point(1, 2), true),
        // OOB
        Arguments.of(Point(-1, 0), false),
        Arguments.of(Point(0, -1), false),
        Arguments.of(Point(2, 0), false),
        Arguments.of(Point(0, 3), false),
      )
    }

    @JvmStatic
    fun testGet(): Stream<Arguments> {
      return Stream.of(
        Arguments.of(Point(0, 0), 'a'),
        Arguments.of(Point(0, 1), 'b'),
        Arguments.of(Point(0, 2), 'c'),
        Arguments.of(Point(1, 0), 'x'),
        Arguments.of(Point(1, 1), 'y'),
        Arguments.of(Point(1, 2), 'z'),
      )
    }
  }
}
