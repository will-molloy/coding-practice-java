package com.willmolloy.adventofcode.common

import kotlin.math.max
import kotlin.math.min

val IntRange.size: Int
  get() = endInclusive - start + 1

val LongRange.size: Long
  get() = endInclusive - start + 1

/** Assumes overlapping. */
fun IntRange.merge(other: IntRange) = min(start, other.start)..max(endInclusive, other.endInclusive)

/** Assumes overlapping. */
fun LongRange.merge(other: LongRange) =
  min(start, other.start)..max(endInclusive, other.endInclusive)
