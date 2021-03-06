package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P820ShortEncodingOfWordsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P820ShortEncodingOfWordsTest {

  private final P820ShortEncodingOfWords p820ShortEncodingOfWords = new P820ShortEncodingOfWords();

  @ParameterizedTest
  @MethodSource
  void examples(String[] words, int expected) {
    assertThat(p820ShortEncodingOfWords.minimumLengthEncoding(words)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new String[] {"time", "me", "bell"}, 10), Arguments.of(new String[] {"t"}, 2));
  }

  @Test
  void duplicateWordCheckProperSuffix() {
    assertThat(
            p820ShortEncodingOfWords.minimumLengthEncoding(new String[] {"time", "time", "time"}))
        .isEqualTo(5);
  }
}
