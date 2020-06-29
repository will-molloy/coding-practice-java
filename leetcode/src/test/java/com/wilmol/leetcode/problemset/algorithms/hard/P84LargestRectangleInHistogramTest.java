package com.wilmol.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P84LargestRectangleInHistogramTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P84LargestRectangleInHistogramTest {

  @ParameterizedTest
  @MethodSource("funcs")
  void example(P84LargestRectangleInHistogram fun) {
    assertThat(fun.largestRectangleArea(IntStream.of(2, 1, 5, 6, 2, 3).toArray())).isEqualTo(10);
  }

  @ParameterizedTest
  @MethodSource("funcs")
  void exampleWidenedWith1s(P84LargestRectangleInHistogram fun) {
    assertThat(fun.largestRectangleArea(IntStream.of(2, 1, 5, 6, 2, 3, 1, 1, 1, 1, 1).toArray()))
        .isEqualTo(11);
  }

  @ParameterizedTest
  @MethodSource("funcs")
  void zeroTo20k(P84LargestRectangleInHistogram fun) {
    assertThat(fun.largestRectangleArea(IntStream.range(0, 20_000).toArray()))
        .isEqualTo(100_000_000);
  }

  @ParameterizedTest
  @MethodSource("funcs")
  void emptyInput(P84LargestRectangleInHistogram fun) {
    assertThat(fun.largestRectangleArea(new int[0])).isEqualTo(0);
  }

  static Stream<Arguments> funcs() {
    return Stream.of(
        Arguments.of(new P84LargestRectangleInHistogram.BruteForce()),
        Arguments.of(new P84LargestRectangleInHistogram.Linear()));
  }
}
