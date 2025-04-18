package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1694ReformatPhoneNumberTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1694ReformatPhoneNumberTest {

  private final P1694ReformatPhoneNumber p1694ReformatPhoneNumber = new P1694ReformatPhoneNumber();

  @ParameterizedTest
  @MethodSource
  void examples(String number, String expected) {
    assertThat(p1694ReformatPhoneNumber.reformatNumber(number)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("1-23-45 6", "123-456"),
        Arguments.of("123 4-567", "123-45-67"),
        Arguments.of("123 4-5678", "123-456-78"));
  }
}
