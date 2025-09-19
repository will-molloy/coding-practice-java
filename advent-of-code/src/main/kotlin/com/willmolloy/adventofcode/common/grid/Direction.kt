package com.willmolloy.adventofcode.common.grid

/**
 * 2D direction.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
enum class Direction {
  UP,
  DOWN,
  LEFT,
  RIGHT,
  LEFT_UP,
  RIGHT_UP,
  LEFT_DOWN,
  RIGHT_DOWN;

  companion object {
    @JvmStatic fun straight(): List<Direction> = listOf(UP, DOWN, LEFT, RIGHT)

    @JvmStatic fun straightAndDiagonal(): List<Direction> = entries
  }
}
