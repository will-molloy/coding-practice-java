package wilmol.hackerrank.regex.characterclass.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 2019-04-04 at 22:27. */
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
