package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P394DecodeStringTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P394DecodeStringTest {

  private final P394DecodeString p394 = new P394DecodeString();

  @ParameterizedTest
  @MethodSource
  void examples(String s, String expected) {
    assertThat(p394.decodeString(s)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("3[a]2[bc]", "aaabcbc"),
        Arguments.of("3[a2[c]]", "accaccacc"),
        Arguments.of("2[abc]3[cd]ef", "abcabccdcdcdef"),
        Arguments.of("abc3[cd]xyz", "abccdcdcdxyz"));
  }
}
