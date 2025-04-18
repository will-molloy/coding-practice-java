package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1784CheckIfBinaryStringHasAtMostOneSegmentOfOnesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1784CheckIfBinaryStringHasAtMostOneSegmentOfOnesTest {

  private final P1784CheckIfBinaryStringHasAtMostOneSegmentOfOnes
      p1784CheckIfBinaryStringHasAtMostOneSegmentOfOnes =
          new P1784CheckIfBinaryStringHasAtMostOneSegmentOfOnes();

  @ParameterizedTest
  @MethodSource
  void examples(String s, boolean expected) {
    assertThat(p1784CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment(s))
        .isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(Arguments.of("1001", false), Arguments.of("110", true));
  }
}
