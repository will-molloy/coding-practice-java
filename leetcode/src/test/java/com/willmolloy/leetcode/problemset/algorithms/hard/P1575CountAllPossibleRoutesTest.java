package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1575CountAllPossibleRoutesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1575CountAllPossibleRoutesTest {

  private final P1575CountAllPossibleRoutes p1575CountAllPossibleRoutes =
      new P1575CountAllPossibleRoutes();

  @ParameterizedTest
  @MethodSource
  void examples(int[] locations, int start, int finish, int fuel, int expected) {
    assertThat(p1575CountAllPossibleRoutes.countRoutes(locations, start, finish, fuel))
        .isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {2, 3, 6, 8, 4}, 1, 3, 5, 4),
        Arguments.of(new int[] {4, 3, 1}, 1, 0, 6, 5),
        Arguments.of(new int[] {5, 2, 1}, 0, 2, 3, 0),
        Arguments.of(new int[] {2, 1, 5}, 0, 0, 3, 2),
        Arguments.of(new int[] {1, 2, 3}, 0, 2, 40, 615088286));
  }
}
