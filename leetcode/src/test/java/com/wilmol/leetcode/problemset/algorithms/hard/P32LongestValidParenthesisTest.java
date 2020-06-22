package com.wilmol.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2019-08-11. */
class P32LongestValidParenthesisTest {

  private final P32LongestValidParenthesis fun = new P32LongestValidParenthesis();

  @Test
  void example1() {
    assertThat(fun.longestValidParentheses("(()")).isEqualTo(2);
  }

  @Test
  void example2() {
    assertThat(fun.longestValidParentheses(")()())")).isEqualTo(4);
  }

  @Test
  void nestedParenthesis() {
    assertThat(fun.longestValidParentheses("())((())")).isEqualTo(4);
  }

  @Test
  void emptyString() {
    assertThat(fun.longestValidParentheses("")).isEqualTo(0);
  }

  @Test
  void singleBracket() {
    assertThat(fun.longestValidParentheses("(")).isEqualTo(0);
    assertThat(fun.longestValidParentheses(")")).isEqualTo(0);
  }
}
