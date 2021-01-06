package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P910SmallestRange2Test.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P910SmallestRange2Test {

  private final P910SmallestRange2 p910SmallestRange2 = new P910SmallestRange2();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int k, int expected) {
    assertThat(p910SmallestRange2.smallestRangeII(nums, k)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1}, 0, 0),
        Arguments.of(new int[] {0, 10}, 2, 6),
        Arguments.of(new int[] {1, 3, 6}, 3, 3));
  }
}
