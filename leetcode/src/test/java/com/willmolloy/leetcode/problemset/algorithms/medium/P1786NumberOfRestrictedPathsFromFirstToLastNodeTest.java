package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1786NumberOfRestrictedPathsFromFirstToLastNodeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1786NumberOfRestrictedPathsFromFirstToLastNodeTest {

  private final P1786NumberOfRestrictedPathsFromFirstToLastNode
      p1786NumberOfRestrictedPathsFromFirstToLastNode =
          new P1786NumberOfRestrictedPathsFromFirstToLastNode();

  @Test
  void example1() {
    assertThat(
            p1786NumberOfRestrictedPathsFromFirstToLastNode.countRestrictedPaths(
                5,
                new int[][] {
                  {1, 2, 3},
                  {1, 3, 3},
                  {2, 3, 1},
                  {1, 4, 2},
                  {5, 2, 2},
                  {3, 5, 1},
                  {5, 4, 10},
                }))
        .isEqualTo(3);
  }

  @Test
  void example2() {
    assertThat(
            p1786NumberOfRestrictedPathsFromFirstToLastNode.countRestrictedPaths(
                7,
                new int[][] {
                  {1, 3, 1},
                  {4, 1, 2},
                  {7, 3, 4},
                  {2, 5, 3},
                  {5, 6, 1},
                  {6, 7, 2},
                  {7, 5, 3},
                  {2, 6, 4},
                }))
        .isEqualTo(1);
  }
}
