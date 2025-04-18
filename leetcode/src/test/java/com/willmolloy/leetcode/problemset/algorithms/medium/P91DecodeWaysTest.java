package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P91DecodeWaysTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P91DecodeWaysTest {

  @ParameterizedTest
  @MethodSource("funcs")
  void example1(P91DecodeWays func) {
    assertThat(func.numDecodings("12")).isEqualTo(2);
  }

  @ParameterizedTest
  @MethodSource("funcs")
  void example2(P91DecodeWays func) {
    assertThat(func.numDecodings("226")).isEqualTo(3);
  }

  @ParameterizedTest
  @MethodSource("funcs")
  void someSequencesOfSize2GreaterThan26(P91DecodeWays func) {
    assertThat(func.numDecodings("4425")).isEqualTo(2);
  }

  @ParameterizedTest
  @MethodSource("funcs")
  void allSequencesOfSize2GreaterThan26(P91DecodeWays func) {
    assertThat(func.numDecodings("999999999")).isEqualTo(1);
  }

  @ParameterizedTest
  @MethodSource("funcs")
  void allSequencesOfSize2LessThan26(P91DecodeWays func) {
    assertThat(func.numDecodings("111111111")).isEqualTo(55);
  }

  @ParameterizedTest
  @MethodSource("funcs")
  void zero(P91DecodeWays func) {
    assertThat(func.numDecodings("0")).isEqualTo(0);
  }

  @ParameterizedTest
  @MethodSource("funcs")
  void cantHaveSingleZeroes(P91DecodeWays func) {
    assertThat(func.numDecodings("101010")).isEqualTo(1);
  }

  @ParameterizedTest
  @MethodSource("funcs")
  void cantStartWithZero(P91DecodeWays func) {
    assertThat(func.numDecodings("07")).isEqualTo(0);
  }

  @ParameterizedTest
  @MethodSource("funcs")
  void cantEndWithZeroOrSequenceOfSize2GreaterThan26(P91DecodeWays func) {
    assertThat(func.numDecodings("260")).isEqualTo(0);
  }

  @ParameterizedTest
  @MethodSource("funcs")
  void largeInput(P91DecodeWays func) {
    assertThat(
            func.numDecodings(
                "17878977599662618259133152623772981325169695784412368332555969671325734822815"
                    + "98412163216914566534565"))
        .isEqualTo(5898240);
  }

  static Stream<Arguments> funcs() {
    return Stream.of(
        Arguments.of(new P91DecodeWays.TopDownWithMemoize()),
        Arguments.of(new P91DecodeWays.BottomUpDp()));
  }
}
