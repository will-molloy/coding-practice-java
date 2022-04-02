package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1640CheckArrayFormationThroughConcatenationTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1640CheckArrayFormationThroughConcatenationTest {

  private final P1640CheckArrayFormationThroughConcatenation p1640 =
      new P1640CheckArrayFormationThroughConcatenation();

  @ParameterizedTest
  @MethodSource
  void examples(int[] arr, int[][] pieces, boolean expected) {
    assertThat(p1640.canFormArray(arr, pieces)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {85}, new int[][] {{85}}, true),
        Arguments.of(new int[] {15, 88}, new int[][] {{88}, {15}}, true),
        Arguments.of(new int[] {49, 18, 16}, new int[][] {{16, 18, 49}}, false),
        Arguments.of(new int[] {91, 4, 64, 78}, new int[][] {{78}, {4, 64}, {91}}, true),
        Arguments.of(new int[] {1, 3, 5, 7}, new int[][] {{2, 4, 6, 8}}, false));
  }
}
