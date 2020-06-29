package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P784LetterCasePermutationTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P784LetterCasePermutationTest {

  private final P784LetterCasePermutation p784 = new P784LetterCasePermutation();

  @Test
  void example1() {
    assertThat(p784.letterCasePermutation("a1b2")).containsExactly("a1b2", "a1B2", "A1b2", "A1B2");
  }

  @Test
  void example2() {
    assertThat(p784.letterCasePermutation("3z4")).containsExactly("3z4", "3Z4");
  }

  @Test
  void example3() {
    assertThat(p784.letterCasePermutation("12345")).containsExactly("12345");
  }

  @Test
  void abc() {
    assertThat(p784.letterCasePermutation("abc"))
        .containsExactly("abc", "abC", "aBc", "aBC", "Abc", "AbC", "ABc", "ABC");
  }
}
