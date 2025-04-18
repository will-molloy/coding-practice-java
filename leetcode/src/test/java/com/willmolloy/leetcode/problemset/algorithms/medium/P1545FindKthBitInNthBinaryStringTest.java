package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1545FindKthBitInNthBinaryStringTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1545FindKthBitInNthBinaryStringTest {

  private final P1545FindKthBitInNthBinaryString p1545 = new P1545FindKthBitInNthBinaryString();

  @ParameterizedTest
  @MethodSource
  void examples(int n, int k, char expected) {
    assertThat(p1545.findKthBit(n, k)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(3, 1, '0'),
        Arguments.of(4, 11, '1'),
        Arguments.of(1, 1, '0'),
        Arguments.of(2, 3, '1'));
  }

  @Test
  void maxN() {
    assertThat(p1545.findKthBit(20, 1)).isEqualTo('0');
  }
}
