package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1672RichestCustomerWealthTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1672RichestCustomerWealthTest {

  private final P1672RichestCustomerWealth p1672 = new P1672RichestCustomerWealth();

  @ParameterizedTest
  @MethodSource
  void examples(int[][] accounts, int expected) {
    assertThat(p1672.maximumWealth(accounts)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[][] {{1, 2, 3}, {3, 2, 1}}, 6),
        Arguments.of(new int[][] {{1, 5}, {7, 3}, {3, 5}}, 10),
        Arguments.of(new int[][] {{2, 8, 7}, {7, 1, 3}, {1, 9, 5}}, 17));
  }
}
