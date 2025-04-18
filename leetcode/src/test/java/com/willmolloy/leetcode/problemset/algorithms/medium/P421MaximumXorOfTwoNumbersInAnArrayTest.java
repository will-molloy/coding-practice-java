package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P421MaximumXorOfTwoNumbersInAnArrayTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P421MaximumXorOfTwoNumbersInAnArrayTest {

  private final P421MaximumXorOfTwoNumbersInAnArray p421 =
      new P421MaximumXorOfTwoNumbersInAnArray();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int expected) {
    assertThat(p421.findMaximumXor(nums)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {3, 10, 5, 25, 2, 8}, 28),
        Arguments.of(new int[] {0}, 0),
        Arguments.of(new int[] {2, 4}, 6),
        Arguments.of(new int[] {8, 10, 2}, 10),
        Arguments.of(new int[] {14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70}, 127));
  }
}
