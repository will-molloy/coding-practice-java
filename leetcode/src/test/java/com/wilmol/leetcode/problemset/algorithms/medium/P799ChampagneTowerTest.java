package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P799ChampagneTowerTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P799ChampagneTowerTest {

  private final P799ChampagneTower p799 = new P799ChampagneTower();

  @ParameterizedTest
  @MethodSource
  void examples(int poured, int queryRow, int queryGlass, double expected) {
    assertThat(p799.champagneTower(poured, queryRow, queryGlass)).isWithin(0.02).of(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(1, 1, 1, 0), Arguments.of(2, 1, 1, 0.5), Arguments.of(100000009, 33, 17, 1));
  }
}
