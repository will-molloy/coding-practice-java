package com.willmolloy.hackerrank.interviewpreparationkit.stringmanipulation.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * AlternatingCharactersTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class AlternatingCharactersTest {

  @Test
  void emptyString() {
    assertThat(AlternatingCharacters.alternatingCharacters("")).isEqualTo(0);
  }

  @Test
  void noAlternating() {
    assertThat(AlternatingCharacters.alternatingCharacters("AAAAA")).isEqualTo(4);
  }

  @Test
  void onlyAlternating() {
    assertThat(AlternatingCharacters.alternatingCharacters("ABABABA")).isEqualTo(0);
  }

  @Test
  void mixture() {
    assertThat(AlternatingCharacters.alternatingCharacters("AABBABABAABB")).isEqualTo(4);
  }
}
