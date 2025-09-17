package com.willmolloy.adventofcode._2024

import com.willmolloy.adventofcode.common.Day
import com.willmolloy.adventofcode.common.Input
import com.willmolloy.adventofcode.common.grid.Point
import kotlin.math.min

/** https://adventofcode.com/2024/day/13 */
object Day13 : Day(2024, 13) {

  private data class Game(val a: Point, val b: Point, val p: Point)

  private fun parseInput(input: Input): List<Game> {
    val lines = input.lines()
    return lines.indices.step(4).map { i ->
      // TODO lib for parsing into data class
      val (ax, ay) = Regex("Button A: X[+](\\d+), Y[+](\\d+)").matchEntire(lines[i])!!.destructured
      val a = Point(ax.toLong(), ay.toLong())
      val (bx, by) =
        Regex("Button B: X[+](\\d+), Y[+](\\d+)").matchEntire(lines[i + 1])!!.destructured
      val b = Point(bx.toLong(), by.toLong())
      val (px, py) = Regex("Prize: X=(\\d+), Y=(\\d+)").matchEntire(lines[i + 2])!!.destructured
      val p = Point(px.toLong(), py.toLong())
      Game(a, b, p)
    }
  }

  override fun part1(input: Input): Any {
    val games = parseInput(input)
    return games.sumOf { solveDfsDp(it) }
  }

  private fun solveDfsDp(game: Game): Int {
    // draw out the tree, starting with (a=0, b=0) and you'll see overlapping nodes
    // not that intuitive because dp usually works in the other direction!
    val dp = mutableMapOf<Pair<Int, Int>, Int>()

    fun dfs(a: Int, b: Int): Int {
      return dp.getOrPut(Pair(a, b)) {
        if (a > 100 || b > 100) {
          // max moves reached
          Int.MAX_VALUE
        } else {
          val x = game.a.x * a + game.b.x * b
          val y = game.a.y * a + game.b.y * b
          val tokens = a * 3 + b
          if (x == game.p.x && y == game.p.y) {
            // winner
            tokens
          } else {
            min(dfs(a + 1, b), dfs(a, b + 1))
          }
        }
      }
    }

    val minTokens = dfs(0, 0)
    return if (minTokens == Int.MAX_VALUE) 0 else minTokens
  }

  override fun part2(input: Input): Any {
    val offset = 10000000000000
    val games = parseInput(input).map { Game(it.a, it.b, it.p.move(offset, offset)) }
    return games.sumOf { solveCramers(it) }
  }

  private fun solveCramers(game: Game): Long {
    // turns out it's just a math problem...
    // part1 we could have solved it like:
    // given: p(x,y) = a * a(x,y) + b * b(x,y)
    // loop over a [0..100] (a since it costs more, so first solution will be min):
    // r(x,y) = p(x,y) - a * a(x,y)
    // then b = r(x,y) / b(x,y)
    // ^but that still isn't good enough, as it is still O(a)
    // one optimisation is: https://en.wikipedia.org/wiki/Cramer%27s_rule
    // credit: https://blog.jverkamp.com/2024/12/13/aoc-2024-day-13-cramerinator/

    val det = game.a.x * game.b.y - game.a.y * game.b.x
    val detSubA = game.p.x * game.b.y - game.p.y * game.b.x
    val detSubB = game.a.x * game.p.y - game.a.y * game.p.x

    if (det == 0L || detSubA % det != 0L || detSubB % det != 0L) {
      return 0
    } else {
      val a = detSubA / det
      val b = detSubB / det
      return a * 3 + b
    }
  }
}
