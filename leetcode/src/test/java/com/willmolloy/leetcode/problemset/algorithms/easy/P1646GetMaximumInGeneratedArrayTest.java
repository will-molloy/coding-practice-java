package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1646GetMaximumInGeneratedArrayTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1646GetMaximumInGeneratedArrayTest {

  private final P1646GetMaximumInGeneratedArray p1646 = new P1646GetMaximumInGeneratedArray();

  @ParameterizedTest
  @MethodSource
  void examples(int n, int expected) {
    assertThat(p1646.getMaximumGenerated(n)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(Arguments.of(7, 3), Arguments.of(2, 1), Arguments.of(3, 2));
  }

  @Test
  void empty() {
    assertThat(p1646.getMaximumGenerated(0)).isEqualTo(0);
  }
}
