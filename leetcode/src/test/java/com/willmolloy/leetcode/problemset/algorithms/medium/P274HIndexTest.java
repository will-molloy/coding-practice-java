package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P274HIndexTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P274HIndexTest {

  private final P274HIndex p274 = new P274HIndex();

  @Test
  void example() {
    assertThat(p274.hIndex(new int[] {3, 0, 6, 1, 5})).isEqualTo(3);
  }

  @Test
  void exampleSorted() {
    assertThat(p274.hIndex(new int[] {0, 1, 3, 5, 6})).isEqualTo(3);
  }

  @Test
  void duplicates() {
    assertThat(p274.hIndex(new int[] {4, 4, 4, 4, 4, 4, 5})).isEqualTo(4);
  }

  @Test
  void hValueDiffersFromNumberOfCitations() {
    assertThat(p274.hIndex(new int[] {1, 3, 5, 7, 10, 20, 30, 40, 50})).isEqualTo(6);
  }

  @Test
  void noPapers() {
    assertThat(p274.hIndex(new int[0])).isEqualTo(0);
  }

  @Test
  void onePaperNoCitations() {
    assertThat(p274.hIndex(new int[] {0})).isEqualTo(0);
  }

  @Test
  void onePaperOneCitation() {
    assertThat(p274.hIndex(new int[] {1})).isEqualTo(1);
  }

  @Test
  void onePaperSeveralCitations() {
    assertThat(p274.hIndex(new int[] {100})).isEqualTo(1);
  }
}
