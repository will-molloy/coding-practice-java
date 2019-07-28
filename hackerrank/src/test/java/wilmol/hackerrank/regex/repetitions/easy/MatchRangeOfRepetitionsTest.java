package wilmol.hackerrank.regex.repetitions.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 2019-04-06 at 13:28. */
class MatchRangeOfRepetitionsTest {

  @Test
  void testMatches() {
    assertThat(new MatchRangeOfRepetitions().matches("3threeormorealphabets.")).isTrue();
    assertThat(new MatchRangeOfRepetitions().matches("32threeormorealphabets")).isTrue();
    assertThat(
            new MatchRangeOfRepetitions()
                .matches("3threeormorealphabetsACNSDNPINQCPIQNCPNQPCINQPICNPIQNCPQINCQPC"))
        .isTrue();
  }

  @Test
  void testDoesNotMatch() {
    assertThat(new MatchRangeOfRepetitions().matches("3threeormorealphabets....")).isFalse();
    assertThat(new MatchRangeOfRepetitions().matches("123threeormorealphabets....")).isFalse();
    assertThat(new MatchRangeOfRepetitions().matches("3ab.")).isFalse();
    assertThat(new MatchRangeOfRepetitions().matches("abc")).isFalse();
  }
}
