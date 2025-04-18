package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1344AngleBetweenHandsOfAClockTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1344AngleBetweenHandsOfAClockTest {

  private final P1344AngleBetweenHandsOfAClock p1344 = new P1344AngleBetweenHandsOfAClock();

  @ParameterizedTest
  @MethodSource
  void examples(int hour, int minutes, double angle) {
    assertThat(p1344.angleClock(hour, minutes)).isWithin(1e-5).of(angle);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(12, 30, 165),
        Arguments.of(3, 30, 75),
        Arguments.of(3, 15, 7.5),
        Arguments.of(4, 50, 155),
        Arguments.of(12, 0, 0));
  }

  @Test
  void requireSmallerAngle() {
    assertThat(p1344.angleClock(1, 57)).isWithin(1e-5).of(76.5);
  }

  @Test
  void angleIs180() {
    assertThat(p1344.angleClock(6, 0)).isWithin(1e-5).of(180);
  }
}
