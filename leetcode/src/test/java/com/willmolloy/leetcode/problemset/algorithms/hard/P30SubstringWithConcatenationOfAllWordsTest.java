package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P30SubstringWithConcatenationOfAllWordsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P30SubstringWithConcatenationOfAllWordsTest {

  private final P30SubstringWithConcatenationOfAllWords fun =
      new P30SubstringWithConcatenationOfAllWords();

  @Test
  void example1() {
    assertThat(fun.findSubstring("barfoothefoobarman", new String[] {"foo", "bar"}))
        .containsExactly(0, 9);
  }

  @Test
  void example2() {
    assertThat(
            fun.findSubstring(
                "wordgoodgoodgoodbestword", new String[] {"word", "good", "best", "word"}))
        .isEmpty();
  }

  @Test
  void noWords() {
    assertThat(fun.findSubstring("nothing", new String[0])).isEmpty();
  }

  @Test
  void emptyString() {
    assertThat(fun.findSubstring("", new String[] {"hello"})).isEmpty();
  }
}
