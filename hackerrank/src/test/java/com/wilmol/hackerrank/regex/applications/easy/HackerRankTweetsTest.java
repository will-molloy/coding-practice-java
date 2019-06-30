package com.wilmol.hackerrank.regex.applications.easy;

import static com.google.common.truth.Truth.assertThat;
import static com.wilmol.hackerrank.regex.applications.easy.HackerRankTweets.containsHackerrank;

import org.junit.jupiter.api.Test;

/** Created by Will on 2019-04-07 at 19:22. */
class HackerRankTweetsTest {

  @Test
  void testMatches() {
    assertThat(containsHackerrank("I love #hackerrank")).isTrue();
    assertThat(
            containsHackerrank(
                "I just scored 27 points in the Picking Cards challenge on #HackerRank"))
        .isTrue();
    assertThat(containsHackerrank("I just signed up for summer cup @hackerrank")).isTrue();
    assertThat(containsHackerrank("interesting talk by hari, co-founder of hackerrank")).isTrue();
  }

  @Test
  void testDoesNotMatch() {
    assertThat(containsHackerrank("hackrank")).isFalse();
    assertThat(containsHackerrank("hackerank")).isFalse();
    assertThat(containsHackerrank("hackerrrank")).isFalse();
    assertThat(containsHackerrank("leetcode")).isFalse();
    assertThat(containsHackerrank("project euler is better")).isFalse();
  }
}
