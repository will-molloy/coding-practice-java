package com.wilmol.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P154FindMinimumInRotatedSortedArray2Test.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P154FindMinimumInRotatedSortedArray2Test {

  private final P154FindMinimumInRotatedSortedArray2 p154 =
      new P154FindMinimumInRotatedSortedArray2();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int expected) {
    assertThat(p154.findMin(nums)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 3, 5}, 1), Arguments.of(new int[] {2, 2, 2, 0, 1}, 0));
  }

  @Test
  void worstCase() {
    assertThat(p154.findMin(new int[] {1, 1, 1, 1, 1, 0, 1, 1, 1, 1})).isEqualTo(0);
  }
}
