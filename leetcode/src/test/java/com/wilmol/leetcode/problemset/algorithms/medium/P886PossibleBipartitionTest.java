package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P886PossibleBipartitionTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P886PossibleBipartitionTest {

  private final P886PossibleBipartition p886 = new P886PossibleBipartition();

  @Test
  void example1() {
    assertThat(p886.possibleBipartition(4, new int[][] {{1, 2}, {1, 3}, {2, 4}})).isTrue();
  }

  @Test
  void example2() {
    assertThat(p886.possibleBipartition(3, new int[][] {{1, 2}, {1, 3}, {2, 3}})).isFalse();
  }

  @Test
  void example3() {
    assertThat(p886.possibleBipartition(5, new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}}))
        .isFalse();
  }

  @Test
  void triangle() {
    assertThat(p886.possibleBipartition(3, new int[][] {{1, 2}, {2, 3}, {1, 3}})).isFalse();
  }

  @Test
  void disjointGraphHasTwoSources() {
    assertThat(p886.possibleBipartition(5, new int[][] {{1, 2}, {3, 4}, {4, 5}, {3, 5}})).isFalse();
  }
}
