package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1630ArithmeticSubarraysTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1630ArithmeticSubarraysTest {

  private final P1630ArithmeticSubarrays p1630 = new P1630ArithmeticSubarrays();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int[] l, int[] r, List<Boolean> expected) {
    assertThat(p1630.checkArithmeticSubarrays(nums, l, r))
        .containsExactlyElementsIn(expected)
        .inOrder();
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(
            new int[] {4, 6, 5, 9, 3, 7},
            new int[] {0, 0, 2},
            new int[] {2, 3, 5},
            List.of(true, false, true)),
        Arguments.of(
            new int[] {-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10},
            new int[] {0, 1, 6, 4, 8, 7},
            new int[] {4, 4, 9, 7, 9, 10},
            List.of(false, true, false, false, true, true)));
  }
}
