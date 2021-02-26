package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P946ValidateStackSequencesTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P946ValidateStackSequencesTest {

  @ParameterizedTest
  @MethodSource
  void examples(int[] pushed, int[] popped, boolean expected) {
    assertThat(new P946ValidateStackSequences().validateStackSequences(pushed, popped))
        .isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 3, 4, 5}, new int[] {4, 5, 3, 2, 1}, true),
        Arguments.of(new int[] {1, 2, 3, 4, 5}, new int[] {4, 3, 5, 1, 2}, false));
  }
}
