package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P796RotateStringTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P796RotateStringTest {

  private final P796RotateString fun = new P796RotateString();

  @Test
  void example1() {
    assertThat(fun.rotateString("abcde", "cdeab")).isTrue();
  }

  @Test
  void example2() {
    assertThat(fun.rotateString("abcde", "abced")).isFalse();
  }

  @Test
  void differentLengths() {
    assertThat(fun.rotateString("a", "aa")).isFalse();
  }
}
