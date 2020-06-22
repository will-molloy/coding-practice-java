package com.wilmol.hackerrank.regex.introduction.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 2019-04-02 at 21:08. */
class MatchDigitsAndNonDigitCharactersTest {

  @Test
  void testMatches() {
    assertThat(new MatchDigitsAndNonDigitCharacters().matches("06-11-2015")).isTrue();
  }

  @Test
  void testDoesNotMatch() {
    assertThat(new MatchDigitsAndNonDigitCharacters().matches("06112015")).isFalse();
  }
}
