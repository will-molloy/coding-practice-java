package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P4MedianOfTwoSortedArraysTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P4MedianOfTwoSortedArraysTest {

  private static final int[] EMPTY = new int[0];

  private final P4MedianOfTwoSortedArrays function = new P4MedianOfTwoSortedArrays();

  @Test
  void oneOddSizedOneEvenSized() {
    assertThat(function.findMedianSortedArrays(new int[] {1, 3}, new int[] {2})).isEqualTo(2d);
  }

  @Test
  void bothEvenSized() {
    assertThat(function.findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4})).isEqualTo(2.5d);
  }

  @Test
  void oneOddSizedOneEmpty() {
    assertThat(function.findMedianSortedArrays(new int[] {1, 2, 3}, EMPTY)).isEqualTo(2d);
  }

  @Test
  void oneEventSizedOneEmpty() {
    assertThat(function.findMedianSortedArrays(new int[] {1, 2, 3, 4}, EMPTY)).isEqualTo(2.5d);
  }
}
