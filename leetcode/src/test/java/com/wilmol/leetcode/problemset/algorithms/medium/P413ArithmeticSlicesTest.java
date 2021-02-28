package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P413ArithmeticSlicesTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P413ArithmeticSlicesTest {

  private final P413ArithmeticSlices p413ArithmeticSlices = new P413ArithmeticSlices();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int expected) {
    assertThat(p413ArithmeticSlices.numberOfArithmeticSlices(nums)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(Arguments.of(new int[] {1, 2, 3, 4}, 3), Arguments.of(new int[] {1}, 0));
  }
}
