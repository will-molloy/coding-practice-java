package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1657DetermineIfTwoStringsAreCloseTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1657DetermineIfTwoStringsAreCloseTest {

  private final P1657DetermineIfTwoStringsAreClose p1657 = new P1657DetermineIfTwoStringsAreClose();

  @ParameterizedTest
  @MethodSource
  void examples(String word1, String word2, boolean expected) {
    assertThat(p1657.closeStrings(word1, word2)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("abc", "bca", true),
        Arguments.of("a", "aa", false),
        Arguments.of("cabbba", "abbccc", true),
        Arguments.of("cabbba", "aabbss", false));
  }

  @Test
  void wa1() {
    assertThat(p1657.closeStrings("uau", "ssx")).isFalse();
  }
}
