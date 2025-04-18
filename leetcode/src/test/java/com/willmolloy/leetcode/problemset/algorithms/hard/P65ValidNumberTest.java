package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P65ValidNumberTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P65ValidNumberTest {

  private final P65ValidNumber p65ValidNumber = new P65ValidNumber();

  @ParameterizedTest
  @MethodSource
  void examples(String s, boolean expected) {
    assertThat(p65ValidNumber.isNumber(s)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("0", true),
        Arguments.of("e", false),
        Arguments.of(".", false),
        Arguments.of(".1", true));
  }
}
