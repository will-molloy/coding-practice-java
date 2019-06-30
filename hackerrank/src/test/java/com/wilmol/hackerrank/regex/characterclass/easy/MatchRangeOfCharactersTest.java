package com.wilmol.hackerrank.regex.characterclass.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 2019-04-04 at 22:37. */
class MatchRangeOfCharactersTest {

  @Test
  void testMatches() {
    assertThat(new MatchRangeOfCharacters().matches("h4CkR")).isTrue();
  }

  @Test
  void testDoesNotMatch() {
    assertThat(new MatchRangeOfCharacters().matches("hh4CkRank")).isFalse();
    assertThat(new MatchRangeOfCharacters().matches("q9$?WWe")).isFalse();
    assertThat(new MatchRangeOfCharacters().matches("w12\t4'")).isFalse();
  }
}
