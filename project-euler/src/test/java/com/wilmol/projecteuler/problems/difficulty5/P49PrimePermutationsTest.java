package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by will on 2019-04-21 at 2:31 PM. */
class P49PrimePermutationsTest {

  @Test
  void firstSequenceWithPrimePermutationProperty() {
    assertThat(P49PrimePermutations.nInSequenceWithPrimePermutationProperty(1))
        .isEqualTo("148748178147");
  }

  @Test
  void secondSequenceWithPrimePermutationProperty() {
    assertThat(P49PrimePermutations.nInSequenceWithPrimePermutationProperty(2))
        .isEqualTo("296962999629");
  }
}
