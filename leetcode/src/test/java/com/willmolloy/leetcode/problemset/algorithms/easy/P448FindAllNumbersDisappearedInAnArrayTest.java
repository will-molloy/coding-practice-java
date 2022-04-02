package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P448FindAllNumbersDisappearedInAnArrayTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P448FindAllNumbersDisappearedInAnArrayTest {

  private final P448FindAllNumbersDisappearedInAnArray p448 =
      new P448FindAllNumbersDisappearedInAnArray();

  @Test
  void example() {
    // assuming order doesn't matter?
    assertThat(p448.findDisappearedNumbers(new int[] {4, 3, 2, 7, 8, 2, 3, 1}))
        .containsExactly(5, 6);
  }
}
