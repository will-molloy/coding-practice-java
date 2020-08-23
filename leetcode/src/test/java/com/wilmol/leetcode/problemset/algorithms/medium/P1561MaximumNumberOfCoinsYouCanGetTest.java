package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1561MaximumNumberOfCoinsYouCanGetTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1561MaximumNumberOfCoinsYouCanGetTest {

  private final P1561MaximumNumberOfCoinsYouCanGet p1561 = new P1561MaximumNumberOfCoinsYouCanGet();

  @ParameterizedTest
  @MethodSource
  void examples(int[] piles, int expected) {
    assertThat(p1561.maxCoins(piles)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {2, 4, 1, 2, 7, 8}, 9),
        Arguments.of(new int[] {2, 4, 5}, 4),
        Arguments.of(new int[] {9, 8, 7, 6, 5, 1, 2, 3, 4}, 18));
  }
}
