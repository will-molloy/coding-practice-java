package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P136SingleNumberTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P136SingleNumberTest {

  private final P136SingleNumber fun = new P136SingleNumber();

  @Test
  void example1() {
    assertThat(fun.singleNumber(new int[] {2, 2, 1})).isEqualTo(1);
  }

  @Test
  void example2() {
    assertThat(fun.singleNumber(new int[] {4, 1, 2, 1, 2})).isEqualTo(4);
  }
}
