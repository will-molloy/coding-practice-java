package com.willmolloy.adventofcode.common.datastructures

/**
 * Disjoint Set (Union Find) data structure.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class DisjointSet(private val parent: IntArray, private val size: IntArray) {

  constructor(numNodes: Int) : this(IntArray(numNodes) { it }, IntArray(numNodes) { 1 })

  fun size(node: Int) = size[find(node)]

  fun sizes() = size.clone()

  /**
   * Union the sets that [src] and [dst] belong to.
   *
   * @return `true` if the sets were combined, `false` if they were already the same set.
   */
  fun union(src: Int, dst: Int): Boolean {
    val srcSet = find(src)
    val dstSet = find(dst)

    if (srcSet == dstSet) {
      return false
    }

    parent[dstSet] = srcSet
    size[srcSet] += size[dstSet]
    size[dstSet] = 0

    return true
  }

  /**
   * Find the set that [node] belongs to.
   *
   * @return the root (representative) node of the set that [node] belongs to.
   */
  fun find(node: Int): Int {
    if (parent[node] != node) {
      // two-pass path-compression
      parent[node] = find(parent[node])
    }
    return parent[node]
  }
}
