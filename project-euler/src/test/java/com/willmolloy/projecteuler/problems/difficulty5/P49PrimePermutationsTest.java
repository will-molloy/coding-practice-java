package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P49PrimePermutationsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
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
