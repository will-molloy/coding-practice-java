package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1539KthMissingPositiveNumberTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1539KthMissingPositiveNumberTest {

  private final P1539KthMissingPositiveNumber p1539KthMissingPositiveNumber =
      new P1539KthMissingPositiveNumber();

  @ParameterizedTest
  @MethodSource
  void examples(int[] arr, int k, int expected) {
    assertThat(p1539KthMissingPositiveNumber.findKthPositive(arr, k)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {2, 3, 4, 7, 11}, 5, 9), Arguments.of(new int[] {1, 2, 3, 4}, 2, 6));
  }
}
