package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P20ValidParenthesisTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P20ValidParenthesisTest {

  private final P20ValidParenthesis function = new P20ValidParenthesis();

  @Test
  void example1() {
    assertThat(function.isValid("()")).isTrue();
  }

  @Test
  void example2() {
    assertThat(function.isValid("()[]{}")).isTrue();
  }

  @Test
  void example3() {
    assertThat(function.isValid("(]")).isFalse();
  }

  @Test
  void example4() {
    assertThat(function.isValid("([)]")).isFalse();
  }

  @Test
  void example5() {
    assertThat(function.isValid("{[]}")).isTrue();
  }
}
