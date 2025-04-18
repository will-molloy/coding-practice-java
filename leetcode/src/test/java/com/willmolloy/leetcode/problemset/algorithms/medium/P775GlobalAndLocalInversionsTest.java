package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P775GlobalAndLocalInversionsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P775GlobalAndLocalInversionsTest {

  private final P775GlobalAndLocalInversions p775GlobalAndLocalInversions =
      new P775GlobalAndLocalInversions();

  @ParameterizedTest
  @MethodSource
  void examples(int[] a, boolean expected) {
    assertThat(p775GlobalAndLocalInversions.isIdealPermutation(a)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 0, 2}, true), Arguments.of(new int[] {1, 2, 0}, false));
  }
}
