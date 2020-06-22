package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-06-09. */
class P414ThirdMaximumNumberTest {

  private final P414ThirdMaximumNumber p414 = new P414ThirdMaximumNumber();

  @Test
  void example1ExactlyThreeElementsReturnThirdMax() {
    assertThat(p414.thirdMax(new int[] {3, 2, 1})).isEqualTo(1);
  }

  @Test
  void example2LessThanThreeElementsReturnMax() {
    assertThat(p414.thirdMax(new int[] {1, 2})).isEqualTo(2);
  }

  @Test
  void example3ExactlyThreeDistinctElementsReturnThirdDistinctMax() {
    assertThat(p414.thirdMax(new int[] {2, 2, 3, 1})).isEqualTo(1);
  }
}
