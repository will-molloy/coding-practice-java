package com.wilmol.hackerrank.regex.characterclass.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 2019-04-04 at 22:20. */
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
