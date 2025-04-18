package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1689PartitioningIntoMinimumNumberOfDeciBinaryNumbersTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1689PartitioningIntoMinimumNumberOfDeciBinaryNumbersTest {

  private final P1689PartitioningIntoMinimumNumberOfDeciBinaryNumbers
      p1689PartitioningIntoMinimumNumberOfDeciBinaryNumbers =
          new P1689PartitioningIntoMinimumNumberOfDeciBinaryNumbers();

  @ParameterizedTest
  @MethodSource
  void examples(String n, int expected) {
    assertThat(p1689PartitioningIntoMinimumNumberOfDeciBinaryNumbers.minPartitions(n))
        .isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("32", 3), Arguments.of("82734", 8), Arguments.of("27346209830709182346", 9));
  }
}
