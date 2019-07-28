package wilmol.hackerrank.regex.repetitions.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 2019-04-06 at 13:55. */
class MatchOneOrMoreRepetitionsTest {

  @Test
  void testMatches() {
    assertThat(new MatchOneOrMoreRepetitions().matches("1Qa")).isTrue();
    assertThat(new MatchOneOrMoreRepetitions().matches("123QWRasd")).isTrue();
  }

  @Test
  void testDoesNotMatch() {
    assertThat(new MatchOneOrMoreRepetitions().matches("123ASD333asd")).isFalse();
    assertThat(new MatchOneOrMoreRepetitions().matches("98754534321AWDADasdknalksndasd123123"))
        .isFalse();
    assertThat(new MatchOneOrMoreRepetitions().matches("ASDA123ASDwer")).isFalse();
    assertThat(new MatchOneOrMoreRepetitions().matches("!1As")).isFalse();
    assertThat(new MatchOneOrMoreRepetitions().matches("Ao")).isFalse();
  }
}
