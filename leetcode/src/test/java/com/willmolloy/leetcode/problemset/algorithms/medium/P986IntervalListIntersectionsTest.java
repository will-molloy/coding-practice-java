package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P986IntervalListIntersectionsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P986IntervalListIntersectionsTest {

  @ParameterizedTest
  @MethodSource("p986")
  void example(P986IntervalListIntersections p986) {
    assertThat(
            p986.intervalIntersection(
                new int[][] {{0, 2}, {5, 10}, {13, 23}, {24, 25}},
                new int[][] {{1, 5}, {8, 12}, {15, 24}, {25, 26}}))
        .isEqualTo(new int[][] {{1, 2}, {5, 5}, {8, 10}, {15, 23}, {24, 24}, {25, 25}});
  }

  static Stream<P986IntervalListIntersections> p986() {
    return Stream.of(
        new P986IntervalListIntersections.Quadratic(), new P986IntervalListIntersections.Linear());
  }
}
