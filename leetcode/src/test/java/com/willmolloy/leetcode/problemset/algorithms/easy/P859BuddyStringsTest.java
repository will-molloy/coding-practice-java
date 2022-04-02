package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P859BuddyStringsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P859BuddyStringsTest {

  private final P859BuddyStrings p859 = new P859BuddyStrings();

  @ParameterizedTest
  @MethodSource
  void examples(String a, String b, boolean expected) {
    assertThat(p859.buddyStrings(a, b)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("ab", "ba", true),
        Arguments.of("ab", "ab", false),
        Arguments.of("aa", "aa", true),
        Arguments.of("aaaaaaabc", "aaaaaaacb", true),
        Arguments.of("", "aa", false));
  }
}
