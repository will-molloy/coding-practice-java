package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P36DoubleBasePalindromesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P36DoubleBasePalindromesTest {

  @Test
  void sumBelow1M() {
    assertThat(P36DoubleBasePalindromes.doubleBasePalindromeSum(1_000_000)).isEqualTo(872187);
  }
}
