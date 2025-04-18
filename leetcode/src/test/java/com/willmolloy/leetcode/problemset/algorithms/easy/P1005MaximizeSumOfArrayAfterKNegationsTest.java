package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1005MaximizeSumOfArrayAfterKNegationsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1005MaximizeSumOfArrayAfterKNegationsTest {

  @ParameterizedTest
  @MethodSource("funs")
  void example1(P1005MaximizeSumOfArrayAfterKNegations fun) {
    assertThat(fun.largestSumAfterKNegations(new int[] {4, 2, 3}, 1)).isEqualTo(5);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void example2(P1005MaximizeSumOfArrayAfterKNegations fun) {
    assertThat(fun.largestSumAfterKNegations(new int[] {3, -1, 0, 2}, 3)).isEqualTo(6);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void example3(P1005MaximizeSumOfArrayAfterKNegations fun) {
    assertThat(fun.largestSumAfterKNegations(new int[] {2, -3, -1, 5, -4}, 2)).isEqualTo(13);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void kLargerThanN(P1005MaximizeSumOfArrayAfterKNegations fun) {
    assertThat(fun.largestSumAfterKNegations(new int[] {-1, -2, -3, 1, 2, 3}, 10)).isEqualTo(10);
  }

  static Stream<P1005MaximizeSumOfArrayAfterKNegations> funs() {
    return Stream.of(
        new P1005MaximizeSumOfArrayAfterKNegations.Sort(),
        new P1005MaximizeSumOfArrayAfterKNegations.MinHeap());
  }
}
