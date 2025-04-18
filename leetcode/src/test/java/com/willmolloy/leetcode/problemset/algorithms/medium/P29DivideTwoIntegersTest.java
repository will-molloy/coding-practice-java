package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P29DivideTwoIntegersTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P29DivideTwoIntegersTest {

  private final P29DivideTwoIntegers fun = new P29DivideTwoIntegers();

  @Test
  void example1() {
    assertThat(fun.divide(10, 3)).isEqualTo(3);
  }

  @Test
  void example2() {
    assertThat(fun.divide(7, -3)).isEqualTo(-2);
  }

  @Test
  void overflow() {
    assertThat(fun.divide(Integer.MIN_VALUE, -1)).isEqualTo(Integer.MAX_VALUE);
  }

  @Test
  void maxValue() {
    assertThat(fun.divide(Integer.MAX_VALUE, -1)).isEqualTo(-Integer.MAX_VALUE);
  }
}
