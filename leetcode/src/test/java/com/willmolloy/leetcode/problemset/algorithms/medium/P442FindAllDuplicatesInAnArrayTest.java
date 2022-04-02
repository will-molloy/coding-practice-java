package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P442FindAllDuplicatesInAnArrayTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P442FindAllDuplicatesInAnArrayTest {

  private final P442FindAllDuplicatesInAnArray p442 = new P442FindAllDuplicatesInAnArray();

  @Test
  void example() {
    assertThat(p442.findDuplicates(new int[] {4, 3, 2, 7, 8, 2, 3, 1})).containsExactly(2, 3);
  }
}
