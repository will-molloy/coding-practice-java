package com.willmolloy.adventofcode._2025

import com.willmolloy.adventofcode.common.Day
import com.willmolloy.adventofcode.common.Input
import kotlin.math.max

/** https://adventofcode.com/2025/day/5 */
object Day5 : Day(2025, 5) {

  override fun part1(input: Input): Any {
    val ranges = getMergedRanges(input)

    return input
      .readLines()
      .filterNot { it.contains('-') || it.isBlank() }
      .map { it.toLong() }
      .count { ranges.any { range -> range.contains(it) } }
  }

  override fun part2(input: Input): Any {
    return getMergedRanges(input).sumOf { it.size }
  }

  private fun getMergedRanges(input: Input): List<LongRange> {
    val ranges =
      input
        .readLines()
        .filter { it.contains('-') }
        .map { line ->
          val split = line.split('-')
          split[0].toLong()..split[1].toLong()
        }

    // merge ranges
    val sorted = ranges.sortedBy { it.start }.toMutableList()

    val merged = mutableListOf<LongRange>()

    for (range in sorted) {
      if (merged.isEmpty() || range.start > merged.last().endInclusive) {
        // non-overlapping case
        merged.add(range)
      } else {
        // overlapping case
        merged[merged.size - 1] =
          merged.last().start..max(merged.last().endInclusive, range.endInclusive)
      }
    }

    return merged
  }

  private val LongRange.size: Long
    get() = endInclusive - start + 1
}
