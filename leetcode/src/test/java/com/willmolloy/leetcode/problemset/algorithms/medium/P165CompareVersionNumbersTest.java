package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P165CompareVersionNumbersTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P165CompareVersionNumbersTest {

  private final P165CompareVersionNumbers p165 = new P165CompareVersionNumbers();

  @ParameterizedTest
  @MethodSource
  void examples(String v1, String v2, int expected) {
    assertThat(p165.compareVersion(v1, v2)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("0.1", "1.1", -1),
        Arguments.of("1.0.1", "1", 1),
        Arguments.of("7.5.2.4", "7.5.3", -1),
        Arguments.of("1.01", "1.001", 0),
        Arguments.of("1.0", "1.0.0", 0));
  }
}
