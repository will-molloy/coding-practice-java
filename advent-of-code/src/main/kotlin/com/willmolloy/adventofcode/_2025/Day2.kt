package com.willmolloy.adventofcode._2025

import com.willmolloy.adventofcode.common.Day
import com.willmolloy.adventofcode.common.Input

/** https://adventofcode.com/2025/day/2 */
object Day2 : Day(2025, 2) {

  override fun part1(input: Input): Any {
    val split = input.string().split(",")

    var res  = 0L

    for (s in split) {
      val r1 = s.split("-")[0].toLong()
      val r2 = s.split("-")[1].toLong()

      for (i in r1..r2) {
        val iString = i.toString()
        val first = i.toString().substring(0, iString.length / 2)
        val second = i.toString().substring(iString.length / 2)
        if (first == second){
          res += i
        }
      }
    }

    return res
  }

  override fun part2(input: Input): Any {
    val split = input.string().split(",")

    var res  = 0L

    for (s in split) {
      val r1 = s.split("-")[0].toLong()
      val r2 = s.split("-")[1].toLong()

      for (i in r1..r2) {
        val iString = i.toString()

        for (j in 1 until iString.length) {
          val chunked = iString.chunked(j)
          if (chunked.all { s -> s == chunked[0] }){
            res += i
            break;
          }
        }
      }
    }

    return res
  }
}
