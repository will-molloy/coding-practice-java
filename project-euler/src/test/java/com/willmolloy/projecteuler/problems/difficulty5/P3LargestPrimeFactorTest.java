package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P3LargestPrimeFactorTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P3LargestPrimeFactorTest {

  @Test
  void largestPrimeFactor() {
    assertThat(new P3LargestPrimeFactor().apply(13_195)).isEqualTo(29L);
    assertThat(new P3LargestPrimeFactor().apply(600_851_475_143L)).isEqualTo(6_857L);
  }
}
