package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P354RussianDollEnvelopesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P354RussianDollEnvelopesTest {

  private final P354RussianDollEnvelopes p354RussianDollEnvelopes = new P354RussianDollEnvelopes();

  @ParameterizedTest
  @MethodSource
  void examples(int[][] envelopes, int expected) {
    assertThat(p354RussianDollEnvelopes.maxEnvelopes(envelopes)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[][] {{5, 4}, {6, 4}, {6, 7}, {2, 3}}, 3),
        Arguments.of(new int[][] {{1, 1}, {1, 1}, {1, 1}}, 1));
  }
}
