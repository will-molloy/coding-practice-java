package com.wilmol.hackerrank.regex.introduction.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * MatchAnythingButNewLineTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class MatchAnythingButNewLineTest {

  @Test
  void testMatches() {
    assertThat(new MatchAnythingButNewLine().matches("123.456.abc.def")).isTrue();
  }

  @Test
  void testDoesNotMatch() {
    assertThat(new MatchAnythingButNewLine().matches("1234.456.abc.def")).isFalse();
  }
}
