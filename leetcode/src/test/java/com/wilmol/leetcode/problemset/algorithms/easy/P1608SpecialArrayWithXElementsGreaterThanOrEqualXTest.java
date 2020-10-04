package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1608SpecialArrayWithXElementsGreaterThanOrEqualXTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1608SpecialArrayWithXElementsGreaterThanOrEqualXTest {

  private final P1608SpecialArrayWithXElementsGreaterThanOrEqualX p1608 =
      new P1608SpecialArrayWithXElementsGreaterThanOrEqualX();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int expected) {
    assertThat(p1608.specialArray(nums)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {3, 5}, 2),
        Arguments.of(new int[] {0, 0}, -1),
        Arguments.of(new int[] {0, 4, 3, 0, 4}, 3),
        Arguments.of(new int[] {3, 6, 7, 7, 0}, -1));
  }
}
