package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P540SingleElementInASortedArrayTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P540SingleElementInASortedArrayTest {

  private final P540SingleElementInASortedArray p540 = new P540SingleElementInASortedArray();

  @Test
  void example1() {
    assertThat(p540.singleNonDuplicate(new int[] {1, 1, 2, 3, 3, 4, 4, 8, 8})).isEqualTo(2);
  }

  @Test
  void example2() {
    assertThat(p540.singleNonDuplicate(new int[] {3, 3, 7, 7, 10, 11, 11})).isEqualTo(10);
  }

  @Test
  void singleElementAtStart() {
    assertThat(p540.singleNonDuplicate(new int[] {1, 2, 2, 3, 3, 4, 4})).isEqualTo(1);
  }

  @Test
  void singleElementAtEnd() {
    assertThat(p540.singleNonDuplicate(new int[] {1, 1, 2, 2, 3, 3, 4})).isEqualTo(4);
  }

  @Test
  void singleElement() {
    assertThat(p540.singleNonDuplicate(new int[] {1})).isEqualTo(1);
  }
}
