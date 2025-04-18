package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1578MinimumDeletionCostToAvoidRepeatingLettersTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1578MinimumDeletionCostToAvoidRepeatingLettersTest {

  private final P1578MinimumDeletionCostToAvoidRepeatingLetters p1578 =
      new P1578MinimumDeletionCostToAvoidRepeatingLetters();

  @ParameterizedTest
  @MethodSource
  void examples(String s, int[] cost, int expected) {
    assertThat(p1578.minCost(s, cost)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("abaac", new int[] {1, 2, 3, 4, 5}, 3),
        Arguments.of("abc", new int[] {1, 2, 3}, 0),
        Arguments.of("aabaa", new int[] {1, 2, 3, 4, 1}, 2));
  }
}
