package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1560MostVisitedSectorInACircularTrackTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1560MostVisitedSectorInACircularTrackTest {

  private final P1560MostVisitedSectorInACircularTrack p1560 =
      new P1560MostVisitedSectorInACircularTrack();

  @ParameterizedTest
  @MethodSource
  void examples(int n, int[] rounds, List<Integer> expected) {
    assertThat(p1560.mostVisited(n, rounds)).containsExactlyElementsIn(expected).inOrder();
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(4, new int[] {1, 3, 1, 2}, ImmutableList.of(1, 2)),
        Arguments.of(2, new int[] {2, 1, 2, 1, 2, 1, 2, 1, 2}, ImmutableList.of(2)),
        Arguments.of(7, new int[] {1, 3, 5, 7}, ImmutableList.of(1, 2, 3, 4, 5, 6, 7)));
  }

  @Test
  void startGreaterThanEnd() {
    assertThat(p1560.mostVisited(3, new int[] {3, 2, 1, 2, 1, 3, 2, 1, 2, 1, 3, 2, 3, 1}))
        .containsExactly(1, 3)
        .inOrder();
  }

  @Test
  void doesntVisitAllSectors() {
    assertThat(p1560.mostVisited(4, new int[] {1, 2, 3})).containsExactly(1, 2, 3).inOrder();
  }
}
