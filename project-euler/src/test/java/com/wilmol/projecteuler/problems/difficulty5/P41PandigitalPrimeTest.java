package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P41PandigitalPrimeTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P41PandigitalPrimeTest {

  @Test
  void largestPandigitalPrime() {
    assertThat(P41PandigitalPrime.largestPandigitalPrime()).isEqualTo(7652413);
  }
}
