package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P151ReverseWordsInAStringTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P151ReverseWordsInAStringTest {

  private final P151ReverseWordsInAString p151 = new P151ReverseWordsInAString();

  @Test
  void example1() {
    assertThat(p151.reverseWords("the sky is blue")).isEqualTo("blue is sky the");
  }

  @Test
  void example2TrimLeadingAndTrailingSpaces() {
    assertThat(p151.reverseWords("  hello world!  ")).isEqualTo("world! hello");
  }

  @Test
  void example3MultipleSpacesBetweenWords() {
    assertThat(p151.reverseWords("a good   example")).isEqualTo("example good a");
  }
}
