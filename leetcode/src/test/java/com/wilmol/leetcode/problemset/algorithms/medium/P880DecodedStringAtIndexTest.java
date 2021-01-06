package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P880DecodedStringAtIndexTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P880DecodedStringAtIndexTest {

  private final P880DecodedStringAtIndex p880DecodedStringAtIndex = new P880DecodedStringAtIndex();

  @ParameterizedTest
  @MethodSource
  void examples(String s, int k, String expected) {
    assertThat(p880DecodedStringAtIndex.decodeAtIndex(s, k)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("leet2code3", 10, "o"),
        Arguments.of("ha22", 5, "h"),
        Arguments.of("a2345678999999999999999", 1, "a"));
  }
}
