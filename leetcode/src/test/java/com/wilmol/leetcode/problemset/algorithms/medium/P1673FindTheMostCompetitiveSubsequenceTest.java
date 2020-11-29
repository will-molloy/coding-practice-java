package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1673FindTheMostCompetitiveSubsequenceTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1673FindTheMostCompetitiveSubsequenceTest {

  private final P1673FindTheMostCompetitiveSubsequence p1673 =
      new P1673FindTheMostCompetitiveSubsequence();

  @ParameterizedTest
  @MethodSource
  void examples(int[] nums, int k, List<Integer> expected) {
    assertThat(p1673.mostCompetitive(nums, k))
        .asList()
        .containsExactlyElementsIn(expected)
        .inOrder();
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {3, 5, 2, 6}, 2, List.of(2, 6)),
        Arguments.of(new int[] {2, 4, 3, 3, 5, 4, 9, 6}, 4, List.of(2, 3, 3, 4)));
  }

  @Test
  void notMonotonicToEnsureSizeK() {
    assertThat(p1673.mostCompetitive(new int[] {71, 18, 52, 29, 55, 73, 24, 42, 66, 8, 80, 2}, 3))
        .asList()
        .containsExactly(8, 80, 2);
  }
}
