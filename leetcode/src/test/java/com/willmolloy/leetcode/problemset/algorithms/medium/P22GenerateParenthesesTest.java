package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P22GenerateParenthesesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P22GenerateParenthesesTest {

  private final P22GenerateParentheses fun = new P22GenerateParentheses();

  @Test
  void one() {
    assertThat(fun.generateParenthesis(1)).containsExactly("()");
  }

  @Test
  void two() {
    assertThat(fun.generateParenthesis(2)).containsExactly("(())", "()()");
  }

  @Test
  void three() {
    assertThat(fun.generateParenthesis(3))
        .containsExactly("((()))", "(()())", "(())()", "()(())", "()()()");
  }

  @Test
  void four() {
    assertThat(fun.generateParenthesis(4))
        .containsExactly(
            "(((())))",
            "((()()))",
            "((())())",
            "((()))()",
            "(()(()))",
            "(()()())",
            "(()())()",
            "(())(())",
            "(())()()",
            "()((()))",
            "()(()())",
            "()(())()",
            "()()(())",
            "()()()()");
  }
}
