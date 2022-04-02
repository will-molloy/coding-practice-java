package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P416PartitionEqualSubsetSumTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P416PartitionEqualSubsetSumTest {

  private final P416PartitionEqualSubsetSum p416 = new P416PartitionEqualSubsetSum();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, boolean expected) {
    assertThat(p416.canPartition(nums)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 5, 11, 5}, true), Arguments.of(new int[] {1, 2, 3, 5}, false));
  }
}
