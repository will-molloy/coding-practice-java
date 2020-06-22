package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-24. */
class P268MissingNumberTest {

  private final P268MissingNumber p268 = new P268MissingNumber();

  @Test
  void example1() {
    assertThat(p268.missingNumber(new int[] {3, 0, 1})).isEqualTo(2);
  }

  @Test
  void example2() {
    assertThat(p268.missingNumber(new int[] {9, 6, 4, 2, 3, 5, 7, 0, 1})).isEqualTo(8);
  }

  @Test
  void equalsZero() {
    assertThat(p268.missingNumber(new int[] {1, 2, 3})).isEqualTo(0);
  }
}
