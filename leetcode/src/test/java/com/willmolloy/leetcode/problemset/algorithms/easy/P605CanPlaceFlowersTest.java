package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P605CanPlaceFlowersTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P605CanPlaceFlowersTest {

  @ParameterizedTest
  @MethodSource
  void examples(int[] flowerbed, int n, boolean expected) {
    assertThat(new P605CanPlaceFlowers().canPlaceFlowers(flowerbed, n)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 0, 0, 0, 1}, 1, true),
        Arguments.of(new int[] {1, 0, 0, 0, 1}, 2, false));
  }
}
