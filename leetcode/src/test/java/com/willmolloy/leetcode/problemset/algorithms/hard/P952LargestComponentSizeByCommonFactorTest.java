package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P952LargestComponentSizeByCommonFactorTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P952LargestComponentSizeByCommonFactorTest {

  private final P952LargestComponentSizeByCommonFactor p952 =
      new P952LargestComponentSizeByCommonFactor();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int expected) {
    assertThat(p952.largestComponentSize(nums)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {4, 6, 15, 35}, 4),
        Arguments.of(new int[] {20, 50, 9, 63}, 2),
        Arguments.of(new int[] {2, 3, 6, 7, 4, 12, 21, 39}, 8));
  }
}
