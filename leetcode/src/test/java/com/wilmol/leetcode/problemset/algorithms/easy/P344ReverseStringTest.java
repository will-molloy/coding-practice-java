package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P344ReverseStringTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P344ReverseStringTest {

  private final P344ReverseString p344 = new P344ReverseString();

  @Test
  void example1() {
    // Given
    char[] chars = new char[] {'h', 'e', 'l', 'l', 'o'};

    // When
    p344.reverseString(chars);

    // Then
    assertThat(chars).asList().containsExactly('o', 'l', 'l', 'e', 'h');
  }

  @Test
  void example2() {
    // Given
    char[] chars = new char[] {'H', 'a', 'n', 'n', 'a', 'h'};

    // When
    p344.reverseString(chars);

    // Then
    assertThat(chars).asList().containsExactly('h', 'a', 'n', 'n', 'a', 'H');
  }
}
