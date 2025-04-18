package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1688CountOfMatchesInTournamentTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1688CountOfMatchesInTournamentTest {

  private final P1688CountOfMatchesInTournament p1688CountOfMatchesInTournament =
      new P1688CountOfMatchesInTournament();

  @ParameterizedTest
  @MethodSource
  void examples(int n, int expected) {
    assertThat(p1688CountOfMatchesInTournament.numberOfMatches(n)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(Arguments.of(7, 6), Arguments.of(14, 13));
  }
}
