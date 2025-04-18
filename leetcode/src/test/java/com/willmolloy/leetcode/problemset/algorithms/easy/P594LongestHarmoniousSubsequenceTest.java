package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P594LongestHarmoniousSubsequenceTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P594LongestHarmoniousSubsequenceTest {

  private final P594LongestHarmoniousSubsequence p594LongestHarmoniousSubsequence =
      new P594LongestHarmoniousSubsequence();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int expected) {
    assertThat(p594LongestHarmoniousSubsequence.findLhs(nums)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 3, 2, 2, 5, 2, 3, 7}, 5),
        Arguments.of(new int[] {1, 2, 3, 4}, 2),
        Arguments.of(new int[] {1, 1, 1, 1}, 0));
  }
}
