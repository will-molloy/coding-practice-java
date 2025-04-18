package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1592RearrangeSpacesBetweenWordsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1592RearrangeSpacesBetweenWordsTest {

  private final P1592RearrangeSpacesBetweenWords p1592 = new P1592RearrangeSpacesBetweenWords();

  @ParameterizedTest
  @MethodSource
  void examples(String text, String expected) {
    assertThat(p1592.reorderSpaces(text)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("  this   is  a sentence ", "this   is   a   sentence"),
        Arguments.of(" practice   makes   perfect", "practice   makes   perfect "),
        Arguments.of("hello   world", "hello   world"),
        Arguments.of("  walks  udp package   into  bar a", "walks  udp  package  into  bar  a "),
        Arguments.of("a", "a"));
  }

  @Test
  void singleWordSpacesAtFront() {
    assertThat(p1592.reorderSpaces("  hello")).isEqualTo("hello  ");
  }
}
