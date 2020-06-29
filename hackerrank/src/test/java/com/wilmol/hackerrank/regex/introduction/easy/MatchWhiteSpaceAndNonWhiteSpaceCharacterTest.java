package com.wilmol.hackerrank.regex.introduction.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * MatchWhiteSpaceAndNonWhiteSpaceCharacterTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class MatchWhiteSpaceAndNonWhiteSpaceCharacterTest {

  @Test
  void testMatches() {
    assertThat(new MatchWhiteSpaceAndNonWhiteSpaceCharacter().matches("12 11 15")).isTrue();
  }

  @Test
  void testDoesNotMatch() {
    assertThat(new MatchWhiteSpaceAndNonWhiteSpaceCharacter().matches("123 11 15")).isFalse();
  }
}
