package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P763PartitionLabelsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P763PartitionLabelsTest {

  @ParameterizedTest
  @MethodSource("p763")
  void example(P763PartitionLabels p763) {
    assertThat(p763.partitionLabels("ababcbacadefegdehijhklij")).containsExactly(9, 7, 8).inOrder();
  }

  static Stream<P763PartitionLabels> p763() {
    return Stream.of(new P763PartitionLabels.MergeIntervals(), new P763PartitionLabels.Greedy());
  }
}
