package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1461CheckIfAStringContainsAllBinaryCodesOfSizeKTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1461CheckIfAStringContainsAllBinaryCodesOfSizeKTest {

  private final P1461CheckIfAStringContainsAllBinaryCodesOfSizeK
      p1461CheckIfAStringContainsAllBinaryCodesOfSizeK =
          new P1461CheckIfAStringContainsAllBinaryCodesOfSizeK();

  @ParameterizedTest
  @MethodSource
  void examples(String s, int k, boolean expected) {
    assertThat(p1461CheckIfAStringContainsAllBinaryCodesOfSizeK.hasAllCodes(s, k))
        .isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("00110110", 2, true),
        Arguments.of("00110", 2, true),
        Arguments.of("0110", 1, true),
        Arguments.of("0110", 2, false),
        Arguments.of("0000000001011100", 4, false));
  }
}
