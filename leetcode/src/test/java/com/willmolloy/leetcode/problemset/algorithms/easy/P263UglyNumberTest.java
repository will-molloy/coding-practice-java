package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P263UglyNumberTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P263UglyNumberTest {

  private final P263UglyNumber fun = new P263UglyNumber();

  @Test
  void example1() {
    assertThat(fun.isUgly(6)).isTrue();
  }

  @Test
  void example2() {
    assertThat(fun.isUgly(8)).isTrue();
  }

  @Test
  void example3() {
    assertThat(fun.isUgly(14)).isFalse();
  }

  @Test
  void zero() {
    assertThat(fun.isUgly(0)).isFalse();
  }

  @Test
  void one() {
    assertThat(fun.isUgly(1)).isTrue();
  }
}
