package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1680ConcatenationOfConsecutiveBinaryNumbersTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1680ConcatenationOfConsecutiveBinaryNumbersTest {

  private final P1680ConcatenationOfConsecutiveBinaryNumbers
      p1680ConcatenationOfConsecutiveBinaryNumbers =
          new P1680ConcatenationOfConsecutiveBinaryNumbers();

  @ParameterizedTest
  @MethodSource
  void examples(int n, int expected) {
    assertThat(p1680ConcatenationOfConsecutiveBinaryNumbers.concatenatedBinary(n))
        .isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(Arguments.of(1, 1), Arguments.of(3, 27), Arguments.of(12, 505379714));
  }
}
