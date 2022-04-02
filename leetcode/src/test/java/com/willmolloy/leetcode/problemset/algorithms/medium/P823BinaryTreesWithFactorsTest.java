package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P823BinaryTreesWithFactorsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P823BinaryTreesWithFactorsTest {

  private final P823BinaryTreesWithFactors p823BinaryTreesWithFactors =
      new P823BinaryTreesWithFactors();

  @ParameterizedTest
  @MethodSource
  void examples(int[] a, int expected) {
    assertThat(p823BinaryTreesWithFactors.numFactoredBinaryTrees(a)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(Arguments.of(new int[] {2, 4}, 3), Arguments.of(new int[] {2, 4, 5, 10}, 7));
  }
}
