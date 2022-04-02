package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P524LongestWordInDictionaryThroughDeletingTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P524LongestWordInDictionaryThroughDeletingTest {

  @ParameterizedTest
  @MethodSource
  void examples(String s, List<String> dictionary, String expected) {
    assertThat(new P524LongestWordInDictionaryThroughDeleting().findLongestWord(s, dictionary))
        .isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("abpcplea", List.of("ale", "apple", "monkey", "plea"), "apple"),
        Arguments.of("abpcplea", List.of("a", "b", "c"), "a"));
  }
}
