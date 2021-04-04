package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;
import static com.wilmol.testlib.CartesianProduct.cartesianProduct;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P647PalindromicSubstringsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P647PalindromicSubstringsTest {

  @ParameterizedTest
  @MethodSource
  void examples(P647PalindromicSubstrings p647PalindromicSubstrings, String s, int expected) {
    assertThat(p647PalindromicSubstrings.countSubstrings(s)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return cartesianProduct(solutions(), examplesArgs());
  }

  private static Stream<Arguments> examplesArgs() {
    return Stream.of(Arguments.of("abc", 3), Arguments.of("aaa", 6));
  }

  private static Stream<P647PalindromicSubstrings> solutions() {
    return Stream.of(
        new P647PalindromicSubstrings.TestAllSubstrings(), new P647PalindromicSubstrings.Dp());
  }
}
