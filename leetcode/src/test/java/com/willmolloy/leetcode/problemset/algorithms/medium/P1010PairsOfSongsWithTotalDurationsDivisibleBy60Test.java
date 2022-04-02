package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1010PairsOfSongsWithTotalDurationsDivisibleBy60Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1010PairsOfSongsWithTotalDurationsDivisibleBy60Test {

  private final P1010PairsOfSongsWithTotalDurationsDivisibleBy60 p1010 =
      new P1010PairsOfSongsWithTotalDurationsDivisibleBy60();

  @ParameterizedTest
  @MethodSource
  void examples(int[] time, int expected) {
    assertThat(p1010.numPairsDivisibleBy60(time)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {30, 20, 150, 100, 40}, 3), Arguments.of(new int[] {60, 60, 60}, 3));
  }
}
