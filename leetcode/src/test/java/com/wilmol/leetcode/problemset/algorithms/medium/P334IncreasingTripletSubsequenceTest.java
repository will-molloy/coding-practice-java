package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P334IncreasingTripletSubsequenceTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P334IncreasingTripletSubsequenceTest {

  private final P334IncreasingTripletSubsequence p334IncreasingTripletSubsequence =
      new P334IncreasingTripletSubsequence();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, boolean expected) {
    assertThat(p334IncreasingTripletSubsequence.increasingTriplet(nums)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 3, 4, 5}, true),
        Arguments.of(new int[] {5, 4, 3, 2, 1}, false),
        Arguments.of(new int[] {2, 1, 5, 0, 4, 6}, true));
  }
}
