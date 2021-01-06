package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1695MaximumErasureValueTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1695MaximumErasureValueTest {

  private final P1695MaximumErasureValue p1695 = new P1695MaximumErasureValue();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int expected) {
    assertThat(p1695.maximumUniqueSubarray(nums)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {4, 2, 4, 5, 6}, 17),
        Arguments.of(new int[] {5, 2, 1, 2, 5, 2, 1, 2, 5}, 8));
  }
}
