package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

/**
 * P1222QueensThatCanAttackTheKingTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1222QueensThatCanAttackTheKingTest {

  private final P1222QueensThatCanAttackTheKing p1222 = new P1222QueensThatCanAttackTheKing();

  @Test
  void example1() {
    assertThat(
            p1222.queensAttacktheKing(
                new int[][] {{0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}}, new int[] {0, 0}))
        .containsExactly(ImmutableList.of(0, 1), ImmutableList.of(1, 0), ImmutableList.of(3, 3));
  }

  @Test
  void example2() {
    assertThat(
            p1222.queensAttacktheKing(
                new int[][] {
                  {5, 6}, {7, 7}, {2, 1}, {0, 7}, {1, 6}, {5, 1}, {3, 7}, {0, 3}, {4, 0}, {1, 2},
                  {6, 3}, {5, 0}, {0, 4}, {2, 2}, {1, 1}, {6, 4}, {5, 4}, {0, 0}, {2, 6}, {4, 5},
                  {5, 2}, {1, 4}, {7, 5}, {2, 3}, {0, 5}, {4, 2}, {1, 0}, {2, 7}, {0, 1}, {4, 6},
                  {6, 1}, {0, 6}, {4, 3}, {1, 7}
                },
                new int[] {3, 4}))
        .containsExactly(
            ImmutableList.of(2, 3),
            ImmutableList.of(1, 4),
            ImmutableList.of(1, 6),
            ImmutableList.of(3, 7),
            ImmutableList.of(4, 3),
            ImmutableList.of(5, 4),
            ImmutableList.of(4, 5));
  }
}
