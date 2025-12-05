package com.willmolloy.adventofcode.common

import kotlin.math.max
import kotlin.math.min

val IntRange.size: Int
  get() = endInclusive - start + 1

val LongRange.size: Long
  get() = endInclusive - start + 1

fun IntRange.span(other: IntRange) = min(start, other.start)..max(endInclusive, other.endInclusive)

fun LongRange.span(other: LongRange) =
  min(start, other.start)..max(endInclusive, other.endInclusive)
