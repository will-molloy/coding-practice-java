package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1704DetermineIfStringHalvesAreAlikeTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1704DetermineIfStringHalvesAreAlikeTest {

  private final P1704DetermineIfStringHalvesAreAlike p1704DetermineIfStringHalvesAreAlike =
      new P1704DetermineIfStringHalvesAreAlike();

  @ParameterizedTest
  @MethodSource
  void examples(String s, boolean expected) {
    assertThat(p1704DetermineIfStringHalvesAreAlike.halvesAreAlike(s)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("book", true),
        Arguments.of("textbook", false),
        Arguments.of("MerryChristmas", false),
        Arguments.of("AbCdEfGh", true));
  }
}
