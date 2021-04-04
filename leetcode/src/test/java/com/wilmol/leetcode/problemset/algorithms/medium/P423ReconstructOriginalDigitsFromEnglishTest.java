package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P423ReconstructOriginalDigitsFromEnglishTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P423ReconstructOriginalDigitsFromEnglishTest {

  private final P423ReconstructOriginalDigitsFromEnglish p423ReconstructOriginalDigitsFromEnglish =
      new P423ReconstructOriginalDigitsFromEnglish();

  @ParameterizedTest
  @MethodSource
  void examples(String s, String expected) {
    assertThat(p423ReconstructOriginalDigitsFromEnglish.originalDigits(s)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(Arguments.of("owoztneoer", "012"), Arguments.of("fviefuro", "45"));
  }
}
