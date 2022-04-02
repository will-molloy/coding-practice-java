package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P316RemoveDuplicateLettersTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P316RemoveDuplicateLettersTest {

  private final P316RemoveDuplicateLetters p316 = new P316RemoveDuplicateLetters();

  @ParameterizedTest
  @MethodSource
  void examples(String s, String expected) {
    assertThat(p316.removeDuplicateLetters(s)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(Arguments.of("bcabc", "abc"), Arguments.of("cbacdcbc", "acdb"));
  }
}
