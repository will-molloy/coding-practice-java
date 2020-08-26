package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P412FizzBuzzTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P412FizzBuzzTest {

  private final P412FizzBuzz p412 = new P412FizzBuzz();

  @Test
  void example() {
    assertThat(p412.fizzBuzz(15))
        .containsExactly(
            "1",
            "2",
            "Fizz",
            "4",
            "Buzz",
            "Fizz",
            "7",
            "8",
            "Fizz",
            "Buzz",
            "11",
            "Fizz",
            "13",
            "14",
            "FizzBuzz")
        .inOrder();
  }
}
