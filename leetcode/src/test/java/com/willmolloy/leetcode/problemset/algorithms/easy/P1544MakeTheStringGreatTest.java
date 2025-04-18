package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1544MakeTheStringGreatTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1544MakeTheStringGreatTest {

  private final P1544MakeTheStringGreat p1544 = new P1544MakeTheStringGreat();

  @ParameterizedTest
  @MethodSource
  void examples(String s, String expected) {
    assertThat(p1544.makeGood(s)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("leEeetcode", "leetcode"), Arguments.of("abBAcC", ""), Arguments.of("s", "s"));
  }

  @Test
  void worstCaseRuntime() {
    assertThat(p1544.makeGood("abcdefgGFEDCBA")).isEmpty();
  }
}
