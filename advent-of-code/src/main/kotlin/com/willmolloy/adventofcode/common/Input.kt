package com.willmolloy.adventofcode.common

import com.willmolloy.adventofcode.common.grid.CharGrid

/**
 * Helper for reading the various inputs.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface Input {

  /** Read input lines. */
  fun lines(): List<String>

  /** Read input num lines. */
  fun numLines(): List<LongArray>

  /** Read input string. */
  fun string(): String

  /** Read input nums. */
  fun nums(): LongArray

  /** Read input [CharGrid]. */
  fun charGrid(): CharGrid
}
