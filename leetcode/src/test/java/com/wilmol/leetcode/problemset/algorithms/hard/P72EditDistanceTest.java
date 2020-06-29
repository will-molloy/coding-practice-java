package com.wilmol.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P72EditDistanceTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P72EditDistanceTest {

  private final P72EditDistance p72 = new P72EditDistance();

  @ParameterizedTest
  @MethodSource
  void examples(String word1, String word2, int expected) {
    assertThat(p72.minDistance(word1, word2)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(Arguments.of("horse", "ros", 3), Arguments.of("intention", "execution", 5));
  }
}
