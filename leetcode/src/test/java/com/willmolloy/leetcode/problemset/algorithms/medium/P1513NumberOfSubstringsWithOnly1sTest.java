package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.base.Strings;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1513NumberOfSubstringsWithOnly1sTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1513NumberOfSubstringsWithOnly1sTest {

  private final P1513NumberOfSubstringsWithOnly1s p1513 = new P1513NumberOfSubstringsWithOnly1s();

  @ParameterizedTest
  @MethodSource
  void examples(String s, int expected) {
    assertThat(p1513.numSub(s)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("0110111", 9),
        Arguments.of("101", 2),
        Arguments.of("111111", 21),
        Arguments.of("000", 0));
  }

  @Test
  void overflow() {
    assertThat(p1513.numSub(Strings.repeat("1", (int) 1e5))).isEqualTo(49965);
  }
}
