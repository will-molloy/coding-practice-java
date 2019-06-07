package com.wilmol.hackerrank.regex.repetitions.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

class MatchZeroOrMoreRepetitionsTest
{
  @Test
  void testMatches()
  {
    assertThat(new MatchZeroOrMoreRepetitions().matches("14")).isTrue();
    assertThat(new MatchZeroOrMoreRepetitions().matches("135133131aB")).isTrue();
    assertThat(new MatchZeroOrMoreRepetitions().matches("221231231vacmascvamsvcASCAXA")).isTrue();
    assertThat(new MatchZeroOrMoreRepetitions().matches("531ADASD")).isTrue();
  }

  @Test
  void testDoesNotMatch()
  {
    assertThat(new MatchZeroOrMoreRepetitions().matches("13123sc132123")).isFalse();
    assertThat(new MatchZeroOrMoreRepetitions().matches("1akldflkvnlDFVDFVDFVD")).isFalse();
    assertThat(new MatchZeroOrMoreRepetitions().matches("123321dasdASDASDASD1132")).isFalse();
  }
}
