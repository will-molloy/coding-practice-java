package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P948BagOfTokensTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P948BagOfTokensTest {

  private final P948BagOfTokens p948 = new P948BagOfTokens();

  @ParameterizedTest
  @MethodSource
  void examples(int[] tokens, int p, int expected) {
    assertThat(p948.bagOfTokensScore(tokens, p)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {100}, 50, 0),
        Arguments.of(new int[] {100, 200}, 150, 1),
        Arguments.of(new int[] {100, 200, 300, 400}, 200, 2));
  }
}
