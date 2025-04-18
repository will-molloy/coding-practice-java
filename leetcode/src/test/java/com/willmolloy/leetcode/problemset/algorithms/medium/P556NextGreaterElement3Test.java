package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P556NextGreaterElement3Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P556NextGreaterElement3Test {

  private final P556NextGreaterElement3 p556NextGreaterElement3 = new P556NextGreaterElement3();

  @ParameterizedTest
  @MethodSource
  void examples(int n, int expected) {
    assertThat(p556NextGreaterElement3.nextGreaterElement(n)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(Arguments.of(12, 21), Arguments.of(21, -1));
  }
}
