package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1217MinimumCostToMoveChipsToTheSamePositionTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1217MinimumCostToMoveChipsToTheSamePositionTest {

  private final P1217MinimumCostToMoveChipsToTheSamePosition p1217 =
      new P1217MinimumCostToMoveChipsToTheSamePosition();

  @ParameterizedTest
  @MethodSource
  void examples(int[] position, int expected) {
    assertThat(p1217.minCostToMoveChips(position)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 3}, 1),
        Arguments.of(new int[] {2, 2, 2, 3, 3}, 2),
        Arguments.of(new int[] {1, 1000000000}, 1));
  }
}
