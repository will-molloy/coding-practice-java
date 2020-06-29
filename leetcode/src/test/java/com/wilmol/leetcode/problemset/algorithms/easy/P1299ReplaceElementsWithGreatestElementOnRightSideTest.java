package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1299ReplaceElementsWithGreatestElementOnRightSideTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1299ReplaceElementsWithGreatestElementOnRightSideTest {

  private final P1299ReplaceElementsWithGreatestElementOnRightSide p1299 =
      new P1299ReplaceElementsWithGreatestElementOnRightSide();

  @Test
  void example() {
    assertThat(p1299.replaceElements(new int[] {17, 18, 5, 4, 6, 1}))
        .asList()
        .containsExactly(18, 6, 6, 6, 1, -1)
        .inOrder();
  }
}
