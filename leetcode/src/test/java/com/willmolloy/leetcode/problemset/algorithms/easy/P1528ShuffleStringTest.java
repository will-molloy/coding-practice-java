package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1528ShuffleStringTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1528ShuffleStringTest {

  private final P1528ShuffleString p1528 = new P1528ShuffleString();

  @ParameterizedTest
  @MethodSource
  void examples(String s, int[] indices, String expected) {
    assertThat(p1528.restoreString(s, indices)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("codeleet", new int[] {4, 5, 6, 7, 0, 2, 1, 3}, "leetcode"),
        Arguments.of("abc", new int[] {0, 1, 2}, "abc"),
        Arguments.of("aiohn", new int[] {3, 1, 4, 2, 0}, "nihao"),
        Arguments.of("aaiougrt", new int[] {4, 0, 2, 6, 7, 3, 1, 5}, "arigatou"),
        Arguments.of("art", new int[] {1, 0, 2}, "rat"));
  }
}
