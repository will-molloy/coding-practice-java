package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1475FinalPricesWithASpecialDiscountInAShopTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1475FinalPricesWithASpecialDiscountInAShopTest {

  private final P1475FinalPricesWithASpecialDiscountInAShop p1475 =
      new P1475FinalPricesWithASpecialDiscountInAShop();

  @ParameterizedTest
  @MethodSource
  void examples(int[] prices, List<Integer> expected) {
    assertThat(p1475.finalPrices(prices)).asList().containsExactlyElementsIn(expected).inOrder();
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {8, 4, 6, 2, 3}, ImmutableList.of(4, 2, 4, 2, 3)),
        Arguments.of(new int[] {1, 2, 3, 4, 5}, ImmutableList.of(1, 2, 3, 4, 5)),
        Arguments.of(new int[] {10, 1, 1, 6}, ImmutableList.of(9, 0, 1, 6)));
  }
}
