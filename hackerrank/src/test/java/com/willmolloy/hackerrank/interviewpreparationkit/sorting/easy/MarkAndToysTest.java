package com.willmolloy.hackerrank.interviewpreparationkit.sorting.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * MarkAndToysTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class MarkAndToysTest {

  @Test
  void sampleTestCase0() {
    assertThat(MarkAndToys.maximumToys(new int[] {1, 12, 5, 111, 200, 1000, 10}, 50)).isEqualTo(4);
  }

  @Test
  void sampleTestCase1() {
    assertThat(MarkAndToys.maximumToys(new int[] {1, 2, 3, 4}, 7)).isEqualTo(3);
  }

  @Test
  void sampleTestCase2() {
    assertThat(MarkAndToys.maximumToys(new int[] {3, 7, 2, 9, 4}, 15)).isEqualTo(3);
  }

  @Test
  void singleToyWithExactPrice() {
    assertThat(MarkAndToys.maximumToys(new int[] {50}, 50)).isEqualTo(1);
  }
}
