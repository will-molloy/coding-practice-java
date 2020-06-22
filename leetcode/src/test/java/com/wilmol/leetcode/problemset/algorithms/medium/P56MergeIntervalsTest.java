package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/** Created by wilmol on 2019-12-02. */
class P56MergeIntervalsTest {

  @ParameterizedTest
  @MethodSource("funs")
  void example1(P56MergeIntervals fun) {
    assertThat(fun.merge(new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}}))
        .isEqualTo(new int[][] {{1, 6}, {8, 10}, {15, 18}});
  }

  @ParameterizedTest
  @MethodSource("funs")
  void example2(P56MergeIntervals fun) {
    assertThat(fun.merge(new int[][] {{1, 4}, {4, 5}})).isEqualTo(new int[][] {{1, 5}});
  }

  @ParameterizedTest
  @MethodSource("funs")
  void withDoubleMerge(P56MergeIntervals fun) {
    assertThat(fun.merge(new int[][] {{1, 2}, {3, 4}, {2, 3}})).isEqualTo(new int[][] {{1, 4}});
  }

  @ParameterizedTest
  @MethodSource("funs")
  void firstRangeIsEnclosing(P56MergeIntervals fun) {
    assertThat(fun.merge(new int[][] {{1, 4}, {2, 3}})).isEqualTo(new int[][] {{1, 4}});
  }

  @ParameterizedTest
  @MethodSource("funs")
  void secondRangeIsEnclosing(P56MergeIntervals fun) {
    assertThat(fun.merge(new int[][] {{2, 3}, {1, 4}})).isEqualTo(new int[][] {{1, 4}});
  }

  static Stream<Arguments> funs() {
    return Stream.of(
        Arguments.of(new P56MergeIntervals.MergeIntervalsInEncounterOrder()),
        Arguments.of(new P56MergeIntervals.SortFirst()));
  }
}
