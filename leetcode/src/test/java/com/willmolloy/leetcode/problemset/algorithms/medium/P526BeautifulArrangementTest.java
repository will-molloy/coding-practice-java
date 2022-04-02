package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P526BeautifulArrangementTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P526BeautifulArrangementTest {

  private final P526BeautifulArrangement p526BeautifulArrangement = new P526BeautifulArrangement();

  @ParameterizedTest
  @MethodSource
  void examples(int n, int expected) {
    assertThat(p526BeautifulArrangement.countArrangement(n)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(Arguments.of(2, 2), Arguments.of(1, 1));
  }

  @Test
  void maxN() {
    assertThat(p526BeautifulArrangement.countArrangement(15)).isEqualTo(24679);
  }
}
