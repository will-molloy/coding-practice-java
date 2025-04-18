package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1625LexicographicallySmallestStringAfterApplyingOperationsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1625LexicographicallySmallestStringAfterApplyingOperationsTest {

  private final P1625LexicographicallySmallestStringAfterApplyingOperations p1625 =
      new P1625LexicographicallySmallestStringAfterApplyingOperations();

  @ParameterizedTest
  @MethodSource
  void examples(String s, int a, int b, String expected) {
    assertThat(p1625.findLexSmallestString(s, a, b)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("5525", 9, 2, "2050"),
        Arguments.of("74", 5, 1, "24"),
        Arguments.of("0011", 4, 2, "0011"),
        Arguments.of("43987654", 7, 3, "00553311"));
  }
}
