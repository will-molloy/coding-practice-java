package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1641CountSortedVowelStringsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1641CountSortedVowelStringsTest {

  private final P1641CountSortedVowelStrings p1641 = new P1641CountSortedVowelStrings();

  @ParameterizedTest
  @MethodSource
  void examples(int n, int expected) {
    assertThat(p1641.countVowelStrings(n)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(Arguments.of(1, 5), Arguments.of(2, 15), Arguments.of(33, 66045));
  }
}
