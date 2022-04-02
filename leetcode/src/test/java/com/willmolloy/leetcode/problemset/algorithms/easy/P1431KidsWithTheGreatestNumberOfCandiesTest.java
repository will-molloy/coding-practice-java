package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1431KidsWithTheGreatestNumberOfCandiesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1431KidsWithTheGreatestNumberOfCandiesTest {

  private final P1431KidsWithTheGreatestNumberOfCandies p1431 =
      new P1431KidsWithTheGreatestNumberOfCandies();

  @Test
  void example1() {
    assertThat(p1431.kidsWithCandies(new int[] {2, 3, 5, 1, 3}, 3))
        .containsExactly(true, true, true, false, true)
        .inOrder();
  }

  @Test
  void example2() {
    assertThat(p1431.kidsWithCandies(new int[] {4, 2, 1, 1, 2}, 1))
        .containsExactly(true, false, false, false, false)
        .inOrder();
  }

  @Test
  void example3() {
    assertThat(p1431.kidsWithCandies(new int[] {12, 1, 12}, 10))
        .containsExactly(true, false, true)
        .inOrder();
  }
}
