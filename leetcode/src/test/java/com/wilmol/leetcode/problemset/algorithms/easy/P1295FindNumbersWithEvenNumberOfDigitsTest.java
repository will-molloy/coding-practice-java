package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/** Created by wilmol on 2020-06-08. */
class P1295FindNumbersWithEvenNumberOfDigitsTest {

  private final P1295FindNumbersWithEvenNumberOfDigits p1295 =
      new P1295FindNumbersWithEvenNumberOfDigits();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int expected) {
    assertThat(p1295.findNumbers(nums)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {12, 345, 2, 6, 7896}, 2),
        Arguments.of(new int[] {555, 901, 482, 1771}, 1));
  }
}
