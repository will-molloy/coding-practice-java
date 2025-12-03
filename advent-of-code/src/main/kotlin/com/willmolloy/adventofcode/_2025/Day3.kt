package com.willmolloy.adventofcode._2025

import com.willmolloy.adventofcode.common.Day
import com.willmolloy.adventofcode.common.Input
import kotlin.math.max

/** https://adventofcode.com/2025/day/3 */
object Day3 : Day(2025, 3) {

  override fun part1(input: Input): Any {
    var res = 0

    for (line in input.readLinesOfDigits()) {

      // try all the combos...
      var lineMax = 0
      for (i in 0 until line.size) {
        for (j in i + 1 until line.size) {
          val num = line[i] * 10 + line[j]
          lineMax = max(lineMax, num)
        }
      }

      res += lineMax
    }
    return res
  }

  override fun part2(input: Input): Any {
    // same but go to a depth of 12 rather than 2... thinking dfs
    // dfs too slow...

    // instead it can be greedy?? how?
    // want the largest digit that's remaining in the string... while leaving enough digits

    // example: 987654321111111 - 15 digits
    // search these ranges:
    // 987654321111111
    // L..R........... | L=0, R=3 | remain = 11 | max = 9
    // .L..R.......... | L=1, R=4 | remain = 10 | max = 8
    // ..L..R......... | L=2, R=5 | remain = 9 | max = 7
    // ...L..R........ | L=3, R=6 | remain = 8 | max = 6
    // ....L..R....... | L=4, R=7 | remain = 7 | max = 5
    // .....L..R...... | L=5, R=8 | remain = 6 | max = 4
    // ......L..R..... | L=6, R=9 | remain = 5 | max = 3
    // .......L..R.... | L=7, R=10 | remain = 4 | max = 2
    // ........L..R... | L=8, R=11 | remain = 3 | max = 1
    // .........L..R.. | L=9, R=12 | remain = 2 | max = 1
    // ..........L..R. | L=10, R=13 | remain = 1 | max = 1
    // ...........L..R | L=11, R=14 | remain = 0 | max = 1
    // not the best example...

    // example: 818181911112111 - also 15 digits
    // search these ranges:
    // 818181911112111
    // L..R........... | L=0, R=3 | remain = 11 | max = 8 at index=0
    // .L..R.......... | L=1, R=4 | remain = 10 | max = 8 at index=2
    // ...L.R......... | L=3, R=5 | remain = 9  | max = 8 at index=4
    // .....LR........ | L=5, R=6 | remain = 8  | max = 9 at index=6
    // .......L....... | L=7, R=7 | remain = 7  | max = 1 at index=7
    // (Range is stuck at size 1, takes all remaining digits)

    // so L = the last index we took + 1
    // and R = length - remain - 1

    var res = 0L

    for (line in input.readLinesOfDigits()) {
      var sum = 0L

      var remain = 12
      var l = 0

      while (remain-- > 0) {
        val r = line.size - remain - 1

        val maxDigit = (l..r).map { IndexedValue(it, line[it]) }.maxBy { it.value }
        sum = sum * 10 + maxDigit.value
        l = maxDigit.index + 1
      }

      res += sum
    }
    return res
  }
}
