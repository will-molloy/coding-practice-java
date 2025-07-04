package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;
import static com.willmolloy.testlib.CartesianProduct.cartesianProduct;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P436FindRightIntervalTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P436FindRightIntervalTest {

  @ParameterizedTest
  @MethodSource
  void examples(P436FindRightInterval approach, int[][] intervals, List<Integer> expected) {
    assertThat(approach.findRightInterval(intervals))
        .asList()
        .containsExactlyElementsIn(expected)
        .inOrder();
  }

  static Stream<Arguments> examples() {
    return cartesianProduct(approaches(), examplesArguments());
  }

  private static Stream<P436FindRightInterval> approaches() {
    return Stream.of(
        new P436FindRightInterval.WithCustomObjectAndBinarySearch(),
        new P436FindRightInterval.WithTreeMap());
  }

  private static Stream<Arguments> examplesArguments() {
    return Stream.of(
        Arguments.of(new int[][] {{1, 2}}, List.of(-1)),
        Arguments.of(new int[][] {{3, 4}, {2, 3}, {1, 2}}, List.of(-1, 0, 1)),
        Arguments.of(new int[][] {{1, 4}, {2, 3}, {3, 4}}, List.of(-1, 2, -1)));
  }
}
