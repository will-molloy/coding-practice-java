package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P220ContainsDuplicate3Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P220ContainsDuplicate3Test {

  private final P220ContainsDuplicate3 p220 = new P220ContainsDuplicate3();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int k, int t, boolean expected) {
    assertThat(p220.containsNearbyAlmostDuplicate(nums, k, t)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 2, 3, 1}, 3, 0, true),
        Arguments.of(new int[] {1, 0, 1, 1}, 1, 2, true),
        Arguments.of(new int[] {1, 5, 9, 1, 5, 9}, 2, 3, false));
  }

  @Test
  void overflowsInt() {
    assertThat(
            p220.containsNearbyAlmostDuplicate(
                new int[] {0, Integer.MAX_VALUE}, 1, Integer.MAX_VALUE))
        .isTrue();
  }

  @Test
  void negativeT() {
    assertThat(p220.containsNearbyAlmostDuplicate(new int[] {0, 1, 2, 3}, 1, -1)).isFalse();
  }
}
