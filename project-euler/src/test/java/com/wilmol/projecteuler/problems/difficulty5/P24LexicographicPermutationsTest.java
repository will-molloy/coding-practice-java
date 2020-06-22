package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 18/03/2019. */
class P24LexicographicPermutationsTest {

  private final P24LexicographicPermutations lexicographicPermutations =
      new P24LexicographicPermutations();

  @Test
  void secondFor021() {
    assertThat(lexicographicPermutations.apply("012", 2)).isEqualTo("021");
  }

  @Test
  void oneMillionthFor0123456789() {
    assertThat(lexicographicPermutations.apply("0123456789", 1_000_000)).isEqualTo("2783915460");
  }
}
