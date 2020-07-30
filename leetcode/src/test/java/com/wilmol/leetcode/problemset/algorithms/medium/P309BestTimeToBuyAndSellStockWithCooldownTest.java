package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P309BestTimeToBuyAndSellStockWithCooldownTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P309BestTimeToBuyAndSellStockWithCooldownTest {

  @ParameterizedTest
  @MethodSource("p309")
  void example(P309BestTimeToBuyAndSellStockWithCooldown p309) {
    assertThat(p309.maxProfit(new int[] {1, 2, 3, 0, 2})).isEqualTo(3);
  }

  @ParameterizedTest
  @MethodSource("p309")
  void noDays(P309BestTimeToBuyAndSellStockWithCooldown p309) {
    assertThat(p309.maxProfit(new int[0])).isEqualTo(0);
  }

  @ParameterizedTest
  @MethodSource("p309")
  void oneDay(P309BestTimeToBuyAndSellStockWithCooldown p309) {
    assertThat(p309.maxProfit(new int[] {1})).isEqualTo(0);
  }

  @ParameterizedTest
  @MethodSource("p309")
  void twoDaysWithProfit(P309BestTimeToBuyAndSellStockWithCooldown p309) {
    assertThat(p309.maxProfit(new int[] {1, 6})).isEqualTo(5);
  }

  @ParameterizedTest
  @MethodSource("p309")
  void twoDaysWithoutProfit(P309BestTimeToBuyAndSellStockWithCooldown p309) {
    assertThat(p309.maxProfit(new int[] {6, 1})).isEqualTo(0);
  }

  static Stream<P309BestTimeToBuyAndSellStockWithCooldown> p309() {
    return Stream.of(
        new P309BestTimeToBuyAndSellStockWithCooldown.TopDown(),
        new P309BestTimeToBuyAndSellStockWithCooldown.BottomUp());
  }
}
