package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1395CountNumberOfTeamsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1395CountNumberOfTeamsTest {

  @ParameterizedTest
  @MethodSource("funs")
  void example1(P1395CountNumberOfTeams fun) {
    assertThat(fun.numTeams(new int[] {2, 5, 3, 4, 1})).isEqualTo(3);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void example2(P1395CountNumberOfTeams fun) {
    assertThat(fun.numTeams(new int[] {2, 1, 3})).isEqualTo(0);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void example3(P1395CountNumberOfTeams fun) {
    assertThat(fun.numTeams(new int[] {1, 2, 3, 4})).isEqualTo(4);
  }

  static Stream<P1395CountNumberOfTeams> funs() {
    return Stream.of(
        new P1395CountNumberOfTeams.Cubic(),
        new P1395CountNumberOfTeams.Quadratic(),
        new P1395CountNumberOfTeams.Linearithmic());
  }
}
