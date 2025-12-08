package com.willmolloy.adventofcode.common.extensions

import kotlin.math.max
import kotlin.math.min

val IntRange.size: Int
  get() = endInclusive - start + 1

val LongRange.size: Long
  get() = endInclusive - start + 1

fun IntRange.span(other: IntRange): IntRange =
  min(start, other.start)..max(endInclusive, other.endInclusive)

fun LongRange.span(other: LongRange): LongRange =
  min(start, other.start)..max(endInclusive, other.endInclusive)
