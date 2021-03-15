package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1790CheckIfOneStringSwapCanMakeStringsEqualTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1790CheckIfOneStringSwapCanMakeStringsEqualTest {

  private final P1790CheckIfOneStringSwapCanMakeStringsEqual
      p1790CheckIfOneStringSwapCanMakeStringsEqual =
          new P1790CheckIfOneStringSwapCanMakeStringsEqual();

  @ParameterizedTest
  @MethodSource
  void examples(String s1, String s2, boolean expected) {
    assertThat(p1790CheckIfOneStringSwapCanMakeStringsEqual.areAlmostEqual(s1, s2))
        .isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("bank", "kanb", true),
        Arguments.of("attack", "defend", false),
        Arguments.of("kelb", "kelb", true),
        Arguments.of("abcd", "dcba", false));
  }
}
