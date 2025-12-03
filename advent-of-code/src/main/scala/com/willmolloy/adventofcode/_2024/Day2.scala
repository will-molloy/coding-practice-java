package com.willmolloy.adventofcode._2024

import com.willmolloy.adventofcode.common.{Day, Input}
import com.willmolloy.adventofcode.scala.Adapters.ListAdapter
import com.willmolloy.adventofcode.scala.Adapters.ArrayAdapter

import scala.annotation.tailrec

/**
 * https://adventofcode.com/2024/day/2
 */
object Day2 extends Day(2024, 2) {

  override def part1(input: Input): Int = {
    input.readLinesOfNums().count(isSafe)
  }

  override def part2(input: Input): Int = {
    // try all combinations
    input
      .readLinesOfNums()
      .count(report =>
        report.indices.exists(i => {
          val newReport = report.take(i) ++ report.drop(i + 1)
          isSafe(newReport)
        })
      )
  }

  private def isSafe(report: Seq[Long]): Boolean = {
    @tailrec
    def isSafe(list: Seq[Long], increasing: Boolean): Boolean = {
      list match
        case Seq() | Seq(_) => true
        case a +: b +: tail => {
          if (increasing && a >= b || !increasing && a <= b) {
            return false
          }

          val diff = math.abs(a - b)
          if (diff < 1 || diff > 3) {
            return false
          }

          isSafe(b +: tail, increasing)
        }
    }

    if (report.length < 2) true
    else isSafe(report, report(0) < report(1))
  }
}
