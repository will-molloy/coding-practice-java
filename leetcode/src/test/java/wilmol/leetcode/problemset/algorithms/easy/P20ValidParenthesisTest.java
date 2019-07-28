package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 2019-07-21 at 21:37. */
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
