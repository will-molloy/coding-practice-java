package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1497CheckIfArrayPairsAreDivisibleByKTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1497CheckIfArrayPairsAreDivisibleByKTest {

  private final P1497CheckIfArrayPairsAreDivisibleByK p1498 =
      new P1497CheckIfArrayPairsAreDivisibleByK();

  @ParameterizedTest
  @MethodSource
  void examples(int[] arr, int k, boolean expected) {
    assertThat(p1498.canArrange(arr, k)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 3, 4, 5, 10, 6, 7, 8, 9}, 5, true),
        Arguments.of(new int[] {1, 2, 3, 4, 5, 6}, 7, true),
        Arguments.of(new int[] {1, 2, 3, 4, 5, 6}, 10, false),
        Arguments.of(new int[] {-10, 10}, 2, true),
        Arguments.of(new int[] {-1, 1, -2, 2, -3, 3, -4, 4}, 3, true));
  }
}
