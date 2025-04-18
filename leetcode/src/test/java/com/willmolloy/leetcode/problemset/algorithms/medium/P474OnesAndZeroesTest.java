package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P474OnesAndZeroesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P474OnesAndZeroesTest {

  private final P474OnesAndZeroes p474OnesAndZeroes = new P474OnesAndZeroes();

  @ParameterizedTest
  @MethodSource
  void examples(String[] strs, int m, int n, int expected) {
    assertThat(p474OnesAndZeroes.findMaxForm(strs, m, n)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new String[] {"10", "0001", "111001", "1", "0"}, 5, 3, 4),
        Arguments.of(new String[] {"10", "0", "1"}, 1, 1, 2));
  }
}
