package com.wilmol.hackerrank.regex.characterclass.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * ExcludeSpecificCharactersTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class ExcludeSpecificCharactersTest {

  @Test
  void testMatches() {
    assertThat(new ExcludeSpecificCharacters().matches("think?")).isTrue();
  }

  @Test
  void testDoesNotMatch() {
    assertThat(new ExcludeSpecificCharacters().matches("think??")).isFalse();
    assertThat(new ExcludeSpecificCharacters().matches("athink?")).isFalse();
    assertThat(new ExcludeSpecificCharacters().matches("w12\t4'")).isFalse();
  }
}
