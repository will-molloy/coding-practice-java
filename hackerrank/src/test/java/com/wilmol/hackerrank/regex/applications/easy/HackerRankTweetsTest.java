package com.wilmol.hackerrank.regex.applications.easy;

import static com.google.common.truth.Truth.assertThat;
import static com.wilmol.hackerrank.regex.applications.easy.HackerRankTweets.hasHackerrank;

import org.junit.jupiter.api.Test;

class HackerRankTweetsTest {

  @Test
  void testMatches() {
    assertThat(hasHackerrank("I love #hackerrank")).isTrue();
    assertThat(
            hasHackerrank("I just scored 27 points in the Picking Cards challenge on #HackerRank"))
        .isTrue();
    assertThat(hasHackerrank("I just signed up for summer cup @hackerrank")).isTrue();
    assertThat(hasHackerrank("interesting talk by hari, co-founder of hackerrank")).isTrue();
  }

  @Test
  void testDoesNotMatch() {
    assertThat(hasHackerrank("hackrank")).isFalse();
    assertThat(hasHackerrank("hackerank")).isFalse();
    assertThat(hasHackerrank("hackerrrank")).isFalse();
    assertThat(hasHackerrank("leetcode")).isFalse();
    assertThat(hasHackerrank("project euler is better")).isFalse();
  }
}
