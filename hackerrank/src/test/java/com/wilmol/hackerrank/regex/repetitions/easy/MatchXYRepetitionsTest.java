package com.wilmol.hackerrank.regex.repetitions.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

class MatchXYRepetitionsTest {
  @Test
  void testMatches() {
    assertThat(new MatchXYRepetitions().matches("3threeormorealphabets.")).isTrue();
    assertThat(new MatchXYRepetitions().matches("32threeormorealphabets")).isTrue();
    assertThat(
            new MatchXYRepetitions()
                .matches("3threeormorealphabetsACNSDNPINQCPIQNCPNQPCINQPICNPIQNCPQINCQPC"))
        .isTrue();
  }

  @Test
  void testDoesNotMatch() {
    assertThat(new MatchXYRepetitions().matches("3threeormorealphabets....")).isFalse();
    assertThat(new MatchXYRepetitions().matches("123threeormorealphabets....")).isFalse();
    assertThat(new MatchXYRepetitions().matches("3ab.")).isFalse();
    assertThat(new MatchXYRepetitions().matches("abc")).isFalse();
  }
}
