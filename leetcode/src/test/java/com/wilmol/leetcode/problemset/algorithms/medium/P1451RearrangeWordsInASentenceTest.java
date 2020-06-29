package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P1451RearrangeWordsInASentenceTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1451RearrangeWordsInASentenceTest {

  private final P1451RearrangeWordsInASentence p1451 = new P1451RearrangeWordsInASentence();

  @Test
  void example1() {
    assertThat(p1451.arrangeWords("Leetcode is cool")).isEqualTo("Is cool leetcode");
  }

  @Test
  void example2() {
    assertThat(p1451.arrangeWords("Keep calm and code on")).isEqualTo("On and keep calm code");
  }

  @Test
  void example3() {
    assertThat(p1451.arrangeWords("To be or not to be")).isEqualTo("To be or to be not");
  }
}
