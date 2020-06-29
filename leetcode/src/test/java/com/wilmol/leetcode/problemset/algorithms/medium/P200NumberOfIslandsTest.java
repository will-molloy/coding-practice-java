package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P200NumberOfIslandsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P200NumberOfIslandsTest {

  private final P200NumberOfIslands fun = new P200NumberOfIslands();

  @Test
  void example1() {
    assertThat(
            fun.numIslands(
                new char[][] {
                  {'1', '1', '1', '1', '0'},
                  {'1', '1', '0', '1', '0'},
                  {'1', '1', '0', '0', '0'},
                  {'0', '0', '0', '0', '0'},
                }))
        .isEqualTo(1);
  }

  @Test
  void example2() {
    assertThat(
            fun.numIslands(
                new char[][] {
                  {'1', '1', '0', '0', '0'},
                  {'1', '1', '0', '0', '0'},
                  {'0', '0', '1', '0', '0'},
                  {'0', '0', '0', '1', '1'},
                }))
        .isEqualTo(3);
  }

  @Test
  void allZeroes() {
    assertThat(
            fun.numIslands(
                new char[][] {
                  {'0', '0'},
                  {'0', '0'},
                }))
        .isEqualTo(0);
  }

  @Test
  void allOnes() {
    assertThat(
            fun.numIslands(
                new char[][] {
                  {'1', '1'},
                  {'1', '1'},
                }))
        .isEqualTo(1);
  }
}
