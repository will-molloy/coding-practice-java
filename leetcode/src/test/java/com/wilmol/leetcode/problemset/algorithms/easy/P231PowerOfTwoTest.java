package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import com.wilmol.testlib.TestLib;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P231PowerOfTwoTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P231PowerOfTwoTest {

  @ParameterizedTest
  @MethodSource
  void examples(P231PowerOfTwo p231, int n, boolean expected) {
    assertThat(p231.isPowerOfTwo(n)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return TestLib.cartesianProduct(solutions(), exampleArgs());
  }

  private static ImmutableList<Arguments> exampleArgs() {
    return ImmutableList.of(
        Arguments.of(1, true), Arguments.of(16, true), Arguments.of(218, false));
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

  private static ImmutableList<Arguments> solutions() {
    return ImmutableList.of(
        Arguments.of(new P231PowerOfTwo.LibraryMethod()),
        Arguments.of(new P231PowerOfTwo.BitManipulation()),
        Arguments.of(new P231PowerOfTwo.Recursive()),
        Arguments.of(new P231PowerOfTwo.Iterative()));
  }
}
