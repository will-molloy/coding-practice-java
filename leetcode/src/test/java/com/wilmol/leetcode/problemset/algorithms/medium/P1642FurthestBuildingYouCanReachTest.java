package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.testlib.TestLib;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1642FurthestBuildingYouCanReachTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1642FurthestBuildingYouCanReachTest {

  @ParameterizedTest
  @MethodSource
  void examples(
      P1642FurthestBuildingYouCanReach p1642,
      int[] heights,
      int bricks,
      int ladders,
      int expected) {
    assertThat(p1642.furthestBuilding(heights, bricks, ladders)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return TestLib.cartesianProduct(
        solutions(),
        Stream.of(
            Arguments.of(new int[] {4, 2, 7, 6, 9, 14, 12}, 5, 1, 4),
            Arguments.of(new int[] {4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2, 7),
            Arguments.of(new int[] {14, 3, 19, 3}, 17, 0, 3)));
  }

  @ParameterizedTest
  @MethodSource("solutions")
  void bricksFirstIsWrong(P1642FurthestBuildingYouCanReach p1642) {
    assertThat(p1642.furthestBuilding(new int[] {1, 61, 62, 63, 64, 65}, 60, 1)).isEqualTo(5);
  }

  static Stream<P1642FurthestBuildingYouCanReach> solutions() {
    return Stream.of(
        new P1642FurthestBuildingYouCanReach.Dfs(), new P1642FurthestBuildingYouCanReach.Greedy());
  }
}
