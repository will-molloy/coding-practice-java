package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1616SplitTwoStringsToMakePalindromeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1616SplitTwoStringsToMakePalindromeTest {

  private final P1616SplitTwoStringsToMakePalindrome p1616 =
      new P1616SplitTwoStringsToMakePalindrome();

  @ParameterizedTest
  @MethodSource
  void examples(String a, String b, boolean expected) {
    assertThat(p1616.checkPalindromeFormation(a, b)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("x", "y", true),
        Arguments.of("abdef", "fecab", true),
        Arguments.of("ulacfd", "jizalu", true),
        Arguments.of("xbdef", "xecab", false));
  }
}
