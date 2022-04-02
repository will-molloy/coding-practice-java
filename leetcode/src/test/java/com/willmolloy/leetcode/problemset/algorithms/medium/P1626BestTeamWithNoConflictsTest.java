package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1626BestTeamWithNoConflictsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1626BestTeamWithNoConflictsTest {

  private final P1626BestTeamWithNoConflicts p1626 = new P1626BestTeamWithNoConflicts();

  @ParameterizedTest
  @MethodSource
  void examples(int[] scores, int[] ages, int expected) {
    assertThat(p1626.bestTeamScore(scores, ages)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {1, 3, 5, 10, 15}, new int[] {1, 2, 3, 4, 5}, 34),
        Arguments.of(new int[] {4, 5, 6, 5}, new int[] {2, 1, 2, 1}, 16),
        Arguments.of(new int[] {1, 2, 3, 5}, new int[] {8, 9, 10, 1}, 6));
  }

  @Test
  void wrongAnswerIfTakingPlayersWithLargerScoreThanLast() {
    // incorrectly did 1+3 or 1x4, correct is 1x5
    assertThat(p1626.bestTeamScore(new int[] {1, 3, 1, 1, 1, 1}, new int[] {1, 2, 3, 4, 5, 6}))
        .isEqualTo(5);
  }

  @Test
  void wrongAnswerIfTakingPlayersWithSmallerScoreThanLast() {
    // incorrectly did 1+2+4+3+5 (conflict between 4+3)
    assertThat(p1626.bestTeamScore(new int[] {1, 2, 4, 3, 5}, new int[] {1, 2, 3, 4, 5}))
        .isEqualTo(12);
  }
}
