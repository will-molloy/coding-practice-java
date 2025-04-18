package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P264UglyNumber2Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P264UglyNumber2Test {

  private final P264UglyNumber2 fun = new P264UglyNumber2();

  @Test
  void example1() {
    assertThat(fun.nthUglyNumber(10)).isEqualTo(12);
  }
}
