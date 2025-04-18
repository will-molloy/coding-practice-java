package com.willmolloy.hackerrank.regex.introduction.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * MatchStartAndEndTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class MatchStartAndEndTest {

  @Test
  void testMatches() {
    assertThat(new MatchStartAndEnd().matches("0qwer.")).isTrue();
    assertThat(new MatchStartAndEnd().matches("00000.")).isTrue();
  }

  @Test
  void testDoesNotMatch() {
    assertThat(new MatchWordAndNonWordCharacter().matches("10aaaa.")).isFalse();
    assertThat(new MatchWordAndNonWordCharacter().matches("1qazq.2w")).isFalse();
  }
}
