package com.willmolloy.hackerrank.regex.repetitions.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * MatchRangeOfRepetitionsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class MatchRangeOfRepetitionsTest {

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
