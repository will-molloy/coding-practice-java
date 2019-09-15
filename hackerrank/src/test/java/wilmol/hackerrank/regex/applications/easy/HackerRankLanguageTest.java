package wilmol.hackerrank.regex.applications.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2019-09-15. */
class HackerRankLanguageTest {

  @Test
  void valid() {
    assertThat(HackerRankLanguage.isValidLanguage("11011 C")).isTrue();
    assertThat(HackerRankLanguage.isValidLanguage("11022 CPP")).isTrue();
    assertThat(HackerRankLanguage.isValidLanguage("00000 JAVA")).isTrue();
  }

  @Test
  void invalidInvalidLanguage() {
    assertThat(HackerRankLanguage.isValidLanguage("11044 X")).isFalse();
  }

  @Test
  void invalidNoApiId() {
    assertThat(HackerRankLanguage.isValidLanguage("JAVA")).isFalse();
  }

  @Test
  void invalidInvalidApiId() {
    assertThat(HackerRankLanguage.isValidLanguage("1234 JAVA")).isFalse();
    assertThat(HackerRankLanguage.isValidLanguage("1234567 JAVA")).isFalse();
  }
}
