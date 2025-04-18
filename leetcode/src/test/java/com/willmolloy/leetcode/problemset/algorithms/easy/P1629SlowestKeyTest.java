package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1629SlowestKeyTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1629SlowestKeyTest {

  private final P1629SlowestKey p1629 = new P1629SlowestKey();

  @ParameterizedTest
  @MethodSource
  void examples(int[] releaseTimes, String keysPressed, char expected) {
    assertThat(p1629.slowestKey(releaseTimes, keysPressed)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {9, 29, 49, 50}, "cbcd", 'c'),
        Arguments.of(new int[] {12, 23, 36, 46, 62}, "spuda", 'a'));
  }
}
