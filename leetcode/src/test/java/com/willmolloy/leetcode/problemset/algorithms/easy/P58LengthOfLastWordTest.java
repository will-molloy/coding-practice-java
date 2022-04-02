package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P58LengthOfLastWordTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P58LengthOfLastWordTest {

  private final P58LengthOfLastWord fun = new P58LengthOfLastWord();

  @Test
  void example() {
    assertThat(fun.lengthOfLastWord("Hello World")).isEqualTo(5);
  }

  @Test
  void emptyString() {
    assertThat(fun.lengthOfLastWord("")).isEqualTo(0);
  }
}
