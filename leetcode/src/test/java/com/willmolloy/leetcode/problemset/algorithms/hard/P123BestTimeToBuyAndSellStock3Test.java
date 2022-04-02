package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P123BestTimeToBuyAndSellStock3Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P123BestTimeToBuyAndSellStock3Test {

  @ParameterizedTest
  @MethodSource("funs")
  void example1(P123BestTimeToBuyAndSellStock3 fun) {
    // buy 0, sell 3, buy 1, sell 4
    assertThat(fun.maxProfit(new int[] {3, 3, 5, 0, 0, 3, 1, 4})).isEqualTo(6);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void example2(P123BestTimeToBuyAndSellStock3 fun) {
    // buy 1, sell 5
    assertThat(fun.maxProfit(new int[] {1, 2, 3, 4, 5})).isEqualTo(4);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void example3(P123BestTimeToBuyAndSellStock3 fun) {
    // no transaction
    assertThat(fun.maxProfit(new int[] {7, 6, 4, 3, 1})).isEqualTo(0);
  }

  static Stream<P123BestTimeToBuyAndSellStock3> funs() {
    return Stream.of(
        new P123BestTimeToBuyAndSellStock3.BruteForce(),
        new P123BestTimeToBuyAndSellStock3.Linear());
  }
}
