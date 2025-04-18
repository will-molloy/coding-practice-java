package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1658MinimumOperationsToReduceXToZeroTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1658MinimumOperationsToReduceXToZeroTest {

  private final P1658MinimumOperationsToReduceXToZero p1658 =
      new P1658MinimumOperationsToReduceXToZero();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int k, int expected) {
    assertThat(p1658.minOperations(nums, k)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 1, 4, 2, 3}, 5, 2),
        Arguments.of(new int[] {5, 6, 7, 8, 9}, 4, -1),
        Arguments.of(new int[] {3, 2, 20, 1, 1, 3}, 10, 5));
  }

  @Test
  void wa1() {
    assertThat(p1658.minOperations(new int[] {1, 1}, 3)).isEqualTo(-1);
  }
}
