package com.willmolloy.adventofcode.common.grid

/**
 * 3D point.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
@JvmRecord
data class Point3(val x: Long, val y: Long, val z: Long) {

  constructor(x: Int, y: Int, z: Int) : this(x.toLong(), y.toLong(), z.toLong())

  constructor(x: String, y: String, z: String) : this(x.toLong(), y.toLong(), z.toLong())

  /** Compute the [distance](https://en.wikipedia.org/wiki/Euclidean_distance) to another point. */
  fun dist(q: Point3): Long {
    val dx = (x - q.x)
    val dy = (y - q.y)
    val dz = (z - q.z)
    // Excluding sqrt to avoid double conversion
    return dx * dx + dy * dy + dz * dz
  }
}
