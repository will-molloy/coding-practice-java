package com.wilmol.hackerrank.regex.repetitions.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * MatchEndingItemsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class MatchEndingItemsTest {

  @Test
  void testMatches() {
    assertThat(new MatchEndingItems().matches("Kites")).isTrue();
    assertThat(new MatchEndingItems().matches("s")).isTrue();
    assertThat(new MatchEndingItems().matches("es")).isTrue();
  }

  @Test
  void testDoesNotMatch() {
    assertThat(new MatchEndingItems().matches("kite")).isFalse();
    assertThat(new MatchEndingItems().matches("")).isFalse();
    assertThat(new MatchEndingItems().matches("e'")).isFalse();
  }
}
