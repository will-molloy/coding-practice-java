package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1456MaximumNumberOfVowelsInASubstringOfGivenLengthTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1456MaximumNumberOfVowelsInASubstringOfGivenLengthTest {

  private final P1456MaximumNumberOfVowelsInASubstringOfGivenLength p1456 =
      new P1456MaximumNumberOfVowelsInASubstringOfGivenLength();

  @ParameterizedTest
  @MethodSource
  void examples(String s, int k, int expected) {
    assertThat(p1456.maxVowels(s, k)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("abciiidef", 3, 3),
        Arguments.of("aeiou", 2, 2),
        Arguments.of("leetcode", 3, 2),
        Arguments.of("rhythms", 4, 0),
        Arguments.of("tryhard", 4, 1));
  }
}
