package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1647MinimumDeletionsToMakeCharacterFrequenciesUniqueTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1647MinimumDeletionsToMakeCharacterFrequenciesUniqueTest {

  private final P1647MinimumDeletionsToMakeCharacterFrequenciesUnique p1647 =
      new P1647MinimumDeletionsToMakeCharacterFrequenciesUnique();

  @ParameterizedTest
  @MethodSource
  void examples(String s, int expected) {
    assertThat(p1647.minDeletions(s)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("aab", 0), Arguments.of("aaabbbcc", 2), Arguments.of("ceabaacb", 2));
  }

  @Test
  void tle1() {
    assertThat(p1647.minDeletions("abcdefghijklmnopqrstuvwxwz")).isEqualTo(23);
  }

  @Test
  void wa1() {
    assertThat(p1647.minDeletions("odofingjfdncnecmfdekekchbbicbflkoanohamkcjljbfmahhbnkiangdal"))
        .isEqualTo(39);
  }
}
