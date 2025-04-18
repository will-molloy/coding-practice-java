package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1041RobotBoundedInCircleTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1041RobotBoundedInCircleTest {

  private final P1041RobotBoundedInCircle p1041 = new P1041RobotBoundedInCircle();

  @ParameterizedTest
  @MethodSource
  void examples(String instructions, boolean expected) {
    assertThat(p1041.isRobotBounded(instructions)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("GGLLGG", true), Arguments.of("GG", false), Arguments.of("GL", true));
  }
}
