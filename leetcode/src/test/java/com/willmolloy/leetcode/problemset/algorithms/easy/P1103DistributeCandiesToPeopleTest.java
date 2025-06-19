package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1103DistributeCandiesToPeopleTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1103DistributeCandiesToPeopleTest {

  private final P1103DistributeCandiesToPeople p1103 = new P1103DistributeCandiesToPeople();

  @ParameterizedTest
  @MethodSource
  void examples(int candies, int n, List<Integer> expected) {
    assertThat(p1103.distributeCandies(candies, n))
        .asList()
        .containsExactlyElementsIn(expected)
        .inOrder();
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(7, 4, List.of(1, 2, 3, 1)), Arguments.of(10, 3, List.of(5, 2, 3)));
  }
}
