package com.willmolloy.adventofcode._2025

import com.willmolloy.adventofcode.common.Day
import com.willmolloy.adventofcode.common.Input
import com.willmolloy.adventofcode.common.extensions.debug
import com.willmolloy.adventofcode.common.grid.CharGrid
import com.willmolloy.adventofcode.common.grid.MutableCharGrid
import com.willmolloy.adventofcode.common.grid.Point
import java.util.concurrent.atomic.AtomicInteger

/** https://adventofcode.com/2025/day/12 */
object Day12 : Day(2025, 12) {

  private data class Present(val grid: CharGrid, val combinations: List<CharGrid>, val index: Int)

  private data class Tree(val width: Int, val length: Int, val presentCounts: List<Int>)

  private fun parsePresents(input: Input): List<Present> {
    var presentIndex = 0
    return input
      .readLines()
      .filter { it.contains('#') || it.contains('.') }
      .filter { it.isNotEmpty() }
      // they're all 3x3
      .chunked(3)
      .map {
        val grid = it.map { it.toCharArray() }.toTypedArray().let { CharGrid(it) }
        Present(grid, grid.combinations(), presentIndex++)
      }
  }

  private fun parseTrees(input: Input): List<Tree> {
    return input
      .readLines()
      .filter { it.contains('x') }
      .map { line ->
        val match = Regex("(\\d+)x(\\d+): (.*)").matchEntire(line)!!
        val (width, length, counts) = match.destructured

        val presentCounts = counts.split(" ").map { it.toInt() }
        Tree(width.toInt(), length.toInt(), presentCounts)
      }
  }

  override fun part1(input: Input): Any {
    val presents = parsePresents(input)
    val trees = parseTrees(input)

    val solveCounter = AtomicInteger()

    fun solve(tree: Tree): Boolean {
      "Solving ${solveCounter.incrementAndGet()}/${trees.size}: $tree".debug()

      // first ensure the grid has enough spaces
      val treeSpaces = tree.length * tree.width
      val totalPresentSpaces =
        presents.sumOf { present ->
          val presentSpaces = present.grid.count { present.grid[it] == '#' }
          presentSpaces * tree.presentCounts[present.index]
        }
      if (totalPresentSpaces > treeSpaces) {
        return false
      }

      val treeGrid = CharGrid(Array(tree.length) { CharArray(tree.width) { '.' } }).toMutable()
      var presentId = 'A' // debugging

      // attempt to place the presents - recursively - it's like the sudoku solver problem
      fun dfs(presentCounts: MutableList<Int>): Boolean {
        //        treeGrid.debug()
        //        presentCounts.debug()

        for (present in presents) {
          if (presentCounts[present.index] == 0) {
            continue
          }

          for (presentGrid in present.combinations) {

            for (x in 0..tree.width - presentGrid.width()) {
              for (y in 0..tree.length - presentGrid.height()) {
                val offset = Point(x, y)

                if (tryPlacePresent(treeGrid, presentGrid, offset, presentId)) {
                  //                  "Placed: ${present.id} as $presentId".debug()
                  presentCounts[present.index]--
                  presentId++
                  if (dfs(presentCounts)) {
                    return true
                  } else {
                    // back track
                    removePresent(treeGrid, presentGrid, offset)
                    presentCounts[present.index]++
                    presentId--
                  }
                }
              }
            }
          }
        }

        return presentCounts.all { it == 0 }
      }

      return dfs(tree.presentCounts.toMutableList())
    }

    return trees.parallelStream().filter { solve(it) }.count()
  }

  private fun tryPlacePresent(
    treeGrid: MutableCharGrid,
    presentGrid: CharGrid,
    offset: Point,
    presentId: Char,
  ): Boolean {
    val placed = mutableListOf<Point>()

    for (presentLoc in presentGrid) {
      // TODO precompute this? i.e. really just need the List<Point> which contain '#'
      if (presentGrid[presentLoc] != '#') {
        continue
      }

      val treeLoc = presentLoc.move(offset)
      if (treeGrid[treeLoc] == '.') {
        treeGrid[treeLoc] = presentId
        placed.add(treeLoc)
      } else {
        // need to clear any partially placed present
        placed.forEach { treeGrid[it] = '.' }
        return false
      }
    }

    return true
  }

  private fun removePresent(treeGrid: MutableCharGrid, presentGrid: CharGrid, offset: Point) {
    for (presentLoc in presentGrid) {
      if (presentGrid[presentLoc] != '#') {
        continue
      }

      val treeLoc = presentLoc.move(offset)
      if (treeGrid[treeLoc] != '.') {
        treeGrid[treeLoc] = '.'
      }
    }
  }

  // TODO move these into Grid class?
  private fun CharGrid.combinations(): List<CharGrid> {
    val rotate90 = this.rotate90()
    val rotate180 = rotate90.rotate90()
    val rotate270 = rotate180.rotate90()
    val rotations = listOf(this, rotate90, rotate180, rotate270)
    return rotations.flatMap { listOf(it, it.flip()) }.distinct()
  }

  private fun CharGrid.rotate90(): CharGrid {
    val rotated = Array(width()) { CharArray(height()) }

    // transpose
    for (row in 0 until height()) {
      for (col in 0 until width()) {
        rotated[col][row] = this[row, col]
      }
    }

    // reverse each row
    for (chars in rotated) {
      chars.reverse()
    }

    return CharGrid(rotated)
  }

  private fun CharGrid.flip(): CharGrid {
    val flipped = Array(height()) { CharArray(width()) }

    // copy
    for (row in 0 until height()) {
      for (col in 0 until width()) {
        flipped[row][col] = this[row, col]
      }
    }

    // reverse each row
    for (chars in flipped) {
      chars.reverse()
    }

    return CharGrid(flipped)
  }

  override fun part2(input: Input): Any {
    return 2222222222222222
  }
}
