package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-06-19. */
class P275HIndex2Test {

  private final P275HIndex2 p275 = new P275HIndex2();

  @Test
  void example() {
    assertThat(p275.hIndex(new int[] {0, 1, 3, 5, 6})).isEqualTo(3);
  }

  @Test
  void duplicates() {
    assertThat(p275.hIndex(new int[] {4, 4, 4, 4, 4, 4, 5})).isEqualTo(4);
  }

  @Test
  void hValueDiffersFromNumberOfCitations() {
    assertThat(p275.hIndex(new int[] {1, 3, 5, 7, 10, 20, 30, 40, 50})).isEqualTo(6);
  }

  @Test
  void noPapers() {
    assertThat(p275.hIndex(new int[0])).isEqualTo(0);
  }

  @Test
  void onePaperNoCitations() {
    assertThat(p275.hIndex(new int[] {0})).isEqualTo(0);
  }

  @Test
  void onePaperOneCitation() {
    assertThat(p275.hIndex(new int[] {1})).isEqualTo(1);
  }

  @Test
  void onePaperSeveralCitations() {
    assertThat(p275.hIndex(new int[] {100})).isEqualTo(1);
  }
}
