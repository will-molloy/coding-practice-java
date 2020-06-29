package com.wilmol.hackerrank.regex.applications.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * HackerRankTweetsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class HackerRankTweetsTest {

  @Test
  void testMatches() {
    assertThat(HackerRankTweets.containsHackerrank("I love #hackerrank")).isTrue();
    assertThat(
            HackerRankTweets.containsHackerrank(
                "I just scored 27 points in the Picking Cards challenge on #HackerRank"))
        .isTrue();
    assertThat(HackerRankTweets.containsHackerrank("I just signed up for summer cup @hackerrank"))
        .isTrue();
    assertThat(
            HackerRankTweets.containsHackerrank(
                "interesting talk by hari, co-founder of hackerrank"))
        .isTrue();
  }

  @Test
  void testDoesNotMatch() {
    assertThat(HackerRankTweets.containsHackerrank("hackrank")).isFalse();
    assertThat(HackerRankTweets.containsHackerrank("hackerank")).isFalse();
    assertThat(HackerRankTweets.containsHackerrank("hackerrrank")).isFalse();
    assertThat(HackerRankTweets.containsHackerrank("leetcode")).isFalse();
    assertThat(HackerRankTweets.containsHackerrank("project euler is better")).isFalse();
  }
}
