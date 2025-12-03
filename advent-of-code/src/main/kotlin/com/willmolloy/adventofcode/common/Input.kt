package com.willmolloy.adventofcode.common

import com.willmolloy.adventofcode.common.grid.CharGrid

/**
 * Helps read the various advent-of-code inputs.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface Input {

  /** Reads the input as a single string. */
  fun readString(): String

  /** Reads the input as a list of lines. */
  fun readLines(): List<String>

  /** Reads the input as space-separated numbers. */
  fun readNums(): LongArray

  /** Reads the input as lines of space-separated numbers. */
  fun readLinesOfNums(): List<LongArray>

  /** Reads the input as lines of digits. */
  fun readLinesOfDigits(): List<IntArray>

  /** Reads the input as a 2D character grid. */
  fun readCharGrid(): CharGrid
}
