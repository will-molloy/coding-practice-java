package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P122BestTimeToBuyAndSellStock2Test.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P122BestTimeToBuyAndSellStock2Test {

  @ParameterizedTest
  @MethodSource("funs")
  void example1(P122BestTimeToBuyAndSellStock2 fun) {
    // buy 1, sell 5, buy 3, sell 6
    assertThat(fun.maxProfit(new int[] {7, 1, 5, 3, 6, 4})).isEqualTo(7);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void example2(P122BestTimeToBuyAndSellStock2 fun) {
    // buy 1, sell 5
    assertThat(fun.maxProfit(new int[] {1, 2, 3, 4, 5})).isEqualTo(4);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void example3(P122BestTimeToBuyAndSellStock2 fun) {
    // no transaction
    assertThat(fun.maxProfit(new int[] {7, 6, 4, 3, 1})).isEqualTo(0);
  }

  static Stream<P122BestTimeToBuyAndSellStock2> funs() {
    return Stream.of(
        new P122BestTimeToBuyAndSellStock2.BruteForce(),
        new P122BestTimeToBuyAndSellStock2.Linear());
  }
}
