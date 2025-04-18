package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;
import static com.willmolloy.testlib.CartesianProduct.cartesianProduct;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P231PowerOfTwoTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P231PowerOfTwoTest {

  @ParameterizedTest
  @MethodSource
  void examples(P231PowerOfTwo p231, int n, boolean expected) {
    assertThat(p231.isPowerOfTwo(n)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return cartesianProduct(solutions(), exampleArgs());
  }

  private static Stream<Arguments> exampleArgs() {
    return Stream.of(Arguments.of(1, true), Arguments.of(16, true), Arguments.of(218, false));
  }

  @ParameterizedTest
  @MethodSource("solutions")
  void n0(P231PowerOfTwo p231) {
    assertThat(p231.isPowerOfTwo(0)).isFalse();
  }

  @ParameterizedTest
  @MethodSource("solutions")
  void nNegative(P231PowerOfTwo p231) {
    assertThat(p231.isPowerOfTwo(-1)).isFalse();
  }

  private static Stream<P231PowerOfTwo> solutions() {
    return Stream.of(
        new P231PowerOfTwo.LibraryMethod(),
        new P231PowerOfTwo.BitManipulation(),
        new P231PowerOfTwo.Recursive(),
        new P231PowerOfTwo.Iterative());
  }
}
