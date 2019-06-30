package com.wilmol.hackerrank.regex.backreference.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 2019-04-06 at 18:06. */
class MatchSameTextAgainAndAgainTest {

  @Test
  void testMatches() {
    assertThat(new MatchSameTextAgainAndAgain().matches("ab #1?AZa$ab #1?AZa$")).isTrue();
  }

  @Test
  void testDoesNotMatch() {
    assertThat(new MatchSameTextAgainAndAgain().matches("Ab #1?AZa$Ab #1?AZa$")).isFalse();
    assertThat(new MatchSameTextAgainAndAgain().matches("qwe")).isFalse();
    assertThat(new MatchSameTextAgainAndAgain().matches("ab -9kUlaaab -9kUlad")).isFalse();
  }
}
