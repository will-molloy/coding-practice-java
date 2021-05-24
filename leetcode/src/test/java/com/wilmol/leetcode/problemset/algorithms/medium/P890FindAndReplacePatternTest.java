package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P890FindAndReplacePatternTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P890FindAndReplacePatternTest {

  private final P890FindAndReplacePattern p890FindAndReplacePattern =
      new P890FindAndReplacePattern();

  @ParameterizedTest
  @MethodSource
  void examples(String[] words, String pattern, Set<String> result) {
    assertThat(p890FindAndReplacePattern.findAndReplacePattern(words, pattern))
        .containsExactlyElementsIn(result);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(
            new String[] {"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb", Set.of("mee", "aqq")),
        Arguments.of(new String[] {"a", "b", "c"}, "a", Set.of("a", "b", "c")));
  }
}
