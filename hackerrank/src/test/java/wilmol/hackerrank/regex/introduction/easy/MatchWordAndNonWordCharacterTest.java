package wilmol.hackerrank.regex.introduction.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 2019-04-04 at 21:43. */
class MatchWordAndNonWordCharacterTest {

  @Test
  void testMatches() {
    assertThat(new MatchWordAndNonWordCharacter().matches("www.hackerrank.com")).isTrue();
  }

  @Test
  void testDoesNotMatch() {
    assertThat(new MatchWordAndNonWordCharacter().matches("www.hackerrank.co")).isFalse();
  }
}
