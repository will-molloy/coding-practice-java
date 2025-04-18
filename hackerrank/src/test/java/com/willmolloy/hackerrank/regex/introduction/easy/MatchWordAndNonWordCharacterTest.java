package com.willmolloy.hackerrank.regex.introduction.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * MatchWordAndNonWordCharacterTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class MatchWordAndNonWordCharacterTest {

  @Test
  void testMatches() {
    assertThat(new MatchWordAndNonWordCharacter().matches("www.hackerrank.com")).isTrue();
  }

  @Test
  void testDoesNotMatch() {
    assertThat(new MatchWordAndNonWordCharacter().matches("www.hackerrank.co")).isFalse();
  }
}
