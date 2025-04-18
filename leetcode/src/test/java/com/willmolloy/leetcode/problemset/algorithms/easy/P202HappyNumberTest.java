package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P202HappyNumberTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P202HappyNumberTest {

  private final P202HappyNumber fun = new P202HappyNumber();

  @Test
  void example1() {
    assertThat(fun.isHappy(19)).isTrue();
  }

  @Test
  void already1() {
    assertThat(fun.isHappy(1)).isTrue();
  }

  @Test
  void unhappy() {
    assertThat(fun.isHappy(80)).isFalse();
  }
}
