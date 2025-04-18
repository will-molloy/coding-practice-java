package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P41PandigitalPrimeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P41PandigitalPrimeTest {

  @Test
  void largestPandigitalPrime() {
    assertThat(P41PandigitalPrime.largestPandigitalPrime()).isEqualTo(7652413);
  }
}
