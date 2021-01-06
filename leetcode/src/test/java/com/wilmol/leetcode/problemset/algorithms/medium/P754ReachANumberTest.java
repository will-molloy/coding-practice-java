package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P754ReachANumberTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P754ReachANumberTest {

  private final P754ReachANumber p754ReachANumber = new P754ReachANumber();

  @ParameterizedTest
  @MethodSource
  void examples(int target, int expected) {
    assertThat(p754ReachANumber.reachNumber(target)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(Arguments.of(3, 2), Arguments.of(2, 3));
  }
}
