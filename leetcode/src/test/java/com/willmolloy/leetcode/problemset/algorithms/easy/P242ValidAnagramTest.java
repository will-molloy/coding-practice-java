package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P242ValidAnagramTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P242ValidAnagramTest {

  private final P242ValidAnagram p242ValidAnagram = new P242ValidAnagram();

  @ParameterizedTest
  @MethodSource
  void examples(String s, String t, boolean expected) {
    assertThat(p242ValidAnagram.isAnagram(s, t)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(Arguments.of("anagram", "nagaram", true), Arguments.of("rat", "car", false));
  }
}
