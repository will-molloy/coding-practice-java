package wilmol.hackerrank.regex.introduction.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 2019-04-04 at 20:09. */
class MatchWhiteSpaceAndNonWhiteSpaceCharacterTest {

  @Test
  void testMatches() {
    assertThat(new MatchWhiteSpaceAndNonWhiteSpaceCharacter().matches("12 11 15")).isTrue();
  }

  @Test
  void testDoesNotMatch() {
    assertThat(new MatchWhiteSpaceAndNonWhiteSpaceCharacter().matches("123 11 15")).isFalse();
  }
}
