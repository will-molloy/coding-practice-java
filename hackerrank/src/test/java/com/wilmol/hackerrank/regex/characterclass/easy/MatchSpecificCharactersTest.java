package com.wilmol.hackerrank.regex.characterclass.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * MatchSpecificCharactersTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class MatchSpecificCharactersTest {

  @Test
  void testMatches() {
    assertThat(new MatchSpecificCharacters().matches("1203x.")).isTrue();
    assertThat(new MatchSpecificCharacters().matches("21sAu,")).isTrue();
  }

  @Test
  void testDoesNotMatch() {
    assertThat(new MatchSpecificCharacters().matches("1203x")).isFalse();
    assertThat(new MatchSpecificCharacters().matches("21sAu,.")).isFalse();
  }
}
