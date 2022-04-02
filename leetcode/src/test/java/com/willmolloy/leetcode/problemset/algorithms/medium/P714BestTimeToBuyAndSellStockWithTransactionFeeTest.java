package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P714BestTimeToBuyAndSellStockWithTransactionFeeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P714BestTimeToBuyAndSellStockWithTransactionFeeTest {

  private final P714BestTimeToBuyAndSellStockWithTransactionFee
      p714BestTimeToBuyAndSellStockWithTransactionFee =
          new P714BestTimeToBuyAndSellStockWithTransactionFee();

  @ParameterizedTest
  @MethodSource
  void examples(int[] prices, int fee, int expected) {
    assertThat(p714BestTimeToBuyAndSellStockWithTransactionFee.maxProfit(prices, fee))
        .isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 3, 2, 8, 4, 9}, 2, 8),
        Arguments.of(new int[] {1, 3, 7, 5, 10, 3}, 3, 6));
  }
}
