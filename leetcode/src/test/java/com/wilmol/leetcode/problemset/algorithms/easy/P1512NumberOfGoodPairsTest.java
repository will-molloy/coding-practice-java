package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1512NumberOfGoodPairsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1512NumberOfGoodPairsTest {

  private final P1512NumberOfGoodPairs p1512 = new P1512NumberOfGoodPairs();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int expected) {
    assertThat(p1512.numIdenticalPairs(nums)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 3, 1, 1, 3}, 4),
        Arguments.of(new int[] {1, 1, 1, 1}, 6),
        Arguments.of(new int[] {1, 2, 3}, 0));
  }
}
