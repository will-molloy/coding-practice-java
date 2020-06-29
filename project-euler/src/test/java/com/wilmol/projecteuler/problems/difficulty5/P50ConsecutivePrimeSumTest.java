package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P50ConsecutivePrimeSumTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P50ConsecutivePrimeSumTest {

  @Test
  void primeBelow100() {
    assertThat(P50ConsecutivePrimeSum.longestConsecutivePrimeSumPrimeResultBelow(100))
        .isEqualTo(41);
  }

  @Test
  void primeBelow1K() {
    assertThat(P50ConsecutivePrimeSum.longestConsecutivePrimeSumPrimeResultBelow(1_000))
        .isEqualTo(953);
  }

  @Test
  void primeBelow1M() {
    assertThat(P50ConsecutivePrimeSum.longestConsecutivePrimeSumPrimeResultBelow(1_000_000))
        .isEqualTo(997_651);
  }
}
