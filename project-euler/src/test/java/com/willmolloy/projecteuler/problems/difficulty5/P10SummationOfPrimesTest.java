package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P10SummationOfPrimesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P10SummationOfPrimesTest {

  private final P10SummationOfPrimes summationOfPrimes = new P10SummationOfPrimes();

  @Test
  void below10() {
    assertThat(summationOfPrimes.apply(10)).isEqualTo(17L);
  }

  @Test
  void below2Million() {
    assertThat(summationOfPrimes.apply(2_000_000)).isEqualTo(142_913_828_922L);
  }

  @Test
  void exclusive() {
    assertThat(summationOfPrimes.apply(5)).isEqualTo(5L);
  }
}
