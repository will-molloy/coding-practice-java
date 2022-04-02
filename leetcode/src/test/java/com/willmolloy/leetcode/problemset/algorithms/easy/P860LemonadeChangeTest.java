package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P860LemonadeChangeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P860LemonadeChangeTest {

  private final P860LemonadeChange fun = new P860LemonadeChange();

  @Test
  void example1() {
    assertThat(fun.lemonadeChange(new int[] {5, 5, 5, 10, 20})).isTrue();
  }

  @Test
  void example2() {
    assertThat(fun.lemonadeChange(new int[] {5, 5, 10})).isTrue();
  }

  @Test
  void example3() {
    assertThat(fun.lemonadeChange(new int[] {10, 10})).isFalse();
  }

  @Test
  void example4() {
    assertThat(fun.lemonadeChange(new int[] {5, 5, 10, 10, 20})).isFalse();
  }

  @Test
  void sparinglyUseFives() {
    assertThat(fun.lemonadeChange(new int[] {5, 5, 5, 5, 10, 20, 10, 10})).isTrue();
  }
}
