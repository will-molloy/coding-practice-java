package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P376WiggleSubsequenceTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P376WiggleSubsequenceTest {

  private final P376WiggleSubsequence p376WiggleSubsequence = new P376WiggleSubsequence();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int expected) {
    assertThat(p376WiggleSubsequence.wiggleMaxLength(nums)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 7, 4, 9, 2, 5}, 6),
        Arguments.of(new int[] {1, 17, 5, 10, 13, 15, 10, 5, 16, 8}, 7),
        Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, 2));
  }

  @Test
  void staysFlat() {
    assertThat(p376WiggleSubsequence.wiggleMaxLength(new int[] {1, 1, 1, 1, 1, 1, 1, 1}))
        .isEqualTo(1);
  }
}
