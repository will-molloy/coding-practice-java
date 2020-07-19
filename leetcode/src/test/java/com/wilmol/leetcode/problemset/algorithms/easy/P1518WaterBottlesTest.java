package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1518WaterBottlesTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1518WaterBottlesTest {

  private final P1518WaterBottles p1518 = new P1518WaterBottles();

  @ParameterizedTest
  @MethodSource
  void examples(int numBottles, int numExchange, int expected) {
    assertThat(p1518.numWaterBottles(numBottles, numExchange)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(9, 3, 13),
        Arguments.of(15, 4, 19),
        Arguments.of(5, 5, 6),
        Arguments.of(2, 3, 2));
  }

  @Test
  void worstCaseRuntime() {
    assertThat(p1518.numWaterBottles(100, 2)).isEqualTo(199);
  }
}
