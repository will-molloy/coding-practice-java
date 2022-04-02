package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P137SingleNumber2Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P137SingleNumber2Test {

  private final P137SingleNumber2 p137 = new P137SingleNumber2();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int expected) {
    assertThat(p137.singleNumber(nums)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {2, 2, 3, 2}, 3),
        Arguments.of(new int[] {0, 1, 0, 1, 0, 1, 99}, 99));
  }
}
