package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1583CountUnhappyFriendsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1583CountUnhappyFriendsTest {

  private final P1583CountUnhappyFriends p1583 = new P1583CountUnhappyFriends();

  @ParameterizedTest
  @MethodSource
  void examples(int n, int[][] preferences, int[][] pairs, int expected) {
    assertThat(p1583.unhappyFriends(n, preferences, pairs)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(
            4,
            new int[][] {{1, 2, 3}, {3, 2, 0}, {3, 1, 0}, {1, 2, 0}},
            new int[][] {{0, 1}, {2, 3}},
            2),
        Arguments.of(2, new int[][] {{1}, {0}}, new int[][] {{1, 0}}, 0),
        Arguments.of(
            4,
            new int[][] {{1, 3, 2}, {2, 3, 0}, {1, 3, 0}, {0, 2, 1}},
            new int[][] {{1, 3}, {0, 2}},
            4));
  }
}
