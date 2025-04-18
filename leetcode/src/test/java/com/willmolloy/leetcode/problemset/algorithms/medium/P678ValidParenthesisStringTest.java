package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P678ValidParenthesisStringTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P678ValidParenthesisStringTest {

  private final P678ValidParenthesisString fun = new P678ValidParenthesisString();

  @Test
  void example1() {
    assertThat(fun.checkValidString("()")).isTrue();
  }

  @Test
  void example2() {
    assertThat(fun.checkValidString("(*)")).isTrue();
  }

  @Test
  void example3() {
    assertThat(fun.checkValidString("(*))")).isTrue();
  }

  @Test
  void adjacent() {
    assertThat(fun.checkValidString("()()")).isTrue();
  }

  @Test
  void nested() {
    assertThat(fun.checkValidString("(())")).isTrue();
  }

  @Test
  void useWildcardAsOpen() {
    assertThat(fun.checkValidString("*)")).isTrue();
  }

  @Test
  void useWildcardAsClose() {
    assertThat(fun.checkValidString("(*")).isTrue();
  }

  @Test
  void useWildcardsAsEmptyStrings() {
    assertThat(fun.checkValidString("(**)")).isTrue();
  }

  @Test
  void useWildcardsAsEmptyStringsAndClose() {
    assertThat(fun.checkValidString("(**")).isTrue();
  }

  @Test
  void useWildcardsAsEmptyStringsAndOpen() {
    assertThat(fun.checkValidString("**)")).isTrue();
  }

  @Test
  void emptyString() {
    assertThat(fun.checkValidString("")).isTrue();
  }

  @Test
  void onlyWildcard() {
    assertThat(fun.checkValidString("*")).isTrue();
  }

  @Test
  void onlyWildcards() {
    assertThat(fun.checkValidString("***")).isTrue();
  }

  @Test
  void invalidNested() {
    assertThat(fun.checkValidString("(()")).isFalse();
  }

  @Test
  void invalidAdjacent() {
    assertThat(fun.checkValidString("()(")).isFalse();
  }

  @Test
  void invalidNotEnoughOpenOrWildcard() {
    assertThat(fun.checkValidString("(**()))))")).isFalse();
  }

  @Test
  void invalidNotEnoughCloseOrWildcard() {
    assertThat(fun.checkValidString("((((()**)")).isFalse();
  }
}
