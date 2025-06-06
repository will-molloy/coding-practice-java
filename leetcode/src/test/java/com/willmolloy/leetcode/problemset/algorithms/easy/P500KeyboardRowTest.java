package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P500KeyboardRowTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P500KeyboardRowTest {

  private final P500KeyboardRow p500 = new P500KeyboardRow();

  @Test
  void example() {

    assertThat(p500.findWords(new String[] {"Hello", "Alaska", "Dad", "Peace"}))
        .asList()
        .containsExactly("Alaska", "Dad")
        .inOrder();
  }
}
