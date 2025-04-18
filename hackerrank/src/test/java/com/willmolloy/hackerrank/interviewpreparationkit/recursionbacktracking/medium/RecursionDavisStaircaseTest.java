package com.willmolloy.hackerrank.interviewpreparationkit.recursionbacktracking.medium;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * RecursionDavisStaircaseTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class RecursionDavisStaircaseTest {

  @Test()
  void negativeInput() {
    assertThrows(IllegalArgumentException.class, () -> RecursionDavisStaircase.stepPerms(-1));
  }

  @ParameterizedTest(name = "stairs = {0}, expectedWaysToClimb = {1}")
  @MethodSource("input")
  void oneStair(int stairs, int expectedWaysToClimb) {
    assertThat(RecursionDavisStaircase.stepPerms(stairs)).isEqualTo(expectedWaysToClimb);
  }

  static Stream<Arguments> input() {
    return Stream.of(
        Arguments.of(0, 1),
        Arguments.of(1, 1),
        Arguments.of(2, 2),
        Arguments.of(3, 4),
        Arguments.of(4, 7),
        Arguments.of(5, 13),
        Arguments.of(7, 44));
  }
}
