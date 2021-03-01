package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P575DistributeCandiesTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P575DistributeCandiesTest {

  private final P575DistributeCandies p575DistributeCandies = new P575DistributeCandies();

  @ParameterizedTest
  @MethodSource
  void examples(int[] candyType, int expected) {
    assertThat(p575DistributeCandies.distributeCandies(candyType)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 1, 2, 2, 3, 3}, 3),
        Arguments.of(new int[] {1, 1, 2, 3}, 2),
        Arguments.of(new int[] {6, 6, 6, 6}, 1));
  }
}
